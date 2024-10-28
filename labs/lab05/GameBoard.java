// By the grace of the Lord

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JPanel {

    /** player 1의 정보를 담을 객체 */
    private Player player1;
    /** player 2의 정보를 담을 객체 */
    private Player player2;
    /** 창의 가로 세로 크기 */
    private final int size = 300;
    /** 이겼을 때 출력할 문구 */
    private final String win = "이겼다";
    /** 비겼을 때 출력할 문구 */
    private final String tie = "비겼다";
    /** player 1의 주사위 숫자 묶음(문자열) */
    private String Dices1;
    /** player 2의 주사위 숫자 묶음(문자열) */
    private String Dices2;

    public GameBoard(Player p1, Player p2) {
        // 인자로 받은 p1과 p2를 각각 player1, player2에 대입 
        player1 = p1;
        player2 = p2;
        JFrame f = new JFrame();
        f.setTitle("주사위 게임");
        f.setSize(size, size);
        f.setVisible(true);
        f.getContentPane().add(this);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void paintComponent(Graphics g) {
        // 게임 진행과 상관없이 그릴 부분
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, size, size);
        g.setColor(Color.BLACK);
        // player 1의 이름, 점수 출력
        g.drawString(player1.getName(), 50, 100);
        g.drawString(Integer.toString(player1.getPoints()), 63, 120);
        // player 2의 이름, 점수 출력
        g.drawString(player2.getName(), 150, 100);
        g.drawString(Integer.toString(player2.getPoints()), 163, 120);

        if (player1.getRolled() != null && player2.getRolled() != null) {
            // 게임 진행 후(주사위를 굴린 다음)에 그릴 부분
            if (player1.getWins()) {
                // 만약 player1이 이겼다면 player1 측에 '이겼다' 출력
                g.drawString(win, 50, 140);
            } else if (player2.getWins()) {
                // 만약 player2가 이겼다면 player2 측에 '이겼다' 출력
                g.drawString(win, 150, 140);
            } else {
                // 비긴 경우 중간에 '비겼다' 출력
                g.drawString(tie, 100, 140);
            }
            // player 1과 2의 주사위 숫자 묶음(문자열)을 각각 출력
            g.drawString(Dices1, 55, 160);
            g.drawString(Dices2, 155, 160);
        }
    }

    /** showResult - 주사위를 던진 후 승패 출력
     * @param d1 - player 1의 주사위 숫자 묶음(문자열)
     * @param d2 - player 2의 주사위 숫자 묶음(문자열) */
    public void showResult(String d1, String d2) {
        Dices1 = d1;
        Dices2 = d2;
        this.repaint();
    }
    
    /** sayGoodBye - 사용자가 종료를 선택한 경우 종료 메시지 출력 */
    public void sayGoodBye() {
        JOptionPane.showMessageDialog(null, "이용해주셔서 감사합니다.");
    }
}
