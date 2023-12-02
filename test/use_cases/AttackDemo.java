package use_cases;

import entities.CardFactory;
import entities.CommonCardFactory;
import entities.GameCard;
import entities.GamePokemon;
import interface_adapters.attack.AttackController;
import interface_adapters.attack.AttackPresenter;
import interface_adapters.game.GameViewModel;
import use_cases.attack.AttackInteractor;
import use_cases.attack.AttackOutputBoundary;

public class AttackDemo {
    private final GamePokemon attacker;
    private final GamePokemon defender;

    public AttackDemo(GamePokemon attacker, GamePokemon defender) {
        this.attacker = attacker;
        this.defender = defender;
    }
    public void showAttack() {
        System.out.printf("%s's attack: %s\n", attacker.getName(), attacker.getAttack());
    }

    public void showAttackType() {
        System.out.printf("%s is a %s-type Pokemon.\n", attacker.getName(), attacker.getType().getOverallType());
    }
    public void showWeakness() {
        System.out.printf("%s has a weakness to %s-type attacks.\n", defender.getName(), defender.getType().getWeaknesses().keySet());

    }

    public void showHP() {
        System.out.printf("%s has %d hit points.\n", defender.getName(), defender.getHP());
    }

    public void attack() {

        AttackOutputBoundary attackPresenter = new AttackPresenter(new GameViewModel());
        AttackController attackController = new AttackController(new AttackInteractor(attackPresenter));
        attackController.execute(attacker, defender);
    }

    public void demoAttack() {

        showAttack();
        showAttackType();
        showWeakness();
        showHP();
        System.out.println("-----");
        attack();
        showHP();

    }


    public static void main(String[] args) {
        CardFactory cardFactory = new CommonCardFactory();
        GamePokemon charizard = new GameCard(cardFactory.create("sv3pt5-6","Charizard"));
        GamePokemon blastoise = new GameCard(cardFactory.create("sv3pt5-9","Blastoise"));
        GamePokemon snorlax = new GameCard(cardFactory.create("sv3pt5-143","Snorlax"));

        AttackDemo attack = new AttackDemo(blastoise, snorlax);
        attack.demoAttack();
        System.out.println("\n========\n");

        AttackDemo weakAttack = new AttackDemo(blastoise, charizard);
        weakAttack.demoAttack();
    }

}
