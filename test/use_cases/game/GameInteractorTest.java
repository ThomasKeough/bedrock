package use_cases.game;

import data.TradingCardGameDAO;
import interface_adapters.attack.AttackPresenter;
import interface_adapters.game.GamePresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_cases.attack.AttackInputBoundary;
import use_cases.attack.AttackInteractor;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class GameInteractorTest {
    private GameInteractor gameInteractor;

    @BeforeEach
    void init() {
        GameDataAccessInterface gameDataAccessInterface = new TradingCardGameDAO(new File("circulating_pokemon_cards.csv"));
        GameOutputBoundary gamePresenter = new GamePresenter();
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