package view;

import entities.Player;
import interface_adapters.game.GameController;
import interface_adapters.game.GameState;
import use_cases.game.GameInputListener;
import interface_adapters.game.GameViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GameView extends JPanel implements ActionListener { //, PropertyChangeListener {
    public final String viewName = "game";

    private final GameViewModel gameViewModel;
//    private final GameInputListener gameInputListener;
    private final GameController gameController;
//    private final Player playerOne;
//    private final Player playerTwo;
//    private final JButton swap;
    private final JButton attack;

    private boolean attackButtonPressed;

    private boolean swapButtonPressed;

    public GameView(GameController controller, GameViewModel gameViewModel) { //, GameInputListener gameInputListener, Player playerOne, Player playerTwo) {
        this.gameController = controller;
        this.gameViewModel = gameViewModel;
//        this.gameInputListener = gameInputListener;
//        this.playerOne = playerOne;
//        this.playerTwo = playerTwo;


        // TODO: fix this
//        gameViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(gameViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // TODO: add card art here?

        JPanel buttons = new JPanel();
//        swap = new JButton(gameViewModel.SWAP_BUTTON_LABEL);
//        buttons.add(swap);
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

        //TODO: finish this
//        swap.addActionListener(
//                new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent evt) {
//                        swapButtonPressed = true;
//                    }
//                }
//        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Cancel not implemented yet.");
    }
    // TODO: fix this (delete actionPerformed and propertyChange in interface?)
//    @Override
//    public void propertyChange(PropertyChangeEvent evt) {
//        GameState state = (GameState) evt.getNewValue();
//        if (state.getUsernameError() != null) {
//            JOptionPane.showMessageDialog(this, state.getUsernameError());
//        }
//    }
}