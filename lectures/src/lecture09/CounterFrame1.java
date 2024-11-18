import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterFrame1 extends JFrame implements ActionListener{
    private Counter count;
    private JLabel label =new JLabel("count = 0");

    public CounterFrame1(Counter c) {
        count = c;
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(label);
        JButton button = new JButton("OK");
        cp.add(button);
        button.addActionListener(this);
        setTitle("Counter");
        setSize(250, 80);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        count.increment();
        label.setText("count = " + count.countOf());
    }
}
