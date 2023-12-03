package interface_adapters.wonder_trade;

import entities.Card;

public class WonderTradeState {
    private Card card;
    private int index;

    public WonderTradeState() {}

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setCardFetchError(String error) {
    }

    public void setIndex(int originalIndex){
        index = originalIndex;
    }

    public int getIndex() {
        return index;
    }
}