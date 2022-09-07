# 정보를 어디에 넣고 싶은데
## 자바에서는 네 가지의 변수가 존재해요
- 어떤 프로그래밍 언어를 사용하든 간에, 내용을 어딘가에 담아두어야 한다. 담아 두는 것을 변수(variable)라고 한다.
- 그리고 변수는 항상 이름을 정해 주어야 한다.
- 변수의 종류는 4가지로 다음과 같다.
```java
public class VariableTypes {
    int instanceVariables;                  // 인스턴스 변수
    static int classVariable;               // 클래스 변수
    public void method(int parameter) {     // 소괄호 내에 매개 변수
        int localVariable;                  // 지역 변수
    }
}
```
### 지역 변수 (local variables)
- 중괄호 내에서 선언된 변수
- 지역 변수를 선언한 중괄호 내에서만 유효하다.

### 매개 변수 (parameters)
- 메소드에 넘겨주는 변수
- 메소드가 호출될 때 생명이 시작되고, 메소드가 끝나면 소멸된다.

### 인스턴스 변수 (instance variables)
- 메소드 밖에, 클래스 안에 선언된 변수, 앞에는 static 이라는 예약어가 없어야 한다.
- 객체가 생성될 때 생명이 시작되고, 그 객체를 참조하고 있는 다른 객체가 없으면 소멸된다.

### 클래스 변수 (class variables)
- 인스턴스 변수처럼 메소드 밖에, 클래스 안에 선언된 변수 중에서 타입 선언 앞에 static 이라는 예약어가 있는 변수
- 클래스가 처음 호출될 때 생명이 시작되고, 자바 프로그램이 끝날 때 소멸된다.

## 예제를 통해서 지역 변수를 확실히 익히자
```java
public class VariableTypes {
    int instanceVariables;               
    static int classVariable;
    public void method(int parameter) {
        int localVariable;     
    }
}
```
- 여기서 지역변수는 localVariable 하나 뿐이다.
- 다음과 같은 메소드가 추가되면
```java
public class VariableTypes {
    int instanceVariables;               
    static int classVariable;
    public void method(int parameter) {
        int localVariable;     
    }
    
    public void anotherMethod() {
        int localVariable;
    }
}
```
- 지역 변수는 지역 변수를 선언한 중괄호 내에서만 유효하다. 두 변수는 각각 다른 중괄호 내에 있으므로 서로 다른 변수이다.
- 다음과 같이 바뀌었다고 가정하자.
```java
public class VariableTypes {
    public void anotherMethod() {
        if (true) {
            int localVariable;
        } 
        if (true) {
            int localVariable;
        }
    }
}
```
- 이 역시, 서로 다른 중괄호 내에 있으므로 이름만 같은 서로 상관 없는 다른 변수이다.
- 마지막으로 다음과 같이 바뀌었다고 가정하자.
```java
public class VariableTypes {
    public void anotherMethod() {
        if (true) {
            int localVariable;
        }
        int localVariable;
    }
}
```
- anotherMethod() 뒤에 있는 중괄호 내에 localVariable 이 2개 존재하므로, 컴파일 에러가 발생한다
- `localVariable is already defined in anotherMethod()`
- 따라서 변수를 선언할 떄에는 되도록이면 하나의 메소드에 하나의 이름만 사용하는 것을 권장한다.

## 변수 이름은 이렇게
### 기본적인 규칙은 다음과 같다.
- 길이의 제한은 없다.
- 첫 문자는 유니코드 문자, 알파벳, $, _ 만 올 수 있다. 보통 변수 이름은 $, _ 로 시작하지 않는다.
- 두 번째 문자부터는 유니코드 문자, 알파벳, 숫자, $, _ 중 아무것이나 사용할 수 있다.
- 보통은 메소드 이름처럼 지정해서 사용한다. 첫 문자는 소문자로 시작하는 단어이고, 두 번째 단어의 첫 문자만 대문자로 시작하면 된다.
- 상수(constant value)의 경우에는 모두 대문자로 지정하며 단어와 단어 사이에는 _로 구분한다.
  - 상수는 절대 변하지 않는 값을 이야기함

## 크게 보면 자바에는 두가지 자료형이 있답니다
- 기본 자료형 (Primitive type)과 참조 자료형 (Reference type)으로 나뉜다.
- 앞서 만든 Calculator, Car 클래스 모두 참조 자료형
- `int a = 10;`
- `Calculator calc = new Calculator();`
- int 를 초기화 할 때에는 그냥 바로 값을 적어주고, Caculator는 new라는 예약어로 생성한다.
- 바로 초기화가 가능한 것은 기본 자료형, new를 사용해 초기화 하는 것을 참조 자료형이라 한다.
  - String은 예외적으로 바로 초기화가 가능하지만 참조 자료형이다. 두 가지 모두 출력 시 결과가 동일하다.
    - `String book = "God Of Java";`
    - `String book = new String("God Of Java");`


## 기본 자료형은 8개에요
- 정수형 : byte, short, int, long, char
- 소수형 : float, double
- 기타 : boolean

### 정수형
| 타입    | 최소                         | 최대                        |
|-------|----------------------------|---------------------------|
| byte  | -128                       | 127                       |
| short | -32,768                    | 32,767                    |
| int   | -2,147,483,648             | 2,147,483,647             |
| long  | -9,223,372,036,854,775,808 | 9,223,372,036,854,775,807 |
| char  | 0 ('₩u0000')               | 65,535 ('₩uffff')         |


| 타입    | 최소              | 최대                 |
|-------|-----------------|--------------------|
| byte  | -2<sup>7</sup>  | 2<sup>7</sup>  - 1 |
| short | -2<sup>15</sup> | 2<sup>15</sup> - 1 |
| int   | -2<sup>31</sup> | 2<sup>31</sup> - 1 |
| long  | -2<sup>63</sup> | 2<sup>63</sup> - 1 |
| char  | 0               | 2<sup>16</sup> - 1 |

- unsigned 는 char 뿐이다. char를 제외하고 먼저 생각해보자.
- 2진수 지수 각각 7(8 - 1), 15(16-1), 31(32-1), 63(64-1)로 각 타입이 나타낼 수 있는 숫자의 범위가 2배씩 증가된다

## 8비트와 byte 타입
- byte는 8비트의 부호가 있는 타입. 8비트는 0과 1로 표현할 수 있는 공간이 8개라는 뜻
- 모든 공간이 1로 채워지면 2<sup>7</sup> + 2<sup>6</sup> + 2<sup>5</sup> + 2<sup>4</sup> +2<sup>3</sup> + 
2<sup>2</sup> + 2<sup>1</sup> + 2<sup>0</sup>  = 255
- 하지만 byte의 범위는 반토막 나있는데, byte의 공간은 8개, 부호를 표시할 공간을 맨 앞의 1개의 공간을 차지한 것이다.
- 즉, 가장 왼쪽의 공간은 2<sup>7</sup>이 아니라, 음수와 양수를 구분하기 위한 공간이다.
- 여기서, 바이트의 최솟값은 -128, 최댓값은 127이 되는데, 최솟값에서 1을 빼면 127, 최댓값에서 1을 더하면 -128이된다.

## 다른 정수형 타입들은 어떻게 활용하나?
- short, int에서 특이한 점은 없고, 다만 long은 선언할 때, 마지막에 L을 붙혀주어야만 한다. (안 붙힐 시, 컴파일 에러)

## 소수점을 처리하고 싶어요
- float, double 모두 소수점 값을 처리하기 위해 사용됨
- float은 32비트, double은 64비트
- 각각 제공할 수 있는 범위를 넘어서면 그 값의 정확성을 보장하지 못하기 때문에 정확한 계산이 요구될 때에는 float, double이 아닌
java.math.BigDecimal이라는 클래스를 사용해야 함
- float : single-precision 32-bit IEEE 754 floating point (단일 정확도를 가지는 32비트 IEEE 부동 소수점)
- double : double-precision 64-bit IEEE 754 floating point
  - IEEE는 국제적인 표준, 754는 그 표준의 번호
- 소수점 처리는 일반적으로 double을 사용 (반드시 X). 대량으로 소수점 자리수가 적은 데이터에 float을 사용
- float : 부호(1자리) + 지수(8자리) + 가수(23자리) = 32비트
- double : 부호(1자리) + 지수(11자리) + 가수(52자리) = 64비트

## char와 boolean은 어떻게 쓰는거지?
- char는 "캐릭터 (character)'라고 읽고 문자열과 관련된 부분에서 사용. 홑따옴표 사용
```java
public void checkChar() {
    char charMin = '\u0000';
    char charMax = '\uffff';
    System.out.println("charMin=["+charMin+"]"); // charMin=[ ] // 공백
    System.out.println("charMax=["+charMax+"]"); // charMax=[?] // ?

    int intValue = 'a';
    System.out.println("intValue=["+intValue+"]"); // intValue=[97] // ?
}
```
- boolean은 "true"와 "false" 두개의 값밖에 없다. 즉, "참", "거짓" 두 가지이다.
```java
public void checkBoolean() {
    boolean flag = true;
    System.out.println(flag);
    
    boolean flag = false;
    System.out.println(flag);
}
```

## 기본 자료형의 기본 값은 뭘까?
- 모든 자료형은 값을 지정하지 않으면 기본 값을 사용하는데, 지역 변수의 경우에는 기본 값이 자동으로 적용되지 않아 반드시 값을 지정해야 한다.
- 기본 값이 있더라도 값을 지정하지 않고 개발하는 것은 좋지 않은 습관이므로, 반드시 값을 지정하자.
```java
public class PrimitiveTypes {
	int intDefault;
	byte byteDefault;
	short shortDefault;
	long longDefault;
	float floatDefault;
	double doubleDefault;
	char charDefault;
	boolean booleanDefault;
	
	public static void main(String[] args) {
		PrimitiveTypes primitiveTypes = new PrimitiveTypes();
		primitiveTypes.defaultValues();
    }
	
	public void defaultValues() {
      System.out.println("intDefault=" + intDefault);
      System.out.println("byteDefault=" + byteDefault);
      System.out.println("shortDefault=" + shortDefault);
      System.out.println("longDefault=" + longDefault);
      System.out.println("floatDefault=" + floatDefault);
      System.out.println("doubleDefault=" + doubleDefault);
      System.out.println("charDefault=" + charDefault);
      System.out.println("booleanDefault=" + booleanDefault);
    }
}
```
- 실행 결과
```text
intDefault=0
byteDefault=0
shortDefault=0
longDefault=0
floatDefault=0.0
doubleDefault=0.0
charDefault=
booleanDefault=false
```
- char 는 '₩u0000'값 즉, 공백이 출력되었고 boolean은 false, 그외에는 0이 출력되었다.
