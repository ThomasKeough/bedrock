package interface_adapters.delete_deck;


import view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteDeckViewModel extends ViewModel {
    private final DeleteDeckState state = new DeleteDeckState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public DeleteDeckViewModel() {
        super("delete deck");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("delete deck", null, state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public DeleteDeckState getState() {
        return this.state;
    }
}
