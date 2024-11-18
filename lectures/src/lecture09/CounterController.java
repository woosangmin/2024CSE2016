import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterController implements ActionListener{
    private CounterFrame2 view;
    private Counter model;

    public CounterController(Counter m, CounterFrame2 v){
        view = v;
        model = m;
    }

    public void actionPerformed(ActionEvent e) {
        model.increment();
        view.update();
    }
}
