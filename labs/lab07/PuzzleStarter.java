/* By the grace of the Lord */

public class PuzzleStarter {

    public static void main(String[] args) {
        // 퍼즐 보드를 생성, 행(열)의 크기를 지정할 수 있다.
        SlidePuzzleBoard board = new SlidePuzzleBoard(4);
        // Input-view 생성
        PuzzleInput input = new PuzzleInput();
        // Controller 생성 후 play() 메소드 호출
        new PuzzleController(board, new PuzzleWriter(board), input).play();
    }
}
