/* By the grace of the Lord */

package Throbbing;

/** 
 * model 공의 모델
 * */
public class ThrobbingBall {
    // 공이 큰 공인지 작은 공인지 지정
    private boolean is_large;

    /** Constructor
     * 공은 작은 공부터 그린다. */
    public ThrobbingBall() {
        is_large = false;
    }

    /** isLarge 공이 큰 공인지 작은 공인지 반환
     * @return 공이 큰 공이면 true, 작은 공이면 false */
    public boolean isLarge() {
        return is_large;
    }

    /** throb 공이 큰 공이면 작은 공으로
     * 작은 공이면 큰 공으로 바꾼다. */
    public void throb(){
        if (is_large) is_large = false;
        else is_large = true;
    }
}
