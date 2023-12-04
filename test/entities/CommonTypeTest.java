package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CommonTypeTest {
    Card card;
    CardFactory cardFactory = new CommonCardFactory();

    @Test
    void getOverallType() {
        card = cardFactory.create("sv3pt5-81","Magnemite");
        assertEquals("Lightning", card.getType().getOverallType());
    }

    @Test
    void getWeaknesses() {
        card = cardFactory.create("sv3pt5-95","Onix");
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("Grass", 2);
        assertEquals(expected, card.getType().getWeaknesses());
    }

    @Test
    void getResistances() {
        card = cardFactory.create("sv3pt5-65","Alakazam ex");
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("Fighting", 30);
        assertEquals(expected, card.getType().getResistances());
    }
}