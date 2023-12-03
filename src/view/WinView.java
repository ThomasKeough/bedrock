package view;

import view.ViewModel;
import interface_adapters.WinViewModel;
import interface_adapters.game.GameState;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WinView extends JPanel implements ActionListener {

    public final String viewName = "win";
    private final WinViewModel winViewModel; // TODO make a WinViewModel file
    final JButton back; // Back button for the user to press (takes user back to hub)

    public WinView(WinViewModel winViewModel) {
        this.winViewModel = winViewModel;
        this.winViewModel.addPropertyChangeListener(this);
        //TODO: FIX THIS

        JLabel title = new JLabel(winViewModel.MESSAGE);
//        title.setAlignmentX(Component.CENTER_ALIGNMENT);

//        LabelTextPanel usernameInfo = new LabelTextPanel(
//                new JLabel("Username"), usernameInputField);
//        LabelTextPanel passwordInfo = new LabelTextPanel(
//                new JLabel("Password"), passwordInputField);

        JPanel buttons = new JPanel();
        back = new JButton(winViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

        back.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

//    @Override
//    public void propertyChange(PropertyChangeEvent evt) {
//
//    }


//    public final String TITLE_LABEL = "Win View";
//    public final String MESSAGE = "Congratulations! You won!";
//
//    private GameState state = new GameState();
//
//    public WinViewModel() {
//        super("win view");
//    }
//
//    public void setState(GameState state) {
//        this.state = state;
//    }
//
//    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
//
//    // This is what the Signup Presenter will call to let the ViewModel know
//    // to alert the View
//    public void firePropertyChanged() {
//        support.firePropertyChange("state", null, this.state);
//    }
//
//    public void addPropertyChangeListener(PropertyChangeListener listener) {
//        support.addPropertyChangeListener(listener);
//    }
//
//    public LoginState getState() {
//        return state;
//    }
}
