package interface_adapters.build_deck;

import entities.Deck;
import entities.Player;

public class BuildDeckState {
    private Player player;
    private Deck deck;
    private String deckName;

    public BuildDeckState() {}

    public BuildDeckState(BuildDeckState copy) {
        player = copy.player;
        deck = copy.deck;
        deckName = copy.deckName;
    }

    public Player getPlayer() {
        return player;
    }

    public Deck getDeck() {
        return deck;
    }

    public String getDeckName() {
        return deckName;
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
}
