package use_cases.wonder_trade;

import data.TradingCardGameDAO;
import entities.Card;
import entities.CommonCardFactory;
import use_cases.add_card_to_collection.AddToCollectionOutputData;

import java.util.Objects;

public class WonderTradeInteractor implements WonderTradeInputBoundary {

    private final WonderTradeOutputBoundary wonderTradePresenter;
    private final WonderTradeDataAccessInterface wonderTradeDAO;

    public WonderTradeInteractor(WonderTradeOutputBoundary wonderTradePresenter,
                                 WonderTradeDataAccessInterface wonderTradeDAO) {
        this.wonderTradePresenter = wonderTradePresenter;
        this.wonderTradeDAO = wonderTradeDAO;
    }

    @Override
    public void execute(WonderTradeInputData wonderTradeInputData) {
        Card card = wonderTradeInputData.getCard();
        int original_index = wonderTradeInputData.getIndex();

        String replacement_card_id = wonderTradeDAO.fetch_similar_card(card.isHighHp(), card.isSpecial());

        if (Objects.equals(replacement_card_id, "No matching card found")) {
            wonderTradePresenter.prepareFailView("Wonder Trade failed. No trade partner was found.");
        }
        else {
            try {
                CommonCardFactory factory = new CommonCardFactory();
                Card replacement_card = factory.create(replacement_card_id, "name");

                WonderTradeOutputData wonderTradeOutputData = new WonderTradeOutputData(replacement_card, original_index);
                wonderTradePresenter.prepareSuccessView(wonderTradeOutputData);
            }
            catch (Exception e) {
                wonderTradePresenter.prepareFailView("exception");
            }
        }
    }
}
