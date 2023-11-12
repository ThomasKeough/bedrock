package entities;

import java.util.ArrayList;

public class CommonCollection implements Collection {
    private Integer limit;
    private ArrayList<Card> cards;

    public CommonCollection(ArrayList<Card> cards) {
        this.cards = cards;
        this.limit = 100;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Integer getLimit() {
        return limit;
    }

    public Boolean atLimit() {
        return cards.size() <= limit;
    }
}