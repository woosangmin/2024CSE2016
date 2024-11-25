
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountButton extends JButton implements ActionListener {
    private CounterFrame view;
    private Counter model;

    public CountButton(String label, Counter m, CounterFrame v) {
        super(label);
        view = v;
        model = m;
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        model.increment();
        view.update();
    }
}
