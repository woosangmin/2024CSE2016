public class Hand {
    private Card[] hand;
    int number_of_cards;

    public Hand() {
        number_of_cards = 0;
        hand = new Card[10];
    }

    public void showHand() {
        if (number_of_cards == 0) {
            System.out.println("들고 있는 카드가 없습니다.");
        } else {
            for (int i = 0 ; i < number_of_cards-1; i++) {
                if (hand[i] != null)
                    System.out.print(hand[i].getSuit() + hand[i].getRank() + " ");
            }
            System.out.println();
        }
    }

    public boolean receiveCard(Card c) {
        boolean result = false;
        if (number_of_cards <= 10) {
            hand[number_of_cards] = c;
            number_of_cards++;
            result = true;
        }
        return result;
    }

    public Card removeCard() {
        Card choice = null;
        if (number_of_cards > 0) {
            while (choice == null) {
                int c = (int)(Math.random() * (number_of_cards - 1));
                if (hand[c] != null) {
                    choice = hand[c];
                    hand[c] = null;
                    number_of_cards--;
                }
            }
        }
        return choice;
    }

    public static void main(String[] args) {
        CardDeck deck = new CardDeck();
        Hand hand = new Hand();
        for (int i = 0 ; i < 10 ; i++) {
            hand.showHand();
            Card card = deck.newCard();
            if (hand.receiveCard(card))
                hand.showHand();
        }
        for (int i = 0 ; i < 10 ; i++) {
            hand.showHand();
            Card card = hand.removeCard();
            System.out.println("The removed card is " + card.getSuit() + card.getRank() + ".");
        }
    }
}
