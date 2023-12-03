package interface_adapters.delete_deck;

import entities.Deck;
import entities.Player;
import use_cases.delete_deck.DeleteDeckInputBoundary;
import use_cases.delete_deck.DeleteDeckInputData;

public class DeleteDeckController {
    final DeleteDeckInputBoundary deleteDeckUseCaseInteractor;

    public DeleteDeckController(DeleteDeckInputBoundary deleteDeckUseCaseInteractor) {
        this.deleteDeckUseCaseInteractor = deleteDeckUseCaseInteractor;
    }

    public void execute(Player player, Deck deckToDelete) {
        DeleteDeckInputData inputData = new DeleteDeckInputData(player, deckToDelete);
        deleteDeckUseCaseInteractor.execute(inputData);
    }
}
