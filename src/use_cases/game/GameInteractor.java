package use_cases.game;

import entities.*;
import interface_adapters.attack.AttackController;
import use_cases.attack.AttackDataAccessInterface;
import use_cases.attack.AttackInputBoundary;
import use_cases.attack.AttackInputData;
import use_cases.attack.AttackInteractor;
import use_cases.swap.SwapDataAccessInterface;
import use_cases.swap.SwapInputBoundary;
import use_cases.swap.SwapInputData;
import use_cases.swap.SwapInteractor;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameInteractor implements GameInputBoundary, GameInputListener {

    private final GameDataAccessInterface gameDataAccessInterface;

    private final GameOutputBoundary gameOutputBoundary;

    private final AttackInputBoundary attackInteractor;

    private final SwapInputBoundary swapInteractor;

    private boolean attackButtonPressed;
    private boolean swapButtonPressed;

    private final GameInputListener gameInputListener;

    public GameInteractor(GameDataAccessInterface gameDataAccessInterface,
                          GameOutputBoundary gameOutputBoundary, AttackInputBoundary attackInteractor,
                          SwapInputBoundary swapInteractor) {
        this.gameDataAccessInterface = gameDataAccessInterface;
        this.gameOutputBoundary = gameOutputBoundary;
        this.attackInteractor = attackInteractor;
        this.swapInteractor = swapInteractor;
        this.gameInputListener = this;
    }

    @Override
    public void onGameStateUpdate(GameCard activeOne, GameCard activeTwo) {
        if (attackButtonPressed) {
            handleAttack(activeOne, activeTwo);
            resetAttackButton(); // Reset the button state
            // TODO: update GameState here
        }

        if (swapButtonPressed) {
            handleSwap(activeOne, activeTwo);
            gameInputListener.resetSwapButton(); // Reset the button state
            // TODO: update GameState? (changed active pokemon)
        }
    }

    @Override
    public void resetAttackButton() {
        attackButtonPressed = false;
    }

    @Override
    public void resetSwapButton() {
        swapButtonPressed = false;
    }

    public void handleAttack(GameCard activeOne, GameCard activeTwo) {
        AttackInputData attackInputData = new AttackInputData(activeOne, activeTwo);
        attackInteractor.execute(attackInputData);
    }

    public void handleSwap(GameCard activeOne, GameCard activeTwo) {
        SwapInputData swapInputData = new SwapInputData((..., ...));
        SwapInteractor.execute(swapInputData);
    }




    @Override
    public Player execute(GameInputData gameInputData) {
        Player playerOne = gameInputData.getPlayerOne();
        Player playerTwo = gameInputData.getPlayerTwo();

        // INITIALIZE GAMECARDS
        ArrayList<GameCard> gameCardsOne = initializeCards(playerOne);
        ArrayList<GameCard> gameCardsTwo = initializeCards(playerTwo);

        Integer winner;


        //TODO: fix this so that it's cleaner
        Random random = new Random();
        // if coinFlip = 0: player 1 goes first
        // else:  player 2 goes first
        int coinFlip = random.nextInt(2);
        if (coinFlip == 0) {
            winner = runGameLoop(gameCardsOne, gameCardsTwo);
            if (winner == 1) {
                return playerOne;
            }
            else {
                return playerTwo;
            }
        }
        else {
            winner = runGameLoop(gameCardsTwo, gameCardsOne);
            if (winner == 2) {
                return playerTwo;
            }
            else {
                return playerOne;
            }
        }

        // TODO: write up a presenter.prepareSuccessView()
    }

    public ArrayList<GameCard> initializeCards(Player player) {
        // INITIALIZES GAMECARD OBJECTS GIVEN THE USERS
        Deck deckOne = player.getCurrentDeck();

        ArrayList<GameCard> gameCards = new ArrayList<>();

        for (Card card : deckOne.getCards()) {
            gameCards.add(new GameCard(card));
        }
        return gameCards;
    }

    public Integer runGameLoop(ArrayList<GameCard> gameCardsFirst, ArrayList<GameCard> gameCardsSecond) {

        GameCard activeOne = null;
        GameCard activeTwo = null;

        while (true) {
            for (int i = 0; i < gameCardsFirst.size(); i++) { // since both arrays equal size, we only need 1
                if (gameCardsFirst.get(i).isOnField()) {
                    activeOne = gameCardsFirst.get(i);
                }
                if (gameCardsSecond.get(i).isOnField()) {
                    activeTwo = gameCardsSecond.get(i);
                }
                // activeOne and activeTwo are the active pokemons on the battlefield
            }

            onGameStateUpdate(activeOne, activeTwo);

//                gameInputListener.onGameStateUpdate(activeOne, activeTwo);
//
//                if (gameInputListener.isAttackButtonPressed()) {
//                    AttackInputData attackInputData = new AttackInputData((activeOne, activeTwo))
//                    attackInteractor.execute(attackInputData);
//                    gameInputListener.resetAttackButton(); // Reset the button state
//                    // TODO: update GameState here
//                }
//
//                if (gameInputListener.isSwapButtonPressed()) {
//                    SwapInputData swapInputData = new SwapInputData(...)
//                    SwapInteractor.execute(swapInputData);
//                    gameInputListener.resetSwapButton(); // Reset the button state
//                    // TODO: update GameState? (changed active pokemon)
//                }


                // CHECKS IF A POKEMON HAS FAINTED - IF IT HAS, REMOVE FROM THE LIST
                for (int j = 0; j < gameCardsFirst.size(); j++) { // since both arrays equal size, we only need 1
                    if (gameCardsFirst.get(j).hasFainted()) {
                        gameCardsFirst.remove(gameCardsFirst.get(j));
                    }
                    if (gameCardsSecond.get(j).hasFainted()) {
                        gameCardsSecond.remove(gameCardsSecond.get(j));
                    }
                }
                if (gameCardsFirst.isEmpty()) {
                    return 2; // second player wins
                }
                if (gameCardsSecond.isEmpty()) {
                    return 1; // first player wins
                }
            }
        }
}

