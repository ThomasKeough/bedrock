package use_cases.wonder_trade;

public interface WonderTradeOutputBoundary {
    void prepareSuccessView(WonderTradeOutputData wonderTradeOutputData);

    void prepareFailView(String error);
}
