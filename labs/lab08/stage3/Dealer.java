// By the grace of the Lord

package stage3;

public class Dealer {

    /** Dealer가 사용할 카드 덱 */
    private CardDeck deck;

    /** Constructor 카드 덱 초기화 */
    public Dealer() {
        deck = new CardDeck();
    }

    /** dealTo - 카드를 한 장씩 매번 물어 보면서 원하는 만큼 p에게 준다. */
    public void dealTo(CardPlayerBehavior p) {
        while (p.wantsACard()) {
            p.receiveCard(deck.newCard());
        }
    }

    /** dealOneTo - 카드를 한 장 p에게 준다. */
    public void dealOneTo(CardPlayerBehavior p) {
        p.receiveCard(deck.newCard());
    }
}

