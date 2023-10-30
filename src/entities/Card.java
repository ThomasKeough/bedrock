package entities;

import java.util.Dictionary;
import java.util.HashMap;

public interface Card {
    String getName();

    String getId();

    Integer getHP();

    HashMap<String, Integer> getAttacks();

    String getCardArt();

    Type getType();

}
