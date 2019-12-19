import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangle {

    public static void drawTriangles(Graphics graphics){


            graphics.drawLine(0, 0, WIDTH/4, HEIGHT/2);
            graphics.drawLine(WIDTH/4, HEIGHT/2, WIDTH/2, 0);
            graphics.drawLine(WIDTH/2, 0, 0, 0);

            graphics.drawLine(WIDTH/4, HEIGHT/2, WIDTH/2, HEIGHT);
            graphics.drawLine(WIDTH/2, HEIGHT, WIDTH*3/4, HEIGHT/2);
            graphics.drawLine(WIDTH*3/4, HEIGHT/2, WIDTH/4, HEIGHT/2);

            graphics.drawLine(WIDTH/2, 0, WIDTH*3/4, HEIGHT/2);
            graphics.drawLine(WIDTH*3/4, HEIGHT/2, WIDTH, 0);
            graphics.drawLine(WIDTH, 0, WIDTH/2, 0);



    }
    public static void mainDraw(Graphics graphics){
        drawTriangles(graphics);

    }

    // Don't touch the code below
    static int WIDTH = 360;
    static int HEIGHT = 360;

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
