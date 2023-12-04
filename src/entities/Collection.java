package entities;

import java.util.ArrayList;

public interface Collection {
    void replaceCard(int card_index, Card replacement_card);

    Card getCard(String cardID);

    ArrayList<Card> getCards();
    Integer getLimit();
    Boolean atLimit();

    void initializeCollection(boolean onlySpecials);
}
