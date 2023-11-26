package interface_adapters.attack;

import entities.GamePokemon;
import use_cases.attack.AttackInputBoundary;
import use_cases.attack.AttackInputData;

public class AttackController {

    final AttackInputBoundary attackInputBoundary;

    public AttackController(AttackInputBoundary attackInputBoundary) {
        this.attackInputBoundary = attackInputBoundary;
    }

    public void execute(GamePokemon attacker, GamePokemon defender) {
        AttackInputData attackInputData = new AttackInputData(attacker, defender);
        attackInputBoundary.execute(attackInputData);
    }
}
