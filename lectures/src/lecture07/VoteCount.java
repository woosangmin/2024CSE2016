import javax.swing.*;

public class VoteCount {

    public static void main(String[] args) {
        int num_candidates = 4;
        int[] votes = new int[num_candidates];

        boolean processing = true;
        while (processing) {
            /* loop invariant : 투표는 해당 배열에 누적되었음 */
            String input = JOptionPane.showInputDialog("원하는 후보에 투표하세요 : 0, 1, 2, 3");
            int v = Integer.parseInt(input);
            if (v >= 0 && v < votes.length)
                votes[v] = votes[v] + 1;
            else processing = false;
        }
        for (int i = 0 ; i != votes.length ; i++) {
            System.out.println("후보 " + i + "번이 " + votes[i] + "표를 득표하였습니다.");
        }

        int[][] election = new int[3][4];
        for (int j = 0 ; j < 4 ; j++) {
            int vote = 0;
            for (int i = 0 ; i < 3 ; i++) {
                vote = vote + election[i][j];
            }
            System.out.println("기호" + (j + 1) + "번은 " + vote + "표 받았습니다.");
        }
        for (int i = 0 ; i < 3 ; i++) {
            int vote = 0;
            for (int j = 0 ; j < 3 ; j++) {
                vote = vote + election[i][j];
            }
            System.out.println((i+1) + "학년은 " + vote + "표 행사했습니다.");
        }
    }
}
