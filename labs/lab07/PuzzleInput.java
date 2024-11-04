/* By the grace of the Lord */
import javax.swing.*;

public class PuzzleInput {

    /** isDigit() - 문자열을 숫자로 바꿀 수 있는지 확인하는 메소드
     * @param s - 확인하고자 하는 문자열
     * @return 숫자로 바꿀 수 있는지 여부*/
    private boolean isDigit(String s) {
        // 문자열을 숫자로 바꿀 수 있으면 true를 바꿀 수 없으면 false를 반환한다.
        try {
            int n = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /** getInput - 사용자로부터 옮기고자 하는 값을 입력받는 메소드
     * @param limit - 사용자가 입력할 수 있는 최대값 
     * @return num - 사용자의 입력값*/
    public int getInput(int limit) {
        // 반환할 값
        int num = -1;
        // 루프 종료 조건
        boolean processing = true;
        while (processing) {
            // 사용자의 입력을 받을 메시지 창
            String message = "움직일 퍼즐 조각 번호를 선택하세요!(1 ~ " + (limit-1) + ")";
            String input = JOptionPane.showInputDialog(message);
            // 아무런 입력도 받지 않았으면 num을 -1로 설정하고 루프 종료
            if (input == null) {
                num = -1;
                break;
            }
            // 입력이 숫자인 경우 num에 숫자 저장, 아닌 경우 다음 루프로 넘어간다.
            if (isDigit(input)) {
                num = Integer.parseInt(input);
            } else {
                continue;
            }
            // 숫자가 0보다 크고 최대 입력값보다 작으면 루프를 종료한다.
            if (num > 0  && num < limit)
                processing = false;
        }
        return num;
    }
}
