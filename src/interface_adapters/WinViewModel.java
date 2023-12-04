package interface_adapters;

import interface_adapters.game.WinState;
import view.ViewModel;
import view.WinView;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WinViewModel extends ViewModel {

    public final String BACK_BUTTON_LABEL = "Back";
    public final String MESSAGE = "Congratulations! You won!";

    private WinState state = new WinState();

    public WinViewModel() {
        super("win");
    }

    public void setState(WinState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public WinState getState() {
        return state;
    }
}
