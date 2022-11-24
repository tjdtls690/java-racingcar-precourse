# 기능 구현 목록

## 입력
- [ ] n대의 자동차 이름을 입력 받는다 (구분자는 쉼표)
  - [ ] 정상 입력
  - [ ] 예외 처리 (IllegalArgumentException) ("[ERROR]"로 시작하는 에러 메시지) (그 부분부터 입력을 다시 받는다.)
    - [ ] null or empty 입력 시
    - [ ] 5자를 초과한 경우
    - [ ] 공백 입력 시
    - [ ] 특수 문자 입력 시
    - [ ] 숫자 입력 시
      - [ ] 양수
      - [ ] 음수
      - [ ] 0
    - [ ] 한글 입력 시
      - [ ] 자음
      - [ ] 모음
      - [ ] 단어
    - [ ] 영어 대문자 입력 시
    - [ ] 구분자가 쉼표가 아닐 시

- [ ] 시도할 회수 입력 (9자리 이하의 숫자만 입력 가능)
  - [ ] 정상 입력
  - [ ] 예외 처리 (IllegalArgumentException) ("[ERROR]"로 시작하는 에러 메시지) (그 부분부터 입력을 다시 받는다.)
    - [ ] null or empty 입력 시
    - [ ] 2자리 이상일 때, 1번째 자리가 0인 경우
    - [ ] 공백 입력 시
    - [ ] 특수 문자 입력 시
    - [ ] 한글 입력 시
      - [ ] 자음
      - [ ] 모음
      - [ ] 단어
    - [ ] 영어 입력 시
      - [ ] 소문자
      - [ ] 대문자
    - [ ] 9자리를 초과한 경우
    - [ ] 양수가 아닌 숫자 입력 시
      - [ ] 음수 입력 시
      - [ ] 0 입력 시

## 출력
- [ ] 각 차수별 실행 결과
  - ```
      pobi : --
      woni : ----
      jun : ---
      ```

- [ ] 우승자 안내 문구 출력
  - [ ] 단독 우승자 안내 문구
    - ```
      최종 우승자 : pobi
      ```
    
  - [ ] 공동 우승자 안내 문구 (쉼표 + 공백으로 구분)
    - ```
      최종 우승자 : pobi, jun
      ```
    
  - [ ] 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 [ERROR] 로 시작해야 한다.
    - ```
      [ERROR] 시도 횟수는 숫자여야 한다.
      ```

## 도메인
- [ ] 자동차를 생성한다. (MovableFactory - CarFactory)
- [ ] n대의 자동차를 생성한다. (MovablesFactory - CarsFactory)

- [ ] 자동차 경주 게임을 한다. (Movables - Cars)
  - [ ] 자동차가 경주한다. (Movable - Car)
    - [ ] 자동차가 이동한다. (Position)
    - [ ] 자동차의 이동 가능 여부를 결정한다. (MoveStrategy - RandomBasedMoveStrategy)
      - [ ] 0~9 무작위 숫자 중 4이상인 경우 이동
      
  - [ ] 우승자를 구한다. (1명 이상) (Movables - Cars)



주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
아래의 프로그래밍 실행 결과 예시와 동일하게 입력과 출력이 이루어져야 한다.