package interface_adapters.add_to_collection;

import use_cases.add_card_to_collection.AddToCollectionOutputBoundary;
import use_cases.add_card_to_collection.AddToCollectionOutputData;

public class AddToCollectionPresenter implements AddToCollectionOutputBoundary {
    @Override
    public void prepareSuccessView(AddToCollectionOutputData outputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
