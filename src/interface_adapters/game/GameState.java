package interface_adapters.game;

import entities.Game;
import entities.GameCard;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameState {
    private GameCard activePokemon = null;
    private ArrayList<GameCard> faintedPokemons = new ArrayList<>();

    public GameState(GameState copy) {
        activePokemon = copy.activePokemon;
        faintedPokemons = copy.faintedPokemons;
    }
    public GameState() {}

    public GameCard getActivePokemon() {
        return activePokemon;
    }

    public ArrayList<GameCard> getFaintedPokemons() {
        return faintedPokemons;
    }

    public void setActivePokemon(GameCard activePokemon) {
        this.activePokemon = activePokemon;
    }

    public void setFaintedPokemons(ArrayList<GameCard> faintedPokemons) {
        this.faintedPokemons = faintedPokemons;
    }

}
