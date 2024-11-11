package RecordKey;

public class BankAccount implements Record {

    private int balance;
    private Key key;

    /** Constructor 계좌개설
     * @param initial_amount 개설 예금액
     * @param id 계좌의 키
     */
    public BankAccount(int initial_amount, Key id) {
        balance = initial_amount;
        key = id;
    }

    /** deposit 입금
     * @param amount 입금액 (0 이상의 정수)
     */
    public void deposit(int amount) {
        balance += amount;
    }

    /** withdraw 출금 (잔고가 충분하면)
     * @param amount 출금액 (0 이상의 정수)
     * @return true 출금 성공, false 출금 실패
     */
    public boolean withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    /** getBalance 잔액 리턴
     * @return 잔액 */
    public int getBalance() {
        return balance;
    }

    /** getKey 계좌 키 리턴
     * @return 키 */
    public Key getKey() {
        return key;
    }

    public static void main(String[] args) {
        Database db = new Database(4);
        IntegerKey k = new IntegerKey(55);
        BankAccount b = new BankAccount(10000, k);
        boolean success = db.insert(b);

        Record r = db.find(k); // <-> Record r = db.find(some_key) // IntegerKey가 아닌 다른 키
        // r.getBalance(); // 컴파일러가 오류를 잡아낸다.
        //((BankAccount)r).getBalance(); // 컴파일러가 오류를 잡아내지 못한다.

        if (r instanceof BankAccount) {
            ((BankAccount)r).getBalance();
        } else {
            System.out.println("취급 불가 Record");
        }

        IntegerKey k1 = new IntegerKey(3);
        StringKey k2 = new StringKey("three");
        boolean answer = k2.equals(k1);
    }
}