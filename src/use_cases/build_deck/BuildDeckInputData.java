package use_cases.build_deck;

import entities.Deck;
import entities.Player;

public class BuildDeckInputData {
    private Deck deck;
    private Player player;

    public BuildDeckInputData(Deck deck, Player player) {
        this.deck = deck;
        this.player = player;
    }

    public Deck getDeck() {
        return deck;
    }

    public Player getPlayer() {
        return player;
    }
}
