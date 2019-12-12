import javax.swing.*;
import java.awt.*;
import java.util.Random;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CenteredSquare {

    public static void mainDraw(Graphics graphics) {
        // Draw a green 10x10 square to the canvas' center.
        int x =40;
        int y =50;
        //backCage(graphics);
        centeredSquare(graphics);


    }

    private static void centeredSquare(Graphics graphics) {
        for (int i = 0; i < 500; i+= 10) {
            graphics.setColor(new Color(randomGenerator(10), randomGenerator(10), randomGenerator(10)));
            graphics.drawRect((WIDTH+i)/8, (HEIGHT+i)/8, (WIDTH+i)/3, (HEIGHT+i)/3);
        }
    }
    private static void backCage(Graphics graphics){
        for (int i = 0; i < 3700; i+=10) {
            graphics.setColor(new Color(randomGenerator(100), randomGenerator(100), randomGenerator(100)));
            graphics.drawLine((WIDTH+i)/8, (HEIGHT)/8, (WIDTH+i)/8, 323);
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
