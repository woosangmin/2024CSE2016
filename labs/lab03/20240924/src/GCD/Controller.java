package GCD;

public class Controller {
    void control(Model m, View v) {
        int[] nums = v.getInt();
        v.showGCD(m.calcGCD(nums));
    }
}
