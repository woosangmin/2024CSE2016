// By the grace of the Lord
import javax.swing.*;

public class Registrar {
    /** isDigit - 문자열을 숫자로 바꿀 수 있는지 확인 하는 함수
     * @param s - 확인하고자 하는 문자열
     * @return result - 확인한 결과 */
    private boolean isDigit(String s) {
        boolean result = true;
        try {
            int n = Integer.parseInt(s);
            return result;
        } catch (ArithmeticException e) {
            result = false;
            return result;
        }
    }

//    /** chooseEven() - 플레이어 공격 시 홀/짝 여부를 입력받아 리턴한다.
//     * true는 짝수, false는 홀수를 의미한다.
//     * @return result - 플레이어의 홀/짝 선택*/
//    public boolean chooseEven() {
//        // 반환값, 기본값으로 true(짝)을 선택한다.
//        boolean result = true;
//        // 플레이어로부터 홀/짝을 입력받는다.
//        int input = JOptionPane.showConfirmDialog(null, "홀(Yes)/짝(No)을 고르시오.", "Confirm", JOptionPane.YES_NO_OPTION);
//        // loop invariant : 사용자의 입력은 두 가지의 입력(YES_OPTION, NO_OPTION)중 하나이다.
//        while (input == JOptionPane.CLOSED_OPTION) {
//            input = JOptionPane.showConfirmDialog(null, "홀(Yes)/짝(No)을 고르시오.", "Confirm", JOptionPane.YES_NO_OPTION);
//        }
//        // 만약 사용자가 No(홀)를 선택한 경우 result의 값을 false로 바꾼다.
//        if (input == JOptionPane.NO_OPTION)
//            result = false;
//        return result;
//    }

    /** chooseEven() - 플레이어 공격 시 홀/짝 여부를 입력받아 리턴한다.
     * true는 짝수, false는 홀수를 의미한다.
     * @return result - 플레이어의 홀/짝 선택*/
    public boolean chooseEven() {
        // 반환값, 기본값으로 true(짝)을 선택한다.
        boolean result = true;
        // while loop를 제어할 변수
        boolean processing = true;
        // 플레이어로부터 홀/짝을 입력받을 변수
        String input = null, n_input = null;
        // loop invariant : 사용자의 입력은 두 가지의 입력(홀, 짝)중 하나이다.
        while (processing) {
            input = JOptionPane.showInputDialog(null, "홀과 짝 중 한 단어를 입력하시오.");
            if (input != null) {
                // 사용자의 입력이 null이 아닌 경우 input 문자열의 공백을 지우고 n_input에 저장한다.
                n_input = input.trim();
                if (n_input.equals("홀") || n_input.equals("짝"))
                    // n_input이 "홀"이나 "짝이면 loop를 중지한다.
                    processing = false;
            }
        }
        // 만약 사용자가 홀을 선택한 경우 result의 값을 false로 바꾼다.
        if (n_input.equals("홀"))
            result = false;
        return result;
    }

    /** chooseForAttack - 플레이어가 공격 시 몇 개의 구슬을 집을지 입력받는다.
     * @param max - 플레이어가 현재 가진 구슬의 수와 컴퓨터가 현재 가진 구슬의 수 중
     *            작은 값을 입력받는다.
     * @return num - 사용자의 입력, 촤소 1에서 최대 5개까지 가능하나
     *               최대값이 max보다 클 수 없다.
     */
    public int chooseForAttack(int max) {
        // 확인된 최대값을 담을 변수이자 사용자의 입력을 담을 변수
        // 최대값과 5를 비교하여 그 중 작은 수를 num에 저장한다.
        int num = Math.min(5, max);
        // 사용자로부터 집고자 하는 구슬의 수를 입력받는다.
        String input = JOptionPane.showInputDialog(null, "몇 개의 구슬을 집으시겠어요? (1 ~ " + num + ")까지 집을 수 있습니다.");
        // 만약 사용자가 아무것도 입력하지 않았으면 게임을 종료한다.
        if (input == null) {
            System.out.println("게임을 종료합니다.");
            System.exit(0);
        }
        // loop invariant : 사용자의 입력은 1 ~ 최대값(5 또는 max) 사이의 정수여야 한다.
        while (input.isEmpty() || !isDigit(input) || Integer.parseInt(input) > num || Integer.parseInt(input) < 1) {
            input = JOptionPane.showInputDialog(null, "몇 개의 구슬을 집으시겠어요? (1 ~ " + num + ")까지 집을 수 있습니다.");
            // 만약 사용자가 아무것도 입력하지 않았으면 게임을 종료한다.
            if (input == null) {
                System.out.println("게임을 종료합니다.");
                System.exit(0);
            }
        }
        // 사용자의 입력을 정수로 변환하여 저장한다.
        num = Integer.parseInt(input);
        return num;
    }

    /** chooseForGuard - 플레이어가 방어 시 몇 개의 구슬을 집을지 입력받는다.
     * @param max - 플레이어가 현재 가진 구슬의 수와 컴퓨터가 현재 가진 구슬의 수 중
     *              작은 값을 입력받는다.
     * @return num - 사용자의 입력은 최소 0에서 최대 5개까지 가능하나,
     * 최대값이 max보다 클 수 없다. */
    public int chooseForGuard(int max) {
        // 확인된 최대값을 담을 변수이자 사용자의 입력을 담을 변수
        // 최대값과 5를 비교하여 그 중 작은 수를 num에 저장한다.
        int num = Math.min(5, max);
        // 사용자로부터 집고자 하는 구슬의 수를 입력받는다.
        String input = JOptionPane.showInputDialog(null, "몇 개의 구슬을 집으시겠어요? (0 ~ " + num + ")까지 집을 수 있습니다.");
        // 만약 사용자가 아무것도 입력하지 않았으면 게임을 종료한다.
        if (input == null) {
            System.out.println("게임을 종료합니다.");
            System.exit(0);
        }
        // loop invariant : 사용자의 입력은 0 ~ 최대값(5 또는 max) 사이의 정수여야 한다.
        while (input.isEmpty() || !isDigit(input) || Integer.parseInt(input) > num || Integer.parseInt(input) < 0) {
            input = JOptionPane.showInputDialog(null, "몇 개의 구슬을 집으시겠어요? (0 ~ " + num + ")까지 집을 수 있습니다.");
            // 만약 사용자가 아무것도 입력하지 않았으면 게임을 종료한다.
            if (input == null) {
                System.out.println("게임을 종료합니다.");
                System.exit(0);
            }
        }
        // 사용자의 입력을 정수로 변환하여 저장한다.
        num = Integer.parseInt(input);
        return num;
    }
}
