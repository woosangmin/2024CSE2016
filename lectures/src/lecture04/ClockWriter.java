package lecture04;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;

public class ClockWriter extends JPanel {

    private final int WIDTH;


    void foo() {
        System.out.println(n);
        int n = 333;
        System.out.println(n);
    }
    private int n = 3;
    private int x = n + 3;

    public int add(int x, int y) {
        int r = x + y;
        return mult(r, r);
    }

    public int mult(int x, int y) {
        int r = x * y;
        return add(r, r);
    }

    public ClockWriter(int w) {
        WIDTH = w;
        JFrame frame = new JFrame();
        frame.setTitle("Clock");
        frame.getContentPane().add(this);
        frame.setSize(WIDTH, WIDTH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void paintComponent(Graphics g) {
        int x = 50;
        int y = 50;
        int diameter = 100;
        LocalTime now = LocalTime.now();
        int minutes_angle = 90 - now.getMinute() * 6;
        int hours_angle = 90 - now.getHour() * 30;
        g.setColor(Color.WHITE);
        g.fillRect(0 , 0, WIDTH, WIDTH);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, diameter, diameter);
        g.setColor(Color.red);
        g.fillArc(x+5, y+5,diameter - 10, diameter - 10,
                minutes_angle, 5);
        g.setColor(Color.blue);
        g.fillArc(x+25, y+25, diameter - 50, diameter - 50,
                hours_angle, -8);
    }

    public static void main(String[] args) {
        new ClockWriter(200);
    }
}
