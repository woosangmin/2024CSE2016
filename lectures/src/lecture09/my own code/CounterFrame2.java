import javax.swing.*;
import java.awt.*;

public class CounterFrame2 extends JFrame{
    private Counter count;
    private JLabel label =new JLabel("count = 0");

    public CounterFrame2(Counter c) {
        count = c;
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(label);
        JButton button = new JButton("OK");
        cp.add(button);
        button.addActionListener(new CounterController(count, this));
        setTitle("Counter");
        setSize(250, 80);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void update() {
        label.setText("count = " + count.countOf());
    }
}
