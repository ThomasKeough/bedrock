package view;

import entities.Player;
//import interface_adapters.game.GameController;
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

public class GameView extends JPanel  { //, PropertyChangeListener {
    public final String viewName = "game";

    private final GameViewModel gameViewModel;
    private final ViewManagerModel viewManagerModel;
//    private final GameInputListener gameInputListener;
//    private final GameController gameController;
//    private final Player playerOne;
//    private final Player playerTwo;
//    private final JButton swap;
    final JButton attack;


    private boolean attackButtonPressed;

    private boolean swapButtonPressed;

//    public GameView(GameController controller, GameViewModel gameViewModel) { //, GameInputListener gameInputListener, Player playerOne, Player playerTwo) {
    public GameView(GameViewModel gameViewModel, ViewManagerModel viewManagerModel) {
        this.gameViewModel = gameViewModel;
        this.viewManagerModel = viewManagerModel;
//        gameViewModel.addPropertyChangeListener((PropertyChangeListener) this);

        JLabel title = new JLabel(gameViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // TODO: add card art here?

        JPanel buttons = new JPanel();
        attack = new JButton(gameViewModel.ATTACK_BUTTON_LABEL);
        buttons.add(attack);

        attack.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                            attackButtonPressed = true;
                        }
                    }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }

}