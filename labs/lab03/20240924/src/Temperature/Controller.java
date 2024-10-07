package Temperature;

public class Controller {
    void control(Model m, View v) {
        double c = v.getTemperature();
        double f = m.ctof(c);
        v.showTemperature(c, f);
    }
}
