package view;

import app.Main;
import entities.Card;
import entities.Deck;
import interface_adapters.DecksViewModel;
import interface_adapters.PlayViewModel;
import interface_adapters.ViewManagerModel;
import interface_adapters.build_deck.BuildDeckState;
import interface_adapters.build_deck.BuildDeckViewModel;
import interface_adapters.delete_deck.DeleteDeckController;
import interface_adapters.delete_deck.DeleteDeckState;
import interface_adapters.delete_deck.DeleteDeckViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
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

public class PlayView extends JPanel implements PropertyChangeListener {
    public final String viewName = "Play Menu";
    private final PlayViewModel playViewModel;
    private final BuildDeckViewModel buildDeckViewModel;
    private final HashMap<String, Deck> decks;
    private ViewManagerModel viewManagerModel;
    private Deck selectedDeck = null;
    final JList<Deck> deckJList;
    final DefaultListModel<Deck> deckListModel;
    final JScrollPane scrollPane;
    final JPanel buttons;
    final JButton start;
    final JButton back;
    final JButton setCurrentDeck;



    public PlayView(PlayViewModel playViewModel, BuildDeckViewModel buildDeckViewModel,
                    ViewManagerModel viewManagerModel) {
        this.playViewModel = playViewModel;
        this.buildDeckViewModel = buildDeckViewModel;
        this.viewManagerModel = viewManagerModel;
        this.decks = Main.player.getDecks();
        buildDeckViewModel.addPropertyChangeListener(this);

        deckJList = new JList<Deck>(decks.values().toArray(new Deck[0]));

        deckListModel = new DefaultListModel<>();
        deckListModel.addAll(decks.values());
        deckJList.setModel(deckListModel);

        // Create a JScrollPane to enable scrolling
        scrollPane = new JScrollPane(deckJList);
        scrollPane.setPreferredSize(new Dimension(800, 600));
        // scrollPane.setBorder(new EmptyBorder(50, 0, 0, 50));

        buttons = new JPanel();

        start = new JButton(playViewModel.START_BUTTON_LABEL);
        buttons.add(start);

        setCurrentDeck = new JButton(playViewModel.SET_CURRENT_DECK_LABEL);
        setCurrentDeck.setEnabled(false);
        buttons.add(setCurrentDeck);

        back = new JButton(playViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

        this.add(scrollPane);
        this.add(buttons);
        this.setLayout(new FlowLayout());

        start.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(start)) {
                            viewManagerModel.setActiveView("Game Menu");
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );
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
        setCurrentDeck.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(setCurrentDeck)) {
                            Main.player.setCurrentDeck(selectedDeck);
                            System.out.println(Main.player.getCurrentDeck().getDeckName());
                            setCurrentDeck.setEnabled(false);
                        }
                    }
                }
        );
        deckJList.addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (!e.getValueIsAdjusting()) {
                            selectedDeck = deckJList.getSelectedValue();

                            if (Main.player.getCurrentDeck().equals(selectedDeck)) {
                                setCurrentDeck.setEnabled(false);
                            } else {
                                setCurrentDeck.setEnabled(true);
                            }
                        }
                    }
                });
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("build deck")) {
            BuildDeckState state = (BuildDeckState) evt.getNewValue();
            if (!state.getUseCaseFailed()) {
                // Build Deck Use Case Passes
                deckJList.setListData(decks.values().toArray(new Deck[0]));
            }
        }
    }
}

