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

        if (defenderWeaknesses.containsKey(attackerType)) {
            // find damage

            Integer damage = getDamageValue(attack);
            // apply positive multiplier: should be float, not integer
            Integer multiplier = defenderWeaknesses.get(attackerType);
            damage = damage * multiplier;

            // take damage
            defender.takeDamage(damage);

            // attack succeeds
            AttackOutputData attackOutputData = new AttackOutputData(String.format("%s took %d damage!", defender.getName(), damage));
            attackPresenter.prepareSuccessView(attackOutputData);

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
}
