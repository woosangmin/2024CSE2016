package lecture05;

import javax.swing.*;

public class BankAccount {
    // invariant: balance >= 0
    private int balance;

    /** BankAccount - 계좌 개설
     * @param initial_amount 초기 입금 금액 (0 이상 양수)
     */
    public BankAccount(int initial_amount) {
        if (initial_amount < 0) {
            balance = 0;
        } else {
            balance = initial_amount;
        }
    }

    boolean deposit(int amount) {
        boolean result = false;
        if (amount >= balance) {
            balance = balance + amount;
            result = true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "입금액에 문제가 있어서 입금이 취소되었습니다.");
        }
        return result;
    }

    boolean withdraw(int amount) {
        boolean result = false;
        if (amount < 0) {
            JOptionPane.showMessageDialog(null, "출금액에 문제가 있어서 출금이 취소되었습니다.");
        }
        else if (amount > balance)
            JOptionPane.showMessageDialog(null, "출금액이 잔고액보다 많아서 출금이 취소되었습니다.");
        else {
            balance = balance - amount;
            result = true;
        }
        return result;
    }

    int getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount tester = new BankAccount(0);
        System.out.println("잔액 = " + tester.getBalance());
        int five = 50000;
        int three = 30000;
        if (tester.deposit(five))
            System.out.println(five + "원 입금 성공 : 잔액 = " + tester.getBalance());
        else
            System.out.println(five + "원 입금 실패 : 잔액 = " + tester.getBalance());
        if (tester.withdraw(three))
            System.out.println(three + "원 출금 성공 : 잔액 = " + tester.getBalance());
        else
            System.out.println(three + "원 출금 실패 : 잔액 = " + tester.getBalance());
        if (tester.withdraw(three))
            System.out.println(three + "원 출금 성공 : 잔액 = " + tester.getBalance());
        else
            System.out.println(three + "원 출금 실패 : 잔액 = " + tester.getBalance());
    }
}
