package entities;
import java.util.ArrayList;

public interface Deck {
    String getDeckName();
    void setDeckName(String deckName);

    ArrayList<Card> getCards();

//    int getDeckId();

    Integer numPokemonAlive();

    Card getActivePokemon();
}
