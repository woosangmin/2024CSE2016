package Clock;

public class Controller {
    void control(Model m, View v) {
        v.showSwing(m.whatTimeIsIt());
    }
}
