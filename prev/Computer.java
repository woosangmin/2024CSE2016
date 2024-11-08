// By the grace of the Lord
import java.util.Random;

public class Computer {

    /** 컴퓨터가 가지고 있는 구슬의 수 */
    private int beads;

    public Computer() {
        // 구슬의 수를 10으로 초기화한다.
        beads = 10;
    }
    /** addBeads - 컴퓨터의 구슬을 n개 더한다.
     * @param n - 더할 구슬의 수 */
    public void addBeads(int n) {
            beads += n;
    }

    /** removeBeads - 컴퓨터의 구슬을 n개 뺀다.
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
    
    /** getBeads - 컴퓨터가 소지한 구슬의 수를 반환한다.
     * @return beads - 구슬의 수 */
    public int getBeads() {
        return beads;
    }

    /** lose - 게임에 패배했는지 여부를 알려준다.
     * @return result - 승패 여부 */
    public boolean lose(){
        // 기본값으로 true(졌음)를 선택한다.
        boolean result = true;
        if (beads > 0) {
            // 보유 하고 있는 구슬의 수가 0보다 크면 result를 false로 선택한다.
            result = false;
        }
        return result;
    }

    /** pickForAttack - 컴퓨터가 공격할 때 집을 구슬의 수를 무작위로 리턴한다.
     * 최소값은 1, 최대값은 5이지만 현재 구슬의 수를 넘길 수는 없다.
     * @param max - 플레이어가 현재 가진 구슬의 수와 컴퓨터가 현재 가진 구슬의 수 중
     *             작은 값을 입력받는다.
     * @return n_attack - 컴퓨터가 집은 구슬의 수 */
    public int pickForAttack(int max) {
        // 집을 구슬의 수를 무작위로 선택하기 위해 random 클래스 사용
        Random random = new Random();
        // 집을 구슬의 수를 담을 변수
        int n_attack = 0;
        if (max > 5) {
            // loop invariant : 구슬의 수는 1 ~ 5까지의 정수여야 한다.
            while (n_attack == 0) {
                // 구슬의 수가 5보다 큰 경우 1 ~ 5까지의 수 중에서 무작위로 선택한다.
                n_attack = random.nextInt(6);
            }
        } else {
            // loop invariant : 구슬의 수는 1 ~ max까지의 정수여야 한다.
            while (n_attack == 0) {
                // 구슬의 수가 5보다 작은 경우 1 ~ max까지의 수 중에서 무작위로 선택한다.
                n_attack = random.nextInt(max+1);
            }
        }
        return n_attack;
    }
    /** pickForGuard - 컴퓨터가 수비할 때 집을 구슬의 수를 무작위로 리턴한다.
     * 최소값은 0, 최대값은 5이지만 현재 구슬의 수를 넘길 수는 없다.
     * @return n_guard - 컴퓨터가 집은 구슬의 수 */
    public int pickForGuard() {
        // 집을 구슬의 수를 무작위로 선택하기 위해 random 클래스 사용
        Random random = new Random();
        // 집을 구슬의 수를 담을 변수
        int n_guard = -1;
        if (beads > 5) {
            // loop invariant : 구슬의 수는 0 ~ 5까지의 정수여야 한다.
            while (n_guard == -1) {
                // 구슬의 수가 5보다 큰 경우 0 ~ 5까지의 수 중에서 무작위로 선택한다.
                n_guard = random.nextInt(6);
            }
        } else {
            // loop invariant : 구슬의 수는 0 ~ beads까지의 정수여야 한다.
            while (n_guard == -1) {
                // 구슬의 수가 5보다 작은 경우 0 ~ beads까지의 수 중에서 무작위로 선택한다.
                n_guard = random.nextInt(beads+1);
            }
        }
        return n_guard;
    }

    /** pickEven - 컴퓨터 공격시 선택한 홀/짝을 무작위로 리턴한다.
     * true는 짝수, false는 홀수를 의미한다.
     * @return result - 선택한 홀/짝 */
    public boolean pickEven() {
        // 0 ~ 1까지의 정수를 선택하기 위한 random 변수
        Random random = new Random();
        // 무작위로 선택한 수를 담을 변수
        int num = random.nextInt(2);
        // 반환값
        boolean result = true;
        // 만약 0(false)을 선택했다면 result의 false를 바꾼다.
        if (num == 0)
            result = false;
        return result;
    }
}
