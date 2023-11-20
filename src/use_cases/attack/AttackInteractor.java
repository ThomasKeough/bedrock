package use_cases.attack;

import entities.GamePokemon;
import entities.Type;

import java.util.Arrays;
import java.util.HashMap;

public class AttackInteractor implements AttackInputBoundary {

    public void execute(AttackInputData attackInputData) {
        HashMap<String, Integer> attack = attackInputData.getAttack();
        String attackerType = attackInputData.getAttackerType().getOverallType();

        GamePokemon defender = attackInputData.getDefender();
        HashMap<String, Integer> defenderWeaknesses = defender.getType().getWeaknesses();
        HashMap<String, Integer> defenderResistances = defender.getType().getResistances();

        if (defenderWeaknesses.containsKey(attackerType)) {
            // apply positive multiplier and take damage
            // need a way to key into attack hash map
            // attack succeeds
        }
        else if (defenderResistances.containsKey(attackerType)) {
            // apply negative multiplier and take damage
            // attack succeeds
        }
        else {
            // no multiplier application, base damage is taken
            // attack succeeds

        }




    }
}
