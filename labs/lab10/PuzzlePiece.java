/* By the grace of the Lord */



/** 퍼즐 한 조각을 만드는 모델 클래스 */
public class PuzzlePiece {

    /** 퍼즐 조각 위에 표시되는 값 */
    private int face_value;

    /** PuzzlePiece - 생성자
     * @param value - 퍼즐 조각 위에 표시되는 값*/
    public PuzzlePiece(int value) {
        face_value = value;
    }

    /** getFacevalue - 퍼즐 조각의 액면 값을 리턴한다 */
    public int getFacevalue() {
        return face_value;
    }

    /** setFacevalue - 퍼즐 조각의 액면 값을 변경한다
     * @param w - 바꾸고자 하는 값 */
    public void setFacevalue(int w) {
        face_value = w;
    }
}
