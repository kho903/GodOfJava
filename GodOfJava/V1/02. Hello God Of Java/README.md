# Hello God Of Java
- 현재 ide를 사용하지 않고 vim으로 실습.

## HelloGodOfJava 만들기
- 자바의 경우 코드 작성 -> 컴파일 -> 실행의 과정으로 진행
1. 코드 작성
```java
public class HelloGodOfJava {
	
}
```
2. 컴파일 및 실행
```sh
$ javac HelloGodOfJava.java
$ java HelloGodOfJava
Error: Main method not found in class HelloGodOfJava, please define the main method as:
   public static void main(String[] args)
or a JavaFX application class must extend javafx.application.Application
```
- javac 명령어를 통해 컴파일을 하면 HelloGodOfJava.class 파일이 만들어진다.
- java로 실행을 해도 main이 존재하지 않아 예외가 발생한다. (NoSuchMethodError: main)
  - 여기서 존재하지 않는 java 파일 컴파일을 시도하면 NoClassDefFoundError 발생
- 메인을 추가한다.
```java
public class HelloGodOfJava {
    public static void main(String[] args) {
    }
}
```
- main 구문은 반드시 알아야 한다.
  - public : 접근 제어자
  - static : 사전적 의미는 "정적인". 자바의 예약어. 메소드를 static으로 선언하면 객체를 생성하지 않아도 호출할 수 있다.
  - void : 메소드 이름 바로 앞에는 그 메소드가 어떤 값을 넘겨줄지를 정한다. 돌려줄 것이 없을 때 void
  - main : 메소드(method) 이름. 반드시 이 이름을 써야한다.
  - (String[] args) : 메소드 옆의 소괄호 안에는 매개변수가 들어간다. main() 메소드의 매개변수는 반드시 String[] args 여야 한다.
- main 구문 추가 후 컴파일, 실행 시 에러가 사라진다.
```sh
$ javac HelloGodOfJava.java

$ java HelloGodOfJava
```
- 하지만 아무런 결과가 나타나지 않는다. main() 메소드 내에 아무 작업도 하지 않았기 때문이다. 출력에 대해 알아보자.

## System;.put.println()과 System.out.print()
```java
public class HelloGodOfJava {
    public static void main(String[] args) {
        System.out.println("Hello God of Java !!!");
        System.out.println("I Love this book");
    }
}
```
- 다음과 같이 추가하고 컴파일, 실행 시
```sh
$ javac HelloGodOfJava.java
Hello God of Java !!!
I Love this book.

$ java HelloGodOfJava
```
- println() 이라는 메소드를 호출한 것.
- System.out은 System 클래스에 있는 static한 out이라는 필드를 의미한다.
- 정리하자면 매개변수로 "Hello God of Java !!!" 문자열을 넘겨주었고, 커맨드창에 출력할 때 사용하는 것이다.
- println() 대신에 print() 메소드로 바꾸고 수행
```java
public class HelloGodOfJava {
    public static void main(String[] args) {
        System.out.print("Hello God of Java !!!");
        System.out.print("I Love this book");
    }
}
```
```sh
$ javac HelloGodOfJava.java
Hello God of Java !!!I Love this book.
$ java HelloGodOfJava
```
- 줄바꿈이 사라졌다.

## 주석(comment) 처리하기
- 소스 코드를 지우고 싶지만 나중에 다시 사용할 것 같은 부분을 지우지 않고 보존하기 위해서 사용
### 한줄주석
- 한줄만 주석 처리
```
//
```
- 이 뒤에는 어떤 글자가 오더라도 컴파일 할 때 무시한다.
- 디버깅을 위한 출력을 감출 때, 또는 소스에 대한 간단한 설명을 적어 놓을 때 사용

### 블록 주석
- 여러 줄을 한꺼번에 주석 처리할 때 사용
```
/*
*/
```
- 메소드 안에 여러 줄을 주석 처리 또는 메소드 자체를 주석 처리할 때 자주 사용

### 문서용 주석 (documentation comment)
```
/**
*/
```
- 자주클래스 선언 바로 앞이나 메소드 선언 바로 앞에 있을 때 문서용 주석.

## 메소드를 직접 만들어보자.
- 앞 장의 연습문제인 계산기 클래스 
```java
public class Calculator {

  public int add(int num1, int num2) {
    int sum;
    sum = num1 + num2;
    return sum;
  }

  public int subtract(int num1, int num2) {
    int sub;
    sub = num1 - num2;
    return sub;
  }

  public int multiply(int num1, int num2) {
    int multi;
    multi = num1 * num2;
    return multi;
  }

  public int divide(int num1, int num2) {
    int div;
    div = num1 / num2;
    return div;
  }

  public static void main(String[] args) {
    System.out.println("Calculator class started");
  }
}
```
- 하나의 메소드는 다음과 같이 여섯 부분으로 나뉘어 진다.
1. 제어자 (modifier) : main() 메소드에 있는 public static 같은 메소드의 특성을 정하는 부분
2. 리턴 타입 (return type) : 메소드가 끝났을 때 돌려주는 타입
3. 메소드 이름 (method name) : 소괄호 앞에 있는 메소드 이름
4. 매개 변수 목록 (parameter list) : 소괄호 안에 있는 매개변수 목록
5. 예외 목록 (exception list) : 메소드 매개변수 끝 소괄호와 중괄호 시작 사이의 예외 목록 선언 가능
6. 메소드 내용 (method body) : 중괄호 안의 내용

- 여기서 꼭 필요한 것은 리턴타입, 메소드 이름, 메소드 내용이다.
