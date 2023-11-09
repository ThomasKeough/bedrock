package use_cases.add_card_to_collection;

import entities.Card;

public interface AddToCollectionOutputBoundary {

    void prepareSuccessView(AddToCollectionOutputData outputData);

    void prepareFailView(String error);
}
