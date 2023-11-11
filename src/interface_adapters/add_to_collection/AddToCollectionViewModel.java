package interface_adapters.add_to_collection;

import interface_adapters.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AddToCollectionViewModel extends ViewModel {

    public final String TITLE_LABEL = ""; // TODO
    private AddToCollectionState state = new AddToCollectionState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public AddToCollectionViewModel() {
        super("addToCollection");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    public AddToCollectionState getState() {
        return state;
    }

    public void setState(AddToCollectionState state) {
        this.state = state;
    }
}
