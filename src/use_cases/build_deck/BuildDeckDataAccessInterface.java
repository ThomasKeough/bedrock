package use_cases.build_deck;

import entities.Card;

public interface BuildDeckDataAccessInterface { // CardDAO implements this, save is irrelevant to the build_deck use case, maybe move somewhere else?

    void save(Card card);
}