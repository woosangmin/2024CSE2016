import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test4 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader((System.in));
        BufferedReader keyboard = new BufferedReader(reader);
        System.out.println("도 단위를 입력해주세요.");
        String province = keyboard.readLine();
        System.out.println("시 단위를 입력해주세요.");
        String city = keyboard.readLine();
        System.out.println("구 단위를 입력해주세요.");
        String district = keyboard.readLine();
        System.out.println("입력한 주소는 \"");
        System.out.println(province + " " + city + " " + district + "\" 입니다.");
    }
}
