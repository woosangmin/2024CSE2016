public class Slogan {
    public static void main(String[] args) {
        String slogan = "창의와 나눔으로 세상에 힘이 되는 한양";
        System.out.println(slogan);
        System.out.println(slogan.length());
        String slogan2 = "  " + slogan + "  ";
        System.out.println(slogan2 + "!");
        System.out.println(slogan2.length());
        String slogan3 = slogan2.trim();
        System.out.println(slogan3 + "!");
        System.out.println(slogan);
        System.out.println(slogan3);
        // 같은 메모리 주소를 가리키는지 비교!! / false
        System.out.println(slogan == slogan3);
        // 문자열의 내용을 비교 / true
        System.out.println(slogan.equals(slogan3));
        System.out.println(slogan.charAt(5));
        System.out.println(slogan.substring(4, 6));
        String slogan_E = "Hanyang : Acient Capital, Modern Academics";
        System.out.println(slogan_E.toUpperCase());
        System.out.println(slogan_E.toLowerCase());
        System.out.println(slogan_E.indexOf("o"));
        System.out.println(slogan_E.indexOf("o", 6));
        // 아스키 코드 상에서 비교
        System.out.println("a".compareTo("c"));
        System.out.println("C".compareTo("A"));
        char hangul = '한';
        System.out.println((int)hangul);
        System.out.println((char)(hangul+1));
    }
}