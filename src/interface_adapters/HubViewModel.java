package interface_adapters;

import view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HubViewModel extends ViewModel {
    public final String TITLE_LABEL = "Hub Menu View";
    public final String PLAY_BUTTON_LABEL = "Play";
    public final String COLLECTION_BUTTON_LABEL = "Collection";
    public final String DECKS_BUTTON_LABEL = "Decks";
    public HubViewModel() {
        super("hub menu");
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        // support.firePropertyChange("main", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
