package interface_adapters.game;

import entities.Player;
import interface_adapters.attack.AttackController;
import interface_adapters.attack.AttackPresenter;
import interface_adapters.swap.SwapController;
import use_cases.attack.AttackInputBoundary;
import use_cases.game.GameInputBoundary;
import use_cases.game.GameInputData;
import use_cases.swap.SwapInputBoundary;

public class GameController {
    final AttackInputBoundary attackInteractor;
    final SwapInputBoundary swapInteractor;

    final GameInputBoundary gameUseCaseInteractor;

    public GameController(GameInputBoundary gameUseCaseInteractor, AttackInputBoundary attackInteractor, SwapInputBoundary swapInteractor) {
        this.gameUseCaseInteractor = gameUseCaseInteractor;
        this.attackInteractor = attackInteractor;
        this.swapInteractor = swapInteractor;
    }

    public Player execute(Player playerOne, Player playerTwo) {
        GameInputData gameInputData = new GameInputData(playerOne, playerTwo);
        return gameUseCaseInteractor.execute(gameInputData);
    }

//    public Player executeAttack(Player playerOne, Player playerTwo) {
//        GameInputData gameInputData = new GameInputData(playerOne, playerTwo);
////        return attackInteractor.execute(gameInputData);
//        return gameUseCaseInteractor.executeAttack(gameInputData);
//    }
//
//    public Player executeSwap(Player playerOne, Player playerTwo, SwapController swapController) {
//        GameInputData gameInputData = new GameInputData(playerOne, playerTwo);
//        return gameUseCaseInteractor.executeSwap(gameInputData);
//    }
}
