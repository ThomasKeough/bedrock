package entities;
import java.util.ArrayList;
import java.util.HashMap;

public interface Player {
    String getName();

    Deck getCurrentDeck();

    // returns a list of all the cards in the player's collection
    ArrayList<Card> getCollection();

    // returns a mapping of decks that the user has
    HashMap<String, Deck> getDecks();

}
