package use_cases.delete_deck;

public interface DeleteDeckOutputBoundary {
    void prepareSuccessView(DeleteDeckOutputData outputData);

    void prepareFailView(String error);
}
