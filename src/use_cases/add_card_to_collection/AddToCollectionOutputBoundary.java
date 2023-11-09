package use_cases.add_card_to_collection;

import entities.Card;

public interface AddToCollectionOutputBoundary {

    void prepareSuccessView(Card card);

    void prepareFailView(String error);
}
