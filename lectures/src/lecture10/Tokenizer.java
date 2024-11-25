import java.util.StringTokenizer;

public class Tokenizer {
    public static void main(String[] args) {
        String s = "경기도 안산시 상록구";
        StringTokenizer t = new StringTokenizer(s, " ");
        String province = t.nextToken();
        System.out.println(province);
        String city = t.nextToken();
        System.out.println(city);
        String district = t.nextToken();
        System.out.println(district);

        s = "$24.99";
        t = new StringTokenizer(s, "$ ");
        System.out.println(t.nextToken());
        // System.out.println(t.nextToken()); // 에러
    }
}
