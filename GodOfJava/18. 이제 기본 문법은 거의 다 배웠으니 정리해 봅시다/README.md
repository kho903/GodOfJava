# 이제 기본 문법은 거의 다 배웠으니 정리해 봅시다
## 객체지향 개발과 관련된 용어들
### 객체지향 관련 용어 목록
- 클래스 (Class)
- 상태 (State)와 행위 (behavior)
- 캡슐화 (Encapsulation)
- 메시지 (Message)
- 객체 (Object)
- 상속 (Inheritance)
- Overriding
- 다형성 (PolyMorphism)
- Overloading

### 클래스 (Class)
- "상태"와 "행위"를 갖는 자바의 기본 단위를 의미

### 상태 (state)와 행위 (behavior)
- 어떤 사물을 나타낼 때에는 상태와 행위로 구분하여 표시하는 것이 가능
- 자바에서 "상태"는 인스턴스 변수, "행위"는 메소드로 표현 가능
```java
public class Common {
    private int state; // 상태
    public void setState(int newState) { // 행위
    }
}
```

### 캡슐화 (Encapsulation)
- "상태"와 "행위"를 결정하는 기능을 묶어 주는 것을 의미
- 기능을 클래스 밖에서 접근 가능한 대상을 제한하는 정보 은닉과 하나의 객체를 위한 코드가, 다른 객체를 위한 코드와 무관하게 수행할 수 있도록 모듈화가 가능
- 묶여 있는 가장 작은 단위가 클래스이다.

```java
public class Common {
    private int state; // private 으로 선언함으로써 정보 은닉
    public void setState(int newState) { // 상태를 변경 가능
    }
}
```

### 메시지 (Message)
- 메소드에서 다른 메소드를 호출할 때 전달하는 값을 메시지라고 한다. 자바에서는 매개 변수들이 해당

### 객체 (Obeject)
- 클래스는 사물의 단위를 의미하지만 객체는 각 사물을 의미
```java
Book godOfJava = new Book();
```
- "godOfJava"는 책 중 하나를 의미하는 객체

### 상속
- 부모에 선언된 변수와 메소드에 대한 사용권을 갖는 경우
- 클래스 선언시 extends를 사용하여 확장 또는 implements를 사용하여 구현한 경우가 속함

### 다형성
- 자바에서는 부모 클래스에서 파생된 자식 클래스들의 기능이 각기 다를 수 있다는 것을 의미
```java
public class Parent {
    public void method() {
    }
}
```
```java
public class FirstChild extends Parent {
    public void method() {
    }
}
```
```java
public class SecondChild extends Parent {
    public void method() {
    }
}
```
- 다음과 같이 있으면 FirstChild와 SecondChild에 있는 method()는 다른 기능을 수행해도 무관하다는 것이 다형성이다.

### Overriding
- 다형성은 부모 클래스에 선언되어 있는 메소드와 동일한 선언을 갖지만 구이 다른 거슬 의미한다. 자바에서 다형성을 제공하는 하나의 방법이 Overriding
```java
public class Parent {
    public void method() {
        // ...
    }
}
```
```java
public class Child extends Parent {
    public void method() {
        // ...
    }
}
```
- method()는 부모 클래스의 method()를 덮어 쓰며 Overriding 처리가 된 것이다.

### Overloading
- 메소드의 이름은 동일해도 매개 변수를 다르게 하는 것을 의미. 동일한 기능을 하지만, 메소드에 넘겨줄 수 있는 매개 변수의 타입을 다양하게 함으로써
다른 개발자가 쉽게 구현할 수 있게 해준다.
```java
public class Overloading {
    public void getData() {
    }

    public void getData(int value) {
    }

    public void getData(String value) {
    }
}
```
- 매개 변수에 따라 셋 중에 호출되는 메소드가 달라진다. 이것이 Overloading

## 자바의 주석문 (comment)
- 주석은 개발하면서 부연 설명을 추가 또는 개발해 놓은 코드를 임시로 수행하지 않을 때 사용

### 한 줄 주석 : 일반적으로 해당 줄을 실행하지 않도록 할 때 사용
```text
// 주석 처리하는 내용
```

### 블록 주석 : 여러 줄을 실행하지 않도록 할 때 사용
```text
/* 주석 시작
여기에 있는 문장들은 모두 무시됨
주석 끝 */
```

### javadoc을 위한 주석 : API 문서에 설명을 표시할 목적으로 사용
```text
/** 주석 시작
여기에는 해당 클래스나 메소드의 설명이 있어야 함
주석 끝 */
```
- 만약 앞으로도 사용할 일이 없는 주석 처리한 문장이라면, 아예 코드에서 지워버리는 것이 좋다.

## 패키지와 import
- 패키지는 클래스들 그룹화를 위한 단위
- 다른 패키지에 선언되어 있는 클래스를 사용하기 위해서 import 문장 추가 
### 패키지 선언 시 유의사항들
- 패키지는 package로 시작하며 하위 패키지로 내려갈 때마다, `.`을 찍어 주어야 함
- 반드시 소스 가장 첫 줄에 존재해야 함
- 패키지 이름에 자바 예약어 포함되면 안 됨
- 모두 소문자로 구성하는 것이 일반적
- 일반적인 패키지는 java, javax로 시작하면 안됨
- 패키지에 해당하는 폴더에 클래스가 존재하는 것이 일반적

### 패키지 선언 예
```text
package com.roadbook.godofjava;
```

### import
- 다른 패키지에 있는 클래스를 사용하기 위한 문자
- 다른 클래스에 static 으로 선언되어 있는 접근 가능한 변수를 참조하려면 import static을 사용
- 하나의 패키지 내에 있는 모든 클래스를 참조하려면 * 사용
- import 사용 예
```text
import com.roadbook.godofjava.SummaryClass;
import static com.roadvbook.godofjava.SummaryClass.SUMMARY_CHAPTER_NUMBER;
import com.roadbook.godofjava.exception.*;
```

## 자바에서 사용되는 타입의 종류
- 기본 자료형과 참조 자료형으로 나뉨

### 기본 자료형
- 8개의 기본 자료형 : 숫자와 boolean(true, false)을 나타내기 위한 자료형
  - 정수형 : byte, short, int, long, char
  - 소수형 : float, double
  - 기타 : boolean
- 정수형의 범위는 다음과 같다.

| 타입    | 최소             | 최대                 | 비트 수 |
|-------|----------------|--------------------|------|
| byte  | -2<sup>7</sup> | 2<sup>7</sup> - 1  | 8    |
| short | -2<sup>7</sup> | 2<sup>15</sup> - 1 | 16   |
| int   | -2<sup>7</sup> | 2<sup>31</sup> - 1 | 32   |
| long  | -2<sup>7</sup> | 2<sup>63</sup> - 1 | 64   |
| char  | 0              | 2<sup>16</sup> - 1 | 16   |
- 기본 자료형의 기본값은 다음과 같다.
  - byte : 0
  - short : 0
  - int : 0
  - long : 0L
  - float : 0.0f
  - double : 0.0d
  - char : '₩u0000'
  - boolean : false

### 참조 자료형
- 기본 자료형을 제외한 모든 타입을 말하며, 모든 클래스는 참조 자료형
#### 참조 자료형과 기본 자료형의 차이
- 초기화 할 때 : 기본 자료형은 값을 바로 지정하면 되지만, 참조 자료형은 일반적으로 new와 생성자를 지정하ㅣ여 객체 생성
- 메소드를 호출할 때의 매개 변수 : 기본 자료형 및 참조 자료형 모두 값을 전달하지만, 참조 자료형 안에 있는 변수들은 참조 주소를 전달한다.

#### 특수한 참조 자료형
- String : String 클래스는 new 를 이용하여 객체를 생성할 필요가 없는 특수한 클래스다. 그리고, + 연산까지 가능한 유일한 클래스다.

## 변수의 종류
- 지역 변수 (local variables) : 지역 변수를 선언한 곳에서부터 생명이 시작되고, 지역 변수를 선언한 중괄호가 끝나면 소멸
- 매개 변수 (parameters) : 메소드가 호출될 때 생명이 시작되고, 메소드가 끝나면 소멸 (호출한 메소드에서 넘겨준 참조 자료형은 그대로 살아 있음)
- 인스턴스 변수 (instance variables) : 객체가 생성될 때 생명이 시작되고, 그 객체를 참조하고 있는 다른 객체가 없으면 소멸
- 클래스 변수 (class variables) : 클래스가 생성될 때 생명이 시작되고, 자바 프로그램이 끝날 떄 소멸
```java
public class VariablesTypes {
    int instanceVariable;
    static int classVariable;
    public void method(int parameter) {
        int localVariable;
    }
}
```

## 계산을 쉽게 도와주는 연산자들
### 연산자의 종류
- 할당 연산자 : =
- 사칙 연산자 : +, -, *, /, % (+, - 는 더하기 빼기)
- 대입 연산자 : +=, -=, *=, /=, %=
- 단항 연산자 : +, -, ++, -- (여기서 +와 -는 양수와 음수를 나타내는 연산자)
- 비교 연산자 : ==, != >, <, >=, <=
- 조건적 논리 연산자 : &&, ||
- 논리 연산자 : !, &, |, ^
- 삼항 연산자 : ? : (변수 = (boolean 조건식) ? true일때의 값 : false일때의 값)
- Bitwise 연산자 : &(AND), |(OR), ^(XOR), ~(NOT)
- Bit 이동 연산자 : <<, >>, >>>
- Bit 대입 연산자 : &=, |=, ^=, <<=, >>=, >>>=

### 연산자 연산 순위
- 우선 순위 1

| 연산자 | 한글 설명          | 영문 설명                | 결합 방향  |
|-----|----------------|----------------------|--------|
| []  | 배열 요소 접근       | access array element | 좌 -> 우 |
| .   | 객체 변수 접근       | access object member |        |
| ,   | for 루프의 초기화시에만 | comma                |        |
| ()  | 메소드 호출         | invoke a method      |        |
| ++  | x++로 사용할 경우    | post-increment       |        |
| --  | x--로 사용할 경우    | post-decrement       |        |

- 우선 순위 2

| 연산자 | 한글 설명       | 영문 설명         | 결합 방향  |
|-----|-------------|---------------|--------|
| ++  | ++x로 사용할 경우 | pre-increment | 우 -> 좌 |
| --  | --x로 사용할 경우 | pre-decrement |        |
| +   | +x          | unary plus    |        |
| -   | -x          | unary minus   |        |
| !   |             | logical NOT   |        |
| ~   |             | bitwise NOT   |        |

- 우선 순위 3

| 연산자 | 한글 설명     | 영문 설명           | 결합 방향  |
|-----|-----------|-----------------|--------|
| ()  | 형 변환시 소괄호 | case            | 우 -> 좌 |
| new | 객체 생성     | object creation |        |

- 우선 순위 4

| 연산자   | 한글 설명 | 영문 설명          | 결합 방향  |
|-------|-------|----------------|--------|
| * / % | 배수 연산 | multiplicative | 좌 -> 우 |

- 우선 순위 5

| 연산자 | 한글 설명    | 영문 설명                | 결합 방향  |
|-----|----------|----------------------|--------|
| +-  | 증감 연산    | additive             | 좌 -> 우 |
| +   | 문자열 더하기  | string concatenation |        |

- 우선 순위 6

| 연산자       | 한글 설명     | 영문 설명 | 결합 방향  |
|-----------|-----------|-------|--------|
| << >> >>> | Bit 이동 연산 | shift | 좌 -> 우 |

- 우선 순위 7

| 연산자         | 한글 설명    | 영문 설명           | 결합 방향  |
|-------------|----------|-----------------|--------|
| < <= > >=   | 비교 연산    | relational      | 좌 -> 우 |
| insatanceof | 타입 비교 연산 | type comparison |        |

- 우선 순위 8

| 연산자   | 한글 설명 | 영문 설명    | 결합 방향  |
|-------|-------|----------|--------|
| == != | 비교 연산 | equality | 좌 -> 우 |

- 우선 순위 9

| 연산자 | 한글 설명  | 영문 설명       | 결합 방향  |
|-----|--------|-------------|--------|
| &   | 비트 AND | bitwise AND | 좌 -> 우 |

- 우선 순위 10

| 연산자 | 한글 설명  | 영문 설명       | 결합 방향  |
|-----|--------|-------------|--------|
| ^   | 비트 XOR | bitwise XOR | 좌 -> 우 |

- 우선 순위 11

| 연산자    | 한글 설명 | 영문 설명      | 결합 방향  |
|--------|-------|------------|--------|
| &#124; | 비트 OR | bitwise OR | 좌 -> 우 |

- 우선 순위 12

| 연산자 | 한글 설명     | 영문 설명           | 결합 방향  |
|-----|-----------|-----------------|--------|
| &&  | 조건 논리 AND | conditional AND | 좌 -> 우 |

- 우선 순위 13

| 연산자          | 한글 설명    | 영문 설명          | 결합 방향  |
|--------------|----------|----------------|--------|
| &#124;&#124; | 조건 논리 OR | conditional OR | 좌 -> 우 |

- 우선 순위 14

| 연산자 | 한글 설명 | 영문 설명       | 결합 방향  |
|-----|-------|-------------|--------|
| ? : | 삼항 연산 | conditional | 우 -> 좌 |

- 우선 순위 15

| 연산자                                         | 한글 설명 | 영문 설명      | 결합 방향  |
|---------------------------------------------|-------|------------|--------|
| = += -= *= /= %= &= ^= &#124;= <<= >>= >>>= | 할당 연산 | assignment | 우 -> 좌 |


## 조건문들
- 변수들의 상태에 따라서 프로그램을 분기할 필요가 있을 때 사용하는 조건문들은 다음과 같다.

### if
```java
if (boolean 값) 처리문장;
```
### if-else
```java
if (boolean 값) 처리문장1;
else 처리문장2;
```
- 처리문장이 두 줄 이상일 때,
```java
if (boolean 값) {
    처리문장1;
    ...
} else {
    처리문장2;
    ...
}
```

### if-else if
```java
if (boolean 값) {
    처리문장1;
    ...
} else if (boolean 값) {
    처리문장2;
    ...
}
```

### switch-case
```java
switch (비교대상변수) {
case 점검값1:
    처리 문장1;
    ....
    break;
case 점검값2:
    처리 문장2;
    ....
    break;
...
default:
    기본처리문장;
    ...
    break;
}
```
- 비교 대상 변수는 정수형만 사용 가능 했지만, JDK 7 이상부터 String도 가능

## 반복문들
### while
```java
while (boolean 조건이 true 일 경우 실행) {
    ...
}
```

### do-while : 반복 수행을 하기 전에 적어도 한 번은 처리할 필요가 있을 경우 사용
```text
do {
    처리문장;
    ...
} while (boolean 조건이 true일 경우 실행);
```

### for 루프 : for 루프가 수행되는 순서는 다음과 같음
```text
for (초기화; 종료조건; 조건값증가) {
    반복문장
}
```
1. 초기화에서 변수 초기화
2. 종료조건 구문 수행. 이 조건을 만족하지 않으면 (false) 반복 문장을 실행하지 않고 중괄호 밖으로 나간다. 종료조건을 만족하면 (true) 반복문장 수행
3. 조건값 증가가 수행된다. 보통 초기화에서 선언한 변수를 여기서 증가시킴
4. 반복문장을 수행하기 전에 다시 종료조건에 맞는지 다시 확인
5. 반복문장 다시 수행
6. 조건값 증가가 다시 수행
7. 종료조건을 만족하는지 확인
8. 종료조건에 만족하지 않으면 for 루프는 끝나고 중괄호 밖으로 나감

### 조건을 빠져 나오기 위한 break
- 조건문이나 반복문의 중간에서 하던 작업을 중단할 필요가 있을 때 break 사용

### 검증 로직으로 이동하기 위한 continue
반복문에서 중간에서 하던 작업을 중단하고, 조건을 확인하는 부분으로 바로 이동하기 위해서 사용
```text
int x = 1;
while (x < 3) {
    x++;
    if (x==1) continue;
    if (x==2) break;
}
```
- x가 1이면 아랫 줄 연산을 수행하지 않고 바로 while 비교 문장으로 돌아가고 x가 2일 때 while문 종료

## 아무나 사용 못하게 막아주는 접근 제어자
클래스, 변수, 메소드 등을 선언할 때 사용하고, 선언한 해당 항목의 범위를 제한하기 위한 목적
- public : 누구나 접근 가능하다.
- protected : 같은 패키지 내에 있거나 상속받은 경우에만 접근 가능
- (package-private) : 아무런 접근 제어자를 적어주지 않을 때, package-private 이며, 같은 패키지 내에 있을 때만 접근 가능
- private : 해당 클래스 내에서만 접근 가능

| 접근 제어자              | 해당 클래스 안에서 | 같은 패키지에서 | 상속 받은 클래스에서 | import한 클래스에서 |
|---------------------|------------|----------|-------------|---------------|
| public              | O          | O        | O           | O             |
| protected           | O          | O        | O           | X             |
| (package-protected) | O          | O        | X           | X             |
| private             | O          | X        | X           | X             |

## 선언할 때 사용할 수 있는 각종 제어자들
| 제어자                                       | 클래스 | 메소드 | 변수  |
|-------------------------------------------|-----|-----|-----|
| 접근 제어자 : public, protected, private       | O   | O   | O   |
| 구현 필요 제어자 : abstract                      | O   | O   | X   |
| 하나의 인스턴스만 허용하는 제어자 : static               | O   | O   | O   |
| 값 수정 제한 제어자 : final                       | O   | O   | O   |
| strict 소수 값 제어자 : strictfp                | O   | O   | X   |
| 어노테이션                                     | O   | O   | O   |
| 동시 접근 제어자 : synchronized                  | X   | O   | X   |
| 다른 언어로 구현된 것을 명시하는 제어자 : native           | X   | O   | X   |
| 실행시의 동작 방법을 알리는 제어자 : transient, volatile | X   | O   | O   |

## 자바를 구성하는 클래스, 인터페이스, abstract 클래스
### 자바에서 만든 코드를 관리하는 클래스 파일(.class)이 되는 타입의 종류
- 클래스
- 인터페이스
- abstract 클래스
- enum 클래스
- 어노테이션 선언 클래스

### 인터페이스와 abstract 클래스, 클래스의 차이
#### 인터페이스
- 어떤 메소드가 존재해야 하는지에 대한 선언만 되어 있다.
- 절대로 구현되어 있는 메소드가 있으면 안 된다.
- 인터페이스를 구현하는 클래스에서는 implements를 사용하여 선언한다.

#### abstract 클래스
- 구현되어 있는 메소드가 있어도 상관 없다.
- abstract 로 선언된 메소드가 1개 이상일 경우에는 반드시 abstract로 선언해야 한다.
- abstract 로 선언된 메소드는 절대로 구현되어 있어서는 안 된다.
- abstract 클래스를 확장하는 클래스에서는 extends를 사용하여 선언한다.

#### 클래스
- 인터페이스나 abstract 클래스와 다르게 모든 메소드가 구현되어 있어야 한다.

|                     | 인터페이스     | abstract 클래스   | 클래스   |
|---------------------|-----------|----------------|-------|
| 선언 시 사용하는 예약어       | interface | abstract class | class |
| 구현 안된 메소드 포함 가능 여부  | O(필수)     | O              | X     |
| 구현된 메소드 포함 가능 여부    | X         | O              | O(필수) |
| static 메소드 선언 가능 여부 | X         | O              | O     |
| final 메소드 선언 가능 여부  | X         | O              | O     |
| 상속 (extends) 가능     | X         | O              | O     |
| 구현 (implements) 가능  | O         | X              | X     |

#### 클래스 선언 예
```java
public class Sample extends SuperClass implements InterfaceA, InterfaceB {
    // ...
}
```
- 파일 이름 : Sample.java 
- 대문자로 시작, 추가 단어가 있을 때에는 첫문자만 대문자 사용
- 접근 제어자 사용 가능
- extends 부모 클래스인 SuperClass 확장, 반드시 하나의 클래스만 지정 가능. abstract 클래스도 extends로 확장 가능
- implements 뒤에 인터페이스 이름을 명시하고 구현 가능, 한 개 이상의 인터페이스 구현 가능. 인터페이스에 선언된 모든 메소드가 이 클래스에 구현되어야 함

#### 인터페이스 선언 예
```java
public interface InterfaceA {
    public void methodA();
    public void methodB();
}
```
- 구현되어 있는 메소드가 하나라도 있으면 안 된다.
### abstract 클래스 선언 예
```java
public abstract class AbstractClass {
    public abstract void methodC();
    public void methodD() {
        // ...
    }
}
```
- abstract로 선언된 메소드가 하나라도 있을 경우 클래스를 abstract로 선언하여야 함

#### enum 클래스 선언 예
```java
public enum EnumClass {
    THREE_HOUR(18000),
    FIVE_HOUR(30000),
    // ....
}
```
- 상수를 열거하기 위한 용도로 사용하고 상수는 이름만 정의해도 된다.
- 별도의 생성자를 만들어 각 상수의 값을 지정할 수 있다.
- 모든 enum 클래스의 부모 클래스는 java.lang.Enum 클래스뿐
- enum에 메소드를 만들어 기능 추가 가능

#### 어노테이션 선언 예
```java
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationDefinition {
    public int number();
    public String text() default "This is first annotation";
}
```
- 대상 (@Target)과 적용 범위 (@Retention)를 명시하는 것이 좋다.
- @interface를 사용하여 어노테이션이라는 것을 명시한다.

## 메소드 선언
- 메소드는 자바에서 클래스의 행위 (behavior)를 처리하는 데 사용됨
### 기본적인 메소드 선언 예
```java
public void method(String param, int ... params) {
    // 메소드 내용
}
```
- method라는 이름을 갖는 메소드
- public과 같은 제어자 선언이 가능
- void로 선언되어 있어 리턴값이 없다.
- param이라는 String 타입의 매개 변수를 가진다.
- params라는 여러 개의 int 타입을 콤마로 구분하여 매개 변수로 지정 가능

## 자주 사용하게 되는 상속
- 리팩토링 단계를 거쳐 반복되는 메소드를 상위 클래스로 구분해 주는 것이 좋다. (코드의 재사용성과 유지 보수성, 가독성 향상 목적)
- 상속 관계가 발생했을 때 생성자, 메소드, 변수가 어떻게 지정하고 동작할까?

### 생성자
- 자식 클래스의 생성자가 호출되면 자동으로 부모 클래스의 매개 변수가 없는 기본 생성자가 호출됨.
- 부모 클래스의 생성자를 명시적으로 호출하려면 super() 사용

### 메소드
- 부모 클래스에 선언된 메소드들이 자신의 클래스에 선언된 것처럼 사용 가능 (private 제외)
- 부모 클래스에 선언된 메소드와 동일한 시그니처를 사용함으로써 메소드 overriding이 가능하다
- 부모 클래스에 선언되어 있지 않은 이름의 새로운 메소드 선언 가능

### 변수
- 부모 클래스에 private을 제외한 선언된 모든 변수가 자신의 클래스에 선언된 것처럼 사용 가능
- 부모 클래스에 선언된 변수와 동일한 이름을 가지는 변수 선언 가능 (권장 X)
- 부모 클래스에 선언되어 있지 않는 이름의 변수 선언 가능

## 예외를 처리하자
### try-catch 기본 구문
```text
try {
    // 예외 발생 가능성 있는 문장
} catch (예외1 e1) {
    // 예외1이 발생했을 때 처리 문장
} catch (예외2 e2) {
    // 예외2가 발생했을 때 처리 문장
} finally {
    // try나 catch가 어떻게 수행되었든 간에 수행되는 문장
}
```

### 자바에서 사용하는 예외의 종류
- checked exception : try-catch로 묶어 줘야 하는 예외이며, 컴파일 시 예외 처리 여부 체크
- error : 자바 프로세스에 영향을 주는 예외이며, 실행 시 발생
- runtime exception 또는 unchecked exception : try-catch로 묶지 않아도 컴파일 시 체크를 하지 않는 예외이며, 실행 시 발생하는 예외

### throw와 throws
- throw : 예외 객체를 던지기 위해 사용
- throws : 예외가 발생하면 던질 것이라고 메소드 선언시 사용
- 메소드를 선언할 때 매개 변수 소괄호 뒤에 throws라는 적어준 뒤 예외를 선언하면 해당 메소드에서 해당 예외 발생시 호출한 메소드로 예외가 전달됨
- 두 가지 이상의 예외를 던지게 되면 implements 처럼 콤마로 구분해서 적어줌
- try 블록 내에서 예외를 발생시키려면 throw 를 적어준 뒤 예외 객체를 생성하거나, 생성되어 있는 객체를 명시
- throw 한 예외 클래스가 catch에 없거나 throws 선언에 없다면 컴파일 에러 발생
- catch 블록에서 예외를 throw 할 경우 메소드 선언의 throws 구문에 해당 예외가 정의되어 있어야 함

## Object 클래스
- Object 클래스는 모든 클래스의 최상위 부모 클래스이다. 따라서 모든 클래스에서 Object에 선언된 메소드들을 사용 가능

### Object 클래스의 주요 메소드
- clone() : 객체의 복사본을 만들어 리턴
- equals() : 현재 객체와 매개 변수로 넘겨받은 객체가 같은지 확인
- finalize() : 현재 객체가 더 이상 쓸모가 없어졌을 때 가비지 컬렉터에 의해 이 메소드가 호출됨
- getClass() : 현재 객체의 Class 클래스의 객체를 리턴
- hashCode() : 객체에 대한 해시 코드 값 리턴
- String toString() : 객체를 문자열로 표현하는 값을 리턴
- wait(), notify(), notifyAll() : 쓰레드 처리시 사용하는 메소드

## String 클래스
### String 클래스의 특징
- new를 사용하지 않고 객체를 생성할 수 있는 유일한 클래스
- 더하기 연산이 가능하다. 더하기 연산 시 String 클래스는 기존 문자열은 버리고 새로운 객체를 생성한다.

### String 클래스의 주요 메소드
- getBytes() : 문자열을 byte 배열로 변경
- length() : 문자열의 길이를 리턴
- isEmpty() : 문자열이 비어 있는지 확인
- equals() : 두 문자열의 값이 같은지 확인한다.
- startsWith(), endsWith() : 매개 변수로 넘어온 문자열로 시작하는지 끝나는지 확인
- contains() : 매개 변수로 넘어온 문자열이 포함되어 있는지 확인
- indexOf(), lastIndexOf() : 매개 변수로 넘어온 문자열이 있는 위치를 0부터 시작하는 값으로 리턴, 없으면 -1 리턴
- subString(), subsequence() : 문자열의 특정 범위 값을 잘라서 리턴
- split() : 문자열을 매개 변수로 넘어온 정규 표현식에 따라서 String 배열로 리턴
- concat() : 기존 문자열 뒤에 매개 변수로 넘어온 문자열을 합친다.
- trim() : 문자열의 맨 앞과 뒤의 공백 제거
- replace() : 문자열의 특정 위치의 내용을 매개 변수로 넘어온 값으로 변경
- format() : 문자열을 정해진 포맷으로 변환
- intern() : 절대로 써서는 안 되는 메소드

### StringBuffer와 StringBuilder 클래스
- String의 단점을 보완하기위해 제공되는 클래스들로 StringBuffer는 쓰레드에 안전하고 StringBuilder는 그렇지 못하다.
- append() 메소드를 사용하여 문자열을 더할 수 있고, 만약 String 문자열을 더하면 컴파일러에서 StringBuilder 클래스로 변환한다. (반복문에선 X)

## 어노테이션을 선언할 때 사용하는 메타 어노테이션들
- 어노테이션 선언 시 사용하는 메타 어노테이션에는 @Target, @Retention, @Documented, @Inherited 이 있다.

### JDK에 선언되어 있는 어노테이션
- @Override : Override 한다는 것을 명시적으로 선언할 때 사용
- @Deprecated : 더 이상 사용하지 않아 Deprecated 되었다는 것을 명시적으로 선언할 때 사용
- @SuppressWarnings : 컴파일러의 경고를 무시하도록 할 때 사용

### Target 어노테이션에서 사용하는 ElementType의 종류
| 요소 타입          | 대상                         |
|----------------|----------------------------|
| CONSTRUCTOR    | 생성자 선언 시                   |
| FIELD          | enum 상수를 포함한 필드(field) 선언시 |
| LOCAL_VARIABLE | 지역 변수 선언시                  |
| METHOD         | 메소드 선언시                    |
| PACKAGE        | 패키지 선언시                    |
| PARAMETER      | 매개 변수 선언시                  |
| TYPE           | 클래스, 인터페이스, enum 등 선언시     |
- 두 개 이상의 ElementType을 선언할 때에는 배열퍼럼 중괄호로 묶어 사용
```text
@Target({ElementType.METHOD, ElementType.TYPE})
```

### Retention 어노테이션에서 사용하는 RetentionPolicy의 종류
| 요소 타입   | 대상                                                                      |
|---------|-------------------------------------------------------------------------|
| SOURCE  | 어노테이션 정보가 컴파일시 사라짐                                                      |
| CLASS   | 클래스 파일에 있는 어노테이션 정보가 컴파일러에 의해서 참조 가능. 하지만 가상 머신(Virtual Machine)에서는 사라짐 |
| RUNTIME | 실행시 어노테이션 정보가 가상 머신에 의해서 참조 가능                                          |
