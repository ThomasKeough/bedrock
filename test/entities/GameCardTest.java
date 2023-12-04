package entities;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GameCardTest {
    Card card;
    GamePokemon gameCard;

    @BeforeEach
    void init() {
        CardFactory cardFactory = new CommonCardFactory();
        card = cardFactory.create("sv3pt5-143","Snorlax");
        gameCard = new GameCard(card);
    }

    @Test
    void getName() {
        assertEquals("Snorlax", gameCard.getName());
    }

    @Test
    void getType() {
        assertEquals("Colorless", gameCard.getType().getOverallType());
    }

    @Test
    void getHP() {
        assertEquals(150, gameCard.getHP());
    }

    @Test
    void getAttackName() {
        Set<String> keys = gameCard.getAttack().keySet();
        Integer damage = 0;
        String attackName = "";
        for (String key : keys) {
            damage = gameCard.getAttack().get(key);
            attackName = key;
        }
        assertEquals("Thudding Press", attackName);
        assertEquals(130, damage);
    }

    @Test
    void hasFainted() {
        assertEquals(false, gameCard.hasFainted());
    }

    @Test
    void isOnField() {
        assertFalse(gameCard.isOnField());
    }

    @Test
    void DamageToFaint() {
        gameCard.takeDamage(7000);
        assertTrue(gameCard.hasFainted());
    }

    @Test
    void takeDamage() {
        gameCard.takeDamage(1);
        assertEquals(149, gameCard.getHP());
    }

    @Test
    void swap() {
        gameCard.swap();
        assertTrue(gameCard.isOnField());
        gameCard.swap();
        assertFalse(gameCard.isOnField());
    }