// By the grace of the Lord

package stage2;

public class Main2 {

    public static void main(String[] args) {
        Database db = new Database(4);

        BankAccount a1 = new BankAccount(50000, new IntegerKey(55));
        Key k = new StringKey("열려라");
        BankAccount a2 = new BankAccount(10000, k);
        boolean transaction1 = db.insert(a1);
        boolean transaction2 = db.insert(a2);

        Record p = db.find(k); // 열려라 - StringKey
        BankAccount q = (BankAccount)p; // a2
        System.out.println(q.getBalance()); // 10000

        k = q.getKey(); // "열려라"
        if (k instanceof IntegerKey) // StringKey가 아니므로 false
            System.out.println(((IntegerKey)k).getInt());
        else if (k instanceof StringKey) // StringKey이므로 true
            System.out.println(((StringKey)k).getString()); // 열려라
        else // else 이후는 참조하지 않는다.
            System.out.println("모르는 Key 출현 오류");
    }

    //    public static void main(String[] args) {
//        Database db = new Database(4);
//        IntegerKey k = new IntegerKey(55);
//        BankAccount b = new BankAccount(10000, k);
//        boolean success = db.insert(b);
//
//        Record r = db.find(k); // <-> Record r = db.find(some_key) // IntegerKey가 아닌 다른 키
//        // r.getBalance(); // 컴파일러가 오류를 잡아낸다.
//        //((BankAccount)r).getBalance(); // 컴파일러가 오류를 잡아내지 못한다.
//
//        if (r instanceof BankAccount) {
//            ((BankAccount)r).getBalance();
//        } else {
//            System.out.println("취급 불가 Record");
//        }
//
//        IntegerKey k1 = new IntegerKey(3);
//        StringKey k2 = new StringKey("three");
//        boolean answer = k2.equals(k1);
//    }
}
