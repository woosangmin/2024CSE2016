package HelloWorld;

import javax.swing.*;
public class View {
    void show(String message) {
        System.out.println(message);
    }
    void showSwing(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
