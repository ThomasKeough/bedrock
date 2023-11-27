package interface_adapters.swap;

import entities.GamePokemon;
import use_cases.swap.SwapInputBoundary;
import use_cases.swap.SwapInputData;

public class SwapController {
    final SwapInputBoundary swapInputBoundary;

    public SwapController(SwapInputBoundary swapInputBoundary) {
        this.swapInputBoundary = swapInputBoundary;
    }

    public void execute(GamePokemon swapIn, GamePokemon swapOut) {
        SwapInputData swapInputData = new SwapInputData(swapIn, swapOut);
        swapInputBoundary.execute(swapInputData);
}
