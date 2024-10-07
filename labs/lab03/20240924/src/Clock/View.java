package Clock;
import javax.swing.*;
import java.time.*;

public class View {
    void show(LocalTime t) {
        System.out.println(t);
    }
    void showSwing(LocalTime t) {
        JOptionPane.showMessageDialog(null, t);
    }
}
