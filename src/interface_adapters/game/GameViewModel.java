package interface_adapters.game;

import view.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GameViewModel extends ViewModel {

    public final String TITLE_LABEL = "Game View";
//    public final String SWAP_BUTTON_LABEL = "Swap Cards";
    public final String ATTACK_BUTTON_LABEL = "Attack";
    public final String BACK_BUTTON_LABEL = "Back to Play Hub";

    private GameState state = new GameState();

    public GameViewModel() {
        super("game");
    }

//    public void setState(GameState state) {
//        this.state = state;
//    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

//    public GameState getState() {
//        return state;
//    }
}
