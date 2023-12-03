package view;

import app.Main;
import entities.Card;
import interface_adapters.CollectionViewModel;
import interface_adapters.ViewManagerModel;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static view.ImageIconCreator.createImageIconFromURL;
import static view.ImageResizer.resizeIcon;

public class CollectionView extends JPanel {
    public final String viewName = "Collection Menu";
    private ViewManagerModel viewManagerModel;
    private final CollectionViewModel collectionViewModel;
    private final List<Card> cards;
    final JButton back;

    public CollectionView(CollectionViewModel collectionViewModel, ViewManagerModel viewManagerModel) {
        this.collectionViewModel = collectionViewModel;
        this.viewManagerModel = viewManagerModel;
        this.cards = Main.player.getCollection().getCards();

        // Create a JList with the items
        JList<Card> cardList = new JList<Card>(cards.toArray(new Card[0]));

        // Create a JScrollPane to enable scrolling
        JScrollPane scrollPane = new JScrollPane(cardList);
        scrollPane.setPreferredSize(new Dimension(800, 600));

        this.setLayout(new BorderLayout());
        this.add(Box.createRigidArea(new Dimension(100, 0)), BorderLayout.WEST);
        this.add(scrollPane, BorderLayout.WEST);
        back = new JButton(collectionViewModel.BACK_BUTTON_LABEL);
        this.add(back);

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
        cardList.addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (!e.getValueIsAdjusting()) {
                            // The user has finished making a selection
                            Card selectedCard = cardList.getSelectedValue();

                            String description = selectedCard.getName() + '\n';
                            JLabel descriptionLabel = new JLabel(description);

                            ImageIcon cardImage = resizeIcon(createImageIconFromURL(selectedCard.getCardArt()), 0.5);
                            JLabel cardImageLabel = new JLabel(cardImage);

                            JPanel panel =  new JPanel(new BorderLayout());
                            panel.add(descriptionLabel);
                            panel.add(cardImageLabel);

                            JOptionPane.showOptionDialog(
                                    cardList,
                                    panel,
                                    selectedCard.getName(),
                                    JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.PLAIN_MESSAGE,
                                    null,  // No custom icon
                                    null,  // No custom options
                                    null);  // Default initial value
                        }
                    }
                });
    }
}
