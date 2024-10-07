package Temperature;

import javax.swing.*;

public class View {
    double getTemperature() {
        String message = "섭씨 온도를 입력해주세요(소수점 가능).";
        String input = JOptionPane.showInputDialog(message);
        double n_c = Double.parseDouble(input);
        return n_c;
    }
    void showTemperature(double c, double f) {
        JOptionPane.showMessageDialog(null, "섭씨" + c + "도는 화씨로 " + f + "도입니다.");
    }
}
