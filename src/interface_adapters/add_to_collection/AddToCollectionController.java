package interface_adapters.add_to_collection;

import entities.Card;
import entities.Collection;
import use_cases.add_card_to_collection.AddToCollectionInputData;
import use_cases.add_card_to_collection.AddToCollectionInputBoundary;

public class AddToCollectionController {
    final AddToCollectionInputBoundary addToCollectionUseCaseInteractor;

    public AddToCollectionController(AddToCollectionInputBoundary addToCollectionUseCaseInteractor) {
        this.addToCollectionUseCaseInteractor = addToCollectionUseCaseInteractor;
    }

    public void execute(Card card, Collection collection) {
        AddToCollectionInputData addToCollectionInputData = new AddToCollectionInputData(
                card, collection);

        addToCollectionUseCaseInteractor.execute(addToCollectionInputData);
    }
}
