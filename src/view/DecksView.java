package view;

import app.Main;
import entities.Card;
import entities.Deck;
import interface_adapters.DecksViewModel;
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

public class DecksView extends JPanel implements PropertyChangeListener {
    public final String viewName = "Decks Menu";
    private final DecksViewModel decksViewModel;
    private final DeleteDeckViewModel deleteDeckViewModel;
    private final ViewManagerModel viewManagerModel;
    private final HashMap<String, Deck> decks;
    private final DeleteDeckController deleteDeckController;
    private Deck selectedDeck = null;
    final JList<Deck> deckJList;
    final DefaultListModel<Deck> deckListModel;
    final JScrollPane scrollPane;
    final JButton back;
    final JButton edit;
    final JButton delete;
    final JButton createNewDeck;

    public DecksView(DeleteDeckController deleteDeckController, DecksViewModel decksViewModel,
                     DeleteDeckViewModel deleteDeckViewModel, ViewManagerModel viewManagerModel) {
        this.deleteDeckController = deleteDeckController;
        this.decksViewModel = decksViewModel;
        this.deleteDeckViewModel = deleteDeckViewModel;
        this.viewManagerModel = viewManagerModel;
        this.decks = Main.player.getDecks();
        deleteDeckViewModel.addPropertyChangeListener(this);

        deckJList = new JList<Deck>(decks.values().toArray(new Deck[0]));

        deckListModel = new DefaultListModel<>();
        deckListModel.addAll(decks.values());
        deckJList.setModel(deckListModel);


        // Create a JScrollPane to enable scrolling
        scrollPane = new JScrollPane(deckJList);
        scrollPane.setPreferredSize(new Dimension(800, 600));

        JPanel buttons = new JPanel();

        back = new JButton(decksViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

        edit = new JButton(decksViewModel.EDIT_DECK_BUTTON_LABEL);
        edit.setEnabled(false);
        buttons.add(back);

        delete = new JButton(decksViewModel.DELETE_DECK_BUTTON_LABEL);
        delete.setEnabled(false);
        buttons.add(delete);

        createNewDeck = new JButton(decksViewModel.CREATE_NEW_DECK_BUTTON_LABEL);
        buttons.add(createNewDeck);

        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.WEST);
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
        delete.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deleteDeckController.execute(Main.player, selectedDeck);
                    }
                }
        );
        createNewDeck.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO
                    }
                }
        );
        deckJList.addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (!e.getValueIsAdjusting()) {
                            // The user has finished making a selection
                            selectedDeck = deckJList.getSelectedValue();

                            edit.setEnabled(true);
                            delete.setEnabled(true);
                            createNewDeck.setEnabled(true);
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
                DefaultListModel<Deck> listModel = (DefaultListModel<Deck>) deckJList.getModel();
                listModel.removeElement(deletedDeck);

                deckJList.clearSelection();
                edit.setEnabled(false);
                delete.setEnabled(false);
                createNewDeck.setEnabled(false);

                JOptionPane.showMessageDialog(this, deletedDeck + " successfully deleted!");
            } else {
                JOptionPane.showMessageDialog(this, deletedDeck + " failed to delete!");
            }
        }
    }
}
