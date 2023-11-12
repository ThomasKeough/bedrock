package entities;

import java.util.ArrayList;

public class CommonDeck extends CommonCollection implements Deck {
    private Integer limit;
    private ArrayList<Card> cards;

    public CommonDeck(ArrayList<Card> cards) {
        super(cards);
        this.limit = 6;
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
