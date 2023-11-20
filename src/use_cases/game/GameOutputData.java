package use_cases.game;

import entities.Player;

public class GameOutputData {
    private final Player winner;

    public GameOutputData(Player winner) {
        this.winner = winner;
    }

    public Player getWinner() { return this.winner; }
}
