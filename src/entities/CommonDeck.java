package entities;

import java.util.ArrayList;

public class CommonDeck extends CommonCollection implements Deck {
    private String deckName;
    private Integer limit;
    private ArrayList<Card> cards;

    public CommonDeck(ArrayList<Card> cards) {
        super(cards, 6);
    }

    public CommonDeck(String deckName, Card one, Card two, Card three, Card four, Card five, Card six) {
        super(null, 6);
        this.deckName = deckName;
        ArrayList<Card> cards = new ArrayList<Card>();
            cards.add(one);
            cards.add(two);
            cards.add(three);
            cards.add(four);
            cards.add(five);
            cards.add(six);
        this.cards = cards;
    }

    @Override
    public String getDeckName() {
        return this.deckName;
    }

    @Override
    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    @Override
    public ArrayList<Card> getCards() {
        return this.cards;
    }

    @Override
    public Integer numPokemonAlive() {
        Integer numPokemonAlive = 0;
        for (Card card : this.cards) {
            if (card.getHP() > 0) {
                numPokemonAlive++;
            }
        }
        return numPokemonAlive;
    }

    @Override
    public Card getActivePokemon() {
        return null;
    }

    @Override
    public String toString() {
        return this.getDeckName();
    }
}
