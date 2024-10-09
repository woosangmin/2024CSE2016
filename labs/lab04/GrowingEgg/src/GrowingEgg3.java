import javax.swing.*;
import java.awt.*;

public class GrowingEgg3 extends JPanel {

// 실습 3
    private int net_size;
    private int egg_width = 60;
    private int egg_height = 40;
    private int x = 170; // net_size가 초기값이 없으므로 net_size / 2를 사용할 수 없음
    private int y = 180; // net_size가 초기값이 없으므로 net_size / 2를 사용할 수 없음
    private int count = 0;

    public GrowingEgg3(int frame_size) {
        net_size = frame_size; // 인자로 받은 frame_size를 net_size의 값으로 설정
        JFrame f = new JFrame();
        f.setTitle("Egg");
        f.setSize(frame_size, frame_size);
        f.setVisible(true);
        f.getContentPane().add(this);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void paintComponent(Graphics g) {
        count += 1; // count가 2보다 큰 경우에만 너비와 높이에 각각 60, 40씩 더한다.
        if (count >= 2) {
            egg_width += 60;
            egg_height += 40;
            x = (net_size / 2) - (egg_width / 2);
            y = (net_size / 2) - (egg_height / 2);
        } else { // count가 2보다 작은 경우 x, y의 값을 다시 산출한다.
            x = (net_size / 2) - (egg_width / 2);
            y = (net_size / 2) - (egg_height / 2);
        }
        g.setColor(Color.green);
        g.fillRect(0, 0, net_size, net_size);
        g.setColor(Color.yellow);
        g.fillOval(x, y, egg_width, egg_height);
    }

    public static void main(String[] args) {
        new GrowingEgg3(600);
    }
}