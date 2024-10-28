import java.awt.*;

/** BounceTheBall 애니메이션 객체를 생성하고 공 운동 시작 */
public class BounceTheBall {
    
    public static void main(String[] args) {
        // 모델 객체 생성
        int box_size = 200;
        int balls_radius = 6;
        // 서로 같지 않은 x와 y 좌표를 무작위로 생성
        int x = (int)(Math.random() * 10), y = (int)(Math.random() * 10);
        // loop invariant : y와 x의 값은 서로 달라야 한다.
        while (y == x)
            y = (int)(Math.random() * 10);
        Box box = new Box(box_size);
        // 공을 상자의 적절한 위치에 둠
        MovingBall ball = new MovingBall((int)(box_size / 3.0), (int)(box_size / 5.0), balls_radius, box);
        // 공의 속도를 조절
        ball.setVelocity(x, y);
        BallWriter ball_writer = new BallWriter(ball, Color.red);
        BoxWriter box_writer = new BoxWriter(box);
        AnimationWriter writer = new AnimationWriter(box_writer, ball_writer, box_size);
        // 컨트롤러 객체를 생성하고 애니메이션 시작
        new BounceController(ball, writer).runAnimation();
    }
}
