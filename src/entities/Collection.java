package entities;

import java.util.ArrayList;

public interface Collection {
    ArrayList<Card> getCards();
    Integer getLimit();
    Boolean atLimit();
}
