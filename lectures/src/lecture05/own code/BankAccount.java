import javax.swing.*;
import javax.swing.text.BadLocationException;

public class BankAccount {

    private int balance; // invariant : balance >= 0

    /** BackAccount - 계좌개설
     * @param initial_amount - 초기 입금 금액(0 이상 양수) */
     public BankAccount(int initial_amount) {
         if (initial_amount >= 0)
             balance = initial_amount;
         else balance = 0;
     }

    /** deposit - 입금
     * @param amount - 입금액 (0 이상 양수)
     * @return 입금 성공하면 true, 실패하면 false */
    public boolean deposit(int amount) {
        boolean result = false;

        if (amount >= 0) {
            balance = balance + amount;
            result = true;
        }
        else
            JOptionPane.showMessageDialog(null, "입금액에 문제가 있어서 입금이 취소되었습니다.");
        return result;
    }

    /** withdraw - 출금 (잔고가 있는 경우에 한해)
     * @param amount - 출금액 (0 이상 양수)
     * @return 출금 성공하면 true, 실패하면 false */
    public boolean withdraw(int amount) {
        boolean result = false;
        if (amount < 0) {
            JOptionPane.showMessageDialog(null, "출금액에 문제가 있어서 출금이 취소되었습니다.");
        } else if (amount > balance)
            JOptionPane.showMessageDialog(null, "출금액이 잔고액보다 많아서 출금이 취소되었습니다.");
        else {
            balance -= amount;
            result = true;
        }
        return result;
    }

    /** getBalance - 잔액 확인
     * @return 잔액 */
    public int getBalance() {
        return balance;
    }
}
