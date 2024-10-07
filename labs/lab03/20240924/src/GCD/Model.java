package GCD;

public class Model {
    int[] calcGCD(int[] arr) {
        int x = arr[0];
        int y = arr[1];
        int result;
        while (true) {
            if (x == 0) {
                result = y;
                break;
            } else if (y == 0) {
                result = x;
                break;
            }else if (x == y) {
                result = x;
                break;
            } else if (x > y) {
                x = x % y;
            } else {
                y = y % x;
            }
        }
        arr[2] = result;
        return arr;
    }
}
