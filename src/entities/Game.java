package entities;

import java.util.Optional;
import java.util.Set;

public interface Game {
    Integer getTurnCounter();

    Set<Player> getPlayers();

    Player getTurn();

    Optional<Player> getWinner();




}
