# 자바를 제대로 알려면 객체가 무엇인지를 알아야 해요
## 자바는 객체지향 언어라고 해요
- 자바는 객체지향 언어(Object Oriented Language)이다.
- 책, 의자, 핸드폰 모두 객체이다.
- 모든 사물에도 "상태"와 "행위"가 있다.
  - 책 : 덮혀있는 상태, 펼쳐져 있는 상태 / 펼치는 행위, 페이지를 넘기는 행위, 덮는 행위
  - 자동차 : 시속 50km/h 로 주행중인 상태, 512km를 주행한 상태, 빨간색인 상태 / 가속을 하는 행위, 감속을 하는 행위, 문이 열리는 행위
  - 핸드폰 : 켜져 있는 상태, 꺼져 있는 상태, 잠금 해제된 상태, 잠금 중인 상태 / 키는 행위, 끄는 행위, 잠금 해제하는 행위, 잠금하는 행위
- Car 클래스
```java
public class Car {
    
    int speed; // 속도
    int distance; // 주행한 거리
    String color; // 차의 색
    
    /**
     * 생성자 (constructor)
     * - Car 클래스의 객체를 생성할 때 필요
     */
    public Car {
        
    }

	/**
     * 속도를 올리는 메소드
	 */
    public void speedUp() {
        speed = speed + 5;
    }

	/**
     * 속도를 줄이는 메소드
	 */
    public void breakDown() {
        speed = speed - 10;
    }
	
    public int getCurrentSpeed() {
        return speed;
    }
}
```

## 클래스와 객체는 구분하셔야 해요
- Car 클래스는 말 그대로 "클래스"이다. "포르쉐"가 있다고 해도 A의 "포르쉐"와 B의 "포르쉐"는 다르다.
- 각각의 실제 사물을 나타내기 위한 것을 객체(Object) 혹은 인스턴스(instance)라고 한다.
```java
public class CarManager {
    public static void main(String[] args) {
        Car aCar = new Car(); // aCar 생성
        Car bCar = new Car(); // bCar 생성
        bCar.speedUp();
        bCar.speedUp();
        System.out.println(bCar.getCurrentSpeed());
        bCar.breakDown();
        System.out.println(bCar.getCurrentSpeed());
    }
}
```
- "Car"라는 클래스는 그냥 껍데기. new라는 예약어로 생성자인 Car() 를 호출하면 aCar, bCar 객체가 생성된다. 
- 즉, 클래스는 대부분 그 자체만으로 일을 할 수 없고, 객체를 생성해야만 우리가 일을 시킬 수 있다.
```sh
$ javac CarManager.java

$ java CarManager
10
0
```

## 계산기 클래스를 만들어보자
```java
public class Calculator {
    public static void main(String[] args) {
        System.out.println("Calculator class started");
    }
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public int divide(int a, int b) {
        return a / b;
    }
	
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        int a = 10;
        int b = 5;
        System.out.println("add=" + calc.add(a, b));
        System.out.println("subtract=" + calc.subtract(a, b));
        System.out.println("multiply=" + calc.multiply(a, b));
        System.out.println("divide=" + calc.divide(a, b));
    }
}
```
```sh
$ javac Caclculator.java

$ java Caclculator
add=15
subtract=5
multiply=50
divide=2
```
