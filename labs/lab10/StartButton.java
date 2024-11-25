/* By the grace of the Lord */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButton extends JButton implements ActionListener {
    // Control 하고자 하는 board
    private SlidePuzzleBoard board;
    // Control 하고자 하는 frame
    private PuzzleFrame frame;

    /** Constructor
     * @param b Control 하고자 하는 board
     * @param f Control 하고자 하는 frame*/
    public StartButton(SlidePuzzleBoard b, PuzzleFrame f) {
        super("Start");
        board = b;
        frame = f;
        addActionListener(this); // 자신의 상태에 변화가 있는지 기다린다.
    }

    /** actionPerformed 이벤트 핸들러
     * @param e 발생한 이벤트 */
    public void actionPerformed(ActionEvent e) {
        // 퍼즐의 액면값을 랜덤하게 설정한다.
        board.initializeBoard(false);
        // 게임을 시작했음을 표시한다.
        board.setgameOn();
        // 프레임을 다시 그린다.
        frame.update();
    }
}
