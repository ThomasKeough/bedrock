package interface_adapters.game;

import entities.Player;
import use_cases.game.GameInputBoundary;
import use_cases.game.GameInputData;

public class GameController {

    final GameInputBoundary gameUseCaseInteractor;

    public GameController(GameInputBoundary gameUseCaseInteractor) {
        this.gameUseCaseInteractor = gameUseCaseInteractor;
    }

    public Player execute(Player playerOne, Player playerTwo) {
        GameInputData gameInputData = new GameInputData(playerOne, playerTwo);
        return gameUseCaseInteractor.execute(gameInputData);
    }
}
