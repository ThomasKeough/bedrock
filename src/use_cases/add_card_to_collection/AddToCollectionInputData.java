package use_cases.add_card_to_collection;

import entities.Card;
import entities.Collection;

public class AddToCollectionInputData {
    Card card;
    Collection collection;

    AddToCollectionInputData(Card card, Collection collection) {
        this.card = card;
        this.collection = collection;
    }

    public Card getCard() { return this.card; }

    public Collection getCollection() {return this.collection; }
}
