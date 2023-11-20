package entities;

import java.util.Dictionary;
import java.util.HashMap;

public interface Card {
    String getName();

    String getId();

    Integer getHP();

    Boolean isHighHp();

    Type getType();

    HashMap<String, Integer> getAttacks();

    Boolean isSpecial();

    String getCardArt();

}
