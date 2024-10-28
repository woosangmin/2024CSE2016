import java.awt.*;

/** BallWriter 움직이는 공을 그림 */
public class BallWriters {

    private MovingBall ball1; // 공1 객체
    private Color ball1_color; // 공1의 색깔
    private MovingBall ball2; // 공2 객체
    private Color ball2_color; // 공2의 색깔

    /** Constructor BallWriter
     * @param x1 공1 객체
     * @param c1 공1의 색깔
     * @param x2 공2 객체
     * @param c2 공2의 색깔 */
    public BallWriters(MovingBall x1, Color c1, MovingBall x2, Color c2) {
        ball1 = x1;
        ball1_color = c1;
        ball2 = x2;
        ball2_color = c2;
    }

    /** paint 공 그리기
     * @param g 그래픽스 펜 */
    public void paintComponent(Graphics g, int seq){
        if (seq == 1) {
            g.setColor(ball1_color);
            int radius1 = ball1.getRadius();
            g.fillOval(ball1.getXposition() - radius1, ball1.getYposition() - radius1, radius1 * 2, radius1 * 2);
        } else {
            g.setColor(ball2_color);
            int radius2 = ball2.getRadius();
            g.fillOval(ball2.getXposition() - radius2, ball2.getYposition() - radius2, radius2 * 2, radius2 * 2);
        }
    }
}
