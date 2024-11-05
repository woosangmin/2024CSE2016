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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.red);
        g.drawString("Java!", 100, 60);
    }

    public int add(int a, int b) {
        int r = a + b;
        return r;
    }

    public static void main(String[] args) {
        Canvas c = new Canvas();
    }
}
