package view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class ImageResizer {
    private ImageResizer() {}

    public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();

        return new ImageIcon(bufferedImage);
    }

    public static ImageIcon resizeIcon(ImageIcon icon, double percentage) {
        Image image = icon.getImage();

        int newWidth = (int) (image.getWidth(null) * percentage);
        int newHeight = (int) (image.getHeight(null) * percentage);

        BufferedImage bufferedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(image, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        return new ImageIcon(bufferedImage);
    }
}
