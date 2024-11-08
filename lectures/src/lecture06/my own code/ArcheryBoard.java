import javax.swing.*;
import java.awt.*;

public class ArcheryBoard extends JPanel{
    private int board_size = 400;

    /** Constructor ArcheryBoard 패널을 만들고 프레임을 씌움 */
    public ArcheryBoard() {
        JFrame f = new JFrame();
        f.getContentPane().add(this);
        f.setTitle("Archery Board");
        f.setSize(board_size+15, board_size+36);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /** paintComponent 패널에 그림을 그림
     * @param g 그래픽스 펜 */
    public void paintComponent(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, board_size, board_size);
        paintBoard(g);
    }
    /** paintBoard 양궁과녁을 그림
     * @param g 그래픽스 펜 */
    private void paintBoard(Graphics g) {
        int x = 0, y = 0, radius = board_size, count = 0;
        /* loop invariant : 총 10 개의 원을 그린다.
           0 <= count <= 1 : 외곽선은 검정, 원 내부는 흰색
           1 < count <= 3 : 외곽선은 흰색, 원 내부는 검정
           3 < count <= 5 : 외곽선은 흰색, 원 내부는 파랑
           5 < count <= 7 : 외곽선은 흰색, 원 내부는 빨강
           7 < count < 10 : 외곽선은 빨강, 원 내부는 노랑
        */
        while (count < 10) {
            // 원의 외곽선을 그린다.
            if (count <= 1) g.setColor(Color.black);
            else if (count <= 7) g.setColor(Color.WHITE);
            else g.setColor(Color.red);
            g.drawOval(x, y, radius, radius);
            // 원을 알맞은 색깔로 채운다.
            if (count <= 1) g.setColor(Color.WHITE);
            else if (count <= 3) g.setColor(Color.black);
            else if (count <= 5) g.setColor(Color.BLUE);
            else if (count <= 7) g.setColor(Color.red);
            else g.setColor(Color.yellow);
            g.fillOval(x, y, radius, radius);
            // x좌표와 y좌표를 각각 20씩 늘린다.
            x += 20; y += 20;
            // 반지름을 x좌표와 y좌표를 늘린만큼 줄인다.
            radius -= 40;
            // 다음 loop로 넘어가도록 count를 1씩 증가한다.
            count++;
        }
    }

    public static void main(String[] args) {
        new ArcheryBoard();
    }
}
