package interface_adapters.wonder_trade;

import entities.Card;
import entities.Collection;
import use_cases.wonder_trade.WonderTradeInputBoundary;
import use_cases.wonder_trade.WonderTradeInputData;

public class WonderTradeController {
    final WonderTradeInputBoundary wonderTradeUseCaseInteractor;

    public WonderTradeController(WonderTradeInputBoundary wonderTradeUseCaseInteractor) {
        this.wonderTradeUseCaseInteractor = wonderTradeUseCaseInteractor;
    }

    public void execute(Card card) {
        WonderTradeInputData wonderTradeInputData = new WonderTradeInputData(card);

        wonderTradeUseCaseInteractor.execute(wonderTradeInputData);
    }
}
