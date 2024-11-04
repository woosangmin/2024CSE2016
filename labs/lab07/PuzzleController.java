/* By the grace of the Lord */

public class PuzzleController {

    /** 제어할 퍼즐 보드 */
    private SlidePuzzleBoard board;
    /** 제어할 Output-view */
    private PuzzleWriter writer;
    /** 제어할 Input-view */
    private PuzzleInput input;
    /** while 문의 종료 조건 */
    private boolean processing;
    /** 보드의 크기 */
    private int board_size;

    public PuzzleController(SlidePuzzleBoard b, PuzzleWriter w, PuzzleInput i) {
        /* 퍼즐 보드, Output/Input-view, while문 종료 조건, 보드의 크기 초기화 */
        board = b;
        writer = w;
        input = i;
        processing = true;
        board_size = board.getBoardsize();
    }
    /** play - 게임을 플레이할 수 있는 메소드 */
    void play() {
        // 사용자의 입력을 담을 변수
        int num;
        while (processing) {
            // 보드 출력
            writer.displayPuzzle();
            // 사용자로부터 입력을 받는다.
            num = input.getInput(board_size * board_size);
            // 사용자가 취소 버튼을 누르면 종료
            if (num == -1) {
                writer.printMessage("게임을 종료합니다.");
                System.exit(0);
            }
            else {
                // 사용자로부터 유효한 입력을 받았으면 해당 칸을 찾아 빈칸으로 옮기기를 시도한다. 
                boolean moved = board.move(num);
                // 빈칸으로 옮길 수 없으면 "움직일 수 없습니다." 출력
                if (!moved) writer.printMessage("움직일 수 없습니다.");
            }
            // 보드를 푸는데 성공했으면 "퍼즐을 완성하셨습니다."를 출력하고 while문을 종료한다.
            if (board.win()) {
                writer.printMessage("퍼즐을 완성하셨습니다.");
                processing = false;
            }
        }
    }
}
