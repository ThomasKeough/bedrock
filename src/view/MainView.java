package view;

import app.Main;
import entities.Card;
import interface_adapters.HubViewModel;
import interface_adapters.MainViewModel;
import interface_adapters.ViewManagerModel;

import javax.swing.*;
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
        backgroundLabel.setLayout(new GridBagLayout());
        this.setLayout(new GridBagLayout());
        this.add(backgroundLabel);

        // Create a panel to hold the logo and start button
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        // Add Pokemon logo
        GridBagConstraints logoConstraints = new GridBagConstraints();
        logoConstraints.gridx = 0;
        logoConstraints.gridy = 0;
        logoConstraints.weightx = 1;
        logoConstraints.weighty = 0.1;  // Adjust this value to move the logo more up
        logoConstraints.anchor = GridBagConstraints.CENTER;
        panel.add(pokemonLogoLabel, logoConstraints);

        // Add space between logo and button
        GridBagConstraints spaceConstraints = new GridBagConstraints();
        spaceConstraints.gridx = 0;
        spaceConstraints.gridy = 1;
        spaceConstraints.weighty = 0.01;  // Adjust this value to control the space between the logo and the button
        panel.add(Box.createRigidArea(new Dimension(0, 20)), spaceConstraints);

        // Add Start button
        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 2;
        buttonConstraints.weighty = 0.2;  // Adjust this value to move the button more up
        buttonConstraints.anchor = GridBagConstraints.CENTER;
        panel.add(start, buttonConstraints);

        // Make the panel transparent
        panel.setOpaque(false);

        // Center the panel both vertically and horizontally
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;

        backgroundLabel.add(panel, gbc);

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
