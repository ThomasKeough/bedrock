package interface_adapters.swap;

import interface_adapters.ViewManagerModel;
import interface_adapters.game.GameViewModel;
import use_cases.swap.SwapOutputBoundary;
import use_cases.swap.SwapOutputData;

public class SwapPresenter implements SwapOutputBoundary {

    private final SwapViewModel swapViewModel;
    private final GameViewModel gameViewModel;
    private final ViewManagerModel viewManagerModel;
    public SwapPresenter(SwapViewModel swapViewModel,
                         GameViewModel gameViewModel,
                         ViewManagerModel viewManagerModel) {
        this.swapViewModel = swapViewModel;
        this.gameViewModel = gameViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSucessView(SwapOutputData swapOutputData) {
        SwapState swapState = swapViewModel.getState();
        swapState.setSwaps(swapOutputData);
        swapViewModel.setState(swapState);
        swapViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(gameViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(SwapOutputData swapOutputData) {
        System.out.println("swap failed");
    }
}
