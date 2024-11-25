import java.io.FileWriter;
import java.io.PrintWriter;

public class Test2 {
    public static void main(String[] args) throws Exception {
        FileWriter writer = new FileWriter("poem.txt", true);
        PrintWriter outfile = new PrintWriter(writer);
        outfile.println("방학이 되면...");
        outfile.println("뭘 할까?");
        outfile.close();
    }
}
