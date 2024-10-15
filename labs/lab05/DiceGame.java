// By the grace of the Lord

public class DiceGame {
    public static void main(String[] args) {
        Registrar r = new Registrar(); // input-view 초기화
        Player p1 = new Player(r.invitePlayer()); // 플레이어 1의 이름을 입력받아 p1 객체 생성
        Player p2 = new Player(r.invitePlayer()); // 플레이어 2의 이름을 입력받아 p2 객체 생성
        GameBoard b = new GameBoard(p1, p2); // output-view 초기화
        new Dealer().dealDiceGame(p1, p2, b, r); // 게임 진행을 위해 dealDiceGame 메소드 호출
    }
}
