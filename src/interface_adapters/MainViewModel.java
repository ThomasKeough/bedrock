package interface_adapters;

import java.beans.PropertyChangeListener;

public class MainViewModel extends ViewModel {
    public final String START_BUTTON_LABEL = "Start";
    public MainViewModel() {
        super("main menu");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {}

}
