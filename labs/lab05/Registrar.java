import javax.swing.*;

public class Registrar {

    /** invitePlayer - showInputDialog로 플레이어 이름을 받아서 전달한다. */
    public String invitePlayer() {
        return JOptionPane.showInputDialog("이름을 등록해주세요.");
    }

    /** wantToContinue - showConfirmDialog로 게임을 계속할지 의사를 확인 후 전달한다.
     * 사용자가 Yes 버튼을 누르면 0을 전달한다. No 버튼을 누르면 다른 수를 전달한다. */
    public int wantToContinue() {
        return JOptionPane.showConfirmDialog(null, "계속 하시겠어요?");
    }
}
