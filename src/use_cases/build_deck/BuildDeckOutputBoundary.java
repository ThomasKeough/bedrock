package use_cases.build_deck;;

public interface BuildDeckOutputBoundary {
    void prepareSuccessView(BuildDeckOutputData outputData);

    void prepareFailView(String error);
}
