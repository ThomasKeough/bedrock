package interface_adapters.build_deck;

import entities.Deck;
import entities.Player;

public class BuildDeckState {
    private Player player;
    private Deck deck;
    private String deckName;
    private boolean useCaseFailed;

    public BuildDeckState() {}

    public Player getPlayer() {
        return player;
    }

    public Deck getDeck() {
        return deck;
    }

    public String getDeckName() {
        return deckName;
    }

    public boolean getUseCaseFailed() {
        return this.useCaseFailed;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public void setUseCaseFailed(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }
}
