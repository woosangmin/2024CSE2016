import javax.swing.*;
import java.awt.*;

/** AnimationWriter 상자와 공의 애니메이션 디스플레이 */
public class AnimationWriters extends JPanel{
    private BoxWriter box_writer; // 상자 그리는 객체
    private BallWriters ball_writer1; // 공 그리는 객체

    /** Constructor AnimationWriter 상자와 공을 그리는 View 객체를 생성
     * @param b 상자 그리는 객체
     * @param l 공 그리는 객체
     * @param size 프레임의 크기 */
    public AnimationWriters(BoxWriter b, BallWriters l, int size) {
        box_writer = b;
        ball_writer1 = l;
        JFrame f = new JFrame();
        f.getContentPane().add(this);
        f.setTitle("Bounce");
        f.setSize(size, size+22);
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /** paintComponent 공과 상자 그리기
     * @param g 그래픽스 펜 */
    public void paintComponent(Graphics g) {
        box_writer.paintComponent(g);
        ball_writer1.paintComponent(g, 1);
        ball_writer1.paintComponent(g, 2);
    }
}
