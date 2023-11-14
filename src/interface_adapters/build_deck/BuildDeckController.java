package interface_adapters.build_deck;

import entities.Card;
import entities.CommonDeck;
import entities.Deck;
import entities.Player;
import use_cases.build_deck.BuildDeckInputBoundary;
import use_cases.build_deck.BuildDeckInputData;

public class BuildDeckController {
    final BuildDeckInputBoundary buildDeckUseCaseInteractor;

    public BuildDeckController(BuildDeckInputBoundary buildDeckUseCaseInteractor) {
        this.buildDeckUseCaseInteractor = buildDeckUseCaseInteractor;
    }

    public void execute(Player player, String deckName, Card one, Card two, Card three, Card four, Card five, Card six) {
        BuildDeckInputData buildDeckInputData = new BuildDeckInputData(player, deckName, one, two, three, four, five, six);
        buildDeckUseCaseInteractor.execute(buildDeckInputData);
    }
}
