import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LineInTheMiddle {
    public static void mainDraw(Graphics graphics){
        // draw a red horizontal line to the canvas' middle.
        // draw a green vertical line to the canvas' middle.
        graphics.setColor(Color.red);
        graphics.drawLine(0,0,WIDTH, HEIGHT);
        graphics.drawLine(0, HEIGHT, WIDTH, 0);
        graphics.setColor(Color.blue);
        graphics.drawLine(WIDTH/2, 0, WIDTH/2, HEIGHT);
        graphics.drawLine(0, HEIGHT/2, WIDTH, HEIGHT/2);


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
            this.setBackground(Color.black);
            mainDraw(graphics);
        }
    }
    }

