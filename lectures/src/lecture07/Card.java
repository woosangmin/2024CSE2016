public class Card {
    private String suit;
    private int rank;

    static String[] suits = {"D", "H", "C", "S"};
    static int[] ranks = {0,1,2,3,4,5,6,7,8,9,10,11,12,13};

    public Card(String s, int r) {
        suit = s;
        rank = r;
    }

    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
}
