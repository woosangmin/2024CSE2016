import java.io.FileWriter;
import java.io.PrintWriter;

public class Test1 {
    public static void main(String[] args) throws Exception {
        FileWriter writer = new FileWriter("poem.txt");
        PrintWriter outfile = new PrintWriter(writer);
        outfile.println("가을이 오면...");
        outfile.println("학기가 저물고,");
        outfile.println("시험이 끝나면서");
        outfile.println("겨울이 온다.");
        outfile.close();
    }
}
