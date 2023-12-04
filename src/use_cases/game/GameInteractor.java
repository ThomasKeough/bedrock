package use_cases.game;

import entities.*;
//import interface_adapters.attack.AttackController;
//import use_cases.attack.AttackDataAccessInterface;
import use_cases.attack.AttackInputBoundary;
import use_cases.attack.AttackInputData;
//import use_cases.attack.AttackInteractor;
//import use_cases.swap.SwapDataAccessInterface;
//import use_cases.swap.SwapInputBoundary;
//import use_cases.swap.SwapInputData;
//import use_cases.swap.SwapInteractor;

//import java.sql.Array;
//import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class GameInteractor implements GameInputBoundary, GameInputListener {

    private final GameDataAccessInterface gameDataAccessInterface;

    private final GameOutputBoundary gameOutputBoundary;

    private final AttackInputBoundary attackInteractor;

//    private final SwapInputBoundary swapInteractor;

    private boolean attackButtonPressed;
    private boolean swapButtonPressed;

    private final GameInputListener gameInputListener;

    public GameInteractor(GameDataAccessInterface gameDataAccessInterface,
                          GameOutputBoundary gameOutputBoundary, AttackInputBoundary attackInteractor) {
//                          SwapInputBoundary swapInteractor) {
        this.gameDataAccessInterface = gameDataAccessInterface;
        this.gameOutputBoundary = gameOutputBoundary;
        this.attackInteractor = attackInteractor;
//        this.swapInteractor = swapInteractor;
        this.gameInputListener = this;
    }

    @Override
    public void onGameStateUpdate(GameCard activeOne, GameCard activeTwo) {
        if (attackButtonPressed) {
            handleAttack(activeOne, activeTwo);
            resetAttackButton(); // Reset the button state
            // TODO: update GameState here?
        }

//        if (swapButtonPressed) {
//            handleSwap(activeOne, activeTwo);
//            gameInputListener.resetSwapButton(); // Reset the button state
//            // TODO: update GameState? (changed active pokemon)
//        }
    }

    @Override
    public void resetAttackButton() {
        attackButtonPressed = false;
    }

    @Override
//    public void resetSwapButton() {
//        swapButtonPressed = false;
//    }

    public void handleAttack(GameCard activeOne, GameCard activeTwo) {
        // TODO: add another case for if activeTwo is attacking?
        // TODO: current implementation is activeOne attacks activeTwo
        AttackInputData attackInputData = new AttackInputData(activeOne, activeTwo);
        attackInteractor.execute(attackInputData);
    }

//    public void handleSwap(GameCard activeOne, GameCard activeTwo) {
//        SwapInputData swapInputData = new SwapInputData((..., ...));
//        SwapInteractor.execute(swapInputData);
//        // TODO: fix input data for Swap use case
//    }




    @Override
    public void execute(GameInputData gameInputData) {
        Player playerOne = gameInputData.getPlayerOne();
        Player playerTwo = gameInputData.getPlayerTwo();

        // INITIALIZE GAMECARDS
        ArrayList<GameCard> gameCardsOne = initializeCards(playerOne);
        ArrayList<GameCard> gameCardsTwo = initializeCards(playerTwo);

        // FIND WINNER AND BUNDLE INTO A GAMEOUTPUTDATA OBJECT
        Integer winner = coinFlip(gameCardsOne, gameCardsTwo);
        GameOutputData gameOutputData = determineWinner(winner, playerOne, playerTwo);
        gameOutputBoundary.prepareSuccessView(gameOutputData);
    }

    public GameOutputData determineWinner(Integer winner, Player playerOne, Player playerTwo) {
        if (winner == 1) { // PLAYER 1 WINS
            return new GameOutputData(playerOne);
        }
        else { // winner == 2 -> PLAYER 2 WINS
            return new GameOutputData(playerTwo);
        }
    }

    public Integer coinFlip(ArrayList<GameCard> gameCardsOne, ArrayList<GameCard> gameCardsTwo) {
        // COIN FLIP TO DETERMINE WHICH PLAYER GOES FIRST
        // IF IT LANDS ON 0, PLAYER 1 GOES FIRST
        // IF IT LANDS ON 1, PLAYER 2 GOES FIRST
        Integer winner;
        Random random = new Random();
        int coinFlip = random.nextInt(2);
        if (coinFlip == 0)  {
            winner = runGameLoop(gameCardsOne, gameCardsTwo);
        } else {
            winner = runGameLoop(gameCardsTwo, gameCardsOne);
        }
        return winner;

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
            // TODO: do we need onGameStateUpdate(activeTwo, activeOne); for the second player's move?
            onGameStateUpdate(activeTwo, activeOne);

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

