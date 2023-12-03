package interface_adapters;

import java.beans.PropertyChangeListener;

public class DecksViewModel extends ViewModel {
    public final String TITLE_LABEL =  "Decks Menu View";
    public final String BACK_BUTTON_LABEL = "Back";
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
