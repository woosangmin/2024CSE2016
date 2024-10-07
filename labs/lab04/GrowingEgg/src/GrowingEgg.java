import java.awt.*;
import javax.swing.*;

public class GrowingEgg extends JPanel {

//    private final int NET_SIZE = 400;
//    private int egg_width = 60;
//    private int egg_height = 40;
//    private int x = 170;
//    private int y = 180;
//    private int count = 0; // 너비와 높이를 60, 40 씩 늘릴 때 사용할 변수
//
//    public GrowingEgg() {
//        JFrame f = new JFrame();
//        f.setTitle("Egg");
//        f.setSize(400, 400);
//        f.setVisible(true);
//        f.getContentPane().add(this);
//        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//    }
//
//    public void paintComponent(Graphics g) {
////         // 실습 1
////         g.setColor(Color.green);
////         g.fillRect(0, 0, 400, 400);
////         g.setColor(Color.yellow);
////         g.fillOval(170, 180, 60, 40); //알의 크기는 너비가 60, 높이가 40이다. 시작 좌표는 200 - (60 / 2), 200 - (40 / 2)
//        // 실습 2
//        count += 1; // count가 2보다 큰 경우에만 너비와 높이에 각각 60, 40씩 더한다.
//        if (count >= 2) {
//            egg_width += 60;
//            egg_height += 40;
//            x = 200 - (egg_width / 2);
//            y = 200 - (egg_height / 2);
//        }
//        g.setColor(Color.green);
//        g.fillRect(0, 0, NET_SIZE, NET_SIZE);
//        g.setColor(Color.yellow);
//        g.fillOval(x, y, egg_width, egg_height);
//    }
//
    // 실습 3
    private int net_size;
    private int egg_width = 60;
    private int egg_height = 40;
    private int x = 170; // net_size가 초기값이 없으므로 net_size / 2를 사용할 수 없음
    private int y = 180; // net_size가 초기값이 없으므로 net_size / 2를 사용할 수 없음
    private int count = 0;

    public GrowingEgg(int frame_size) {
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
        new GrowingEgg(600);
    }
}