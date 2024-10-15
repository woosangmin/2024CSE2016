// By the grace of the Lord

public class Dice {

    /** 주사위 1의 숫자 */
    private int face1;
    /** 주사위 2의 숫자 */
    private int face2;
    /** 주사위 1, 2의 합 */
    private int sum;
    /** 주사위 1, 2의 차 */
    private int difference;
    /** 주사위 1, 2의 수가 같은가? */
    private boolean twin;

    /** getFace1 - 주사위 1의 값 반환 
     * @return face1 */
    public int getFace1() {
        return face1;
    }

    /** getFace2 - 주사위 2의 값 반환
     * @return face2 */
    public int getFace2() {
        return face2;
    }

    /** getSum - 주사위 1, 2의 합 반환
     * @return sum */
    public int getSum() {
        return sum;
    }

    /** getDifference - 주사위 1, 2의 차 반환
     * @return difference */
    public int getDifference() {
        return difference;
    }
    
    /** getTwin - 주사위 1, 2의 값이 동일한지 여부 반환
     * @return twin */
    public boolean getTwin() {
        return twin;
    }

    /** rollDice - 주사위 굴리기
     *     face1 = 주사위 1의 값
     *     face2 = 주사위 2의 값
     *     sum = 주사위 1, 2의 합
     *     difference = 주사위 1, 2의 차
     *     twin = 쌍둥인지 여부(difference == 0)
     *  */
    public void rollDice() {
        twin = false;
        face1 = (int)(Math.random() * 6) + 1;
        face2 = (int)(Math.random() * 6) + 1;
        sum = face1 + face2;
        difference = Math.abs(face1 - face2);
        if (difference == 0)
            twin = true;
    }
}
