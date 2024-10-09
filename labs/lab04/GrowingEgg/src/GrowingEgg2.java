import javax.swing.*;
import java.awt.*;

public class GrowingEgg2 extends JPanel {



// 실습 2
    private final int NET_SIZE = 400;
    private int egg_width = 60;
    private int egg_height = 40;
    private int x = 170;
    private int y = 180;
    private int count = 0; // 너비와 높이를 60, 40 씩 늘릴 때 사용할 변수

        public GrowingEgg2() {
        JFrame f = new JFrame();
        f.setTitle("Egg");
        f.setSize(NET_SIZE, NET_SIZE);
        f.setVisible(true);
        f.getContentPane().add(this); // Contents 영역에 추가
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public void paintComponent(Graphics g) {
        count += 1; // count가 2보다 큰 경우에만 너비와 높이에 각각 60, 40씩 더한다.
        if (count >= 2) {
            egg_width += 60;
            egg_height += 40;
            x = 200 - (egg_width / 2);
            y = 200 - (egg_height / 2);
        }
        g.setColor(Color.green);
        g.fillRect(0, 0, NET_SIZE, NET_SIZE);
        g.setColor(Color.yellow);
        g.fillOval(x, y, egg_width, egg_height);
    }



    public static void main(String[] args) {
            new GrowingEgg2();
    }
}