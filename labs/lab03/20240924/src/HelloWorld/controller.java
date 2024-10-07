package HelloWorld;

public class controller {
    void control(Model m, View v) {
        String message = m.createGreetings();
        //v.show(message);
        v.showSwing(message);
    }
}
