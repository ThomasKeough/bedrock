package use_cases.build_deck;

import entities.Card;

public interface BuildDeckDataAccessInterface {

    void save(Card card);
}