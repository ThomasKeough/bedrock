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
        String deckName = buildDeckinputData.getDeckName();
        Deck deck = new CommonDeck(deckName, buildDeckinputData.getOne(), buildDeckinputData.getTwo(), buildDeckinputData.getThree(),
                buildDeckinputData.getFour(), buildDeckinputData.getFive(), buildDeckinputData.getSix());
        Player player = buildDeckinputData.getPlayer();
        player.addDeck(deckName, deck);
        player.notifyObservers();

        // TODO: Implement Fail View Case
        BuildDeckOutputData buildDeckOutputData = new BuildDeckOutputData(deck, deckName,true);
        buildDeckPresenter.prepareSuccessView(buildDeckOutputData);
    }
}
