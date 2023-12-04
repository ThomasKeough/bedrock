package use_cases.game;

import entities.Player;
import interface_adapters.attack.AttackController;
import interface_adapters.swap.SwapController;

public interface GameInputBoundary {
    void execute(GameInputData gameInputData);
}
