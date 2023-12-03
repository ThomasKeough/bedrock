package use_cases.delete_deck;

import entities.Deck;
import entities.Player;

public class DeleteDeckInteractor implements DeleteDeckInputBoundary {
    final DeleteDeckOutputBoundary deleteDeckPresenter;

    public DeleteDeckInteractor(DeleteDeckOutputBoundary deleteDeckPresenter) {
        this.deleteDeckPresenter = deleteDeckPresenter;
    }

    @Override
    public void execute(DeleteDeckInputData deleteDeckInputData) {
        Player player = deleteDeckInputData.getPlayer();
        Deck deckToRemove = deleteDeckInputData.getDeckToDelete();
        if (player.removeDeck(deckToRemove)) {
            // Successfully removed
            deleteDeckPresenter.prepareSuccessView();
        } else {
            deleteDeckPresenter.prepareFailView("Failed to Delete Deck");
        }
    }
}
