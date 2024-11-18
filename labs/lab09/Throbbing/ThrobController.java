/* By the grace of the Lord */

package Throbbing;

/** Controller */
public class ThrobController {
    // Control 하고자 하는 Panel
    private ThrobPanel writer;
    // Controll 하고자 하는 공
    private ThrobbingBall ball;
    // delay time
    private int time;

    /** Constructor
     * @param w Control 하고자 하는 Panel
     * @param b Controll 하고자 하는 공
     * @param delay_time 기다리는 시간 */
    public ThrobController(ThrobPanel w, ThrobbingBall b, int delay_time) {
        time = delay_time;
        writer = w;
        ball = b;
    }

    /** run - 반복적으로 delay time만큼 기다린 후 공을 그린다. */
    public void run() {
        // loop invariant : 공은 delay time마다 한 번씩 크기가 바뀌며 그 때마다 다시 그려진다.
        while (true) {
            ball.throb(); // 공의 크기를 변경
            writer.repaint(); // Panel을 다시 그림
            try { Thread.sleep(time);} // delay time 만큼 기다린다.
            catch (InterruptedException e) { }
        }
    }
}
