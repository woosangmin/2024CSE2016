import javax.swing.*;

public class DivisibleBy9Hard {
    public static void main(String[] args) {
        String input;
        int num, sum = 0;
        input = JOptionPane.showInputDialog("정수를 주세요.");
        while (true) {
            if (MileToKilo.isNumeric(input)) {
                num = Integer.parseInt(input);
                if ((num >= -99999 && num <= -10000) || (num >= 10000 && num <= 99999)) {
                    break;
                } else {
                    input = JOptionPane.showInputDialog("10000 ~ 99999 / -10000 ~ -99999까지의 정수를 주세요.");
                }
            } else {
                input = JOptionPane.showInputDialog("10000 ~ 99999 / -10000 ~ -99999까지의 정수를 주세요.");
            }
        }
        for (int i = 0 ; i < input.length() ; i++) {
            String c = String.valueOf(input.charAt(i));
            if (!c.equals("-")) {
                num = Integer.parseInt(c);
                sum += num;
            }

        }
        boolean yes = true;
        if (sum % 9 != 0) {
            yes = false;
        }
        JOptionPane.showMessageDialog(null, "정수 " + input + "은(는) 9로 나누어 떨어지나? " + yes);

    }
}
