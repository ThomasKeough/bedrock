package entities;

import java.util.HashMap;

public class CommonPlayer implements Player {

    private final String name;
    private final Deck currentDeck;
    private final Collection collection;
    private final HashMap<String, Deck> playerDecks;

    public CommonPlayer(String name, Deck currentDeck, Collection collection, HashMap<String, Deck> playerDecks) {
        this.name = name;
        this.currentDeck = currentDeck;
        this.collection = collection;
        this.playerDecks = playerDecks;
    }


    @Override
    public String getName() {
        return null;
    }

    @Override
    public Deck getCurrentDeck() {
        return null;
    }

    @Override
    public Collection getCollection() {
        return null;
    }

    @Override
    public HashMap<String, Deck> getDecks() {
        return null;
    }
}
