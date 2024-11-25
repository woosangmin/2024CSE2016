/* By the grace of the Lord */

package Throbbing;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener 버튼이 눌릴 때마다 공의 색깔을 바꾼다.
 * */
public class ColorButton extends JButton implements ActionListener {
    // 공의 색깔을 바꾸기 위해 필요한 view
    private ThrobPanel view;

    /** Constructor
     * @param f 공의 색깔을 바꾸기 위해 필요한 view */
    public ColorButton(ThrobPanel f) {
        // 버튼의 텍스트를 'OK'로 지정
        super("OK");
        // view에 ThrobPanel f를 대입
        view = f;
        // 자신의 상태에 변화가 있는지 기다린다.
        addActionListener(this);
    }

    /** actionPerformed 이벤트 핸들러
     * @param e 발생한 이벤트 */
    public void actionPerformed(ActionEvent e) {
        if (view.getColor().equals(Color.RED))
            view.setColor(Color.BLUE); // 공의 색깔이 빨간색이면 파란색으로
        else view.setColor(Color.RED); // 파란색이면 빨간색으로 바꾼다.
        // view.repaint();
        /* Panel을 다시 그린다. -> 비동기 : 자원이 부족한 프로그램의 경우 비동기 함수를 사용할 때 실행시간을 조작해서는 안된다.
         * 일부 코드가 실행되지 않을 수 있다. 비동기 함수 안에 출력 기능을 추가 하지 않는 것이 좋다.
         * 우리가 CPU 스케줄링을 통제할 수 없으므로 우리가 호출한 함수가 계산량이 많은 경우 완벽하게 계산되지 않고
         * 본래 함수로 돌아오게 될 수도 있다. 이런 문제는 빌드 중에는 찾아내기 어렵다. */
    }
}
