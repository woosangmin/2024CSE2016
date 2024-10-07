package lecture04;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {

    public Canvas() {
        JFrame frame = new JFrame();
        frame.setTitle("Canvas");
        frame.setSize(300, 200);
        frame.getContentPane().add(this);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 300, 200);
        g.setColor(Color.red);
        g.drawRect(100, 60, 90, 60);
        g.fillOval(100, 60, 50, 50);
        g.setColor(Color.green);
        g.fillArc(100, 60, 50, 50, 45, 20);
        g.setColor(Color.blue);
        g.fillArc(100, 60, 50, 50, 270, 30);
    }

    public static void main(String[] args) {
        new Canvas();
    }
}