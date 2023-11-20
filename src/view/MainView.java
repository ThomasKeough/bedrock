package view;

import interface_adapters.MainViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class MainView extends JPanel {
    public final String viewName = "Main Menu";
    private MainViewModel mainViewModel;
    final JButton start;

    public MainView(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;

        JLabel title = new JLabel("Pokemon");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        start = new JButton(mainViewModel.START_BUTTON_LABEL);
        buttons.add(start);

        try {
            ImageIcon pokemonLogo = new ImageIcon("images/pokemon_logo.png");
            ImageIcon resizedPokemonLogo = resizeIcon(pokemonLogo, 0.2);
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
                            System.out.println("Balls");
                        }
                    }
                }
        );
    }

    private static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();

        return new ImageIcon(bufferedImage);
    }

    private static ImageIcon resizeIcon(ImageIcon icon, double percentage) {
        Image image = icon.getImage();

        int newWidth = (int) (image.getWidth(null) * percentage);
        int newHeight = (int) (image.getHeight(null) * percentage);

        BufferedImage bufferedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(image, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        return new ImageIcon(bufferedImage);
    }}
