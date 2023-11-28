package entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    void getHP() {
    }

    @Test
    void getAttack() {
    }

    @Test
    void hasFainted() {
    }

    @Test
    void isOnField() {
    }

    @Test
    void faint() {
    }

    @Test
    void takeDamage() {
    }

    @Test
    void swap() {
    }
}