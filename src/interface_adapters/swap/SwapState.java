package interface_adapters.swap;

import entities.GamePokemon;
import use_cases.swap.SwapOutputData;

public class SwapState {
    private GamePokemon swapIn;
    private GamePokemon swapOut;

    public SwapState() {};

    public void setSwaps(SwapOutputData swapOutputData) {
        this.swapIn = swapOutputData.getSwapIn();
        this.swapOut = swapOutputData.getSwapOut();
    }

    public GamePokemon getSwapIn() {
        return swapIn;
    }

    public GamePokemon getSwapOut() {
        return swapOut;
    }
}
