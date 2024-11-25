import javax.swing.*;

public class DialogReader {
    public String readString(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }
    public int readInt(String prompt) {
        int n;
        String input = readString(prompt);
        try {
            n = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " 정수가 아닙니다.");
            n = readInt(prompt);
        }
        return n;
    }
    public double readDouble(String prompt) {
        double n;
        String input = readString(prompt);
        try {
            n = Double.parseDouble(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " 실수가 아닙니다.");
            n = readDouble(prompt);
        }
        return n;
    }

    public static void main(String[] args) {
        int n = new DialogReader().readInt("정수를 주세요. 100에서 나누어 드립니다.");
        try {
            String answer = "100에서 나누기 " + Integer.toString(n) + " = " + (100 / n);
        } catch (java.lang.ArithmeticException e) {
            JOptionPane.showMessageDialog(null, e.getMessage() + " : 0으로 나눌 수 없습니다.");
        }
    }
}
