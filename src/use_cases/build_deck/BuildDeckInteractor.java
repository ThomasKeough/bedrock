package use_cases.build_deck;

import entities.CommonDeck;
import entities.Deck;
import entities.Player;

public class BuildDeckInteractor implements BuildDeckInputBoundary {
    final BuildDeckOutputBoundary buildDeckPresenter;

    public BuildDeckInteractor(BuildDeckOutputBoundary buildDeckPresenter) {
        this.buildDeckPresenter = buildDeckPresenter;
    }

    @Override
    public void execute(BuildDeckInputData buildDeckinputData) {
        Deck deck = new CommonDeck(buildDeckinputData.getOne(), buildDeckinputData.getTwo(), buildDeckinputData.getThree(),
                buildDeckinputData.getFour(), buildDeckinputData.getFive(), buildDeckinputData.getSix());
        String deckName = buildDeckinputData.getDeckName();
        Player player = buildDeckinputData.getPlayer();
        player.addDeck(deckName, deck);

        BuildDeckOutputData buildDeckOutputData = new BuildDeckOutputData(deckName);
        buildDeckPresenter.prepareSuccessView(buildDeckOutputData);
    }
}
