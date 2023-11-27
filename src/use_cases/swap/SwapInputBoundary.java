package use_cases.swap;

import entities.Game;
import entities.GamePokemon;

public interface SwapInputBoundary {
    public void execute(SwapInputData swapInputData);
}
