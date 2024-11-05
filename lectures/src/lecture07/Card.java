public class Card {
    private String suit;
    private String rank;

    static String[] suits = {"Diamond", "Heart", "Club", "Spade"};
    static String[] ranks = {"0","A","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};

    public Card(String s, String r) {
        suit = s;
        rank = r;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }
}
