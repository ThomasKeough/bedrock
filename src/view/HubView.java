package view;

import interface_adapters.HubViewModel;
import interface_adapters.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HubView extends JPanel {
    public final String viewName = "Hub Menu";
    private final HubViewModel hubViewModel;
    private ViewManagerModel viewManagerModel;
    final JButton play;
    final JButton collection;
    final JButton decks;
    final Dimension buttonSize;

    public HubView(HubViewModel hubViewModel, ViewManagerModel viewManagerModel) {
        this.hubViewModel = hubViewModel;
        this.viewManagerModel = viewManagerModel;

        buttonSize = new Dimension(200, 100);
        JPanel buttons = new JPanel();
        play = new JButton(hubViewModel.PLAY_BUTTON_LABEL);
        play.setPreferredSize(buttonSize);
        buttons.add(play);
        collection = new JButton(hubViewModel.COLLECTION_BUTTON_LABEL);
        collection.setPreferredSize(buttonSize);
        buttons.add(collection);
        decks = new JButton(hubViewModel.DECKS_BUTTON_LABEL);
        decks.setPreferredSize(buttonSize);
        buttons.add(decks);

        this.add(buttons);

        play.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(play)) {
                            viewManagerModel.setActiveView("Play Menu");
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );
        collection.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(collection)) {
                            viewManagerModel.setActiveView("Collection Menu");
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );
        decks.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(decks)) {
                            viewManagerModel.setActiveView("Decks Menu");
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );
    }
}
