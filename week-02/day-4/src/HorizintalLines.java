import javax.swing.*;
import java.awt.*;
import java.util.Random;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class HorizintalLines {

    public static void mainDraw(Graphics graphics) {
        // Create a function that draws a single line and takes 3 parameters:
        // The x and y coordinates of the line's starting point and the graphics
        // and draws a 50 long horizontal line from that point.
        // Draw at least 3 lines with that function using a loop.
        int x =40;
        int y =100;
        drawHorizontal(x, y, graphics);
    }

    private static void drawHorizontal(int x, int y, Graphics graphics) {
        for (int i = 0; i < 300; i+= 100) {
            graphics.setColor(new Color(randomGenerator(100), randomGenerator(120), randomGenerator(100)));
            graphics.drawLine(x+i, y, x+i, y+50);
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
