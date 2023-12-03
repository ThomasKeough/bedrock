package use_cases.delete_deck;

import entities.Deck;

public class DeleteDeckOutputData {
    private final Deck deck;

    public DeleteDeckOutputData(Deck deck) {
        this.deck = deck;
    }

    public Deck getDeck() {
        return this.deck;
    }
}
