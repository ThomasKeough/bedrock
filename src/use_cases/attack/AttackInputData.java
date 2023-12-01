package use_cases.attack;

import entities.GamePokemon;
import entities.Type;

import java.util.HashMap;

public class AttackInputData {
    private final GamePokemon attacker;
    private final GamePokemon defender;

    public AttackInputData(GamePokemon attacker, GamePokemon defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public HashMap<String, Integer> getAttack() {
        return attacker.getAttack();
    }

    public Type getAttackerType() {
        return attacker.getType();
    }

    public GamePokemon getDefender() {
        return defender;
    }


}
