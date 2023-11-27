package use_cases.game;

import entities.Player;

public class GameInputData {
    final private Player playerOne;
    final private Player playerTwo;


    public GameInputData(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    Player getPlayerOne() { return this.playerOne; }

    Player getPlayerTwo() { return this.playerTwo; }
}
