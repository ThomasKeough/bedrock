package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommonDeckTest {
    Deck deck;
    ArrayList<Card> cards = new ArrayList<>();
    @BeforeEach
    void init() {
        CardFactory cardFactory = new CommonCardFactory();
        Card one = (cardFactory.create("sv3pt5-1", "Bulbasaur"));
        Card two = (cardFactory.create("sv3pt5-2", "Ivysaur"));
        Card three = (cardFactory.create("sv3pt5-3", "Venusaur"));
        Card four = (cardFactory.create("sv3pt5-4", "Charmander"));
        Card five = (cardFactory.create("sv3pt5-5", "Charmeleon"));
        Card six = (cardFactory.create("sv3pt5-6", "Charizard"));
        cards = new ArrayList<Card>();
        cards.add(one);
        cards.add(two);
        cards.add(three);
        cards.add(four);
        cards.add(five);
        cards.add(six);

        deck = new CommonDeck("first 6", one, two, three, four, five, six);
    }

    @Test
    void getDeckName() {
        assertEquals("first 6", deck.getDeckName());
    }

    @Test
    void setDeckName() {
        deck.setDeckName("awesome deck");
        assertEquals("awesome deck", deck.getDeckName());
    }

    @Test
    void getCards() {
        assertEquals(cards, deck.getCards());
    }

    @Test
    void numPokemonAlive() {
        assertEquals(6, deck.numPokemonAlive());
    }

    @Test
    void getActivePokemon() {
        // method not implemented yet
    }

    @Test
    void testToString() {
        assertEquals("first 6", deck.toString());
    }

    }
