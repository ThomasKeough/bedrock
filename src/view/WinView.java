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
        this.winViewModel.addPropertyChangeListener((PropertyChangeListener) this);
        //TODO: FIX THIS

        JLabel title = new JLabel(winViewModel.MESSAGE);

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

}
