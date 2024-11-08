// By the grace of the Lord

public class MarbleGame {

    public static void main(String[] args) {
        // 컨트롤러에 넘겨줄 Player 객체
        Player p = new Player();
        // 컨트롤러에 넘겨줄 Computer 객체
        Computer c = new Computer();
        // 컨트롤러에 넘겨줄 Registrar 객체
        Registrar r = new Registrar();
        // Controller 객체를 생성하고 play 메소드를 실행한다.
        new GameController(p, c, r).play();
    }

}
