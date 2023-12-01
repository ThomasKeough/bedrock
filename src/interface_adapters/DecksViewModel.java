package interface_adapters;

import java.beans.PropertyChangeListener;

public class DecksViewModel extends ViewModel {
    public DecksViewModel() {
        super("decks menu");
    }
    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
