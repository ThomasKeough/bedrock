package use_cases.wonder_trade;

import entities.Card;

public class WonderTradeOutputData {
    private final Card replacement_card;

    public WonderTradeOutputData(Card replacement_card) {
        this.replacement_card = replacement_card;
    }

    public Card getReplacementCard() { return this.replacement_card; }
}
