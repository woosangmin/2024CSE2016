import javax.swing.*;

/** BounceController 상자 안에서 움직이는 공 제어 */
public class BounceControllers {
    private MovingBall ball1; // 공1 객체 (Model)
    private MovingBall ball2; // 공2 객체 (Model)
    private AnimationWriters writer; // 애니메이션 객체 (Output-View)

    /** Constructor BounceController 컨트롤러 초기화
     * @param b1 공 객체 (Model)
     * @param b2 공 객체 (Model)
     * @param w 애니메이션 객체 (Output-View) */
    public BounceControllers(MovingBall b1, MovingBall b2, AnimationWriters w) {
        ball1 = b1;
        ball2 = b2;
        writer = w;
    }

    /** runAnimation 내부 시계를 활용하여 애니메이션 구동 */
    public void runAnimation() {
        int time_unit = 1; // 애니메이션 스텝의 시간 단위
        int painting_delay = 20; // 다시 그리기 사이의 지연 시간 간격
        while (true) {
            // 시간 지연
            delay(painting_delay);
            // 공1과 공2를 각각 움직인다.
            ball1.move(time_unit);
            ball2.move(time_unit);
            // 피타고라스의 정리를 활용하여 두 공의 충돌 여부를 계산한다.
            double x = Math.abs(ball1.getXposition() - ball2.getXposition());
            double y = Math.abs(ball1.getYposition() - ball2.getYposition());
            x = Math.pow(x, 2); y = Math.pow(y, 2);
            double d = Math.sqrt(x + y);
            // 계산된 d의 값이 r보다 작거나 같으면 충돌하였으므로 프로그램을 종료한다.
            if (d <= ball1.getRadius()) {
                JOptionPane.showMessageDialog(null, "충돌했습니다.");
                System.out.println("충돌했습니다.");
                System.exit(1);
            }
            System.out.println("ball1's position : " + ball1.getXposition() + ", " + ball1.getYposition() + " / ball2's position : " + ball2.getXposition() + ", " + ball2.getYposition());
            writer.repaint();
        }
    }
    /** delay how_long millisecond 동안 실행 정지 */
    private void delay(int how_long) {
        try { Thread.sleep(how_long);}
        catch (InterruptedException e) { }
    }
}
