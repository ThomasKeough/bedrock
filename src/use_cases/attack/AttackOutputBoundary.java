package use_cases.attack;

public interface AttackOutputBoundary {

    public void prepareSuccessView(AttackOutputData attackOutputData);

    public void prepareFailView(AttackOutputData attackOutputData);

}
