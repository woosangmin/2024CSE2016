public class Player {

    /** player의 이름 */
    private String name;
    /** player가 획득한 점수 */
    private int points;
    /** 방금 굴린 주사위를 담은 객체 */
    private Dice rolled;
    /** 방금 굴린 주사위로 이겼는지 여부를 기억 */
    private boolean wins;

    /** getName - 플레이어의 이름을 반환
     * @return name */
    public String getName() {
        return name;
    }

    /** getPoints - 플레이어의 점수를 반환
     * @return points */
    public int getPoints() {
        return points;
    }

    /** getRolled - 방금 굴린 주사위 객체를 반환
     * @return rolled */
    public Dice getRolled() {
        return rolled;
    }

    /** getWins - 방금 굴린 주사위로 이겼는지 여부를 반환
     * @return wins */
    public boolean getWins() {
        return wins;
    }

    /** 초기화 메소드
     * @param n - 플레이어의 이름 */
    public Player(String n) {
        name = n;
    }

    /** play - 주사위를 인수로 받아 굴려서 결과를 rolled에 기억한다. */
    public void play(Dice d) {
        d.rollDice();
        rolled = d;
    }

    /** receivePoint - points 값을 1 증가시키고 wins를 true 값으로 지정하여 이겼음을 기억한다. */
    public void receivePoint() {
        points += 1;
        wins = true;
    }

    /** reset() - 다음 게임을 위하여 wins를 false 값으로 재지정하여 이긴 기록을 삭제한다. */
    public void reset() {
        wins = false;
    }
}
