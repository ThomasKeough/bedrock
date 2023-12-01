package use_cases.display_card;

import entities.CommonCard;

public class DisplayCardInputData {
    private final CommonCard card;

    public DisplayCardInputData(CommonCard card) {
        this.card = card;
    }

    public String getArt() {
        return card.getCardArt();
    }

}
