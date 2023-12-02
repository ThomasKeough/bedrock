package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CommonCollectionTest {
    Collection collection;
    List<Card> cards;
    @BeforeEach
    void init() throws IOException {
        CardFactory cardFactory = new CommonCardFactory();
        BufferedReader br = new BufferedReader(new FileReader("circulating_pokemon_cards.csv"));
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
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
}