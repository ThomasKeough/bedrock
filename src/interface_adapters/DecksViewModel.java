package interface_adapters;

import view.ViewModel;

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
