package view;

import javax.swing.*;
import java.net.URL;

public class ImageIconCreator {
    private ImageIconCreator() {}

    public static ImageIcon createImageIcon(String directory) {
        return new ImageIcon(directory);
    }

    // Method to create an ImageIcon from a URL
    public static ImageIcon createImageIconFromURL(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            return new ImageIcon(url);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load image: " + e.getMessage());
        }
    }
}
