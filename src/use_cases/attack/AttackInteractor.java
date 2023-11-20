package use_cases.attack;

import entities.GamePokemon;
import entities.Type;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class AttackInteractor implements AttackInputBoundary {

    private final AttackOutputBoundary attackPresenter;

    public AttackInteractor(AttackOutputBoundary attackPresenter) {
        this.attackPresenter = attackPresenter;
    }
    public void execute(AttackInputData attackInputData) {
        HashMap<String, Integer> attack = attackInputData.getAttack();
        String attackerType = attackInputData.getAttackerType().getOverallType();

        GamePokemon defender = attackInputData.getDefender();
        HashMap<String, Integer> defenderWeaknesses = defender.getType().getWeaknesses();
        HashMap<String, Integer> defenderResistances = defender.getType().getResistances();

        try {
            // find damage value
            Integer damage = getDamageValue(attack);

            // boost the damage value in accordance with weaknesses
            Integer multipliedDamage = multiplyDamage(defenderWeaknesses, defenderResistances, attackerType, damage);

            // defender takes mulitplied damage
            defender.takeDamage(multipliedDamage);

            // attack succeeds
            AttackOutputData attackOutputData = new AttackOutputData(String.format("%s took %d damage!", defender.getName(), damage));
            attackPresenter.prepareSuccessView(attackOutputData);
        }
        catch (Exception e) {
            attackPresenter.prepareFailView(new AttackOutputData("The attack could not be completed."))
        }


    }
    private Integer getDamageValue(HashMap<String, Integer> attack) {
        // finds the attack damage value from the attack.
        // this function is needed because attacks are stored as hashmaps,
        // AttackInteractor never learns the key (name) of the attack.

        Set<String> keys = attack.keySet();
        Integer damage;
        for (String key : keys) {
            damage = attack.get(key);
        }
        return damage;
    }

    private Integer multiplyDamage(HashMap<String, Integer> defenderWeaknesses,
                                   HashMap<String, Integer> defenderResistances,
                                   String attackerType,
                                   Integer damage) {
        Integer multiplier = 1;

        if (defenderWeaknesses.containsKey(attackerType)) {
            multiplier = defenderWeaknesses.get(attackerType);

        }
        else if (defenderResistances.containsKey(attackerType)) {
            multiplier = defenderResistances.get(attackerType);

        }

        Integer multipliedDamage = damage * multiplier;
        return multipliedDamage;
    }
}
