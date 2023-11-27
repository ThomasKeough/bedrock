package view;

import interface_adapters.attack.AttackController;
import interface_adapters.game.GameController;
import interface_adapters.game.GameViewModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GameView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "game";

    private final GameViewModel gameViewModel;
//    private final JTextField usernameInputField = new JTextField(15);
//    private final JPasswordField passwordInputField = new JPasswordField(15);
//    private final JPasswordField repeatPasswordInputField = new JPasswordField(15);
    private final GameController gameController;

    private final JButton swap;
    private final JButton attack;

    public GameView(GameController controller, GameViewModel gameViewModel) {

        this.gameController = controller;
        this.gameViewModel = gameViewModel;
        gameViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(gameViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // TODO: add card art here? (if time allows)

        JPanel buttons = new JPanel();
        swap = new JButton(gameViewModel.SWAP_BUTTON_LABEL);
        buttons.add(swap);
        attack = new JButton(gameViewModel.ATTACK_BUTTON_LABEL);
        buttons.add(attack);

        attack.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        // TODO: fix this
                        if (evt.getSource().equals(attack)) {
                            AttackController.execute(signupViewModel.getState().getUsername(),
                                    String.valueOf(signupViewModel.getState().getPassword()),
                                    String.valueOf(signupViewModel.getState().getRepeatPassword()));
                        }
                    }
                }
        );
        swap.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(swap)) {
                            // TODO: fill this in (call swapController.execute)
                        }
                    }
                }
        );

        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the usernameInputField.
        //
        // Notice how it has access to instance variables in the enclosing class!
//        usernameInputField.addKeyListener(
//                new KeyListener() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//                        SignupState currentState = signupViewModel.getState();
//                        currentState.setUsername(usernameInputField.getText() + e.getKeyChar());
//                        signupViewModel.setState(currentState);
//                    }
//
//                    @Override
//                    public void keyPressed(KeyEvent e) {
//                    }
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {
//                    }
//                });
//
//        passwordInputField.addKeyListener(
//                new KeyListener() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//                        SignupState currentState = signupViewModel.getState();
//                        currentState.setPassword(passwordInputField.getText() + e.getKeyChar());
//                        signupViewModel.setState(currentState);
//                    }
//
//                    @Override
//                    public void keyPressed(KeyEvent e) {
//                    }
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {
//                    }
//                });
//
//        repeatPasswordInputField.addKeyListener(
//                new KeyListener() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//                        SignupState currentState = signupViewModel.getState();
//                        currentState.setRepeatPassword(repeatPasswordInputField.getText() + e.getKeyChar());
//                        signupViewModel.setState(currentState);
//                    }
//
//                    @Override
//                    public void keyPressed(KeyEvent e) {
//                    }
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {
//                    }
//                });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
//        this.add(usernameInfo);
//        this.add(passwordInfo);
//        this.add(repeatPasswordInfo);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }
}