package use_cases.swap;
import entities.GamePokemon;

public class SwapInputData {
    private final GamePokemon swapIn;
    private final GamePokemon swapOut;

    public SwapInputData(GamePokemon swapIn, GamePokemon swapOut) {
        this.swapIn = swapIn;
        this.swapOut = swapOut;
    }

    public GamePokemon getSwapIn() {
        return this.swapIn;
    }

    public GamePokemon getSwapOut() {
        return this.swapOut;
    }

}