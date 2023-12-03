package interface_adapters.wonder_trade;
import interface_adapters.CollectionViewModel;
import interface_adapters.ViewManagerModel;
import use_cases.wonder_trade.WonderTradeOutputBoundary;
import use_cases.wonder_trade.WonderTradeOutputData;

public class WonderTradePresenter implements WonderTradeOutputBoundary {

    private final CollectionViewModel collectionViewModel;

    public WonderTradePresenter(CollectionViewModel collectionViewModel) {
        this.collectionViewModel = collectionViewModel;
    }

    @Override
    public void prepareSuccessView(WonderTradeOutputData response) {
        WonderTradeState wonderTradeState = collectionViewModel.getState();
        wonderTradeState.setCard(response.getReplacementCard());
        wonderTradeState.setIndex(response.getOriginalIndex());
        this.collectionViewModel.setState(wonderTradeState);
        collectionViewModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {
        WonderTradeState wonderTradeState = collectionViewModel.getState();
        wonderTradeState.setCardFetchError(error);
        collectionViewModel.firePropertyChanged();
    }
}
