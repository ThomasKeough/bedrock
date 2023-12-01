package use_cases.display_card;

public interface DisplayCardOutputBoundary {
    void prepareSuccessView(DisplayCardOutputData displayCardOutputData);

    void prepareFailView(DisplayCardOutputData displayCardOutputData);
}
