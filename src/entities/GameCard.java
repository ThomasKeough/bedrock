package entities;

import java.util.HashMap;

public class GameCard implements GamePokemon {
    private final String name;
    private final Type type;
    private Integer hp;
    private final HashMap<String, Integer> attack;
    private boolean fainted;

    public GameCard(Card card) {
        this.name = card.getName();
        this.type = card.getType();
        this.hp = card.getHP();
        this.attack = card.getAttacks();
        this.fainted = false;
    }

    public String getName() {
        return name;
    }
    public Type getType() {
        return type;
    }

    public Integer getHP() {
        return hp;
    }

    public HashMap<String, Integer> getAttack() {
        return attack;
    }

    private void setHP(Integer new_hp) {
        this.hp = new_hp;
    }

    public boolean hasFainted() {
        return fainted;
    }

    public void faint() {
        if (this.getHP() <= 0) {
            this.fainted = true;
        }
    }

    public void takeDamage(Integer damage) {
        this.setHP(this.getHP() - damage);
    }

}
