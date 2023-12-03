package use_cases.wonder_trade;

import use_cases.add_card_to_collection.AddToCollectionInputData;

public interface WonderTradeInputBoundary {

    void execute(WonderTradeInputData wonderTradeInputData);
}
