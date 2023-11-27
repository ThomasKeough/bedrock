package interface_adapters.build_deck;

import interface_adapters.ViewModel;
import interface_adapters.add_to_collection.AddToCollectionState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BuildDeckViewModel extends ViewModel {
    public final String TITLE_LABEL = "Deck Builder";
    private BuildDeckState state = new BuildDeckState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public BuildDeckViewModel() {
        super("buildDeck");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    public BuildDeckState getState() {
        return state;
    }

    public void setState(BuildDeckState state) {
        this.state = state;
    }
}