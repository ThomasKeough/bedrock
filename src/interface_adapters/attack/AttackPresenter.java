package interface_adapters.attack;

import interface_adapters.game.GameViewModel;
import use_cases.attack.AttackOutputBoundary;
import use_cases.attack.AttackOutputData;

public class AttackPresenter implements AttackOutputBoundary {
    private final GameViewModel gameViewModel;
    public AttackPresenter(GameViewModel gameViewModel) {
        this.gameViewModel = gameViewModel;
    }
    @Override
    public void prepareSuccessView(AttackOutputData attackOutputData) {
        System.out.println(attackOutputData.getMessage());
    }

    @Override
    public void prepareFailView(AttackOutputData attackOutputData) {
        System.out.println("Attack has failed.");

    }
}
