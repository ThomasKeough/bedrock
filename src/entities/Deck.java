package entities;
import java.util.ArrayList;

public interface Deck {
    ArrayList<Card> getCards();

//    int getDeckId();

    Integer numPokemonAlive();

    Card getActivePokemon();
}
