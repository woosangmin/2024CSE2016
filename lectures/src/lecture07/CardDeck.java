
public class CardDeck {

    private Card[] deck;
    private int remain;

    public CardDeck() {
        deck = new Card[52];
        remain = 0;
        for (int i = 0; i < 52; i++) {
            if ((remain + 1) % 13 == 0)
                deck[i] = new Card(Card.suits[remain / 13],  Card.ranks[13]);
            else
                deck[i] = new Card(Card.suits[remain / 13], Card.ranks[(remain + 1) % 13]);
            remain++;
        }
    }

        public Card newCard() {
            Card choice = null;
            if (remain == 0) {
                for (int i = 0; i < 52; i++) {
                    if ((remain + 1) % 13 == 0)
                        deck[i] = new Card(Card.suits[remain / 13], Card.ranks[13]);
                    else
                        deck[i] = new Card(Card.suits[remain / 13], Card.ranks[(remain + 1) % 13]);
                    remain++;
                }
            } else {
                while (choice == null) {
                    int c = (int)(Math.random() * 51);
                    if (deck[c] != null) {
                        choice = deck[c];
                        deck[c] = null;
                        remain--;
                    }
                }
            }
            return choice;
        }
}
