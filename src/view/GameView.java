package view;

import app.Main;
import entities.Card;
import entities.Collection;
import entities.CommonCollection;
import entities.Player;
import interface_adapters.ViewManagerModel;
import interface_adapters.game.GameState;
import use_cases.game.GameInputListener;
import interface_adapters.game.GameViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import static view.ImageIconCreator.createImageIcon;
import static view.ImageIconCreator.createImageIconFromURL;
import static view.ImageResizer.resizeIcon;

public class GameView extends JPanel {
    public final String viewName = "Game Menu";

    private final GameViewModel gameViewModel;
    private final ViewManagerModel viewManagerModel;

    private List<Card> cards;
    final JLabel currentPokemonCard;
    final JLabel opponentPokemonCard;
    private boolean attackButtonPressed;

    final ImageIcon backgroundIcon;
    final JLabel backgroundLabel;

    private boolean swapButtonPressed;

    public GameView(GameViewModel gameViewModel, ViewManagerModel viewManagerModel) {
        this.gameViewModel = gameViewModel;
        this.viewManagerModel = viewManagerModel;

        this.cards = Main.player.getCurrentDeck().getCards();
        Collection opponentDeck = new CommonCollection(6);
        opponentDeck.initializeCollection(true);

        List<Card> opponentCards = opponentDeck.getCards();

        Card selectedCard = cards.get(0);
        Card opponentCard = opponentCards.get(0); // Assuming the opponent's card is the second card in the list

        JLabel title = new JLabel(gameViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton attack = new JButton(gameViewModel.ATTACK_BUTTON_LABEL);
        JButton back = new JButton(gameViewModel.BACK_BUTTON_LABEL);
        panel.add(attack);
        panel.add(back);

        currentPokemonCard = new JLabel();
        ImageIcon pokemon = resizeIcon(createImageIconFromURL(selectedCard.getCardArt()), 0.5);
        currentPokemonCard.setIcon(pokemon);

        opponentPokemonCard = new JLabel();
        ImageIcon opponentPokemon = resizeIcon(createImageIconFromURL(opponentCard.getCardArt()), 0.5);
        opponentPokemonCard.setIcon(opponentPokemon);

        JPanel cardPanel = new JPanel(new BorderLayout());
        cardPanel.add(currentPokemonCard, BorderLayout.WEST);
        cardPanel.add(opponentPokemonCard, BorderLayout.EAST);
        panel.add(cardPanel);

        panel.setOpaque(false);

        try {
            backgroundIcon = resizeIcon(createImageIcon("images/main_bg.jpg"), 1280, 720);
        } catch (Exception e) {
            throw new RuntimeException("Error loading image: " + e.getMessage());
        }

        backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new BorderLayout());

        // Add the panel to the JLabel
        backgroundLabel.add(panel, BorderLayout.CENTER);

        // Add the JLabel to 'this' JPanel
        this.add(backgroundLabel, BorderLayout.CENTER);

        attack.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        attackButtonPressed = true;
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)) {
                            System.out.println("THIS BUTTON IS BEING PRESSED");
                            // Set activeView to HubView
                            viewManagerModel.setActiveView("Hub View");
                        }
                    }
                }
        );
    }
}
