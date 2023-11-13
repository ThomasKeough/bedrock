package entities;

import java.util.HashMap;

public interface GamePokemon {
    public String getName();
    public Type getType();

    public Integer getHP();

    public HashMap<String, Integer> getAttack();

    public boolean hasFainted();

    public void faint();

    public void takeDamage(Integer damage);
}
