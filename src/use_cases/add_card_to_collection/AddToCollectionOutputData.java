package use_cases.add_card_to_collection;

import entities.Card;

public class AddToCollectionOutputData {
    private final Card card;

    AddToCollectionOutputData(Card card) {
        this.card = card;
    }

    public Card getCard() { return this.card; }

}
