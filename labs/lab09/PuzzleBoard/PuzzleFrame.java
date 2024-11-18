/* By the grace of the Lord */

package PuzzleBoard;

import javax.swing.*;
import java.awt.*;

public class PuzzleFrame extends JFrame {
    // 보드의 상태를 나타내는 SlidePuzzleBoard
    private SlidePuzzleBoard board;
    // 사용자에게 보여지는 PuzzleButton 보드
    private PuzzleButton[][] button_board;

    /** Constructor
     * @param b 보드의 상태를 나타내는 SlidePuzzleBoard */
    public PuzzleFrame(SlidePuzzleBoard b) {
        board = b;
        // boardsize * boardsize 크기의 GridLayout 생성
        setLayout(new GridLayout(board.getBoardsize(), board.getBoardsize()));
        setTitle("PuzzleFrame");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // boardsize * boardsize 크기의 button_board 생성
        button_board = new PuzzleButton[board.getBoardsize()][board.getBoardsize()];
        // PuzzleButton 객체를 생성하여 buttonboard에 집어넣는다.
        for (int i = 0 ; i < board.getBoardsize() ; i++) {
            for (int j = 0 ; j < board.getBoardsize() ; j++) {
                button_board[i][j] = new PuzzleButton(board, this);
                add(button_board[i][j]);
            }
        }
        this.update(); // 버튼의 색상과 숫자를 부여
    }

    /** update 보드의 현 상태를 반영하여 버튼의 색상과 숫자를 부여*/
    public void update() {
        PuzzlePiece[][] pieces = board.getContents(); // 보드의 현 상태를 불러온다.
        for (int i = 0 ; i < board.getBoardsize() ; i++) {
            for (int j = 0 ; j < board.getBoardsize() ; j++) {
                if (pieces[i][j].getFacevalue() != 0) { // 보드의 원소의 facevalue가 0이 아니면
                    button_board[i][j].setBackground(Color.white); // 버튼의 바탕색은 하얀색으로 칠하고
                    button_board[i][j].setText(String.valueOf(pieces[i][j].getFacevalue())); // 버튼에 facevalue를 표기한다.
                } else { // 보드의 원소의 facevalue가 0이면
                    button_board[i][j].setBackground(Color.BLACK); // 버튼의 바탕색은 검은색으로 칠하고
                    button_board[i][j].setText(""); // 버튼에 아무것도 표기하지 않는다.
                }
            }
        }
    }
}
