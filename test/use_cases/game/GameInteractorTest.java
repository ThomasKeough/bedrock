package use_cases.game;

import data.TradingCardGameDAO;
import interface_adapters.ViewManagerModel;
import interface_adapters.WinViewModel;
import interface_adapters.attack.AttackPresenter;
import interface_adapters.game.GamePresenter;
import interface_adapters.game.GameViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_cases.attack.AttackInputBoundary;
import use_cases.attack.AttackInteractor;
import view.WinView;

import java.io.File;

//import static org.junit.jupiter.api.Assertions.*;

class GameInteractorTest {
    private GameInteractor gameInteractor;

    @BeforeEach
    void init() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        WinViewModel winViewModel = new WinViewModel();
        GameViewModel gameViewModel = new GameViewModel();

        GameDataAccessInterface gameDataAccessInterface = new TradingCardGameDAO(new File("circulating_pokemon_cards.csv"));
        GameOutputBoundary gamePresenter = new GamePresenter(viewManagerModel, winViewModel, gameViewModel);
        AttackInputBoundary attackInteractor = new AttackInteractor(new AttackPresenter());
        gameInteractor = new GameInteractor(gameDataAccessInterface, gamePresenter, attackInteractor);
    }

    @Test
    void onGameStateUpdate() {
    }

    @Test
    void resetAttackButton() {
    }

    @Test
    void handleAttack() {
    }

    @Test
    void execute() {
    }

    @Test
    void determineWinner() {
    }

    @Test
    void coinFlip() {
    }

    @Test
    void initializeCards() {
    }

    @Test
    void runGameLoop() {
    }
}