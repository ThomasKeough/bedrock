package view;

import app.Main;
import entities.Card;
import entities.Collection;
import interface_adapters.ViewManagerModel;
import view.ViewModel;

import interface_adapters.build_deck.BuildDeckController;
import interface_adapters.build_deck.BuildDeckState;
import interface_adapters.build_deck.BuildDeckViewModel;
import use_cases.build_deck.BuildDeckInputData;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static view.ImageIconCreator.createImageIconFromURL;
import static view.ImageResizer.resizeIcon;

public class BuildDeckView extends JPanel implements PropertyChangeListener {
    public final String viewName = "Build Deck Menu";
    private final BuildDeckViewModel buildDeckViewModel;
    private final ViewManagerModel viewManagerModel;
    private final BuildDeckController buildDeckController;
    public static List<Card> cards;
    private final List<Integer> highlightedRows = new ArrayList<>();
    private Card selectedCard = null;
    private List<Card> selectedCards;
    final JPanel buttons;
    final JButton back;
    final JButton addCard;
    final JButton removeCard;
    final JButton displayCard;
    final JButton buildDeck;
    final JScrollPane scrollPane;
    public static JList<Card> cardJList;

    public BuildDeckView(BuildDeckViewModel buildDeckViewModel, ViewManagerModel viewManagerModel,
                         BuildDeckController buildDeckController) {
        this.buildDeckViewModel = buildDeckViewModel;
        this.viewManagerModel = viewManagerModel;
        this.cards = Main.player.getCollection().getCards();
        this.buildDeckController = buildDeckController;
        this.selectedCards = new ArrayList<Card>();
        buildDeckViewModel.addPropertyChangeListener(this);

        // Create a JList with the items
        cardJList = new JList<Card>(cards.toArray(new Card[0]));

        // Create a JScrollPane to enable scrolling
        scrollPane = new JScrollPane(cardJList);
        scrollPane.setPreferredSize(new Dimension(800, 600));

        buttons = new JPanel(new FlowLayout());

        addCard = new JButton(buildDeckViewModel.ADD_CARD_BUTTON_LABEL);
        addCard.setEnabled(false);
        buttons.add(addCard);

        removeCard = new JButton(buildDeckViewModel.REMOVE_CARD_BUTTON_LABEL);
        removeCard.setEnabled(false);
        buttons.add(removeCard);

        buildDeck = new JButton(buildDeckViewModel.BUILD_DECK_BUTTON_LABEL);
        buildDeck.setEnabled(false);
        buttons.add(buildDeck);

        displayCard = new JButton(buildDeckViewModel.DISPLAY_CARD_BUTTON_LABEL);
        displayCard.setEnabled(false);
        buttons.add(displayCard);

        back = new JButton(buildDeckViewModel.BACK_BUTTON_LABEL);
        buttons.add(back);

        this.setLayout(new FlowLayout());
        this.add(scrollPane);
        this.add(buttons);

        cardJList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        addCard.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(addCard)) {
                            selectedCards.add(selectedCard);
                            highlightedRows.add(cardJList.getSelectedIndex());

                            updateHighlighting();

                            if (selectedCards.size() == 6) {
                                buildDeck.setEnabled(true);
                            }
                        }
                    }
                }
        );
        removeCard.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(removeCard)) {
                            if (selectedCards.size() == 6) {
                                buildDeck.setEnabled(false);
                            }
                            selectedCards.remove(selectedCard);
                            highlightedRows.remove(Integer.valueOf(cardJList.getSelectedIndex()));

                            updateHighlighting();
                        }
                    }
                }
        );
        buildDeck.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(buildDeck)) {
                            String deckName = JOptionPane.showInputDialog(null,
                                    "What would you like to name this deck?");
                            if (deckName != null) {
                                buildDeckController.execute(Main.player, deckName, selectedCards.get(0),
                                        selectedCards.get(1), selectedCards.get(2), selectedCards.get(3),
                                        selectedCards.get(4), selectedCards.get(5));
                            }
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
                            viewManagerModel.setActiveView("Decks Menu");
                            viewManagerModel.firePropertyChanged();
                            cardJList.setListData(cards.toArray(new Card[0]));

                        }
                    }
                }
        );
        displayCard.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Card Art
                        ImageIcon cardImage = resizeIcon(createImageIconFromURL(selectedCard.getCardArt()), 0.5);
                        JLabel cardImageLabel = new JLabel(cardImage);

                        JPanel panel =  new JPanel(new BorderLayout());
                        panel.add(cardImageLabel);

                        JOptionPane.showOptionDialog(
                                cardJList,
                                panel,
                                selectedCard.getName(),
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.PLAIN_MESSAGE,
                                null,  // No custom icon
                                null,
                                null);  // Default initial value
                    }
                }
        );
        cardJList.addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (!e.getValueIsAdjusting()) {
                            // The user has finished making a selection
                            selectedCard = cardJList.getSelectedValue();

                            if (!selectedCards.contains(selectedCard) && selectedCards.size() < 6) {
                                addCard.setEnabled(true);
                                removeCard.setEnabled(false);
                            } else if (selectedCards.contains(selectedCard)) {
                                addCard.setEnabled(false);
                                removeCard.setEnabled(true);
                            } else {
                                removeCard.setEnabled(false);
                            }
                        }
                    }
                });
    }

    private void updateHighlighting() {
        // Iterate through all rows and update the highlighting
        for (int i = 0; i < cards.size(); i++) {
            if (highlightedRows.contains(i)) {
                cardJList.addSelectionInterval(i, i);
            } else {
                cardJList.removeSelectionInterval(i, i);
            }
        }
        addCard.setEnabled(false);
        removeCard.setEnabled(false);
    }

    private void removeHighlighting() {
        cardJList.clearSelection();
        addCard.setEnabled(false);
        removeCard.setEnabled(false);
        buildDeck.setEnabled(false);
        highlightedRows.clear();
        selectedCards.clear();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("build deck")) {
            BuildDeckState state = (BuildDeckState) evt.getNewValue();
            if (!state.getUseCaseFailed()) {
                removeHighlighting();
                JOptionPane.showMessageDialog(this, "Successfully created!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to create!");
            }
        }
    }
}