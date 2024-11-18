# [CSE2016] 2024년도 가을학기 프로그램설계방법론
## 한양대학교 ERICA 소프트웨어융합대학 컴퓨터학부 & 인공지능학과

### 실습1 : 크기와 색이 변하는 공

- 오늘 배운 `ActionListener`를 사용해서 크기와 색이 변하는 공을 그려봅시다.

주기적으로 공의 크기를 바꾸고, 버튼을 누르면 색상이 바뀌는 공을 그리세요.
프로그램을 시작하면 주기적으로 공의 크기가 작아졌다 커졌다를 반복합니다.
공은 처음에 빨간색이었다가 OK 버튼을 누를 때마다 파란색과 빨간색으로 바뀌어야 합니다.

<img src="lab09image/lab01.png" width="750">

전체 코드의 클래스 다이어그램은 아래와 같습니다. `ColorButton`은 오늘 배운 `ActionListener`를
상속받아 사용자가 버튼을 누르는 이벤트에 맞춰 동작합니다.

<img src="lab09image/lab01_cd.png" width="750">

- `ColorButton` : `actionPerformed(ActionEvent e)` - 이벤트가 발생할 때마다 공의 색상을 바꿉니다.
- `ThrobbingBall` : `throb()` - 공을 크기가 큰지 여부(`is_large`)를 변경합니다.
- `ThrobController` : `run()` - 무조건 반복문으로 `ball`의 크기 여부를 변경하고, `ThrobPanel`을 다시 그린 후(`writer.repaint()`), 정해진 시간만큼 쉽니다(`Thread.sleep(time)`).

### 실습2 : 퍼즐 게임 (GUI 버전)

- 지난 시간에 구현했던 퍼즐 게임을 GUI 버전으로 만들어 봅시다.
아래 그림과 같이 퍼즐 보드의 각 퍼즐 조각(`PuzzlePiece`)을 버튼으로 구현하면 됩니다.

<img src="lab09image/lab02.png" width="750">

전체 코드의 클래스 다이어그램은 아래와 같습니다. `PuzzleButton`은 오늘 배운 `ActionListener`를
상속받아 사용자가 버튼을 누르는 이벤트에 맞춰 동작합니다.

<img src="lab09image/lab02_cd1.png" width="750">

