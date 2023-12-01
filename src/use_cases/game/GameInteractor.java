package use_cases.game;

import entities.*;
import interface_adapters.attack.AttackController;
import use_cases.attack.AttackInputBoundary;
import use_cases.attack.AttackInputData;
import use_cases.attack.AttackInteractor;
import use_cases.swap.SwapInteractor;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameInteractor implements GameInputBoundary {

    final GameDataAccessInterface gameDataAccessInterface;

    final GameOutputBoundary gameOutputBoundary;




    public GameInteractor(GameDataAccessInterface gameDataAccessInterface,
                            GameOutputBoundary gameOutputBoundary) {
        this.gameDataAccessInterface = gameDataAccessInterface;
        this.gameOutputBoundary = gameOutputBoundary;
    }


    // TODO: add to notes (callign controller here might vioalte SOLID?)
    public void executeAttack(GameInputData gameInputData, AttackInteractor attackInteractor) {
        // TODO: need active GamePokemon here

        AttackInputData attackInputData = new AttackInputData(..., ...);
        attackInteractor.execute(attackInputData);
    }

    public void executeSwap(GameInputData gameInputData, SwapInteractor swapInteractor) {
        ...
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

//    public


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
                // activeOne and activeTwo are the active pokemons on the battlefield

                // TODO: implement logic here



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
