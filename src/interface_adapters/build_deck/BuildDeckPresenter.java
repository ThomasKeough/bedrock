package interface_adapters.build_deck;

import use_cases.build_deck.BuildDeckOutputBoundary;
import use_cases.build_deck.BuildDeckOutputData;

public class BuildDeckPresenter implements BuildDeckOutputBoundary {
    private final BuildDeckViewModel buildDeckViewModel;

    public BuildDeckPresenter(BuildDeckViewModel buildDeckViewModel) {
        this.buildDeckViewModel = buildDeckViewModel;
    }

    @Override
    public void prepareSuccessView(BuildDeckOutputData outputData) {
        BuildDeckState buildDeckState = new BuildDeckState();
        buildDeckState.setDeck(outputData.getDeck());
        buildDeckState.setDeckName(outputData.getDeckName());
        buildDeckState.setUseCaseFailed(true);
        buildDeckViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

    }
}
