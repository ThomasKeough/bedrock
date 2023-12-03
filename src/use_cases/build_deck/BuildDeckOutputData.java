package use_cases.build_deck;

import entities.Deck;

public class BuildDeckOutputData {
    private Deck deck;
    private String deckName;
    private boolean useCaseFailed;

    public BuildDeckOutputData(Deck deck, String deckName, boolean useCaseFailed) {
        this.deck = deck;
        this.deckName = deckName;
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
