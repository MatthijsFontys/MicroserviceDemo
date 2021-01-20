package app;

import app.entities.PuzzleHighscoreDto;
import app.entities.UserDto;
import app.grpc.hello.GreeterService;
import app.grpc.highscores.Highscore;
import app.grpc.highscores.HighscoreService;
import app.health.TemplateHealthCheck;
import app.repositories.HighscoreRepository;
import app.repositories.UserRepository;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.UnitOfWorkAwareProxyFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.hibernate.HibernateError;
import org.hibernate.SessionFactory;

import java.io.IOException;


public class DropwizardApp extends Application<MyConfig> {

    private final HibernateBundle<MyConfig> hibernate = new HibernateBundle<MyConfig>(UserDto.class, PuzzleHighscoreDto.class) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(MyConfig config) {
            return config.getDatabase();
        }
    };

    public static void main(String[] args) throws Exception {
        new DropwizardApp().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<MyConfig> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(MyConfig configuration,
                    Environment environment) throws IOException, InterruptedException {

        // Repositories
        final UserRepository repository = new UserRepository(hibernate.getSessionFactory());
        final HighscoreRepository hsRepository = new HighscoreRepository(hibernate.getSessionFactory());

        // Uof aware repo
        final HighscoreService uowAwareService = new UnitOfWorkAwareProxyFactory(hibernate)
                .create(HighscoreService.class, HighscoreRepository.class, hsRepository);

        // Grpc
        Server server = ServerBuilder
                .forPort(5001)
                .addService(new GreeterService())
                .addService(uowAwareService)
                .build();

        server.start();




        // Resource creation
        final MessageResource msgResource = new MessageResource(
                configuration.getTemplate(),
                configuration.getDefaultName(),
                repository
        );



        // Resource registration
        environment.jersey().register(msgResource);

        // Health check creation
        final TemplateHealthCheck templateHealthCheck = new TemplateHealthCheck(configuration.getTemplate());

        // Health check registration
        environment.healthChecks().register("template", templateHealthCheck);
    }
}
