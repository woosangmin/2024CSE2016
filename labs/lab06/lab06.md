# [CSE2016] 2024년도 가을학기 프로그램설계방법론
## 한양대학교 ERICA 소프트웨어융합대학 컴퓨터학부 & 인공지능학과

### 실습 : 상자 안에서 움직이는 공 확장하기

- 오늘 배운 반복 구조를 사용해서 "상자 안에서 움직이는 공"을 확장해 봅시다.
- 수업 시간에 배운 코드는 실습 수업 시작 전에 제공합니다.
- 실습 시간 중 완성 후 조교에게 검사받기 바랍니다.

#### 추가 구현 1 : `MovingBall` 에 다음 요구 조건을 만족하는 생성자 함수를 추가하세요.

- `x`축과 `y`축의 속도를 추가로 입력받아서 공의 속도를 지정할 수 있도록 확장하세요.
- Starter 객체인 `BounceTheBall` 의 코드를 수정해서 공의 속도를 다양하게 바꾸면서 실행해 봅시다.

#### 추가 구현 2 : 다음 조건을 만족하는 `BallWriters`, `BounceControllers`, `AnimationWriters` 클래스를 작성하세요.

- 기본적으로 `BallWriter`, `BounceControllers`, `AnimationWriter` 클래스의 내용을 복제해서 사용합니다.
- `BallWriter` 클래스가 하나의 공 객체 (`MovingBall`)를 가지는 반면, `BallWriters` 클래스는 두개의 공 객체 (`MovingBall`)를 가집니다.
- `BounceController` 클래스가 하나의 공 객체 (`MovingBall`)를 가지는 반면, `BounceControllers` 클래스는 두개의 공 객체 (`MovingBall`)를 가집니다.
- `AnimationWriter` 클래스가 하나의 공 그리는 객체 (`BallWriter`)를 가지는 반면, `AnimationWriters` 클래스는 두개의 공 그리는 객체 (`BallWriter`)를 가집니다.
- 마지막으로 위에 구현한 코드를 적용해서 `BounceTwoBalls` 클래스를 만들어 보세요. 두개의 볼은 서로 다른 위치와 속도를 가지도록 준비해서 실행해 봅시다.

#### 추가 구현 3 : 두개의 공이 움직이다가 부딪힐 경우, 프로그램을 강제 종료하도록 수정하세요.

- `MovingBall` 클래스에 `x`축과 `y`축의 속도를 변경하는 메소드를 추가합니다.
```java
public void setVelocityX(int x_velo) { ... }
public void setVelocityY(int y_velo) { ... }
```
- `BounceControllers` 클래스의 `runAnimation` 메소드에서 두 공을 움직인 다음, 두 공이 충돌했는지 여부를 검사합니다.
- 충돌 조건은 다음과 같이 계산할 수 있습니다.
	- 두 공의 중심(x, y 좌표) 거리 `d`를 계산합니다.
	- 두 공의 반지름 중 짧은 값 `r` 을 찾습니다.
	- 만약 `d`의 값이 `r`보다 작거나 같다면 두 공은 충돌합니다.
- 충돌이 발생하면 `System.out.println` 메소드로 충돌했다는 메시지를 출력하고, `System.exit(1)` 로 프로그램을 강제 종료합니다.
- 다음 보조 함수를 사용하세요.
```java
Math.pow(v, p) : // v의 p 제곱을 구해줍니다.
Math.sqrt(v) : // v의 제곱근을 구해줍니다.
Math.min(r1, r2) : // 입력 받은 두 값 r1, r2 중 작은 값을 내어줍니다.
```
- 빠른 테스트를 위해 공의 시작위치 및 초기 속도를 다르게 하고, 공의 반지름도 적절하게 조절해보세요.