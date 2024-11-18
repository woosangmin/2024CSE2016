/* By the grace of the Lord */

package Throbbing;

import javax.swing.*;
import java.awt.*;

/** JPanel과 JButton을 담을 JFrame */
public class ThrobFrame extends JFrame {

    /** Constructor
     * @param size frame의 크기
     * @param p Frame에 담을 Panel
     * @param b Frame에 담을 Button */
    public ThrobFrame(int size, ThrobPanel p, ColorButton b) {
        Container cp = getContentPane(); // 컨테이너 생성
        cp.setLayout(new BorderLayout()); // 컨테이너의 레이아웃 설정
        cp.add(p, BorderLayout.CENTER); // Panel은 Layout의 Center에
        cp.add(b, BorderLayout.SOUTH); // Button은 Layout의 South에 담는다.

        setTitle("Throb"); // title 설정
        setSize(size, size); // Frame의 크기 설정
        setVisible(true); // Frame이 보이게 한다.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 프레임 종료 시 프로그램도 같이 종료
    }
}
