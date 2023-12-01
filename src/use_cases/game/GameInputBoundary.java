package use_cases.game;

import entities.Player;
import interface_adapters.attack.AttackController;
import interface_adapters.swap.SwapController;

public interface GameInputBoundary {
//    Player execute(GameInputData gameInputData);

//    Player executeAttack(GameInputData gameInputData);
//
//    Player executeSwap(GameInputData gameInputData);

    void execute(GameInputData gameInputData);
}
