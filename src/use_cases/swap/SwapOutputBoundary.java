package use_cases.swap;

public interface SwapOutputBoundary {
    //TODO: check SwapOutputData inputs to the methods
    void prepareSuccessView(SwapOutputData result); // if result is true run this?

    void prepareFailView(SwapOutputData result); // if result is false run this?

}
