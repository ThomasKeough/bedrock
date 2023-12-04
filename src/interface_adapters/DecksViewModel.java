package interface_adapters;

import view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DecksViewModel extends ViewModel {
    public final String TITLE_LABEL =  "Decks Menu View";
    public final String BACK_BUTTON_LABEL = "Back";
    public final String EDIT_DECK_BUTTON_LABEL = "Edit Deck";
    public final String CREATE_NEW_DECK_BUTTON_LABEL = "Create New Deck";
    public final String DELETE_DECK_BUTTON_LABEL = "Delete Deck";
    public final String DISPLAY_DECK_BUTTON_LABEL = "Display Deck";
    public final String RENAME_DECK_BUTTON_LABEL = "Rename Deck";
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

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
