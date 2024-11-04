/* By the grace of the Lord */
import javax.swing.*;
import java.awt.*;

public class PuzzleWriter extends JPanel {
    /** 출력할 퍼즐 보드 */
    private SlidePuzzleBoard board;
    /** 출력할 JFrame의 크기 */
    private final int PANEL_SIZE;
    /** 출력할 보드의 행과 열의 크기 */
    private int board_size;
    /** 보드 한 칸의 사이즈 */
    private final int box_size;
    /** 출력할 퍼즐 보드의 내용 */
    private PuzzlePiece[][] content;

    /** PuzzleWriter - 생성자
     * @param b - PuzzleController에서 생성한 보드 */
    public PuzzleWriter(SlidePuzzleBoard b) {
        // 출력할 퍼즐 보드 초기화
        board = b;
        // 출력할 퍼즐 보드의 내용
        content = board.getContents();
        // 보드의 행과 열의 크기
        board_size = board.getBoardsize();
        // JFrame의 크기를 초기화한다.
        PANEL_SIZE = board_size * 100;
        // 보드 한 칸의 사이즈를 초기화한다.
        box_size = (int)(PANEL_SIZE * 0.8) / board_size;

        JFrame f = new JFrame();
        f.getContentPane().add(this);
        f.setTitle("Slide Puzzle");
        // 좌우 여백을 적당히 선택한다.
        f.setSize((int)(PANEL_SIZE*1.03), (int)(PANEL_SIZE*1.1));
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void paintComponent(Graphics g) {
        // 글자의 폰트 크기를 설정
        g.setFont(new Font("Arial", Font.BOLD, 20));
        // 바탕색 설정
        g.setColor(Color.YELLOW);
        // 바탕색으로 JFrame을 채운다.
        g.fillRect(0, 0, PANEL_SIZE, (int)(PANEL_SIZE*1.1));
        // initial x와 y 좌표를 각각 JFrame 크기의 10분의 1의 값으로 설정한다.
        int start_x = (int)(PANEL_SIZE * 0.1), start_y = (int)(PANEL_SIZE * 0.1);
        for (int x = 0 ; x < board_size ; x++) {
            // x_position은 최초 시작점부터 box_size만큼 늘려나간다.
            int x_position = start_x + x * box_size;
            for (int y = 0; y < board_size ; y++) {
                // y_position도 최초 시작점부터 box_size만큼 늘려나간다.
                int y_position = start_y + y * box_size;
                // 비어있는 칸인지 확인하기 위해 해당 위치의 값을 c에 저장한다.
                int c = content[x][y].getFacevalue();
                // 테두리의 색 설정
                g.setColor(Color.BLACK);
                // box크기 만큼 사각형을 그린다.
                g.drawRect(x_position, y_position, box_size, box_size);
                if (c != 0) {
                    // 칸이 비어있지 않은 경우
                    // 하얀색으로 바탕색 설정
                    g.setColor(Color.WHITE);
                    // 테두리를 가리지 않도록 좌표를 1씩 옮기고 box의 크기도 1씩 줄인다.
                    g.fillRect(x_position+1, y_position+1, box_size-1, box_size-1);
                    // 글자색 설정
                    g.setColor(Color.BLACK);
                    // 퍼즐의 액면값을 문자열로 변환
                    String c_1 = Integer.toString(c);
                    // 액면값의 자릿수 계산
                    int len = c_1.length();
                    // 액면값의 자릿수에 맞춰 각 칸의 중앙에 액면값 표기
                    g.drawString(c_1 , x_position + (box_size / 2) - 5 * len, y_position + (box_size / 2) + 5 * len);
                } else {
                    // 칸이 비어 있는 경우 바탕색을 검정으로 하여 칸을 채운다.
                    g.setColor(Color.BLACK);
                    g.fillRect(x_position, y_position, box_size, box_size);
                }
            }
        }
    }

    /** displayPuzzle() - 수정된 보드를 다시 그리도록 하는 메소드 */
    public void displayPuzzle() {
        this.repaint();
    }

    /** printMessage - 문자열을 받아 알림창을 띄우는 메소드 
     * @param s - 사용자에게 알리고자 하는 메시지 */
    public void printMessage(String s) {
        JOptionPane.showMessageDialog(null, s);
    }
}
