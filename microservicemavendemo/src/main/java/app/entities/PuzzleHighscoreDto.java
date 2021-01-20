package app.entities;

import javax.persistence.*;


@Table(name = "puzzle_highscore")
@Entity
public class PuzzleHighscoreDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "attempt_name")
    private String attemptName;
    @Column(name = "seconds_to_complete")
    private int secondsToComplete;
    @Column(name = "puzzle_id")
    private int puzzleId;

    public int getId() {
        return id;
    }

    public String getAttemptName() {
        return attemptName;
    }

    public int getSecondsToComplete() {
        return secondsToComplete;
    }

    public int getPuzzleId() {
        return puzzleId;
    }
}
