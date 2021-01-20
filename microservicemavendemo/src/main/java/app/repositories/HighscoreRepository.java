package app.repositories;

import app.entities.PuzzleHighscoreDto;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class HighscoreRepository extends AbstractDAO<PuzzleHighscoreDto> {

    private SessionFactory context;

    public HighscoreRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
        context = sessionFactory;
    }

    public List<PuzzleHighscoreDto> getByPuzzleId(int puzzleId){
        var toReturn = list(
                    query("SELECT hs FROM PuzzleHighscoreDto hs WHERE hs.puzzleId = :puzzleId")
                    .setParameter("puzzleId", puzzleId)
        );
        return toReturn;
    }
}
