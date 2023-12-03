package use_cases.wonder_trade;

import entities.Card;

public class WonderTradeOutputData {
    private final Card replacement_card;
    private final int original_index;

    public WonderTradeOutputData(Card replacement_card, int original_index) {
        this.replacement_card = replacement_card;
        this.original_index = original_index;
    }

    public Card getReplacementCard() { return this.replacement_card; }

    public int getOriginalIndex() {return this.original_index;}
}
