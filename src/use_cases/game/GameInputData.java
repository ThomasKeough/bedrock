package use_cases.game;

import entities.Player;

public class GameInputData {
    final private Player player_one;
    final private Player player_two;


    public GameInputData(Player playerOne, Player playerTwo) {
        player_one = playerOne;
        player_two = playerTwo;
    }

    Player getPlayer_one() { return this.player_one; }

    Player getPlayer_two() { return this.player_two; }
}
