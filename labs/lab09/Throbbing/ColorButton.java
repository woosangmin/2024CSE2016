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
        view.repaint(); // Panel을 다시 그린다.
    }
}
