package view;

import app.Main;
import entities.Card;
import interface_adapters.HubViewModel;
import interface_adapters.MainViewModel;
import interface_adapters.ViewManagerModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;;

import static view.ImageIconCreator.createImageIcon;
import static view.ImageResizer.resizeIcon;

public class MainView extends JPanel {
    public final String viewName = "Main Menu";
    private final MainViewModel mainViewModel;
    private ViewManagerModel viewManagerModel;
    final JLabel pokemonLogoLabel;
    final JButton start;
    final ImageIcon backgroundIcon;
    final JLabel backgroundLabel;

    public MainView(MainViewModel mainViewModel, ViewManagerModel viewManagerModel) {
        this.mainViewModel = mainViewModel;
        this.viewManagerModel = viewManagerModel;


        // Start Button
        start = new JButton(mainViewModel.START_BUTTON_LABEL);
        start.setPreferredSize(new Dimension(150, 50));
        start.setFont(new Font("Roboto", Font.BOLD, 16));

        // Loading images
        try {
            // Pokemon Logo
            pokemonLogoLabel = new JLabel();
            ImageIcon pokemonLogo = resizeIcon(createImageIcon("images/pokemon_logo.png"), 0.25);
            pokemonLogoLabel.setIcon(pokemonLogo);

            backgroundIcon = resizeIcon(createImageIcon("images/main_bg.jpg"), 1280, 720);
        } catch (Exception e) {
            throw new RuntimeException("Error loading image: " + e.getMessage());
        }

        backgroundLabel = new JLabel(backgroundIcon);

        backgroundLabel.setLayout(new OverlayLayout(backgroundLabel));
        this.add(backgroundLabel, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(Box.createRigidArea(new Dimension(0, 115)));
        panel.add(pokemonLogoLabel);
        panel.add(start);
        panel.setOpaque(false);

        backgroundLabel.add(panel, BorderLayout.CENTER);

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
