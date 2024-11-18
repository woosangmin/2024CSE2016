/* By the grace of the Lord */

package Throbbing;

public class ThrobbingStarter {
    public static void main(String[] args) {
        ThrobbingBall b = new ThrobbingBall(); // 공을 생성
        ThrobPanel panel = new ThrobPanel(400, b); // Panel을 생성
        ColorButton button = new ColorButton(panel); // 버튼을 생성
        ThrobFrame frame = new ThrobFrame(400, panel, button); // frame을 생성
        new ThrobController(panel, b, 1000).run(); // controller 생성 후 run 호출
    }
}
