package interface_adapters.add_to_collection;

import entities.Card;

public class AddToCollectionState {
    private Card card;

    public AddToCollectionState(AddToCollectionState copy) {
        this.card = copy.card;
    }

    public AddToCollectionState() {}

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
