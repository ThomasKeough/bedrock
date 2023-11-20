package use_cases.game;

import entities.Player;

public interface GameInputBoundary {
    Player execute(GameInputData gameInputData);
}
