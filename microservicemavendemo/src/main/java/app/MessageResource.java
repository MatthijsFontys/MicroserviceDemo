package app;

import app.entities.UserDto;
import app.repositories.UserRepository;
import com.codahale.metrics.annotation.Timed;
import io.dropwizard.hibernate.UnitOfWork;

import javax.management.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/message")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    private final UserRepository repository;

    public MessageResource(String template, String defaultName, UserRepository repository) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
        this.repository = repository;
    }

    @GET
    @Timed
    public Message consumeMessage(@QueryParam("name") Optional<String> name){
        final String value = String.format(template, name.orElse(defaultName));
        return  new Message(counter.incrementAndGet(), value);
    }

    @Path("/adduser")
    @UnitOfWork
    @GET
    public UserDto addUser(@QueryParam("name") String name){
        return repository.addUser(name);
    }
}
