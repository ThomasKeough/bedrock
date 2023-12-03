package use_cases.display_card;

import use_cases.attack.AttackOutputData;

public class DisplayCardInteractor implements DisplayCardInputBoundary{
    private final DisplayCardOutputBoundary displayCardPresenter;
    public DisplayCardInteractor(DisplayCardOutputBoundary displayCardPresenter){
        this.displayCardPresenter = displayCardPresenter;
    }

    @Override
    public void execute(DisplayCardInputData displayCardInputData) {
        String cardArt = displayCardInputData.getArt();

        DisplayCardOutputData displayCardOutputData = new DisplayCardOutputData(cardArt);

        try {
            displayCardPresenter.prepareSuccessView(displayCardOutputData);
        }
        catch (Exception e){
            displayCardPresenter.prepareFailView(new DisplayCardOutputData("The card art could not be fetched."));
        }
    }
}
