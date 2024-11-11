1. 주황색 : 일반적인 class(??) / 파란색 : 상속 관계에서 super class / 초록색 : 인터페이스
   
2. new 키워드와 함께 객체를 생성하는 클래스 : BlackjackController(dealer, hand_player, hand_dealer), Dealer(deck), CardDeck(deck), HumanPlayer/ComputerPlayer(CardPlayer 상속)

3. 한번만 생성되는 클래스 : BlackjackController, Dealer, HumanPlayer, ComputerPlayer, CardDeck / 빈번하게 생성되는 클래스 : Card

4. 플레이어의 수를 두 명으로 늘리는 경우
 - CardDeck처럼 HumanPlayer로 구성된 배열, 배열의 길이를 반환하는 메소드와 배열의 원소를 반환하는 메소드를 가지는 클래스 HumanPlayers를 구현,
 - HumanPlayers 생성자 함수에 HumanPlayer 객체 2개를 원소로 가지는 배열 선언
 - Input-view 클래스로 HumanPlayer의 이름을 입력 받아 HumanPlayer 객체를 생성하고 배열에 저장
 - manageBlackjack에서 for 구문을 이용하여 해당 배열을 순회하도록 구현

5. 플레이어의 수를 두 명에서 네 명까지 입력받아서 동작하도록 하는 경우
 - Input-view 클래스에 인원 수(2 ~ 4명)를 입력 받는 절차를 추가
 - HumanPlayer 클래스에서 배열의 길이를 인원 수에 맞게 지정하여 배열을 선언하도록 수정
 - Input-view 클래스에서 인원 수 대로 HumanPlayer의 이름을 입력 받아 HumanPlayer 객체를 생성하고 배열에 저장
 - manageBlackjack에서 for 구문을 이용하여 해당 배열을 순회하도록 구현
