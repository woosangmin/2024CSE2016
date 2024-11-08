// By the grace of the Lord

public class Player {
    
    /** beads - 플레이어가 소지한 구슬의 수 */
    private int beads;

    public Player() {
        // 구슬의 수를 10으로 초기화 한다.
        beads = 10;
    }

    /** addBeads - 플레이어의 구슬을 n개 더한다.
     * @param n - 더할 구슬의 수 */
    public void addBeads(int n) {
            beads += n;
    }

    /** removeBeads - 플레이어의 구슬을 n개 뺀다.
     * @param n - 뺄 구슬의 수 */
    public void removeBeads(int n) {
        if (beads - n >= 0) {
            // 현재 구슬의 수에서 n만큼 뺐을 때 0보다 크거나 같으면 뺀다.
            beads -= n;
        } else {
            // 0보다 작으면 구슬의 수를 0으로 설정한다.
            beads = 0;
        }
    }

    /** getBeads - 플레이어가 소지한 구슬의 수를 반환한다.
     * @return beads - 구슬의 수 */
    public int getBeads() {
        return beads;
    }

    /** lose - 게임에 패배했는지 여부를 알려준다. 
     * @return result - 승패 여부 */
    public boolean lose(){
        // 기본값으로 true(졌음)를 선택한다.
        boolean result = true;
        // 보유 하고 있는 구슬의 수가 0보다 크면 result를 false로 선택한다.
        if (beads > 0) result = false;
        return result;
    }
}
