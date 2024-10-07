import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class MileToKilo {
    public static boolean isNumeric(String str) {
        try {
            int num = Integer.parseInt(str);
        }catch(Exception e) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String miles;
        int n_miles;
        double kilo;
        miles = JOptionPane.showInputDialog("거리가 몇 마일입니까?");
        while (true) {
            if (isNumeric(miles)) {
                n_miles = Integer.parseInt(miles);
                if (n_miles < 0) {
                    miles = JOptionPane.showInputDialog("거리는 0보다 커야 합니다.");
                } else {
                    break;
                }
            } else {
                miles = JOptionPane.showInputDialog("거리로 정수를 입력해주세요.");
            }
        }
         kilo = n_miles * 1.60934;
        DecimalFormat format = new DecimalFormat("0.0"); // String.format("%.1f", number);
        JOptionPane.showMessageDialog(null, miles + " 마일은 " + format.format(kilo) + "킬로미터 입니다.");
    }
}
