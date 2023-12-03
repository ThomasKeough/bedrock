package use_cases.wonder_trade;

import entities.Card;

public class WonderTradeInputData {
    private final Card card;
    private final int card_index;

    public WonderTradeInputData(Card card, int index) {
        this.card = card;
        this.card_index = index;
    }

    public Card getCard() { return this.card; }
    public int getIndex() {return this.card_index;}
}
