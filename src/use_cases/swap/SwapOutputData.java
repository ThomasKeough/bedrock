package use_cases.swap;

import entities.GamePokemon;

public class SwapOutputData {

    private final GamePokemon swapIn;
    private final GamePokemon swapOut;

    public SwapOutputData(GamePokemon swapIn, GamePokemon swapOut) {
        this.swapIn = swapIn;
        this.swapOut = swapOut;
    }

    public GamePokemon getSwapIn() {return swapIn;}
    public GamePokemon getSwapOut() {return swapOut;}
}
