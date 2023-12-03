package use_cases.delete_deck;

import entities.Deck;
import entities.Player;

public class DeleteDeckInputData {
    private Player player;
    private Deck deckToDelete;

    public DeleteDeckInputData(Player player, Deck deckToDelete) {
        this.player = player;
        this.deckToDelete = deckToDelete;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Deck getDeckToDelete() {
        return this.deckToDelete;
    }
}
