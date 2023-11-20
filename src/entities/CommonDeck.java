package entities;

import java.util.ArrayList;

public class CommonDeck extends CommonCollection implements Deck {
    private Integer limit;
    private ArrayList<Card> cards;

    public CommonDeck(ArrayList<Card> cards) {
        super(cards, 6);
    }

    public CommonDeck(Card one, Card two, Card three, Card four, Card five, Card six) {
        super(null, 6);
        ArrayList<Card> cards = new ArrayList<Card>();
            this.cards.add(one);
            this.cards.add(two);
            this.cards.add(three);
            this.cards.add(four);
            this.cards.add(five);
            this.cards.add(six);
        this.cards = cards;
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
}
