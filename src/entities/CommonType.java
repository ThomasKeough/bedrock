package entities;

import java.util.HashMap;

public class CommonType implements Type {

    private final String type;
    private final HashMap<String, Integer> weaknesses;
    private final HashMap<String, Integer> resistances;

    public CommonType(String type, HashMap<String, Integer> weaknesses, HashMap<String, Integer> resistances) {
        this.type = type;
        this.weaknesses = weaknesses;
        this.resistances = resistances;
    }


    @Override
    public String getOverallType() {
        return type;
    }

    @Override
    public HashMap<String, Integer> getWeaknesses() {
        return weaknesses;
    }

    @Override
    public HashMap<String, Integer> getResistances() { // could possibly be an empty mapping
        return resistances;
    }
}
