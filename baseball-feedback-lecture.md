# 우아한 테크코스 - 프리코스 : 숫자 야구 피드백 강의에서 배운것들

# 1.  프로그램을 구현 하는 과정

1) 구현할 기능 목록 작성

1-1) 논리적 순서대로 작성한다. - 너무 자세히X

1-2) 기능에 따른 메소드명 작성

1-3) 기능과 메소드명에 따른 클래스 작성

2) 기능목록을 보면서 쉬운것부터 구현해 나간다.

3) 기능을 구현했으면 테스트 코드를 작성해 기능을 검증한다.

* 기능을 하나 구현할 때마다 커밋을 한다. ( 이때, 커밋 메시지 컨벤션을 따름)

# 2. Source

- main: 실제로 배포되는 소스
- 자바의 패키지와 디렉토리는 1:1 매칭
- main.baseball.**domain**: 실제로 다루고자하는 서비스의 비즈니스 로직이 들어있는 영역 ex) 계산 등의 행위

- 클래스는 그 클래스의 이름답게 행동해야함

# 3. static 변수(=클래스 변수, 정적변수)

: 인스턴스들이 공유하고 있는 변수

- 따라서 static 값들은 인스턴스 값으로 접근을 하던 클래스 명으로 접근을 하던 같은 값이 나온다
- 그래서 클래스 변수라고 부른다.

- static 메소드(정적 메소드) : 그 클래스 내부에서 인스턴스의 호출 없이 사용하는 메소드
- 정적 메소드 내부에서는 정적 메소드만 사용할 수 있다.
- 그래서 정적 메소드가아닌 인스턴스 메소드는 인스턴스(객체)에 호출해서 사용하는 것

# 4. 테스트코드 작성 팁

@ParameterizedTest : 여러 매개변수 테스트하는 어노테이션

@CsvSource : ParameterizedTest일때, 여러 매개변수들을 매 테스트마다 적용해주는 어노테이션

@BeforeEach: 모든 테스트 메소드들이 실행되기전에 실행되는 setup 코드들을 실행시켜주는 어노테이션

예시 baseball-6

```java
class RefereeTest {
    private Referee referee;
    private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3);

    @BeforeEach
    void setUp() {
        referee = new Referee();

    }

    @ParameterizedTest // 여러가지 경우 테스트
    @CsvSource({"1,2,3,0 볼 3 스트라이크", "7,8,9,낫싱", "2,3,1,3 볼 0 스트라이크"})// 이건 공부해보기
    public void compare(int number1, int number2, int number3, String expected) {
        String actual = referee.compare(ANSWER, Arrays.asList(number1, number2, number3));
        assertThat(actual).isEqualTo(expected);
    }
}
```

## reference
[우아한 테크코스 프리코스 : 숫자야구게임 피드백 강의]()