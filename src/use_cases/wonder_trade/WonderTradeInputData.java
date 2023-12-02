package use_cases.wonder_trade;

import entities.Card;

public class WonderTradeInputData {
    private final Card card;

    public WonderTradeInputData(Card card) {
        this.card = card;
    }

    public Card getCard() { return this.card; }
}
