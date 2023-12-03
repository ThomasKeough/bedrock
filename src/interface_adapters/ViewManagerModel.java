package interface_adapters;

import entities.Card;
import entities.Collection;
import view.BuildDeckView;
import view.Observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ViewManagerModel {

    private String activeViewName;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public String getActiveView() {
        return activeViewName;
    }

    public void setActiveView(String activeView) {
        this.activeViewName = activeView;
    }

    public void firePropertyChanged() {
        support.firePropertyChange("view", null, this.activeViewName);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    private int index;
    private Card card;
    private List<Observer> observers = new ArrayList<>();

    public void updateCollection(int card_index, Card returnedCard) {
        index = card_index;
        card = returnedCard;
        BuildDeckView.cards.set(index, card);
        notifyObservers();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(index, card);
        }
    }
}
