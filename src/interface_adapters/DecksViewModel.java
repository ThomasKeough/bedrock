package interface_adapters;

import java.beans.PropertyChangeListener;

public class DecksViewModel extends ViewModel {
    public final String TITLE_LABEL =  "Decks Menu View";
    public final String BACK_BUTTON_LABEL = "Back";
    public final String EDIT_DECK_BUTTON_LABEL = "Edit Deck";
    public final String CREATE_NEW_DECK_BUTTON_LABEL = "Create New Deck";
    public final String DELETE_DECK_BUTTON_LABEL = "Delete Deck";
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
