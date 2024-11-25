import javax.swing.*;
import java.io.*;

public class Test3 {
    public static void main(String[] args) throws IOException {
        String file_name = JOptionPane.showInputDialog("읽을 파일 이름을 쓰세요.");
        FileReader reader = new FileReader(file_name);
        BufferedReader infile = new BufferedReader(reader);
        FileWriter writer = new FileWriter(file_name + ".out");
        PrintWriter outfile = new PrintWriter(writer);
        while (infile.ready()) {
            String s = infile.readLine();
            outfile.print(s);
        }
        outfile.close();
        infile.close();
    }
}
