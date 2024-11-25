import javax.swing.*;

public class NumberException {
    public static void main(String[] args) {
        int n = readInt();
        String answer = 100 + " 나누기 " + Integer.toString(n) + " = " + (100 / n);
        JOptionPane.showMessageDialog(null, answer);
    }

    private static int readInt() {
        int n;
        String input = JOptionPane.showInputDialog("정수를 주세요. 100에서 나누어 드립니다.");
        try {
            n = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " 정수가 아닙니다.");
            n = readInt();
        }
        return n;
    }
}
