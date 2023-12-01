package interface_adapters.display_card;

import entities.CommonCard;
import use_cases.display_card.DisplayCardInputBoundary;
import use_cases.display_card.DisplayCardInputData;

public class DisplayCardController {
    final DisplayCardInputBoundary displayCardInputBoundary;

    public DisplayCardController(DisplayCardInputBoundary displayCardInputBoundary) {
        this.displayCardInputBoundary = displayCardInputBoundary;
    }

    public void execute(CommonCard card) {
        DisplayCardInputData displayCardInputData = new DisplayCardInputData(CommonCard card);
        displayCardInputBoundary.execute(displayCardInputData);
    }
}
