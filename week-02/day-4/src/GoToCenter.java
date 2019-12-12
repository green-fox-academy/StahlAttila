import javax.swing.*;
import java.awt.*;
import java.util.Random;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GoToCenter {

    public static void mainDraw(Graphics graphics) {
        // Create a function that draws a single line and takes 3 parameters:
        // The x and y coordinates of the line's starting point and the graphics
        // and draws a line from that point to the center of the canvas.
        // Draw at least 3 lines with that function using a loop.
        int x = randomGenerator(10);
        int y = randomGenerator(10);
        drawToCenter(x, y, graphics);



    }

    private static void drawToCenter(int x, int y, Graphics graphics) {
        for (int i = 0; i < 1000; i++) {
            graphics.setColor(new Color(randomGenerator(100), randomGenerator(120), randomGenerator(100)));
            graphics.drawLine(x+randomGenerator(1367), y+randomGenerator(706), WIDTH/2, HEIGHT/2);

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
