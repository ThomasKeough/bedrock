package view;

import interface_adapters.HubViewModel;
import interface_adapters.MainViewModel;
import interface_adapters.ViewManagerModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;;

import static view.ImageResizer.resizeIcon;

public class MainView extends JPanel {
    public final String viewName = "Main Menu";
    private final MainViewModel mainViewModel;
    private ViewManagerModel viewManagerModel;
    final JButton start;

    public MainView(MainViewModel mainViewModel, ViewManagerModel viewManagerModel) {
        this.mainViewModel = mainViewModel;
        this.viewManagerModel = viewManagerModel;

        JLabel pokemonLogoLabel = new JLabel();

        JPanel logoPanel = new JPanel();
        logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.PAGE_AXIS));

        JPanel buttons = new JPanel();
        start = new JButton(mainViewModel.START_BUTTON_LABEL);
        start.setPreferredSize(new Dimension(150, 50));
        start.setFont(new Font("Roboto", Font.BOLD, 16));
        buttons.add(start);

        try {
            ImageIcon pokemonLogo = new ImageIcon("images/pokemon_logo.png");
            ImageIcon resizedPokemonLogo = resizeIcon(pokemonLogo, 0.25);
            pokemonLogoLabel.setIcon(resizedPokemonLogo);
        } catch (Exception e) {
            throw new RuntimeException("Error loading image: " + e.getMessage());
        }

        setLayout(new BorderLayout());

        this.add(pokemonLogoLabel, BorderLayout.NORTH);
        this.add(buttons, BorderLayout.CENTER);

        start.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(start)) {
                            // Set activeView to HubView
                            viewManagerModel.setActiveView("Hub Menu");
                            viewManagerModel.firePropertyChanged();
                        }
                    }
                }
        );
    }
}
