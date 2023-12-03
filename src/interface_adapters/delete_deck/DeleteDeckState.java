package interface_adapters.delete_deck;

import entities.Deck;

public class DeleteDeckState {
    private Deck deck;
    private boolean useCaseFailed;
    public DeleteDeckState() {}

    public void setDeck(Deck deck, boolean useCaseFailed) {
        this.deck = deck;
        this.useCaseFailed = useCaseFailed;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public boolean getUseCaseFailed() {
        return this.useCaseFailed;
    }

    public void setUseCaseFailed(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }
}
