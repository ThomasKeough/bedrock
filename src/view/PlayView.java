package view;

import app.Main;
import entities.Card;
import entities.Deck;
import interface_adapters.DecksViewModel;
import interface_adapters.PlayViewModel;
import interface_adapters.ViewManagerModel;
import interface_adapters.delete_deck.DeleteDeckController;
import interface_adapters.delete_deck.DeleteDeckState;
import interface_adapters.delete_deck.DeleteDeckViewModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

import static view.ImageIconCreator.createImageIconFromURL;
import static view.ImageResizer.resizeIcon;

public class PlayView extends JPanel {
    public final String viewName = "Play Menu";
    private final PlayViewModel playViewModel;
    private ViewManagerModel viewManagerModel;
    final JButton start;
    final JButton back;



    public PlayView(PlayViewModel playViewModel, ViewManagerModel viewManagerModel) {
        this.playViewModel = playViewModel;
        this.viewManagerModel = viewManagerModel;

        JPanel buttons = new JPanel();

        start = new JButton(playViewModel.START_BUTTON_LABEL);
        buttons.add(start);
        start.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(start)) {
                            viewManagerModel.setActiveView("Game"); // TODO: check if the string is correct
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );

        back = new JButton(playViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);
        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)) {
                            // Set activeView to HubView
                            viewManagerModel.setActiveView("Hub Menu");
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );
    }
}

