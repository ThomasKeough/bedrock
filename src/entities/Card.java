package entities;

import java.util.Dictionary;
import java.util.HashMap;

public interface Card {
    String getName();

    String getId();

    Integer getHP();

    Type getType();

    HashMap<String, Integer> getAttacks();

    String getRarity();

    String getCardArt();

}
