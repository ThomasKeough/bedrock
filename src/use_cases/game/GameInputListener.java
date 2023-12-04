package use_cases.game;

import entities.GameCard;

public interface GameInputListener {
    void onGameStateUpdate(GameCard activeOne, GameCard activeTwo);

    void handleAttack(GameCard activeOne, GameCard activeTwo);


//    void handleSwap(GameCard activeOne, GameCard activeTwo);


    void resetAttackButton();


//    void resetSwapButton();

}
