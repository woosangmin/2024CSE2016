import javax.swing.*;
import java.awt.*;

public class CounterFrame3 extends JFrame{
    private Counter count;
    private JLabel label =new JLabel("count = 0");

    public CounterFrame3(Counter c) {
        count = c;
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(label);
        //cp.add(new CountButton("OK", count, this));
        //cp.add(new ResetButton("Reset", count, this));
        setTitle("Counter");
        setSize(250, 80);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void update() {
        label.setText("count = " + count.countOf());
    }
}
