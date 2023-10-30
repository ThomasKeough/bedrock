package entities;

import java.util.HashMap;

public interface Type {
    String getOverallType();

    HashMap<String, Integer> getWeaknesses();

    HashMap<String, Integer> getResistances();

}
