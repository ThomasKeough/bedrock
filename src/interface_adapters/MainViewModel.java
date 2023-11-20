package interface_adapters;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MainViewModel extends ViewModel {
    public final String TITLE_LABEL = "Main Menu View";
    public static final String START_BUTTON_LABEL = "Start";
    public MainViewModel() {
        super("main menu");
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
