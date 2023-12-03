package app;


import data.TradingCardGameDAO;
import interface_adapters.ViewManagerModel;
import interface_adapters.WinViewModel;
import interface_adapters.attack.AttackPresenter;
import interface_adapters.game.GameController;
import interface_adapters.game.GamePresenter;
import interface_adapters.game.GameViewModel;
import use_cases.attack.AttackInputBoundary;
import use_cases.attack.AttackInputData;
import use_cases.attack.AttackInteractor;
import use_cases.attack.AttackOutputBoundary;
import use_cases.game.GameDataAccessInterface;
import use_cases.game.GameInputBoundary;
import use_cases.game.GameInteractor;
import use_cases.game.GameOutputBoundary;
import view.GameView;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class GameUseCaseFactory {
    private GameUseCaseFactory() {}

    public static GameView create(ViewManagerModel viewManagerModel, GameViewModel gameViewModel, WinViewModel winViewModel) {

        try {
            GameController gameController = createGameUseCase(viewManagerModel, gameViewModel, winViewModel);
            return new GameView(gameViewModel, viewManagerModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed opening cards file");
        }
        return null;
    }

    private static GameController createGameUseCase(ViewManagerModel viewManagerModel, GameViewModel gameViewModel, WinViewModel winViewModel) throws IOException {
        GameDataAccessInterface gameDataAccessObject = new TradingCardGameDAO();

        GameOutputBoundary gameOutputBoundary = new GamePresenter(viewManagerModel, winViewModel, gameViewModel);
        AttackOutputBoundary attackOutputBoundary = new AttackPresenter();

        AttackInputBoundary attackInteractor = new AttackInteractor(attackOutputBoundary);

        GameInputBoundary gameInteractor = new GameInteractor(
                gameDataAccessObject, gameOutputBoundary, attackInteractor);

        return new GameController(gameInteractor, attackInteractor);
    }
}
