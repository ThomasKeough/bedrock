package interface_adapters.delete_deck;

import interface_adapters.DecksViewModel;
import use_cases.delete_deck.DeleteDeckOutputBoundary;
import use_cases.delete_deck.DeleteDeckOutputData;

public class DeleteDeckPresenter implements DeleteDeckOutputBoundary {
    private final DeleteDeckViewModel deleteDeckViewModel;

    public DeleteDeckPresenter(DeleteDeckViewModel deleteDeckViewModel) {
        this.deleteDeckViewModel = deleteDeckViewModel;
    }

    @Override
    public void prepareSuccessView(DeleteDeckOutputData deleteDeckOutputData) {
        DeleteDeckState deckState = deleteDeckViewModel.getState();
        deckState.setDeck(deleteDeckOutputData.getDeck(), false);
        deleteDeckViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        DeleteDeckState deckState = deleteDeckViewModel.getState();
        deckState.setUseCaseFailed(true);
        deleteDeckViewModel.firePropertyChanged();
    }
}
