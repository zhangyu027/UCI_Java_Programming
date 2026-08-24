package Assignment.module07;

import java.util.*;

public class ScoreTasks {

    private final List<Integer> scores;

    public ScoreTasks() {
        scores = List.of(
            88, 55, 91, 72, 67, 100,
            83, 74, 60, 95, 79, 86
        );
    }

    public List<Integer> getScores() {
        return scores;
    }

    // TODO:
    // Add methods that can be used by Callable tasks.
    //
    // Possible operations:
    // - calculateSum()
    // - findMaximum()
    // - calculateAverage()
}