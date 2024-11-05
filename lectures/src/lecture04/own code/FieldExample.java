package lecture04;

import java.awt.*;
import javax.swing.*;

public class FieldExample extends JPanel {

    private int count;

    public FieldExample() {
        count = 0;
        JFrame f = new JFrame();
        f.getContentPane().add(this);
        f.setSize(300, 200);
        f.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        count = count + 1;
        g.setColor(Color.black);
        g.drawString(count + "번 그렸습니다.", 25, 40);
    }

    public static void main(String[] args) {
        new FieldExample();
    }
}
