import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PositionSquare {

    public static void mainDraw(Graphics graphics) {
        // create a function that draws one square and takes 3 parameters:
        // the x and y coordinates of the square's top left corner and the graphics
        // and draws a 50x50 square from that point.
        // draw 3 squares with that function.
        // avoid code duplication.
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 50000; i++) {
            int x = randomGenerator(1000);
            int y = randomGenerator(650);
            positionSquare(x, y, graphics);
        }
    }

    private static void positionSquare(int x, int y, Graphics graphics) {
        graphics.setColor(new Color(randomGenerator(256), randomGenerator(256), randomGenerator(256)));
        graphics.drawRect(x, y, 50, 50);
    }

    // Don't touch the code below
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

    public static int randomGenerator(int bound){
        Random random = new Random();
        return random.nextInt(bound);
    }
}
