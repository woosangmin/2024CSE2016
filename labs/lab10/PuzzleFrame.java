/* By the grace of the Lord */



import javax.swing.*;
import java.awt.*;

public class PuzzleFrame extends JFrame {
    // 보드의 상태를 나타내는 SlidePuzzleBoard
    private SlidePuzzleBoard board;
    // 사용자에게 보여지는 PuzzleButton 보드
    private PuzzleButton[][] button_board;
    // 프로그램 시작 시 사용할 변수
    private boolean first = true;

    /** Constructor
     * @param b 보드의 상태를 나타내는 SlidePuzzleBoard */
    public PuzzleFrame(SlidePuzzleBoard b) {
        // board 초기화
        board = b;
        // boardsize * boardsize 크기의 GridLayout 생성
        Container cp = getContentPane();
        // BorderLayout 생성
        cp.setLayout(new BorderLayout());
        // North에 담을 JPanel p1 생성
        JPanel p1 = new JPanel(new FlowLayout());
        p1.add(new StartButton(board, this));
        cp.add(p1, BorderLayout.NORTH);
        // Center에 담을 JPanel p2 생성
        JPanel p2 = new JPanel(new GridLayout(board.getBoardsize(), board.getBoardsize()));
        cp.add(p2, BorderLayout.CENTER);

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
                p2.add(button_board[i][j]); // 생성한 button_board를 p2에 집어넣는다.
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
                    if (board.getgameOn()) { // 게임을 진행 중인 경우
                        button_board[i][j].setBackground(Color.BLACK); // 버튼의 바탕색은 검은색으로 칠하고
                        button_board[i][j].setText(""); // 버튼에 아무것도 표기하지 않는다.
                    } else { // 게임이 끝났거나 시작하지 않은 경우
                        button_board[i][j].setBackground(Color.WHITE); // 버튼의 바탕색은 하얀색으로 칠하고
                        if (first) {
                            button_board[i][j].setText(""); // 처음 시작한 경우 버튼에 아무것도 표기하지 않는다.
                            first = false; // first를 false로 설정하여 처음 시작하지 않았음을 표시한다.
                        }
                        else button_board[i][j].setText("Done"); // 퍼즐을 완성시킨 경우 버튼에 "Done"을 표기한다.
                    }
                }
            }
        }
    }
}
