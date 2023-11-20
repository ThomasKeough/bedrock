package entities;

import java.util.HashMap;

public class CommonCard implements Card {

    private final String name;
    private final String id;
    private final Integer hp;
    private final Type type;
    private final HashMap<String, Integer> attack;
    private final Boolean isSpecial;
    private final String image;

    public CommonCard(String name, String id, Integer hp, Type type, HashMap<String, Integer> attack, Boolean isSpecial, String image) {
        this.name = name;
        this.id = id;
        this.hp = hp;
        this.type = type;
        this.attack = attack;
        this.isSpecial = isSpecial;
        this.image = image;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Integer getHP() {
        return hp;
    }

    public Boolean isHighHp() { return hp >= 110;}

    public Boolean isSpecial() {return isSpecial;}

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public HashMap<String, Integer> getAttacks() {
        return attack;
    }

    @Override
    public String getCardArt() {
        return image;
    }

}
