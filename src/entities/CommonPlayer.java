package entities;
import data.PlayerDAO;
import view.Observer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonPlayer implements Player {

    private final String name;
    private final Deck currentDeck;
    private Collection collection;
    private final HashMap<String, Deck> playerDecks;

    private Observer watch;

    public CommonPlayer(String name, Deck currentDeck, Collection collection, HashMap<String, Deck> playerDecks) {
        this.name = name;
        this.currentDeck = currentDeck;
        this.collection = collection;
        this.playerDecks = playerDecks;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Deck getCurrentDeck() {
        return this.currentDeck;
    }

    @Override
    public Collection getCollection() {
        return this.collection;
    }

    @Override
    public HashMap<String, Deck> getDecks() {
        return this.playerDecks;
    }

    @Override
    public void addDeck(String name, Deck deck) {
        this.playerDecks.put(name, deck);
    }

    @Override
    public boolean removeDeck(Deck deckToRemove) {
        // Iterate through the playerDecks map to find and remove the specified deck
        for (Map.Entry<String, Deck> entry : playerDecks.entrySet()) {
            if (entry.getValue().equals(deckToRemove)) {
                playerDecks.remove(entry.getKey());
                return true; // Successfully removed
            }
        }
        // If the loop completes without finding the deck, it wasn't in the map
        return false;
    }

    @Override
    public void notifyObservers() {
        PlayerDAO.update(this);
    }

}
