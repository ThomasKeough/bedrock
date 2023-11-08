package entities;

import java.util.HashMap;

public class CommonCard implements Card {

    private final String name;
    private final String id;
    private final Integer hp;
    private final Type type;
    private final HashMap<String, Integer> attack;
    private final String rarity;
    private final String image;

    public CommonCard(String name, String id, Integer hp, Type type, HashMap<String, Integer> attack, String rarity, String image) {
        this.name = name;
        this.id = id;
        this.hp = hp;
        this.type = type;
        this.attack = attack;
        this.rarity = rarity;
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


    @Override
    public Type getType() {
        return type;
    }

    @Override
    public HashMap<String, Integer> getAttacks() {
        return attack;
    }

    @Override
    public String getRarity() {
        return null;
    }

    @Override
    public String getCardArt() {
        return image;
    }

}
