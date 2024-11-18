import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends JButton implements ActionListener {
    private CounterFrame view;

    public ExitButton(String label, CounterFrame v) {
        super(label);
        view = v;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
