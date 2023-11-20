package view;

import interface_adapters.MainViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class MainView extends JPanel {
    public final String viewName = "Main Menu";
    private MainViewModel mainViewModel;
    final JButton start;

    public MainView(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;

        JLabel title = new JLabel("Main Menu Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        start = new JButton(mainViewModel.START_BUTTON_LABEL);
        buttons.add(start);

        this.add(title);
        this.add(buttons);

        start.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(start)) { // start button is clicked
                            // TODO
                        }
                    }
                }
        );
    }
}
