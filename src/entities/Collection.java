package entities;

import java.util.ArrayList;

public interface Collection {
    void replace_card(int card_index, Card replacement_card);

    ArrayList<Card> getCards();
    Integer getLimit();
    Boolean atLimit();

    void initializeCollection();
}
