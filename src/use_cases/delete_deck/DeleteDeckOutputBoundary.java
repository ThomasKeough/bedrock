package use_cases.delete_deck;

public interface DeleteDeckOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String error);
}
