package use_cases.wonder_trade;

import entities.Card;
import entities.CardFactory;

public interface WonderTradeDataAccessInterface{

    String fetch_similar_card(boolean isHighHP, boolean isSpecial);
}
