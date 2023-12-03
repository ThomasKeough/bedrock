package interface_adapters.attack;

import use_cases.attack.AttackOutputBoundary;
import use_cases.attack.AttackOutputData;

public class AttackPresenter implements AttackOutputBoundary {
    @Override
    public void prepareSuccessView(AttackOutputData attackOutputData) {}

    @Override
    public void prepareFailView(AttackOutputData attackOutputData) {}
}
