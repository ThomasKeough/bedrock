package use_cases.game;

import data.TradingCardGameDAO;
import entities.*;
import interface_adapters.ViewManagerModel;
import interface_adapters.WinViewModel;
import interface_adapters.attack.AttackPresenter;
import interface_adapters.game.GamePresenter;
import interface_adapters.game.GameViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_cases.attack.AttackInputBoundary;
import use_cases.attack.AttackInteractor;

//import static org.junit.jupiter.api.Assertions.*;

class GameInteractorTest {
    private GameInteractor gameInteractor;
    private GameInputData gameInputData;

    @BeforeEach
    void init() {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        WinViewModel winViewModel = new WinViewModel();
        GameViewModel gameViewModel = new GameViewModel();

        GameDataAccessInterface gameDataAccessInterface = new TradingCardGameDAO();
        GameOutputBoundary gamePresenter = new GamePresenter(viewManagerModel, winViewModel, gameViewModel);
        AttackInputBoundary attackInteractor = new AttackInteractor(new AttackPresenter());
        gameInteractor = new GameInteractor(gameDataAccessInterface, gamePresenter, attackInteractor);

        CommonCardFactory commonCardFactory = new CommonCardFactory();
        Card one = commonCardFactory.create("sv3pt5-202", "Zapdos ex");
        Card two = commonCardFactory.create("sv3pt5-179", "Mr. Mime");
        Card three = commonCardFactory.create("sv3pt5-176", "Poliwhirl");
        Card four = commonCardFactory.create("sv3pt5-193", "Mew ex");
        Card five = commonCardFactory.create("sv3pt5-131", "Lapras");
        Card six = commonCardFactory.create("sv3pt5-143", "Snorlax");

        CommonDeck deckOne = new CommonDeck("deckOne", one, two, three, four, five, six);
        CommonDeck deckTwo = new CommonDeck("deckTwo", one, two, three, four, five, six);

        Player playerOne = new CommonPlayer("playerOne", deckOne);
        Player playerTwo = new CommonPlayer("playerTwo", deckTwo);
        gameInputData = new GameInputData(playerOne, playerTwo);
    }

    @Test
    void onGameStateUpdate() {
        gameInteractor.execute(gameInputData);
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