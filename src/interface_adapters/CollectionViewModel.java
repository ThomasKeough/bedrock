package interface_adapters;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CollectionViewModel extends ViewModel {
    public final String TITLE_LABEL =  "Collection Menu View";
    public final String BACK_BUTTON_LABEL = "Back";
    public CollectionViewModel() {
        super("collection menu");
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}