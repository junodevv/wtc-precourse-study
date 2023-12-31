# Enum

# 1. Enum이란?

Enumeration(열거)란 의미의 예약어

**서로 관련이 있는 상수들을 열거한 집합**

코드에서 사용할 상수의 갯수가 많고 이들의 서로 관련이 있는 값들이라면 하나의 집합 클래스, 즉 Enum 클래스로 선언 할 수 있다.

### 1) 기존의 상수 활용방법

```java
public class EnumExample{

	private final static int MONDAY = 1;
	private final static int TUESDAY = 2;
	private final static int WEDNESDAY = 3;
	private final static int THURSDAY = 4;
	private final static int FRIDAY = 5;
	private final static int SATURDAY = 6;
	private final static int SUNDAY = 7;
	
	public static void main(String[] args){
	
		int day = MONDAY;

		switch (day) {
		case MONDAY:
						System.out.println("월요일");
						break;
		case TUESDAY:
						System.out.println("화요일");
						break;
		case WEDNESDAY:
						System.out.println("수요일");
						break;
			...
			...
			...

		default:
						 break;
		}
	}		
}
```

이처럼 모든 상수들을 변수로 만들어 줘야 한다.

지금처럼 적당한 갯수의 상수변수들이라면 이렇게 쓸 수도 있고 가독성에도 문제가 되지 않지만 여기에 “1~12월”까지 추가해서 상수변수로 표현하려면 필드의 갯수가 너무 길어지면서 가독성이 좋지 않게된다.\

이때 사용할 수 있는 것이 `Enum` 이다.

### 2) `Enum`을 활용한 방법

```java
enum Day{
				MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

public class EnumExample{

	public static void main(String[] args){
	
		int day = MONDAY;

		switch (day) {
		case MONDAY:
						System.out.println("월요일");
						break;
		case TUESDAY:
						System.out.println("화요일");
						break;
		case WEDNESDAY:
						System.out.println("수요일");
						break;
			...
			...
			...

		default:
						 break;
		}
	}		
}
```

`Enum` 을 활용하면 이렇게 다시 쓰일 수 있다.

여기서 `Enum` 클래스는

```java
enum Day{
			MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}
```

아래의 Day 클래스와 같은 기능을 한다.

```java
class Day{
			private final static int MONDAY = new Day();
			private final static int TUESDAY = new Day();
			private final static int WEDNESDAY = new Day();
			private final static int THURSDAY = new Day();
			private final static int FRIDAY = new Day();
			private final static int SATURDAY = new Day();
			private final static int SUNDAY = new Day();
}
```

Day 클래스를 살펴보면 자신을 인스턴스화한 값을 각 상수변수에 할당하는 것을 볼 수 있다.

즉, 각 변수들은 같은 데이터타입이면서 서로 다른 데이터 값을 가지는 것이다.

# 2. Enum 의 장점

1. 코드가 단순해지고 가독성이 좋아진다.
2. 인스턴스 생성과 상속을 방지한다. → 상수값의 타입안정성이 보장된다.

> enum클래스를 통해 상수들의 데이터타입을 새롭게 정의하기 때문에 예상치못하게 다른 타입의 데이터값이 할당되거나 다른 타입의 테이터값과 연산되어  생기는 문제를 방지할수 있다.
>
1. 키워드 enum을 사용하기 때문에 구현의 의도가 열거임을 분명하게 나타낼 수 있다.

# 3. enum과 생성자

### 1) enum클래스의 원소에 추가 속성 부여

enum의 각 상수에는 추가 속성을 부여할 수 있다.

예를 들어 YES라는 표현을 y, 1, true 등 여러가지로 표현하게 될 수 있는데 이러한 다양한 표현들을 추가 속성으로 추가해 줄 수 있다.

```java
package enumtest;

public enum YesOrNo {
    YES("y", "1", true),
    NO("n", "0", false);

    private String value1;
    private String value2;
    private boolean value3;

    YesOrNo(String value1, String value2, boolean value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public String getValue1() {
        return value1;
    }

    public String getValue2() {
        return value2;
    }

    public boolean isValue3() {
        return value3;
    }
}
```

위 코드는 YES와 NO 라는 응답에 대한 enum클래스이다.

속성을 저장해줄 String과 boolean 필드를 만들어주고 getter 메소드를 사용하여 다른 클래스에서 활용할 수 있다.

그냥 YES, NO 라는 인스턴스로 자체로 사용할 수도 있지만 위 처럼 YES와 NO에 다양한 속성들을 추가해 사용할 수 있다.

위의 enum 클래스와 같은 패키지에 `EnumTest.java`클래스를 만들어 출력해보았다.

```java
package enumtest;

public class EnumTest {
    public static void main(String[] args) {

        String YesValue1Test = YesOrNo.YES.getValue1();
        String YesValue2Test = YesOrNo.YES.getValue2();
        boolean YesValue3Test = YesOrNo.YES.isValue3();
        // Object YesInstanceTest = new YesOrNo(); 오류
        Object YesInstanceTest = YesOrNo.YES;

        String NoValue1Test = YesOrNo.NO.getValue1();
        String NoValue2Test = YesOrNo.NO.getValue2();
        boolean NoValue3Test = YesOrNo.NO.isValue3();
        Object NoInstanceTest = YesOrNo.NO;

        System.out.println("YES-value1: " + YesValue1Test);
        System.out.println("YES-value2: " + YesValue2Test);
        System.out.println("YES-value3: " + YesValue3Test);
        System.out.println("YES-Instance: " + YesInstanceTest);

        System.out.println("NO-value1: " + NoValue1Test);
        System.out.println("NO-value2: " + NoValue2Test);
        System.out.println("NO-value3: " + NoValue3Test);
        System.out.println("NO-Instance: " + NoInstanceTest);
    }
}
```

해당 코드를 실행해보면 아래와 같은 결과가 나온다.

<img width="206" alt="Untitled" src="https://github.com/junodevv/wtc-precourse-study/assets/126752196/24691b5f-d57f-44b2-8595-6ad78121bfe6">


enum클래스에서 추가해줬던 속성인 `"y"`, `"1"`, `true` ,`”n”` `"0"`, `false`들을 getter 메소드를 통해 가져와 값을 저장하고 출력했다.

이때 **보통의 클래스들과는 다른점**은 따로 **인스턴스(객체)를 생성하지 않았지만 그 속성값들을 가져와 사용할 수 있다는 점**이다.

그리고 이러한 점때문에 enum 클래스의 생성자에 접근하지 않아도되고 생성자를 사용할 수도 **없다.**

이러한 점이 enum클래스의 값들을 마치 상수와 같이 고정값으로 사용할 수 있는 이유이다.

# 마무리

나는 이번기회에 처음 알게 되었지만 좋은 코드를 짜는 많은 사람들이 이러한 enum 클래스를 사용하는 듯하다.

enum 클래스가 생기기 전에는 interface와 일반 클래스를 import 해서 사용해 왔다고 한다.

역시 천재 개발자들은 많고 나는 아직 부족하다.

## reference

[Limky 삽질블로그, [Java]enum이란?](https://limkydev.tistory.com/50)

[넥스트리 Java: enum의 뿌리를 찾아서](https://www.nextree.co.kr/p11686/)

[우아한 기술 블로그 Java Enum 활용기](https://techblog.woowahan.com/2527/)