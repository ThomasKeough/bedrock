package interface_adapters.wonder_trade;
import use_cases.wonder_trade.WonderTradeOutputBoundary;
import use_cases.wonder_trade.WonderTradeOutputData;

public class WonderTradePresenter implements WonderTradeOutputBoundary {
    @Override
    public void prepareSuccessView(WonderTradeOutputData wonderTradeOutputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
