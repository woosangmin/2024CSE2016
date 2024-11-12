package lecture06.movingball;

import java.awt.*;

public class BounceTheBall {
    public static void main(String[] args) {
        // 모델 객체 생성
        int box_size = 1000;
        int balls_radius = 30;
        Box box = new Box(box_size);
        // 공을 상자의 적절한 위치에 둠
        MovingBall ball = new MovingBall((int)(box_size / 3.0),
                (int)(box_size / 5.0),
                balls_radius, box);
        BallWriter ball_writer1 = new BallWriter(ball, Color.red);
        BoxWriter box_writer  = new BoxWriter(box);
        AnimationWriter writer = new AnimationWriter(box_writer, ball_writer1, box_size);
        // 컨트롤러 객체를 생성하고 애니메이션 시작
        new BounceController(ball, writer).runAnimation();
    }
}
