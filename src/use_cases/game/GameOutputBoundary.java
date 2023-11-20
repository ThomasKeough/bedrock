package use_cases.game;

public interface GameOutputBoundary {
    void prepareSuccessView(GameOutputData winner);

    // there are never any draws, so there shouldn't be a prepareFailView method
}
