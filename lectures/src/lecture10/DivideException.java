import javax.swing.*;

public class DivideException {
    public static void main(String[] args) {
        int n = readInt(); // static 이므로 객체를 생성하지 않아도 된다.
        String answer = 100 + " 나누기 " + Integer.toString(n) + " = " + (100 / n);
        JOptionPane.showMessageDialog(null, answer);
    }

    private static int readInt() {
        String input = JOptionPane.showInputDialog("정수를 주세요. 100에서 나누어 드립니다.");
        int n = Integer.parseInt(input.trim());
        return n;
    }
}
