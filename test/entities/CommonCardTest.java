package entities;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CommonCardTest {
    CardFactory cardFactory = new CommonCardFactory();
    Card card = cardFactory.create("sv3pt5-79", "Slowpoke");
    @Test
    void getName() {
        assertEquals("Slowpoke", card.getName());
    }

    @Test
    void getId() {
        assertEquals("sv3pt5-79", card.getId());
    }

    @Test
    void getHP() {
        assertEquals(80, card.getHP());
    }

    @Test
    void isHighHp() {
        assertFalse(card.isHighHp());
    }

    @Test
    void isSpecial() {
        assertFalse(card.isSpecial());
    }

    @Test
    void getType() {
        HashMap<String, Integer> weak = new HashMap<>();
        HashMap<String, Integer> resist = new HashMap<>();
        weak.put("Darkness", 2);
        resist.put("Fighting", 30);

        Type type = new CommonType("Psychic", weak, resist);

        assertEquals(type.getOverallType(), card.getType().getOverallType());
        assertEquals(type.getWeaknesses(), card.getType().getWeaknesses());
        assertEquals(type.getResistances(), card.getType().getResistances());
    }

    @Test
    void getAttacks() {
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("Sea Bathing", 0);
        expected.put("Headbutt", 20);
        assertEquals(expected, card.getAttacks());
    }

    @Test
    void getCardArt() {
        assertEquals("https://images.pokemontcg.io/sv3pt5/79_hires.png", card.getCardArt());
    }

    @Test
    void testToString() {
        assertEquals("Slowpoke", card.toString());
    }
}