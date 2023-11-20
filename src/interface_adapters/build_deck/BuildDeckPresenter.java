package interface_adapters.build_deck;

import use_cases.build_deck.BuildDeckOutputBoundary;
import use_cases.build_deck.BuildDeckOutputData;

public class BuildDeckPresenter implements BuildDeckOutputBoundary {
    @Override
    public void prepareSuccessView(BuildDeckOutputData outputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
