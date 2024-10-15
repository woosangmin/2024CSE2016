// By the grace of the Lord

public class Dealer {
    /** player1의 주사위 */
    private Dice p1Rolled;
    /** player2의 주사위 */
    private Dice p2Rolled;
    /** player1의 주사위 묶음(문자열) */
    private String p1Dice;
    /** player2의 주사위 묶음(문자열) */
    private String p2Dice;
    /** 사용자의 의사가 확인되었는지 표시하는 변수 */
    private int cont = -1;
    /** 누가 먼저 주사위를 던지는지 표시하는 변수(처음에는 플레이어 1부터) */
    private int first = -1;

    public Dealer() {
        // player1, 2의 주사위 초기화
        p1Rolled = new Dice();
        p2Rolled = new Dice();
    }

    /** dealDiceGame - 실제 주사위 게임을 진행하는 메소드 */
    public void dealDiceGame(Player p1, Player p2, GameBoard b, Registrar r) {
        if (p1.getPoints() > p2.getPoints()) {
            // 플레이어1의 점수가 플레이어2의 점수보다 크면 first를 0으로 설정
            first = 0;
        } else if (p1.getPoints() < p2.getPoints()) {
            // 플레이어2의 점수가 플레이어 1의 점수보다 크면 first를 1로 설정
            first = 1;
        }
        // 맨 처음 주사위를 던질 때
        if (first == -1) {
            p1.play(p1Rolled); p2.play(p2Rolled);
        }
        else if (first == 1) {
            // 플레이어1부터 주사위를 던진다.
            p1.play(p1Rolled); p2.play(p2Rolled);
        } else if (first == 0) {
            // 플레이어2부터 주사위를 던진다.
            p2.play(p2Rolled); p1.play(p1Rolled);
        }
        if (p1Rolled.getTwin()) {
            // p1의 주사위가 쌍둥이일 때
            if (p2Rolled.getTwin()) {
                // p2의 주사위도 쌍둥이이면
                if (p1Rolled.getFace1() > p2Rolled.getFace1()) {
                    // p1의 주사위 값이 p2보다 크면 p1 승
                    p1.receivePoint();
                } else if (p1Rolled.getFace1() < p2Rolled.getFace1()) {
                    // p2의 주사위 값이 p1보다 크면 p2 승
                    p2.receivePoint();
                }
            } else {
                // p2가 쌍둥이가 아니면 p1 승
                p1.receivePoint(); }
        } else {
            // p1의 주사위가 쌍둥이가 아닐 때
            if (p2Rolled.getTwin()) {
                // p2의 주사위가 쌍둥이면 p2 승
                p2.receivePoint();
            } else {
                // p2의 주사위도 쌍둥이가 아니면
                if (p1Rolled.getSum() > p2Rolled.getSum()) {
                    // p1의 합이 p2보다 크면 p1 승
                    p1.receivePoint();
                } else if (p1Rolled.getSum() < p2Rolled.getSum()) {
                    // p2의 합이 p1보다 크면 p2 승
                    p2.receivePoint();
                } else {
                    // p1의 합과 p2의 합이 같은 경우
                    if (p1Rolled.getDifference() < p2Rolled.getDifference()) {
                        // p1의 차가 p2보다 작으면 p1 승
                        p1.receivePoint();
                    } else if (p1Rolled.getDifference() > p2Rolled.getDifference()) {
                        // p2의 차가 p1보다 작으면 p2 승
                        p2.receivePoint();
                    }
                }
            }
        }
        // 플레이어1과 플레이어2의 주사위 묶음를 표현할 문자열을 생성
        p1Dice = p1.getRolled().getFace1() + "    " + p1.getRolled().getFace2();
        p2Dice = p2.getRolled().getFace1() + "    " + p2.getRolled().getFace2();
        // 플레이어1과 플레이어2의 주사위 묶음을 인자로 받아 결과 출력
        b.showResult(p1Dice, p2Dice);

        while (cont == -1) {
            // 사용자의 의사가 확인될 때까지 showConfirmDialog 출력
            cont = r.wantToContinue();
        }
        if (cont == 0) {
            // 사용자가 계속 플레이 한다면 각 플레이어의 wins 변수를 false로 초기화
            p1.reset();
            p2.reset();
            // 사용자의 의사 확인 여부를 표시하는 변수도 초기화
            cont = -1;
            // dealDiceGame 함수를 재귀적으로 호출하여 게임 진행
            this.dealDiceGame(p1, p2, b, r);
        } else {
            // 사용자가 종료를 원하는 경우 종료메시지를 출력하고 프로그램 종료
            b.sayGoodBye();
            System.exit(0);
        }
    }
}
