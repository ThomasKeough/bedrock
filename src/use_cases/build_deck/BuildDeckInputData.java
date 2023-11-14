package use_cases.build_deck;

import entities.Card;
import entities.Deck;
import entities.Player;

public class BuildDeckInputData {
    private Player player;
    private String deckName;
    private Card one;
    private Card two;
    private Card three;
    private Card four;
    private Card five;
    private Card six;

    public BuildDeckInputData(Player player, String deckName,
                              Card one, Card two, Card three, Card four, Card five, Card six) {
        this.player = player;
        this.deckName = deckName;
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;
    }

    public Player getPlayer() {
        return player;
    }

    public String getDeckName() {
        return deckName;
    }

    public Card getOne() {
        return one;
    }

    public Card getTwo() {
        return two;
    }

    public Card getThree() {
        return three;
    }

    public Card getFour() {
        return four;
    }

    public Card getFive() {
        return five;
    }

    public Card getSix() {
        return six;
    }
}
