package interface_adapters.wonder_trade;

import entities.Card;
import interface_adapters.ViewModel;
import interface_adapters.add_to_collection.AddToCollectionState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WonderTradeViewModel extends ViewModel {
    private WonderTradeState state = new WonderTradeState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public WonderTradeViewModel() {
        super("wonderTrade");
    }

    @Override
    public void firePropertyChanged() {

    }
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    public WonderTradeState getState() {
        return state;
    }

    public void setState(WonderTradeState state){
        this.state = state;
    }
}