package use_cases.add_card_to_collection;

import entities.Card;
import entities.Collection;

public class AddToCollectionInteractor implements AddToCollectionInputBoundary {
    private final AddToCollectionOutputBoundary addToCollectionPresenter;
    private final AddToCollectionDataAccessInterface addToCollectionDAO;

    AddToCollectionInteractor(AddToCollectionOutputBoundary addToCollectionPresenter,
                              AddToCollectionDataAccessInterface addToCollectionDAO) {
        this.addToCollectionPresenter = addToCollectionPresenter;
        this.addToCollectionDAO = addToCollectionDAO;
    }

    @Override
    public void execute(AddToCollectionInputData inputData) {
        Card card = inputData.getCard();
        Collection collection = inputData.getCollection();

        if (addToCollectionDAO.cardInCollection(card)) {
            addToCollectionPresenter.prepareFailView("duplicate");
        }
        else {
            try {
                addToCollectionDAO.addCard(card);
                addToCollectionDAO.save();
                AddToCollectionOutputData outputData = new AddToCollectionOutputData(card);
                addToCollectionPresenter.prepareSuccessView(outputData);
            }
            catch (Exception e) {
                addToCollectionPresenter.prepareFailView("exception");
            }
        }



    }
}
