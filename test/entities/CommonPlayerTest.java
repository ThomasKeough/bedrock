package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CommonPlayerTest {
    CardFactory cardFactory = new CommonCardFactory();
    Collection collection = new CommonCollection(4);
    Deck deck = new CommonDeck(new ArrayList<>());
    HashMap<String, Deck> decks = new HashMap<>();
    Player player = new CommonPlayer("Ash", deck, collection, decks);

    @Test
    void getName() {
        assertEquals("Ash", player.getName());
    }

    @Test
    void getCurrentDeck() {
        assertEquals(deck, player.getCurrentDeck());
    }

    @Test
    void getCollection() {
        assertEquals(collection, player.getCollection());
    }

    @Test
    void getDecks() {
        assertEquals(decks, player.getDecks());
    }

    @Test
    void addDeck() {
        Deck deck2 = new CommonDeck(new ArrayList<>());
        player.addDeck("deck 2", deck2);
        decks.put("deck 2", deck2);
        assertEquals(decks, player.getDecks());
    }

    @Test
    void removeDeck() {
        Deck deck2 = new CommonDeck(new ArrayList<>());
        player.addDeck("deck 2", deck2);
        player.removeDeck(deck2);
        assertEquals(new HashMap<>(), player.getDecks());
    }
}