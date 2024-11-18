import javax.swing.*;
import java.awt.*;

public class Drawing extends JPanel {
    private Counter count;

    public Drawing(Counter model) {
        count = model;
        setSize(250, 200);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 240, 200);
        g.setColor(Color.RED);
        int x = 0, y= 0;
        for (int i = 0 ; i != count.countOf() ; i++) {
            g.fillOval(x * 25, y * 25, 20, 20);
            x++;
            if (x > 8) {
                x = 0;
                y++;
            }
        }
    }
}
