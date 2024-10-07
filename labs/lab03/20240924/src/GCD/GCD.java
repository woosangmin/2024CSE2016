package GCD;

public class GCD {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller();
        controller.control(model, view);
    }
}
