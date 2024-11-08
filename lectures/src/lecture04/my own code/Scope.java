package lecture04;

public class Scope {
    private int n = 3;

    public Scope() {
        System.out.println(n); // 3

        int n = 333;

        System.out.println(n); // 333
    }

    public static void main(String[] args) {
        new Scope();
        {
            int n = 2;
            System.out.println(n);
        }
        double n = 3.14; // 중괄호 위에 있으면 에러 발생
        System.out.println(n);
    }
}
