import javax.swing.*;
import java.awt.*;
import java.util.Random;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangle {

    public static void mainDraw(Graphics graphics) {
        // draw four different size and color rectangles.
        // avoid code duplication.
        drawRec(graphics);
    }

    private static void drawRec(Graphics graphics) {
        for (int i = 0; i < 300 ; i+=10) {
            graphics.setColor(new Color(randomGenerator(256), randomGenerator(256), randomGenerator(256)));
            graphics.fill3DRect(randomGenerator(1000), randomGenerator(700), randomGenerator(400), randomGenerator(400), true);
        }
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

