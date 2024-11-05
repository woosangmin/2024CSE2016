package lecture04;

import java.awt.*;
import javax.swing.*;
import java.time.*;

public class ClockWriter extends JPanel {

    private final int width;

    public ClockWriter(int w) {
        width = w;
        JFrame frame = new JFrame();
        frame.getContentPane().add(this);
        frame.setTitle("Clock");
        frame.setSize(width, width);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void paintComponent(Graphics g) {
        // 바탕은 흰색
        g.setColor(Color.white);
        g.fillRect(0, 0, width, width);
        // 시계 크기 설정
        int x = width / 4;
        int y = width / 4;
        int diameter = width / 2;
        // 시계 판 그리기
        g.setColor(Color.black);
        g.drawOval(x, y, diameter, diameter);
        // 현재 시간 + 시침, 분침 각도 계산
        LocalTime now = LocalTime.now();
        int minutes_angle = 90 - now.getMinute() * 6;
        int hours_angle = 90 - now.getHour() * 30;
        // 분침 그리기
        g.setColor(Color.red);
        g.fillArc(x+5, x+5, diameter - 10, diameter - 10, minutes_angle, 5);
        //시침 그리기
        g.setColor(Color.blue);
        g.fillArc(x+25, x+25, diameter-50, diameter-50, hours_angle, -8);
    }

    public static void main(String[] args) {
            new ClockWriter(500);
    }
}
