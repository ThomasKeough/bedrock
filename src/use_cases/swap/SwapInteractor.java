package use_cases.swap;

import entities.GamePokemon;

public class SwapInteractor implements SwapInputBoundary {
    private final SwapOutputBoundary swapOutputBoundary;

    public SwapInteractor(SwapOutputBoundary swapOutputBoundary) {
        this.swapOutputBoundary = swapOutputBoundary;
    }

    @Override
    public void execute(SwapInputData swapInputData) {
        GamePokemon swapIn = swapInputData.getSwapIn();
        GamePokemon swapOut = swapInputData.getSwapOut();
        swapIn.swap();
        swapOut.swap();

        SwapOutputData swapOutputData = new SwapOutputData(swapIn, swapOut);
        swapOutputBoundary.prepareSuccessView(swapOutputData);

    }
}
