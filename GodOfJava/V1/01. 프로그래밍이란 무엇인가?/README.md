# 프로그래밍이란 무엇인가?
## Programming의 P
```
일상에서의 예 - 디지털 도어락
- 집에 들어가려고 현관에서 비밀번호를 입력한다.
- 도어락에 있는 프로그램이 지금 저장되어 있는 번호와 동일한지를 확인해본다.
- 저장된 값과 입력된 값이 일치하면 문이 열린다.
- 즉
  1. 비밀번호를 입력하고 미리 만들어 놓은 어떤 프로그램에서 제공하는 결과를 기다릴 수도 있고
  2. 비밀번호를 입력 받아 비밀 번호가 맞는지 확인하는 것을 직접 작성할 수도 있다.
```

- 프로그래밍을 한다는 것은 모두 이러한 작업을 반복적으로 수행하면서 어떤 기능을 만들어 내는 것.
- 어떤 값을 입력하고 결과를 제공해주는 프로그램을 만들기 위해 사람 - 컴퓨터 간의 언어가 필요한데 이를 프로그래밍 언어라고 한다.
- 서버의 프로그램에 해당하는 부분에서 화면에 보여줄 데이터를 가공하여 제공. -> C, Python, PHP, Ruby, JAVA 등

## 자바 프로그램의 메소드는 이렇게 생겼어요
```java
public boolean checkPassword(String password) {
    // 중간 내용
}
```
- 접근 제어자 : public
- 리턴 타입 : boolean
- 메소드 이름 : checkPassword
- 매개 변수 : String password

## 자바의 가장 작은 단위는 클래스랍니다
- 위에서 봤던 checkPassword() 메소드는 어딘가에 소속되어 있어야 하고, 클래스(class) 안에 포함되어야한다.
```java
public class DoorLockManager {
    public boolean checkPassword(String password) {
		// 비밀번호 확인
    }
	
    public void setPassword(String password) {
        // 비밀번호 설정
    }
	
    public void resetPassword() {
        // 비밀번호 리셋
    }
}
```
- 다음과 같이 클래스 안에 메소드를 위치시키면 된다. 0개 이상의 여러 메소드가 존재할 수 있다.
- `//`은 주석(comment)으로, 어떤 줄을 실행하지 않도록 할 떄 사용.
- `void`는 이 메소드는 아무것도 돌려주지 않아요 라는 리턴타입이다.

## 클래스는 상태를 갖고 있어야 합니다
- 자바와 같은 언어를 객체지향 프로그래밍 언어 (Object Oriented Programming Language)라고 한다.
- 객체지향 언어의 등장으로 현실 세계를 프로그램으로 표현할 수 있게 된다.
- 앞서 살펴 보았던 DoorLockManager는 현실에 있는 사물은 클래스로 표현한 것이고, 장바구니와 같은 추상적인 것도 클래스가 될 수 있다.
- 그런데 이 클래스라는 것은 다음의 조건을 만족해야 한다.
    - 클래스는 상태 (state)와 행동 (behavior)이 있어야만 한다.
- 예를 들어 앞서 살펴본 클래스에 currentPassword 변수를 추가하면
```java
public class DoorLockManager {
	String currentPassword;
	
    public boolean checkPassword(String password) {
    }
	
    public void setPassword(String password) {
    }
	
    public void resetPassword() {
    }
}
```
- 어떤 값을 포함한 currentPassword를 변수라 하고 클래스의 특성을 결정짓는 "상태"에 해당한다.
- 반드시 "상태"와 "행동"이 존재해야 하는 것은 아니다.

## 프로그래밍의 가장 기본은 =를 이해하는 것
```java
int a;
a = 1 + 2;
```
- 프로그램에서는 왼쪽에 대입할 변수를, 오른쪽에 계산식을 적어 주어야 함.
- 변수를 선언 할 때는 `타입 변수명;`
- 정수 num1, num2를 더하는 add() 메소드 예
```java
class Calculator {
    public int add(int num1, int num2) {
        int sum;
        sum = num1 + num2;
        return sum;
    }
}
```
- num1, num2, num3 세 정수를 더하는 addAll() 메소드 예
```java
class Calculator {
    public int add(int num1, int num2) {
        int sum;
        sum = num1 + num2;
        return sum;
    }
	
    public int addAll(int num1, int num2, int num3) {
        int sum;
        sum = num1 + num2 + num3;
        return sum;
    }
}
```

## 한 줄을 의미하는 세미콜론
- 앞의 add() 메소드에서
```java
public int add(int num1, int num2) {
    int sum;
    sum = num1 + num2;
    return sum;
}
```
- 모든 자바 코드의 한 줄이 끝날 때에는 `;`를 적어주어야만 한다. 그렇지 않으면 그 다음 줄도 같은 줄로 생각한다.

## 모든 프로그래밍 언어에는 예약어라는 것이 있어요
- 앞의 Calculator 클래스
```java
class Calculator {
    public int add(int num1, int num2) {
        int sum;
        sum = num1 + num2;
        return sum;
    }
}
```
- public, class, int, return이 예약어이다.
- 예약어 (reserved word)라는 것은 "예약되어 있으니까 쓰지 못하는 단어"라고 보면 된다.
- 즉, 예약어는 클래스, 메소드, 변수의 이름으로 사용할 수 없다.

