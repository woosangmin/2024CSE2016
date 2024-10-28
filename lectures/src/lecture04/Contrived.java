package lecture04;

import java.awt.*;

public class Contrived {

    private double d= 3.14;

    public Contrived() {
        System.out.println(s); // X3.14
        System.out.println(d); // 3.14
        int d = 2;
        System.out.println(d); // 2
        s = d + s; 
        System.out.println(s); // 2X3.14
    }

    private String s = "X" + d;

    public void printComponent(Graphics g) {
        System.out.println(d + " " + s); // frame이 없으므로 실제로 출력 안됨
    }

    public static void main(String[] args) {
        new Contrived();
    }
}
