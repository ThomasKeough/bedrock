package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CommonCollectionTest {
    CommonCollection collection;
    List<Card> cards;
    @BeforeEach
    void init() throws IOException {
        CardFactory cardFactory = new CommonCardFactory();
        BufferedReader br = new BufferedReader(new FileReader("circulating_pokemon_cards.csv"));
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            List<String> line = Arrays.asList(br.readLine().split(","));
            String id = line.get(0);
            String name = line.get(1);
            Card card = cardFactory.create(id, name);
            cards.add(card);
        }
        this.cards = cards;
        collection = new CommonCollection(cards, 100);
    }

    @Test
    void getCards() {
        assertEquals(this.cards, collection.getCards());
    }

    @Test
    void getLimit() {
        assertEquals(100, collection.getLimit());
    }

    @Test
    void atLimit() {
        assertEquals(false, collection.atLimit());
    }

    @Test
    void blankCollection() {
        Collection blank = new CommonCollection();
        assertEquals(new ArrayList<Card>(), blank.getCards());
    }

    @Test
    void blankWithLimit() {
        Collection blankWithLimit = new CommonCollection(16);
        assertEquals(16, blankWithLimit.getLimit());
        assertEquals(new ArrayList<Card>(), blankWithLimit.getCards());
    }

    @Test
    void csv_to_card() {
        CardFactory cardFactory = new CommonCardFactory();
        String line = "sv3pt5-55,Golduck,Water,true,false";
        collection.csv_to_card(line);
        Card card = cardFactory.create("sv3pt5-55", "Golduck");
        assertEquals(card.getName(), collection.getCards().get(collection.getCards().size() - 1).getName());

    }

    @Test
    void replaceCard() {
        CardFactory cardFactory = new CommonCardFactory();
        Card card = cardFactory.create("sv3pt5-52","Meowth");
        collection.replace_card(2, card);
        assertEquals(card.getName(), collection.getCards().get(2).getName());
    }

    @Test
    void initializeCollection() {
        // doesn't actually check the cards initialized, just checks
        // that the collection has cards after this
        Collection newCollection = new CommonCollection(10);
        newCollection.initializeCollection(true);
        assertEquals(10, newCollection.getCards().size());
    }
}