/* By the grace of the Lord */



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

    /** isInt 문자열이 숫자인지 확인하는 메소드
     * @param s 확인하고자 하는 문자열
     * @return result 확인 결과 */
    private boolean isInt(String s) {
        boolean result = true; // 반환값
        try {
            num = Integer.parseInt(s); // 숫자 변환 시도
        } catch (NumberFormatException e) {
            result = false; // 에러 발생 시 false 반환
            return result;
        }
        return result; // 문제 없으면 true 반환
    }

    /** actionPerformed 이벤트 핸들러
     * @param e 발생한 이벤트 */
    public void actionPerformed(ActionEvent e) {
        String s = this.getText(); // button에 표시된 문자를 불러 온다.
        // board.win() 함수가 정상작동하는지 확인하기 위한 코드
//        if (s.isEmpty()) {
//            board.initializeBoard(true);
//            if (board.win()) { // 퍼즐을 완성시킨 경우
//                board.setgameOver(); // 퍼즐을 완성시켰다고 표시한다.
//                frame.update(); // frame을 다시 그린다.
//            }
//        }
        if (!s.isEmpty() && isInt(s)) { // s가 빈 문자열이 아니고 숫자로 변환 가능하면(숫자가 0이 아니면)
            num = Integer.parseInt(this.getText()); // 문자를 숫자로 변환 한다.
            if (board.getgameOn()) { // 퍼즐을 완성시키지 못한 경우
                if (board.move(num)) { // 버튼을 옮길 수 있는 경우 버튼을 옮긴다.
                    frame.update(); // frame을 다시 그린다.
                }
                if (board.win()) { // 퍼즐을 완성시킨 경우
                    board.setgameOver(); // 퍼즐을 완성시켰다고 표시한다.
                    frame.update(); // frame을 다시 그린다.
                }
            }
        }
    }
}
