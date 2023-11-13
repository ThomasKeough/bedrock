package use_cases.build_deck;

import entities.Deck;
import entities.Player;

public class BuildDeckInputData {
    private Deck deck;
    private Player player;
    private String name;

    public BuildDeckInputData(Deck deck, String name, Player player) {
        this.deck = deck;
        this.name = name;
        this.player = player;
    }

    public Deck getDeck() {
        return deck;
    }

    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return name;
    }
}
