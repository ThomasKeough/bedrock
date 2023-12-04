package view;

import app.Main;
import entities.Card;
import entities.Deck;
import interface_adapters.DecksViewModel;
import interface_adapters.ViewManagerModel;
import interface_adapters.build_deck.BuildDeckState;
import interface_adapters.build_deck.BuildDeckViewModel;
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

public class DecksView extends JPanel implements PropertyChangeListener {
    public final String viewName = "Decks Menu";
    private final DecksViewModel decksViewModel;
    private final DeleteDeckViewModel deleteDeckViewModel;
    private final BuildDeckViewModel buildDeckViewModel;
    private final ViewManagerModel viewManagerModel;
    private final HashMap<String, Deck> decks;
    private final DeleteDeckController deleteDeckController;
    private Deck selectedDeck = null;
    final JList<Deck> deckJList;
    final DefaultListModel<Deck> deckListModel;
    final JScrollPane scrollPane;
    final JButton back;
    final JButton edit;
    final JButton renameDeck;
    final JButton delete;
    final JButton display;
    final JButton buildNewDeck;

    public DecksView(DeleteDeckController deleteDeckController, DecksViewModel decksViewModel,
                     DeleteDeckViewModel deleteDeckViewModel, BuildDeckViewModel buildDeckViewModel,
                     ViewManagerModel viewManagerModel) {
        this.deleteDeckController = deleteDeckController;
        this.decksViewModel = decksViewModel;
        this.deleteDeckViewModel = deleteDeckViewModel;
        this.buildDeckViewModel = buildDeckViewModel;
        this.viewManagerModel = viewManagerModel;
        this.decks = Main.player.getDecks();
        deleteDeckViewModel.addPropertyChangeListener(this);
        buildDeckViewModel.addPropertyChangeListener(this);

        deckJList = new JList<Deck>(decks.values().toArray(new Deck[0]));

        deckListModel = new DefaultListModel<>();
        deckListModel.addAll(decks.values());
        deckJList.setModel(deckListModel);

        // Create a JScrollPane to enable scrolling
        scrollPane = new JScrollPane(deckJList);
        scrollPane.setPreferredSize(new Dimension(800, 600));

        JPanel buttons = new JPanel(new FlowLayout());

        edit = new JButton(decksViewModel.EDIT_DECK_BUTTON_LABEL);
        edit.setEnabled(false);
        buttons.add(edit);

        renameDeck = new JButton(decksViewModel.RENAME_DECK_BUTTON_LABEL);
        renameDeck.setEnabled(false);
        buttons.add(renameDeck);

        delete = new JButton(decksViewModel.DELETE_DECK_BUTTON_LABEL);
        delete.setEnabled(false);
        buttons.add(delete);

        display = new JButton(decksViewModel.DISPLAY_DECK_BUTTON_LABEL);
        display.setEnabled(false);
        buttons.add(display);

        buildNewDeck = new JButton(decksViewModel.CREATE_NEW_DECK_BUTTON_LABEL);
        buttons.add(buildNewDeck);

        back = new JButton(decksViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

        this.setLayout(new FlowLayout());
        this.add(scrollPane);
        this.add(buttons);

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
        edit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO
                    }
                }
        );
        renameDeck.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String deckName = JOptionPane.showInputDialog("What would you like the rename this deck?");
                        if (deckName != null) {
                            selectedDeck.setDeckName(deckName);
                            Main.player.removeDeck(selectedDeck);
                            Main.player.addDeck(deckName, selectedDeck);
                            renameDeck.setEnabled(false);
                            deckJList.setListData(decks.values().toArray(new Deck[0]));
                        }
                    }
                }
        );
        delete.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(delete)) {
                            deleteDeckController.execute(Main.player, selectedDeck);
                        }
                    }
                }
        );
        display.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(display)) {
                            JPanel panel =  new JPanel(new FlowLayout());
                            for (Card card: selectedDeck.getCards()) {
                                panel.add(new JLabel(resizeIcon(createImageIconFromURL(card.getCardArt()), 0.3)));
                            }
                            JOptionPane.showOptionDialog(
                                    deckJList,
                                    panel,
                                    selectedDeck.getDeckName(),
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,  // No custom icon
                                    null,  // No custom options
                                    null);  // Default initial value
                        }
                    }
                }
        );
        buildNewDeck.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(buildNewDeck)) {
                            // Set activeView to Build Menu
                            viewManagerModel.setActiveView("Build Deck Menu");
                            viewManagerModel.firePropertyChanged();
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

                            edit.setEnabled(true);
                            delete.setEnabled(true);
                            display.setEnabled(true);
                            renameDeck.setEnabled(true);
                        }
                    }
                });
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("delete deck")) {
            DeleteDeckState state = (DeleteDeckState) evt.getNewValue();
            Deck deletedDeck = state.getDeck();
            if (!state.getUseCaseFailed()) {
                // Delete Use Case Passes
                deckJList.setListData(decks.values().toArray(new Deck[0]));

                deckJList.clearSelection();
                edit.setEnabled(false);
                delete.setEnabled(false);
                display.setEnabled(false);

                JOptionPane.showMessageDialog(this, deletedDeck + " successfully deleted!");
            } else {
                JOptionPane.showMessageDialog(this, deletedDeck + " failed to delete!");
            }
        } else if (evt.getPropertyName().equals("build deck")) {
            BuildDeckState state = (BuildDeckState) evt.getNewValue();
            Deck newDeck = state.getDeck();
            if (!state.getUseCaseFailed()) {
                // Build Deck Use Case Passes
                deckJList.setListData(decks.values().toArray(new Deck[0]));
            }
        }
    }
}
