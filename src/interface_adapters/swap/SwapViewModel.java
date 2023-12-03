package interface_adapters.swap;

import interface_adapters.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SwapViewModel extends ViewModel {
    public final String title = "Swap Active Pokemon";
    private SwapState state = new SwapState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SwapViewModel() {
        super("swap");
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public SwapState getState() {return state;}

    public void setState(SwapState state) {this.state = state;}
}
