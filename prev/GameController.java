// By the grace of the Lord

public class GameController {

    /** 컨트롤러 클래스가 접근하기 위해 저장한 Player 객체 */
    private Player player;
    /** 컨트롤러 클래스가 접근하기 위해 저장한 Computer 객체 */
    private Computer computer;
    /** 컨트롤러 클래스가 접근하기 위해 저장한 Registrar 객체 */
    private Registrar registrar;

    /** GameController - 생성자 메소드
     * @param c - MarbleGame으로부터 입력받은 Computer 객체
     * @param p - MarbleGame으로부터 입력받은 Player 객체
     * @param r - MarbleGame으로부터 입력받은 Registrar 객체 */
    public GameController(Player p, Computer c, Registrar r) {
        player = p;
        computer = c;
        registrar = r;
    }
    /** playerTurn - 플레이어의 턴을 진행하는 메소드 */
    private void playerTurn() {
        // 플레이어의 턴임을 고지
        System.out.println("* 당신의 공격!");
        // 플레이어가 집을 수 있는 구슬의 수는 자신이 가지고 있는 구슬의 수보다 클 수 없다.
        // 동시에 컴퓨터가 집을 수 있는 구슬의 최대 값보다 클 수 없다.
        int p_num = registrar.chooseForAttack(Math.min(computer.getBeads(), player.getBeads()));
        // 플레이어가 집은 구슬의 수를 고지
        System.out.println("당신은 " + p_num + "개의 구슬을 집었습니다.");
        // 플레이어의 홀(true)/짝(false) 선택을 담을 변수
        boolean p_choice = registrar.chooseEven();
        // 플레이어의 선택을 출력
        if (p_choice)
            System.out.println("당신은 짝을 선택했습니다.");
        else
            System.out.println("당신은 홀을 선택했습니다.");
        // 컴퓨터가 구슬을 집을 예정임을 고지
        System.out.println("컴퓨터가 손을 폅니다...");
        // 컴퓨터가 집은 구슬의 수를 저장할 변수
        int c_num = computer.pickForGuard();
        // 컴퓨터가 집은 구슬의 수를 고지
        System.out.println(c_num + "개의 구슬입니다!");
        // 컴퓨터가 집은 구슬의 수가 홀수인지 짝수인지 판별한 결과를 담을 변수
        boolean c_choice;
        if (c_num % 2 == 0)
            c_choice = true; // 짝수이면 c_choice를 true로 설정
        else
            c_choice = false; // 홀수이면 c_choice를 false로 설정
        if (p_choice == c_choice) {
            // 플레이어가 선택한 짝/홀이 컴퓨터가 선택한 구슬의 짝/홀과 일치할 경우, 플레이어가 승리한다
            System.out.println("당신이 이겼습니다. 구슬 획득! : " + p_num);
            player.addBeads(p_num);
            computer.removeBeads(p_num);
        } else {
            // 플레이어가 선택한 짝/홀이 컴퓨터가 선택한 구슬의 짝/홀과 일치하지 않을 경우, 컴퓨터가 승리한다
            System.out.println("당신이 졌습니다. 구슬 제출! : " + p_num);
            computer.addBeads(p_num);
            player.removeBeads(p_num);
        }
        // 턴이 끝나고 계산된 플레이어와 컴퓨터의 구슬의 수를 출력한다.
        System.out.println("당신의 구슬 : " + player.getBeads());
        System.out.println("컴퓨터의 구슬 : " + computer.getBeads());
    }

    /** computerTurn - 컴퓨터의 턴을 진행하는 메소드 */
    private void computerTurn() {
        // 컴퓨터가 공격할 차례임을 고지
        System.out.println("* 컴퓨터의 공격!");
        // 플레이어가 집을 수 있는 구슬의 수는 자신이 가지고 있는 구슬의 수보다 클 수 없다.
        int p_num = registrar.chooseForGuard(player.getBeads());
        // 플레이어가 선택한 구슬의 수를 고지
        System.out.println("당신은 " + p_num + "개의 구슬을 집었습니다.");
        // 컴퓨터가 집을 수 있는 구슬의 수는 자신이 가지고 있는 구슬의 수보다 클 수 없다.
        // 동시에 플레이어가 집을 수 있는 구슬의 최대 값보다 클 수 없다.
        int c_num = computer.pickForAttack(Math.min(player.getBeads(), computer.getBeads()));
        // 컴퓨터가 집은 구슬의 수를 고지
        System.out.println("컴퓨터가 " + c_num + "개의 구슬을 집어듭니다...");
        // 컴퓨터가 홀과 짝 중 선택한 결과를 저장할 변수
        boolean c_choice = computer.pickEven();
        // c_choice가 true(짝)이면 짝을 false(홀)이면 홀을 출력 
        if (c_choice)
            System.out.println("컴퓨터가 짝을 선택했습니다.");
        else
            System.out.println("컴퓨터가 홀을 선택했습니다.");
        // 플레이어가 집어든 구슬의 수가 홀수인지 짝수인지 판별한 결과를 담을 변수
        boolean p_choice;
        // 짝수이면 p_choice를 true로 홀수이면 p_choice를 false로 설정
        if (p_num % 2 == 0)
            p_choice = true;
        else
            p_choice = false;
        // 컴퓨터의 선택과 플레이어의 선택이 동일하면 컴퓨터의 승리이다.
        if (p_choice == c_choice) {
            System.out.println("당신이 졌습니다. 구슬 제출! : " + c_num);
            player.removeBeads(c_num);
            computer.addBeads(c_num);
        } else {
            // 컴퓨터의 선택과 플레이어의 선택이 다르면 플레이어의 승리이다.
            System.out.println("당신이 이겼습니다. 구슬 획득! : " + c_num);
            player.addBeads(c_num);
            computer.removeBeads(c_num);
        }
        // 턴이 끝나고 계산된 플레이어와 컴퓨터의 구슬의 수를 출력한다.
        System.out.println("당신의 구슬 : " + player.getBeads());
        System.out.println("컴퓨터의 구슬 : " + computer.getBeads());
    }

    /** play - 플레이어와 컴퓨터의 턴을 어느 한 쪽의 구슬이
     * 모두 소진될 때까지 반복한다. */
    public void play() {
        // while loop를 제어할 변수
        boolean processing = true;
        // 게임 시작 시 출력할 시작 메시지
        System.out.println("* 게임을 시작합니다...");
        System.out.println("당신의 구슬 : " + player.getBeads());
        System.out.println("컴퓨터의 구슬 : " + computer.getBeads());
        // loop invariant : 플레이어의 구슬의 수나 컴퓨터의 구슬의 수는 반드시 0보다 커야 한다.
        while (processing) {
            // 플레이어가 공격한다.
            playerTurn();
            if (player.lose()){
                // 플레이어의 구슬의 수가 0이면 플레이어가 졌음을 알리고 루프를 종료한다.
                System.out.println("아쉽네요. 당신의 패배입니다.");
                processing = false;
            } else if (computer.lose()) {
                // 컴퓨터의 구슬의 수가 0이면 플레이어가 이겼음을 알리고 루프를 종료한다.
                System.out.println("축하합니다. 당신의 승리입니다.");
                processing = false;
            }
            // 컴퓨터가 공격한다.
            computerTurn();
            if (player.lose()){
                // 플레이어의 구슬의 수가 0이면 플레이어가 졌음을 알리고 루프를 종료한다.
                System.out.println("아쉽네요. 당신의 패배입니다.");
                processing = false;
            } else if (computer.lose()) {
                // 컴퓨터의 구슬의 수가 0이면 플레이어가 이겼음을 알리고 루프를 종료한다.
                System.out.println("축하합니다. 당신의 승리입니다.");
                processing = false;
            }
        }
    }
}
