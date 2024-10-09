import java.awt.*;
import javax.swing.*;

public class GrowingEgg extends JPanel {

//실습 1
    public GrowingEgg() {
        JFrame f = new JFrame();
        f.setTitle("Egg");
        f.setSize(400, 400);
        f.setVisible(true);
        f.getContentPane().add(this); // Contents 영역에 추가
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void paintComponent(Graphics g) {
         g.setColor(Color.green);
         g.fillRect(0, 0, 400, 400);
         g.setColor(Color.yellow);
         g.fillOval(170, 180, 60, 40); //알의 크기는 너비가 60, 높이가 40이다. 시작 좌표는 200 - (60 / 2), 200 - (40 / 2)
 }


    public static void main(String[] args) {
                new GrowingEgg();
    }
}