package Christmas;

import javax.swing.*;
import java.time.Period;

public class View {
    void showDate(Period bt) {
        //int years = bt.getYears();
        int months = bt.getMonths();
        int days = bt.getDays();
        JOptionPane.showMessageDialog(null,"올해 크리스마스까지 " + months +"달하고 " + days +"일 남았다!");
    }
}
