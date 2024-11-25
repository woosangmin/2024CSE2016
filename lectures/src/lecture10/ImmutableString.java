public class ImmutableString {
    public static void main(String[] args) {
        String s = "abc";
        char[] t = new char[3];
        t[0] = 'a';
        t[1] = 'b';
        t[2] = 'c';
        //System.out.println(s == t); // 에러 발생
        System.out.println(s.equals(t)); // false

        String u = "abc";
        System.out.println(s == u); // true : 컴파일러 최적화
        System.out.println(s.equals(u)); // true

        String v = new String("abc");
        System.out.println(s == v); // false : 객체를 새로 생성
        System.out.println(s.equals(v)); // true

        v = new String("ab") + "c";
        System.out.println(s == v); // false : 객체를 새로 생성
        System.out.println(s.equals(v)); // true

        s = v;
        System.out.println(s == v); // true
        System.out.println(s.equals(v)); // true


    }
}
