package view;

import interface_adapters.MainViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;

import static view.ImageResizer.resizeIcon;

public class MainView extends JPanel {
    public final String viewName = "Main Menu";
    private final MainViewModel mainViewModel;
    final JButton start;

    public MainView(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;

        JLabel title = new JLabel("Pokemon");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        start = new JButton(MainViewModel.START_BUTTON_LABEL);
        buttons.add(start);

        try {
            ImageIcon pokemonLogo = new ImageIcon("images/pokemon_logo.png");
            ImageIcon resizedPokemonLogo = resizeIcon(pokemonLogo, 0.25);
            title.setIcon(resizedPokemonLogo);
        } catch (Exception e) {
            throw new RuntimeException("Error loading image: " + e.getMessage());
        }

        this.add(title);
        this.add(buttons);

        start.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(start)) { // start button is clicked
                            System.out.println("Button Pushed");
                        }
                    }
                }
        );
    }
}
