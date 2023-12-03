package use_cases.swap;

import use_cases.build_deck.BuildDeckOutputData;

public interface SwapOutputBoundary {

    void prepareSuccessView(SwapOutputData outputData);

    void prepareFailView(SwapOutputData error);
}