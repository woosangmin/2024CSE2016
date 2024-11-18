/* By the grace of the Lord */

package PuzzleBoard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PuzzleButton extends JButton implements ActionListener {
    // Control 하고자 하는 board
    private SlidePuzzleBoard board;
    // Control 하고자 하는 frame
    private PuzzleFrame frame;
    // 버튼에 표시된 숫자
    private int num;

    /** Constructor
     * @param b Control 하고자 하는 board
     * @param f Control 하고자 하는 frame*/
    public PuzzleButton(SlidePuzzleBoard b, PuzzleFrame f) {
        board = b;
        frame = f;
        addActionListener(this); // 자신의 상태에 변화가 있는지 기다린다.
    }

    /** actionPerformed 이벤트 핸들러
     * @param e 발생한 이벤트 */
    public void actionPerformed(ActionEvent e) {
        String s = this.getText(); // button에 표시된 문자를 불러 온다.
        if (!s.isEmpty()) { // s가 빈 문자열이 아니면(숫자가 0이 아니면)
            num = Integer.parseInt(this.getText()); // 문자를 숫자로 변환 한다.
            if (board.move(num)) { // 버튼을 옮길 수 있는 경우 버튼을 옮긴다.
                frame.update(); // frame을 다시 그린다.
            } else { // 움직일 수 없으면 알림 메시지를 띄운다.
                JOptionPane.showMessageDialog(null, "움직일 수 없습니다.");
            }
        }
        if (board.win()) { // 퍼즐을 푸는데 성공하였으면 알림 메시지를 띄우고 프로그램을 종료한다.
            JOptionPane.showMessageDialog(null, "퍼즐을 완성하셨습니다.");
            System.exit(0);
        }
    }
}
