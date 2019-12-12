import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ColoredBoxes {
    public static void mainDraw(Graphics graphics){
        graphics.setColor(new Color(randomGenerator(256), randomGenerator(256), randomGenerator(256)));
        graphics.drawLine(200, 300, 200,500);
        graphics.setColor(new Color(randomGenerator(256), randomGenerator(256), randomGenerator(256)));
        graphics.drawLine(200, 500, 500, 500);
        graphics.setColor(new Color(randomGenerator(256), randomGenerator(256), randomGenerator(256)));
        graphics.drawLine(500, 500, 500, 300);
        graphics.setColor(new Color(randomGenerator(256), randomGenerator(256), randomGenerator(256)));
        graphics.drawLine(500, 300, 200, 300);

    }
    public static int randomGenerator(int bound){
        Random random = new Random();
        return random.nextInt(bound);
    }

    private static void drawCenteredRectRects( int width, int height, int numberOfBoxes, Graphics graphics) {
        for (int i = 0; i < numberOfBoxes; i++) {
            graphics.clearRect(width, height, width,height);
        }
    }


    static int WIDTH = 1366;
    static int HEIGHT = 705;
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);
        }
    }
}

