# 계산을 하고 싶어요
## 연산자라는 게 뭐지? 벌써 조금 배웠다고?
- 연산자는 영어로 Operator, 기본 자료형 계산을 위해 사용
- `=` : 대입 연산자. assignment operator
- 산술 연산자 5개
- `+` : 더하기 연산자. additive operator
- `-` : 빼기 연산자. subtraction operator
- `*` : 곱하기 연산자. multiplication operator
- `/` : 나누기 연산자. division operator
- `%` : 나머지 연산자. remainder operator

### +와 -
```java
public class OperatorPlusMinus {
    public static void main(String[] args) {
        OperatorPlusMinus sample = new OperatorPlusMinus();
        sample.additive();
    }

    public void additive() {
        int intValue1 = 5;
        int intValue2 = 10;
        int result = intValue1 + intValue2; // intValue1 과 intValue2 더하기
        System.out.println(result);
        result = intValue2 - intValue1; // intValue2 에서 intValue1 빼기
        System.out.println(result);
    }
}
```
- result를 처음에 더하기 값을 할당한 후 추가 변수를 선언하지 않고 result를 재사용하여 
뺄셈을 지정했다.

### *와 /
```java
public class OperatorMultipleDivision {
    public static void main(String[] args) {
        OperatorMultipleDivision sample = new OperatorMultipleDivision();
        sample.multipleDivision(); // 50\n 2
        sample.divideInt(); // 0
        sample.divideDouble();// 0.5
    }
	
    public void multipleDivision() {
        int intValue1 = 5;
        int intValue2 = 10;
        
        int result = intValue1 * intValue2;
        System.out.println(result);
        result = intValue2 / intValue1;
        System.out.println(result);
    }
	
    public void divideInt() {
        int intValue1 = 5;
        int intValue2 = 10;
        int result = intValue1 / intValue2;
        System.out.println(result);
    }
	
    public void divideDouble() {
        double doubleValue1 = 5;
        double doubleValue2 = 10;
        double result = doubleValue1 / doubleValue2;
        System.out.println(result);
    }
}
```
- divideInt의 경우 0 divideDouble의 경우 0.5가 출력된다.
  - int 타입은 정수형이다. 자바에서 계산하는 두 값이 정수형이고 결과값이 소수형이라고 해서
    값이 알아서 소수형으로 결과가 나오지 않는다. 따라서 0.5인 값을 얻고 싶어 double로 변환하여
    계산한 것이다.

### %
- `%`는 연산자의 나머지 값을 구해주는 경우로 remainer operator 라고 한다.
```java
public class OperatorRemainder {
    public static void main(String[] args) {
        OperatorRemainder sample = new OperatorRemainder();
        sample.remainder();
    }
	
    public void remainder() {
        int intValue1 = 53;
        int intValue2 = 10;
        int result = intValue1 % intValue2;
        System.out.println(result);
        intValue1 = 50;
        result = intValue1 % intValue2;
        System.out.println(result);
    }
}
```
- 53 % 10 의 경우 53에서 10으로 나눈 나머지가 3이므로 3 출력
- 50 % 10 의 경우 50에서 10으로 나눈 나머지가 0이므로 0 출력

## 간단하게 계산하는 복합 대입 연산자들
- 복합 대입 연산자는 영어로 "Compound Assignment Operator"이라고 한다.
```java
int intValue = 10;
intValue = intValue + 5;
```
- 위와 같은 코드를 복합 대입 연산자를 사용한 아래와 같은 코드로 간단하게 처리할 수 있다.
```java
int intValue = 10;
intValue += 5;
```
복합 대입 연산자는 아래 5가지가 있다.
- `+=` : 기존 값에 우측 항의 값을 더함
- `-=` : 기존 값에 우측 항의 값을 뺌
- `*=` : 기존 값에 우측 항의 값을 곱함
- `/=` : 기존 값에 우측 항의 값으로 나눈
- `%=` : 기존 값에 우측 항의 값으로 나눈 나머지

복합 연산자를 사용한 연습문제 (OperatorCompound 클래스 내의 compound 메소드)
1. 정수형인 intValue를 선언하여 10을 할당하자
2. 이 값의 5를 더하고 결과 출력
3. 5를 빼고 결과 출력
4. 5를 곱하고 결과 출력
5. 5를 나누고 결과 출력
6. 5로 나눈 나머지 값 출력
7. compound 메소드의 결과는 다음과 같다
```text
15
10
50
10
0
```
```java
public class OperatorCompound {
    public static void main(String[] args) {
        OperatorCompound sample = new OperatorCompound();
        sample.compound();
    }

    public void compound() {
        int intValue = 10;
        intValue += 5;
        System.out.println(intValue);
        intValue -= 5;
        System.out.println(intValue);
        intValue *= 5;
        System.out.println(intValue);
        intValue /= 5;
        System.out.println(intValue);
        intValue %= 5;
        System.out.println(intValue);
    }
}
```

## 피연산자가 하나인 것도 있어요. 이걸 단항 연산자라고 하죠
- +, -, *, /, % 모두 두 개의 피연산자를 사용한다.
- 한개의 단항 연산자는 다음과 같다.
- `+` : 단항 플러스 연산자. Unary plus operator
- `-` : 단항 마이너스 연산자. Unary minus operator
- `++` : 증가 연산자. Increment operator
- `--` : 감소 연산자. Decrement operator
- `!` : 논리 부정 연산자. Logical complement operator

### +와 -
```java
public class OperatorUnary {
    public void unary() {
        int intValue = -10;
        int result = +intValue;
        System.out.println(result);
        result = -intValue;
        System.out.println(result);
    }
}
```
- `+`는 "변수 x (1)"을 의미하고
- `-`는 "변수 x (-1)"을 의미한다.
- `-`는 해당 값이 음수면 양수로 양수이면 음수로 만들 때, 사용되지만 `+`는
그냥 숫자가 양수라는 것을 명시적으로 보여주기 위해 사용된다. 굳이 +를 쓸 필요는 없다.

### ++와 --
- intValue에서 1만큼 증가시키고, 1만큼 감소시키려면 다음과 같이 코딩해야 한다.
```java
intValue = intValue + 1;
intValue = intValue - 1;
```
- 개발하다 보면 1을 더하고 1을 뺼일이 많이 생겨, 자바 뿐만 아니라 다른 언어에서도 이를 쉽게
할 수 있는 ++와 --를 사용하고 있다. 아래의 코드와 같다.
```java
intValue++;
intValue--;
```
- 주의할 점은 ++, --가 앞에 붙는 것과 뒤에 붙는 것에 차이가 있다.
```java
public class OperatorIncrement {
    public static void main(String[] args) {
        OperatorIncrement operator = new OperatorIncrement();
        operator.increment();
    }
    public void increment() {
        int intValue = 1;
        System.out.println(intValue++);
        System.out.println(intValue);
        System.out.println(++intValue);
    }
}
```
이 코드는 다음과 같은 결과를 보여준다.
- 첫 번째 출력애서 결과를 출력한 후에 1을 더하고
- 두 번째 출력에서는 그냥 값만 출력
- 세 번째 출력을 수행하기 전에 1을 더하고 결과를 출력
```text
1
2
3
```

### !
- `!`는 청개구리 연산자다. boolean에서만 사용할 수 있는 연산자로, 그 결과가 반대가 된다.
```java
public class OperatorComplement {
    public static void main(String[] args) {
        OperatorComplement operator = new OperatorComplement();
        operator.complement();
    }
    
    public void complement() {
        boolean flag = true;
        System.out.println(flag);
        System.out.println(!flag);
    }
}
```
```text
true
false
```

## 자바에서는 계산하는 순서를 알아두면 좋다.
```text
1 + 2 * 3
```
- 위 식의 결과는 우선순위에 따라 2 * 3을 먼저한 후 1을 더하여 7이 된다.
- 1 + 2를 먼저 수행하려면 `(1 + 2) * 3`과 같이 괄호를 하게 되면 괄호 안에 있는 것을
먼저 계산한다.
- 자바에서도 연산자의 우선순위가 있는데 다음과 같다.

| 구분     | 연산자           | 우선 순위 |
|--------|---------------|-------|
| 단항 연산자 | ++ -- + - ! ~ | 1     |
| 산술 연산자 | * / %         | 2     |
|        | + -           | 3     |

- `~` (틸트)의 경우 2진수로 되어 있는 비트 값을 전부 거꾸로 바꾸는 데 사용
- 비트 값의 0을 1로 1을 0으로 바꾸는 데 사용
```java
public class OperatorTilde {
    public static void main(String[] args) {
        OperatorTilde operator = new OperatorTilde();
        byte b = 127;
        operator.printTildeResult(b);
        b = 1;
        operator.printTildeResult(b);        
    }

    public void printTildeResult(byte b) {
        System.out.println("Original value=" + b);
        System.out.println("Tilde value=" + ~b);
    }
}
```
```text
Original value=127
Tilde value=-128
Original value=1
Tilde value=-2
```

## 뭔가를 비교할 때는 어떻게 하지?
비교 연산자 사용 
- `==` : 같음 (equal to)
- `!=` : 같지 않음 (not equal to)
- `>` : (왼쪽 값이) 큼 (greater than)
- `>=` : (왼쪽 값이) 같거나 큼 (greater than or equal to)
- `<` : (왼쪽 값이) 작음 (less than)
- `<=` : (왼쪽 값이) 같거나 작음 (less than or equal to)


- 모든 비교 연산자의 결과는 반드시 boolean. 조건에 맞으면 true, 그렇지 않으면 false

### == 과 !=
- `==`와 `!=`는 등가 비교 연산자 라고 하고 Equality Operator 라고 부른다.
- 비교 연산자는 왼쪽 값과 오른쪽을 비교하는 데 사용된다.
```java
public class OperatorComparison {
    public static void main(String[] args) {
        OperatorComparison operator = new OperatorComparison();
        operator.comparison();
		System.out.println("===================");
        operator.comparison2();
		System.out.println("===================");
		operator.comparison3();
	}
    
    public void comparison() {
        int intValue1 = 1;
        int intValue2 = 2;
        int intValue3 = 1;
        System.out.println(intValue1 == intValue2);
        System.out.println(intValue1 == intValue3);
        
        System.out.println(intValue1 != intValue2);
        System.out.println(intValue1 != intValue3);
    }
    
    public void comparison2() {
        char charValue = 'a';
        System.out.println(97 == charValue);
        int intValue = 1;
        double doubleValue = 1.0;
        System.out.println(intValue == doubleValue);
    }
    
    public void comparison3() {
        boolean booleanValue1 = true;
        boolean booleanValue2 = false;
        System.out.println(booleanValue1 == booleanValue2);
        System.out.println(booleanValue1 != booleanValue2);
    }
}
```
```text
false
true
true
false
===================
true
true
===================
false
true
```
- `==`의 경우 두 개의 값이 같으면 true, `!=`의 경우 두 개의 값이 다르면 true로 계산됨
- 기본 자료형은 같은 종류끼리 비교가 가능하다.
  - char == int
  - double == int
  - boolean == boolean
  - 불가능
    - boolean == int
    - boolean == char

### <, >, <=, >=
- 이 네 개의 연산자는 두 개의 값이 큰지 작은지 비교. 
- 대소 비교 연산자 (Relational Operator)라고 부름
- 숫자에서만 사용 가능
```java
public class OperatorRelational {
    public static void main(String[] args) {
        OperatorRelational operator = new OperatorRelational();
        operator.relational();
    }
    
    public void relational() {
        int intValue1 = 1;
        int intValue2 = 2;
        System.out.println(intValue1 > intValue2);
        System.out.println(intValue1 < intValue2);
        System.out.println(intValue1 >= intValue2);
        System.out.println(intValue1 <= intValue2);
    }
}
```
```text
false
true
false
true
```
- 각 연산자를 어디서 사용할 수 있을까

| 연산자          | 사용 가능한 타입                    |
|--------------|------------------------------|
| ==, !=       | 모든 기본 자료형과 참조 자료형 -> 즉 모든 타입 |
| >, <, >=, <= | boolean을 제외한 기본 자료형          |

## 논리 연산자들을 알아보자
- 논리 연산자 (Logical Operator)는 여러 조건이 있을 때 사용한다.

논리 연산자에는 2개가 있다.
- `&&` : AND 결합
- `||` : OR 결합


- AND 결합은 두 개의 조건이 모두 true 일 때 true
- OR 결합은 둘 중 하나라도 true 이면 true


| 값     |       | 결과     |                  |
|-------|-------|--------|------------------|
| x     | y     | x && y | x &#124;&#124; y |
| true  | true  | true   | true             |
| true  | false | false  | true             |
| false | true  | false  | true             |
| false | false | false  | false            |

```java
public class OperatorConditional {
    public static void main(String[] args) {
        OperatorConditional operator = new OperatorConditional();
        operator.condition();
    }

    public void condition() {
        boolean x = true;
        boolean y = true;
        System.out.println(x && y);     
        System.out.println(x || y);
        System.out.println("-----");
        x = false;
        System.out.println(x && y);     
        System.out.println(x || y);
        System.out.println("-----");
        y = false;      
        System.out.println(x && y);     
        System.out.println(x || y);
    }
}

```

## 아주 특이한 ? : 연산자
- if 문은 조건에 맞는 경우에만 처리할 때 사용하는데 if 문을 간단히 처리해 주는 `? :`로 구성된
"삼항 연산자"라는 것이 있는데, "Conditional Operators ? : " 또는 "the ternary operator"
라고 한다.
```java
public class OperatorConditionalTriple {

    public static void main(String[] args) {
        OperatorConditionalTriple operator = new OperatorConditionalTriple();   
        operator.doBlindDate(30);
        operator.doBlindDate(80);
    }       

    public boolean doBlindDate(int point) {
        boolean doBlindDateFlag = true;
        doBlindDateFlag = (point >= 80) ? true : false;
        System.out.println(point + " : " + doBlindDateFlag);
        return doBlindDateFlag;
    }
}
```
```text
30 : false
80 : true
```
- 변수 = (boolean 조건식) ? true일 때 값 : false일 때 값
- 즉, 삼항 연산자는 `=` 왼쪽에 있는 변수에 값을 할당 할 때 사용한다. 변수 우측에는 할당을 위한
`=`을 사용하는 데, `=`과 `?` 사이에 boolean 타입을 반환하는 조건식이 있어야 하고, : 의 우측에는
true일 때의 값, 좌측에는 false 일 때의 값을 지정해 준다.

## 기본 자료형의 형 변환을 이용한 변신
- 형 변환은 영어로 캐스팅(casting)
- boolean을 제외한 모든 기본 자료형에서 형 변환이 가능. 단, 기본 자료형 -> 참조 자료형, 
참조 자료형 -> 기본 자료형은 불가능
- 형 변환 예
  - byte -> short
  - short -> byte
- byte 에서 short는 1바이트 -> 2바이트로 변환 할 경우에는 별도로 해 줄 것이 없다.
- short 에서 byte는 2바이트 -> 1바이트 이므로 확인해야 할 것이 있다.
```java
public class OperatorCasting {

    public static void main(String[] args) {
        OperatorCasting operator = new OperatorCasting();
        operator.casting();
    }

    public void casting() {
        byte byteValue = 127; // 1
        short shortValue = byteValue; // 2

        shortValue++; // 3
        System.out.println(shortValue);
        byteValue = (byte) shortValue; // 4
        System.out.println(byteValue);
    }
}
```
1. byteValue에 byte에 최댓값 127 (2<sup>7</sup> - 1) 할당
2. byteValue를 shortValue 변수에 할당 -> 범위가 작은 타입에서 큰 타입으로 변환할 때에는 
별도 명시 필요 없음.
3. shortValue에 1을 더하고 출력 시 128 출력
4. byte의 최댓값을 넘는 shortValue를 byte에 할당하였다. 범위가 큰 타입에서 작은 타입으로 
형 변환 시 소괄호로 감싸주어야 함 (안 할 시 컴파일 오류)
```text
128
-128
```
- 128은 2<sup>7</sup>, short 에서 byte로 변환 시 1바이트 (8비트)를 그냥 버리므로
- 형 변환 시, 0000 0000 1000 0000(2) 에서 1000 0000 (2) -> 
 첫 비트가 1이면 음수이므로 결과가 -128
- short 의 값을 256으로 지정하고 확인 해보면
```java
public class OperatorCasting {

    public static void main(String[] args) {
        OperatorCasting operator = new OperatorCasting();
        // operator.casting();
        operator.casting2();
    }

    public void casting() {
		// 생략
	}
	
    public void casting2() {
        short shortValue = 256;
		byte byteValue = (byte) shortValue;
		System.out.println(byteValue);
        shortValue = 255;
        byte byteValue = (byte) shortValue;
        System.out.println(byteValue);    
	}
}
```
```text
0
-1
```

### 타입 별 사용 가능한 연산자 알아보기
- 자바의 연산자들은 타입별로 사용 가능한 연산자가 정해져 있다.
- 정수, 소수, boolean, 참조 자료형 별로 연산자가 각각 존재

#### 정수
| 구분            |             | 연산자                          |
|---------------|-------------|------------------------------|
| 결과가 boolean   | 숫자 비교 연산자   | <, <=, >, >=                 |
|               | 숫자 동등 연산자   | ==, !=                       |
| 결과가 int나 long | 기본 사칙 연산자   | +, -, *, /, %                | 
|               | 증감 연산자      | ++, --                       | 
|               | 비트 연산자      | &, &#124;, ^, ~, <<, >>, >>> |
| 기타 연산자        | 삼항 연산자      | ? :                          | 
|               | 형 변환 연산자    | (타입)                         | 
|               | 문자열 더하기 연산자 | +                            | 

#### 소수

| 구분            |             | 연산자                          |
|---------------|-------------|------------------------------|
| 결과가 boolean   | 숫자 비교 연산자   | <, <=, >, >=                 |
|               | 숫자 동등 연산자   | ==, !=                       |
| 결과가 int나 long | 기본 사칙 연산자   | +, -, *, /, %                | 
|               | 증감 연산자      | ++, --                       | 
| 기타 연산자        | 삼항 연산자      | ? :                          | 
|               | 형 변환 연산자    | (타입)                         | 
|               | 문자열 더하기 연산자 | +                            | 
- 정수형 연산자와 다른 것은 비트 연산자가 불가능 하다는 것이다.

#### boolean

| 구분          | 연산자               |
|-------------|-------------------|
| 동등 연산자      | ==, !=            |
| 조건적 논리 연산자  | &&, &#124; &#124; |
| 논리 연산자      | !, &, &#124;, ^   |
| 삼항 연산자      | ? :               |
| 문자열 더하기 연산자 | +                 |

- 여기서 눈여겨 볼 것은 &, |, ^ 이 있다. 
- 이 연산자들은 숫자에 사용하면 비트 연산, boolean 타입에서는 논리 연산을 수행
  - `&` : 두 값이 모두 true 일 경우에만 true
  - `|` : 두 값이 모두 false 일 경우에만 false
  - `^` : 두 값이 서로 다를 경우에는 true, 모두 true 이거나 false 이면 false
- && 과 &, || 과 | 이 결과는 같지만 연산 방식에 큰 차이가 있다.
  - && 은 좌측 연산이 false 이면 우측 연산을 수행하지 않는다. && 연산은 두 결과 모두 true 여야 true가 되므로 앞의 결과가 false 일 경우 뒤 연산이 필요없다.
  - & 의 경우 좌측 결과와 우측 결과를 비교해야 하기 떄문에 모든 연산을 수행한다. 즉, 앞의 연산과 뒤의 연산이 같은지를 확인하는 비트 연산자


- 참조 자료형에서의 `+` 연산자 : 해당 클래스에 있는 toString() 멧드의 결과와 그 연산자 뒤에 있는 문자열을 더한다.
