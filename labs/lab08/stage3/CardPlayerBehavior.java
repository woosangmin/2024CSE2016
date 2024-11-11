package stage3;

public interface CardPlayerBehavior {
    /** wantsACard - 카드 한 장을 받을건지 답한다.
     * @return 카드를 받고 싶으면 true, 아니면 false */
    public boolean wantsACard();

    /** receiveCard - 카드 한 장을 받아서 손에 넣는다.
     * @return 카드를 수령 성공이면 true, 실패이면 false */
    public boolean receiveCard(Card c);
}
