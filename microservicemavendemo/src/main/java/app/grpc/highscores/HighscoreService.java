package app.grpc.highscores;

import app.grpc.highscores.HighscoreServiceGrpc.HighscoreServiceImplBase;
import app.repositories.HighscoreRepository;
import io.dropwizard.hibernate.UnitOfWork;
import io.grpc.stub.StreamObserver;

public class HighscoreService extends HighscoreServiceImplBase {

    private final HighscoreRepository repository;

    public HighscoreService(HighscoreRepository repository) {
        this.repository = repository;
    }

    @Override
    @UnitOfWork
    public void getPuzzleHighscore(PuzzleRequest request, StreamObserver<PuzzleReply> responseObserver){
        var entities = repository.getByPuzzleId(request.getPuzzleId());
        var reply = PuzzleReply.newBuilder();
        for (int i=0; i<entities.size(); i++){
            var entity = entities.get(i);
            var highscore = PuzzleHighscore.newBuilder()
                    .setSecondsToComplete(entity.getSecondsToComplete())
                    .setAttemptName(entity.getAttemptName())
                    .build();
            reply.addHighscores(i, highscore);
        }
        responseObserver.onNext(reply.build());
        responseObserver.onCompleted();
    }
}
