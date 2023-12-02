package interface_adapters.wonder_trade;

import entities.Card;

public class WonderTradeState {
    private Card card;

    public WonderTradeState() {}

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}