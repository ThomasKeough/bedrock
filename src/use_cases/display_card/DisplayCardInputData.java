package use_cases.display_card;

import entities.CommonCard;
import entities.Card;

public class DisplayCardInputData {
    private final Card card;

    public DisplayCardInputData(CommonCard card) {
        this.card = card;
    }

    public String getArt() {
        return card.getCardArt();
    }

}
