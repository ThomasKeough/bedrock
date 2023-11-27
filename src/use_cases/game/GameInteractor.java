package use_cases.game;

import entities.Card;
import entities.Deck;
import entities.GameCard;
import entities.Player;

import java.util.ArrayList;
import java.util.Random;

public class GameInteractor implements GameInputBoundary {

    final GameDataAccessInterface gameDataAccessInterface;

    final GameOutputBoundary gameOutputBoundary;

    public GameInteractor(GameDataAccessInterface gameDataAccessInterface,
                            GameOutputBoundary gameOutputBoundary) {
        this.gameDataAccessInterface = gameDataAccessInterface;
        this.gameOutputBoundary = gameOutputBoundary;
    }

    @Override
    public Player execute(GameInputData gameInputData) {
        // INITIALIZE GAMECARDS
        Player playerOne = gameInputData.getPlayerOne();
        Player playerTwo = gameInputData.getPlayerTwo();

        Deck deckOne = playerOne.getCurrentDeck();
        Deck deckTwo = playerTwo.getCurrentDeck();

        ArrayList<GameCard> gameCardsOne = new ArrayList<>();
        ArrayList<GameCard> gameCardsTwo = new ArrayList<>();

        for (Card card : deckOne.getCards()) {
            gameCardsOne.add(new GameCard(card));
        }
        for (Card card : deckTwo.getCards()) {
            gameCardsTwo.add(new GameCard(card));
        }

        Integer winner;

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
//
//        if (winner == 0) {
//
//        }

        // TODO: write up a presenter.prepareSuccessView()
    }
    // return player or integer?
    public Integer runGameLoop(ArrayList<GameCard> gameCardsFirst, ArrayList<GameCard> gameCardsSecond) {

        GameCard activeOne;
        GameCard activeTwo;

        while (true) {
            for(int i = 0; i < gameCardsFirst.size(); i++) { // since both arrays equal size, we only need 1
                if (gameCardsFirst.get(i).isOnField()) {
                    activeOne = gameCardsFirst.get(i);
                }
                if (gameCardsSecond.get(i).isOnField()) {
                    activeTwo = gameCardsSecond.get(i);
                }
            } // loop initializes active cards



            // first player uses active pokemon to attack second player's active pokemon


//            activeTwo.takeDamage(activeOne);



            /// TODO: swap use case will handle setting which pokemon isOnField

            // TODO:

            // TODO: update loop for every move made
            // TODO: if a pokemon faints, remove from arraylist

            // checks to see if pokemon fainted


            if (gameCardsFirst.isEmpty()) {
                return 2; // second player wins
            }
            if (gameCardsSecond.isEmpty()) {
                return 1; // first player wins
            }
        }


        // TODO: if a GameCard faints, remove from the list



        // TODO: have a user input set into a variable

        // TODO: run the game loop here
    }
}
