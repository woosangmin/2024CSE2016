package GCD;

import javax.swing.*;

public class View {
    int[] getInt() {
        int[] array = new int[3];
        String input1 = JOptionPane.showInputDialog("0보다 큰 정수를 입력하세요!");
        String input2 = JOptionPane.showInputDialog("다른 0보다 큰 정수를 입력하세요!");
        array[0] = Integer.parseInt(input1);
        array[1] = Integer.parseInt(input2);
        return array;
    }
    void showGCD(int[] arr) {
        JOptionPane.showMessageDialog(null, arr[0] + "와(과) " + arr[1] + "의 최대공약수는 " + arr[2] + " 입니다." );
    }
}
