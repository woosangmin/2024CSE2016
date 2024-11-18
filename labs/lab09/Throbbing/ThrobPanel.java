package Throbbing;

import javax.swing.*;
import java.awt.*;

/** Panel frame의 정중앙을 맡은 JPanel */
public class ThrobPanel extends JPanel {
    // 패널의 크기
    private int panel_size;
    // 공의 위치
    private int location;
    // 공의 크기
    private int ball_size;
    // 공의 색깔
    private Color c;
    // 볼의 상태를 확인하기 위한 ball
    private ThrobbingBall ball;

    /** Constructor
     * @param size 패널의 크기
     * @param b ThrobbingStarter에서 생성한 공 */
    public ThrobPanel(int size, ThrobbingBall b) {
        panel_size = size; // panel_size에 size를 대입하고
        setSize(panel_size, panel_size); // panel의 크기를 가로 세로 panel_size 만큼 생성한다.
        ball = b; // ball에는 b를 대입한다.
        c = Color.RED; // 공의 색깔은 빨간색으로 선택한다.
        ball_size = 60; // 공의 크기는 작은 공으로 선택한다.
        location = (size - ball_size - 20) / 2; // 공의 위치에 대한 계산식
    }

    /** getColor 공의 색상을 반환 
     * @return c 공의 색상 */
    public Color getColor() {
        return c;
    }

    /** setColor 공의 색상을 변경
     * @param new_color 바꾸고자 하는 색상 */
    public void setColor(Color new_color) {
        c = new_color;
    }

    /** setBall_size 공의 크기를 변경 */
    public void setBall_size() {
        if (ball.isLarge()) ball_size = 120; // 큰 공의 크기는 120
        else ball_size = 60; // 작은 공의 크기는 60
    }
    
    /** setLocation 공의 크기에 맞춰 위치를 다시 계산 */
    public void setLocation() {
        location = (panel_size - ball_size - 20) / 2;
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE); // 바탕색
        g.fillRect(0, 0, panel_size, panel_size); // 패널 전체를 바탕색으로 채운다.
        g.setColor(c); // 공의 색깔을 선택
        setBall_size(); // 공의 크기를 계산
        setLocation(); // 공의 위치를 계산
        g.fillOval(location, location, ball_size, ball_size); // 공을 그린다.
    }
}
