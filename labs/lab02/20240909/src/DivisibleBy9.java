import javax.swing.*;

public class DivisibleBy9 {
    public static void main(String[] args) {
        int num;
        String input;
        input = JOptionPane.showInputDialog("정수를 주세요.");
        while (true) {
            if (MileToKilo.isNumeric(input)) {
                num = Integer.parseInt(input);
                if (num >= -99999 && num <= 99999) {
                    break;
                } else {
                    input = JOptionPane.showInputDialog("-99999 ~ 99999까지의 정수를 주세요.");
                }
            } else {
                input = JOptionPane.showInputDialog("-99999 ~ 99999까지의 정수를 주세요.");
            }
        }
        boolean yes = true;
        if (num % 9 != 0) {
            yes = false;
        }
        JOptionPane.showMessageDialog(null, "정수 " + input + "은(는) 9로 나누어 떨어지나? " + yes);
    }
}
