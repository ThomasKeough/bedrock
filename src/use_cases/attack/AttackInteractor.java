package use_cases.attack;

import entities.GamePokemon;
import entities.Type;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class AttackInteractor implements AttackInputBoundary {

    private final AttackOutputBoundary attackPresesnter;
    public void execute(AttackInputData attackInputData) {
        HashMap<String, Integer> attack = attackInputData.getAttack();
        String attackerType = attackInputData.getAttackerType().getOverallType();

        GamePokemon defender = attackInputData.getDefender();
        HashMap<String, Integer> defenderWeaknesses = defender.getType().getWeaknesses();
        HashMap<String, Integer> defenderResistances = defender.getType().getResistances();

        if (defenderWeaknesses.containsKey(attackerType)) {
            // find damage
            Set<String> keys = attack.keySet();
            Integer damage;
            for (String key : keys) {
                damage = attack.get(key);
            }
            // apply positive multiplier: should be float, not integer
            Integer multiplier = defenderWeaknesses.get(attackerType);
            damage = damage * multiplier;

            // take damage
            defender.takeDamage(damage);

            // attack succeeds
            AttackOutputData attackOutputData = new AttackOutputData(String.format("%s took %d damage!", defender.getName(), damage));
            attackPresesnter.prepareSuccessView(attackOutputData);

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
