package view;

import entities.Card;
import entities.Collection;

public interface Observer {
    void update(int index, Card card);
}
