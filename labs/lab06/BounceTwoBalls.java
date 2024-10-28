// By the grace of the Lord
import java.awt.*;

/** BounceTheBall 애니메이션 객체를 생성하고 공 운동 시작 */
public class BounceTwoBalls {
    
    public static void main(String[] args) {
        // Model(box, MovingBall)
        int box_size = 400;
        int balls_radius = 10;
        Box box = new Box(box_size);
        // 서로 같지 않은 x1와 y1 좌표를 무작위로 생성
        int x1 = (int)(Math.random() * 10), y1 = (int)(Math.random() * 10);
        // loop invariant : y1와 x1의 값은 서로 달라야 한다.
        while (y1 == x1)
            y1 = (int)(Math.random() * 10);
        // 공1을 상자의 적절한 위치에 둠
        MovingBall ball1 = new MovingBall((int)(box_size / 3.0), (int)(box_size / 5.0), balls_radius, box);
        // 공1의 속도를 조절
        ball1.setVelocity(x1, y1);
        // 서로 같지 않은 x2와 y2 좌표를 무작위로 생성
        int x2 = (int)(Math.random() * 10), y2 = (int)(Math.random() * 10);
        // loop invariant : y2와 x2의 값은 서로 달라야 한다.
        while (y2 == x2)
            y2 = (int)(Math.random() * 10);
        // 공2를 상자의 적절한 위치에 둠
        MovingBall ball2 = new MovingBall((int)(box_size / 5.0), (int)(box_size / 3.0), balls_radius, box);
        // 공2의 속도를 조절
        ball2.setVelocity(x2, y2);
        // Output-View(BallWriters, BoxWriter, AnimationWriters) 생성
        BallWriters ball_writer = new BallWriters(ball1, Color.red, ball2, Color.blue);
        BoxWriter box_writer = new BoxWriter(box);
        AnimationWriters writer = new AnimationWriters(box_writer, ball_writer, box_size);
        // 컨트롤러 객체를 생성하고 애니메이션 시작
        new BounceControllers(ball1, ball2, writer).runAnimation();
    }
}
