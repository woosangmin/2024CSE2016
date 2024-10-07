package HelloWorld;

public class HelloWorld {
    public static void main(String[] args) {
        Model m = new Model();
        View v = new View();
        controller c = new controller();
        c.control(m, v);
    }
}
