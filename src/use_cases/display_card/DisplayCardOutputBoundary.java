package use_cases.display_card;

public interface DisplayCardOutputBoundary {
    void prepareSuccessView(DisplayCardOutputData user);

    void prepareFailView(String error);
}
