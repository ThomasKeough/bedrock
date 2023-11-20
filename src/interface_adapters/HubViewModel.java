package interface_adapters;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HubViewModel extends ViewModel{
    public final String TITLE_LABEL = "Main Menu View";
    public static final String PLAY_BUTTON_LABEL = "Play";
    public static final String COLLECTION_BUTTON_LABEL = "Collection";
    public static final String DECK_BUTTON_LABEL = "Deck";
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
