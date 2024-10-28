/** MovingBall 2차원 상자에서 움직이는 공 */
public class MovingBall {
    private int x_pos; // 공의 중심 x 좌표
    private int y_pos; // 공의 중심 y 좌표
    private int radius; // 공의 반지름

    private int x_velocity; // x축 속도
    private int y_velocity; // y축 속도

    private Box container;

    /** Constructor MovingBall 공 만들기
     * @param x_initial 공의 중심 x 좌표
     * @param y_initial 공의 중심 y 좌표
     * @param r 공의 반지름
     * @param box 공이 살고 있는 상자 */
    public MovingBall(int x_initial, int y_initial, int r, Box box) {
        x_pos = x_initial;
        y_pos = y_initial;
        radius = r;
        container = box;
    }

    /** getXposition 공의 x축 위치 리턴 */
    public int getXposition() {
        return x_pos;
    }

    /** getYposition 공의 y축 위치 리천 */
    public int getYposition() {
        return y_pos;
    }

    /** getRadius 공의 반지름 리턴 */
    public int getRadius() {
        return radius;
    }

    /** setVelocity() 공의 속도를 조절 */
    public void setVelocity(int x_vel, int y_vel) {
        x_velocity = x_vel;
        y_velocity = y_vel;
    }

    /** move time_unit 만큼 공을 이동, 벽에 부딪히면 방향을 바꿈
     * @param time_units 프레임 사이의 시간 */
    public void move(int time_units) {
        x_pos = x_pos + x_velocity * time_units;
        if (x_pos <= 0) x_pos = 0;
        if (x_pos >= container.getSize()) x_pos = container.getSize() - 15;
        if (container.inHorizontalContact(x_pos))
            x_velocity = - x_velocity;
        y_pos = y_pos - y_velocity * time_units;
        if (y_pos <= 0) y_pos = 0;
        if (y_pos >= container.getSize()) y_pos = container.getSize() - 15;
        if (container.inVerticalContact(y_pos))
            y_velocity = - y_velocity;
    }
}
