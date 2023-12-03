package use_cases.build_deck;

import entities.Deck;

public class BuildDeckOutputData {
    private Deck deck;
    private String deckName;
    private boolean useCaseFailed;

    public BuildDeckOutputData(Deck deck, boolean useCaseFailed) {
        this.deck = deck;
        this.deckName = deck.getDeckName();
        this.useCaseFailed = useCaseFailed;
    }

    public Deck getDeck() {
        return deck;
    }

    public String getDeckName() {
        return deckName;
    }

    public boolean getUseCaseFailed() {
        return useCaseFailed;
    }
}
