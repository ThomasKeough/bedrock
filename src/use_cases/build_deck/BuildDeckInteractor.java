package use_cases.build_deck;

import entities.Deck;
import entities.Player;

public class BuildDeckInteractor implements BuildDeckInputBoundary {
    private final BuildDeckOutputBoundary buildDeckPresenter;

    public BuildDeckInteractor(BuildDeckOutputBoundary buildDeckPresenter) {
        this.buildDeckPresenter = buildDeckPresenter;
    }

    @Override
    public void execute(BuildDeckInputData inputData) {
        Deck deck = inputData.getDeck();
        String name = inputData.getName();
        Player player = inputData.getPlayer();
        player.addDeck(name, deck);

        BuildDeckOutputData buildDeckOutputData = new BuildDeckOutputData(name);
        buildDeckPresenter.prepareSuccessView(buildDeckOutputData);
    }
}
