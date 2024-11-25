import javax.swing.*;

public class CounterStarter {
    public static void main(String[] args) {
        Counter model = new Counter(0);
        JPanel panel = new Drawing(model);
        CounterFrame view = new CounterFrame(model, panel);
    }
}
