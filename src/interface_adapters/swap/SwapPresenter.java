package interface_adapters.swap;

import interface_adapters.ViewModel;
import use_cases.swap.SwapOutputBoundary;
import use_cases.swap.SwapOutputData;

public class SwapPresenter implements SwapOutputBoundary {

    private final SwapViewModel swapViewModel;

    private final ViewModel viewModel;
    public SwapPresenter(SwapViewModel swapViewModel,
                         ViewModel viewModel) {
        this.swapViewModel = swapViewModel;
        this.viewModel = viewModel;
    }

    @Override
    public void prepareSucessView(SwapOutputData swapOutputData) {
        SwapState swapState = swapViewModel.getState();
        swapState.setSwaps(swapOutputData);
        swapViewModel.setState(swapState);
        swapViewModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(SwapOutputData swapOutputData) {
        //TODO

    }
}
