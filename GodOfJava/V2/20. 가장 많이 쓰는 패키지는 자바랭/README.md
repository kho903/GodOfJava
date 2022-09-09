# 가장 많이 쓰는 패키지는 자바랭
## java.lang 패키지는 특별하죠
- java.lang 패키지는 자바의 패키지 중 유일하게 impoprt하지 않아도 사용 가능. 그만큼 꼭 필요한 여러 기능 제공
- java.lang, java.util 패키지는 아주 다양한 일을 하는 클래스, 인터페이스 혼재.
- java.lang 패키지에서 제공하는 인터페이스, 클래스, 예외 클래스는 다음과 같이 분류 가능
  - 언어 관련 기본
  - 문자열 관련
  - 기본 자료형 및 숫자 관련
  - 쓰레드 관련
  - 예외 관련
  - 런타임 관련

### 언어 관련 기본
- 인터페이스 : Cloneable, Comparable, Iterable, Readable
- 클래스 : Class, ClassLoader, Compiler, Enum, Object, Package, SecurityManger, StackTraceElement, System, Void
- 예외 및 에러 
  - ArrayIndexOutOfBoundsException, ArrayStoreException
  - ClassCastException, ClassNotFoundException
  - CloneNotSupportedException, EnumConstantNotPresentException, IllegalAccessException
  - IllegalArgumentException, IndexOutOfBoundsException, InstantiationException, NegativeArraySizeException, 
  NoSuchFieldException, NoSuchMethodException
  - NullPointerException, RuntimeException, SecurityException, TypeNotPresentException, UnsupportedOperationException

### 문자열 관련
- 인터페이스 : Appendable, CharSequence
- 클래스 : String, StringBuffer, StringBuilder
- 예외 및 에러 : StringIndexOutOfBoundsException

### 기본 자료형 및 숫자 관련
- 클래스 : Boolean, Byte, Character, Character.Subset, Character.UnicodeBlock, Double, Float, Integer, Long, Math,
Number, Short, StrictMath
- 예외 및 에러 : ArithMeticException, NumberFormatException

### 쓰레드 관련
- 인터페이스 : Runnable, Thread.UncaughtExceptionHandler
- 클래스 : InheritableThreadLocal, Thread, ThreadGroup, ThreadLocal, Thread.State(Enum 타입임)
- 예외 및 에러 : IllegalMonitorStateException, IllegalThreadStateException, InterruptedException

### 예외 관련
- 클래스 : Throwable
- 예외 및 에러 : Exception

### 런타임 관련
- 클래스 : Process, ProcessBuilder, Runtime, RuntimePermission
- 예외 및 에러 : IllegalStateException


추가로 java.lang 패키지에 정의됭되어 있는 "에러"는 다음과 같다.
- AbstractMethodError, AssertionError, ClassCircularityError, ClassFormatError, Error, ExceptionInInitializerError,
IllegalAccessError, IncompatibleClassChangeError, InstantiationError, InternalError, LinkageError, NoClassDefFoundError,
NoSuchFiledError, NoSuchMethodError, OutOfMemoryError, StackOverflowError, ThreadDeath, UnknownError, 
UnsatisfiedLinkError, UnsupportedClassVersionError, VerifyError, VirtualMachineError

- 모두 다 알 필요는 없지만, 몇 가지는 알고 있어야 한다. 부(OOME)와 StackOverflowError다. 
- OOME는 메모리가 부족하여 발생하는 에러. 자바 가상 머신에서 메모리를 관리하지만, 프로그램 잘못 작성 혹은 설정 문제로 OOME 발생 가능
- StackOverflowError는 호출된 메소드의 깊이가 너무 깊을 때 발생. 어떤 메소드가 어떤 메소드를 호출했는지에 대한 정보가 쌓이는 스택 영역에
재귀 메소드를 잘못 작성했다면 호출 정보의 한계를 넘어 발생


- 그리고 java.lang 패키지에는 자바의 기본 어노테이션이 선언되어 있다.
  - Deprecated
  - Override
  - SuppressWarnings

## 숫자를 처리하는 클래스들
- 자바에서 간단한 계산은 기본 자료형 Primitive Type 사용. 힙 영역이 아닌 스택 영역에 저장되어 관리. 따라서 계산할 때보다 빠른 처리가 가능
- 그런데 기본 자료형을 객체로 처리해야 할 떄 사용하는 클래스가 다음과 같이 선언되어 있다.
  - Byte
  - Short
  - Integer
  - Long
  - Float
  - Double
  - Character
  - Boolean
- Character 를 제외한 나머지는 각 기본 자료형에서 첫 문자를 대문자로 바뀌었다. Character와 Boolean을 제외한 숫자를 처리하는 클래스들은 
감싼 (Wrapper) 클래스라고 불리며, 모두 Number라는 abstract 클래스를 확장 (extends)한다.
- 참조 자료형은 기본자료형처럼 사용할 수 있다. 자바 컴파일러에서 자동으로 형 변환을 해 준다.
- Character를 제외하고는 parse타입이름(), valueOf() 메소드를 제공한다.

```java
package _20.lang;

public class JavaLangNumber {
        public static void main(String[] args) {
                JavaLangNumber sample = new JavaLangNumber();
                sample.numberTypeCheck();
        }

        public void numberTypeCheck() {
                String value1 = "3";
                String value2 = "5";
                byte byte1 = Byte.parseByte(value1);
                byte byte2 = Byte.parseByte(value2);

                Integer refInt1 = Integer.valueOf(value1);
                Integer refInt2 = Integer.valueOf(value2);
                System.out.println(refInt1 + refInt2 + "7");
        }
}
```
```text
8
87
```
- 위 코드는 3, 5 라는 String 값을 parseByte() 메소드를 사용하여 byte로 변환하고, 두 값을 더한 결과를 출력
  - byte 타입을 더해 3 + 5 = `8` 이 출력된다.
- valueOf() 메소드를 사용하여 Integer 타입으로 변환한 후 두 값을 더한 후 "7"이라는 String 을 더하여 출력
  - 참조 자료형은 앞서 `+` 연산은 String만 가능하다고 했지만, 참조 자료형 중 Byte, Short, Integer, Long, Float, Double 의 경우
  필요시 기본 자료형처럼 사용할 수 있다. -> 3 + 5 를 한 8이라는 결과에 String 값 "7"이 더해져 `87` 출력
  - 따라서, new 객체를 만들지 않아도 다음과 같이 값을 할당할 수 있다.
```java
public void numberTypeCheck2() {
        Integer refInt1 = 1;
        refInt1 = 100;
        System.out.println(refInt1.doubleValue());
}
```
- 컴파일, 실행 모두 잘 된다. 왜 이런 자료형을 만들었을까?
  - 매개 변수를 참조 자료형으로만 받는 메소드를 처리하기 위해서
  - 제네릭과 같이 기본 자료형을 사용하지 않는 기능을 사용하기 위해서
  - MIN_VALUE, MAX_VALUE 같이 클래스에 선언된 상수 값을 사용하기 위해서
  - 문자열을 숫자로, 숫자를 문자열로 쉽게 변환 및, 2, 8, 10, 16진수 변환을 쉽게 처리하기 위해서
이다.
- 각각 숫자 참조 자료형에서는 많은 메소드를 제공한다.
- 기본 자료형을 참조 자료형으로 만든 클래스들은 Boolean 제외, 모두 MIN_VALUE, MAX_VALUE를 가지고 있다.

```java
public void numberMinMaxCheck() {
        System.out.println("Byte min=" + Byte.MIN_VALUE + " max=" + Byte.MAX_VALUE);
        System.out.println("Short min=" + Short.MIN_VALUE + " max=" + Short.MAX_VALUE);
        System.out.println("Integer min=" + Integer.MIN_VALUE + " max=" + Integer.MAX_VALUE);
        System.out.println("Long min=" + Long.MIN_VALUE + " max=" + Long.MAX_VALUE);
        System.out.println("Float min=" + Float.MIN_VALUE + " max=" + Float.MAX_VALUE);
        System.out.println("Double min=" + Double.MIN_VALUE + " max=" + Double.MAX_VALUE);
        System.out.println("Character min=" + (int)Character.MIN_VALUE + " max=" + (int)Character.MAX_VALUE);
}
```
```text
Byte min=-128 max=127
Short min=-32768 max=32767
Integer min=-2147483648 max=2147483647
Long min=-9223372036854775808 max=9223372036854775807
Float min=1.4E-45 max=3.4028235E38
Double min=4.9E-324 max=1.7976931348623157E308
Character min=0 max=65535
```
- 각 타입의 최대 최솟값이 출력되었따. 이 값을 2진수나 16진수로 표현해서 확인해 보자. Integer 클래스에서 제공하는 toBinaryString() 메소드를 사용한다.
```java
public void integerMinMaxCheckBinary() {
        System.out.println("Integer BINARY min=" + Integer.진(Integer.MIN_VALUE));
        System.out.println("Integer BINARY max=" + Integer.toBinaryString(Integer.MAX_VALUE));  

        System.out.println("Integer HEX min=" + Integer.toHexString(Integer.MIN_VALUE));
        System.out.println("Integer HEX max=" + Integer.toHexString(Integer.MAX_VALUE));
}
```
```text
Integer BINARY min=10000000000000000000000000000000
Integer BINARY max=1111111111111111111111111111111
Integer HEX min=80000000
Integer HEX max=7fffffff
```
- 이와 같이 원하는 진수의 숫자로 표현하고 싶을 때에는 직접 구현보다는 숫자 클래스에서 제공되는 메소드를 사용하면 된다.
- 돈 계산과 같은 중요한 연산 수행시에는 정수형은 BigInteger, 소수형은 BigDecimal을 사용해야 정확한 연산이 가능하며, java.lang.Number를
상속받았고, java.math 패키지에 선언되어 있다.
- 이외에도 많은 상수와 메소드들이 있다.

## 각종 정보를 확인하기 위한 System 클래스
- System 클래스의 가장 큰 특징은 생성자가 없다.
- 3개의 static 변수가 선언되어 있고, 다음과 같다.

| 선언 및 리턴 타입         | 변수명 | 설명                 |
|--------------------|-----|--------------------|
| static PrintStream | err | 에러 및 오류를 출력할 떄 사용. |
| static InputStream | in  | 입력값을 처리할 때 사용.     |
| static PrintStream | out | 출력값을 처리할 때 사용.     |

- 지금까지 데이터 출력시 사용했던 System.out.println()을 살펴보자. System은 클래스 이름. out은 System 클래스에 static으로 선언된 변수 이름.
out은 PrintStream 타입이므로, println()이라는 메소드는 PrintStram 클래스에 선언되어 있는 static 메소드이다.
- PrintStream, InputStream은 모두 java.io 패키지에 선언되어 있다.
- System은 출력만을 위한 클래스가 아니다. 출력을 위한 부분들은 out, err로 선언된 PrintStream 과 연관되고, 실제 System 클래스에 있는 메소드에는
출력과 관련된 것은 없다. 제공되는 메소드의 분류는 다음과 같다.
  - 시스템 속성 (Property) 값 관리
  - 시스템 환경 (Environment) 값 조회
  - GC 수행
  - JVM 종료
  - 현재 시간 조회
  - 기타 관리용 메소드들
- GC 수행과 JVM 종료는 절대 수행해서는 안 된다. 

### 시스템 속성 (Property) 값 관리
| 리턴 타입  | 메소드 이름 및 매개 변수                        | 설명                                                        |
|--------|---------------------------------------|-----------------------------------------------------------|
| static | clearProperty(String key)             | key에 지정된 시스템 속성을 제거                                       |
| static | getProperties()                       | 현재 시스템 속성을 Properties 클래스 형태로 제공                          |
| static | getProperty(String key)               | key에 지정된 문자열로 된 시스템 속성값(value)을 얻는다.                      |
| static | getProperty(String key, String def)   | key에 지정된 문자열로된 시스템 속성값(value)을 얻고, 만약 없으면, def에 지정된 값을 리턴 |
| static | setProperty(Properties props)         | Properties 타입으로 넘겨주는 매개 변수에 있는 값들을 시스템 속성에 넣는다.           |
| static | setProperty(String key, String value) | key에 지정된 시스템 속성의 값을 value로 대체                             |

- Property는 Properties를 먼저 알아야 하는데, Properties는 java.util 패키지에 속하며, Hashtable의 상속을 받은 클래스.
  - Hashtable : key-value 쌍으로 이루어진 여러 개의 값을 갖는 Map 형태의 자료 구조
- 필요 여부와 상관 없이 자바 프로그램 실행시 Properties 객체가 생성되며, 그 값은 언제, 어디서든지 같은 JVM 내에서 꺼내 쓸 수 있다.

```java
package _20.lang;

public class JavaLangSystem {
        public static void main(String[] args) {
                JavaLangSystem sample = new JavaLangSystem();
                sample.systemPropertiesCheck();
        }

        public void systemPropertiesCheck() {
                System.out.println("java.version=" + System.getProperty("java.version"));
        }
}
```
```text
java.version=11.0.11
```
- 즉, 내가 쓰고 있는 자바 버전은 11.0.11 인 것이다.

### 시스템 환경 (Environment) 값 조회
| 리턴 타입                      | 메소드 이름 및 매개 변수      | 설명                              |
|----------------------------|---------------------|---------------------------------|
| static Map<String, String> | getenv()            | 현재 시스템 환경에 대한 Map 형태의 리턴값을 받는다. |
| static String              | getenv(String name) | 지정한 name에 해당하는 값을 받는다.          |

- 앞에서 본 Properties는 추가와 변경이 가능하지만 환경값 env는 변경하지 못하고 읽기만 가능하다. 대부분 OS, 잡이 관련된 것들이다.<br>
`System.out.println("JAVA_HOME=" + System.get);`을 추가하고 결과를 살펴보면

```text
java.version=11.0.11
JAVA_HOME=/Library/Java/JavaVirtualMachines/zulu-11.jdk/Contents/Home
```
- 다음과 같이 출력된다. JAVA_HOME이라는 값은 JDK가 설치되어 있는 경로를 의미한다.
- 매개 변수가 없는 getenv() 메소드는 리턴 타입이 Map<String, String> 이다.

### GC 수행
| 리턴 타입       | 메소드 이름 및 매개 변수    | 설명                                        |
|-------------|-------------------|-------------------------------------------|
| static void | gc()              | 가비지 컬렉터를 실행                               |
| static void | runFinalization() | GC 처리를 기다리는 모든 객체에 대하여 finalize() 메소드를 실행 |

- 해당 메소드들은 개발자가 직접 사용하면 안 된다. 
- 자바는 메모리 처리를 개발자가 별도로 하지 않아, System.gc() 메소드로 명시적으로 처리할 수 있고, finalize() 메소드를 명시적으로 수행하도록
해주는 runFinalization() 메소드가 있다. 명시적으로 호출한다면 시스템은 하려던 일을 멈추고 이 작업을 실행한다.
- 하지만 이 두 개의 메소드는 우리가 처리하지 않아도 JVM에서 알아서 필요한 때에 하기 때문에, 절대, 호출하지 말 것.

### JVM 종료
| 리턴 타입       | 메소드 이름 및 매개 변수   | 설명                |
|-------------|------------------|-------------------|
| static void | exit(int status) | 현재 수행중인 JVM을 멈춘다. |

- 절대 호출하면 안 되는 메소드.
- 안드로이드, 웹 애플리케이션 등에서 이 메소드를 사용하면 해당 애플리케이션 JVM이 죽어버리고, 바로 장애로 직결된다. 따라서 절대 사용하면 안 된다.
- 매개 변수는 0일 경우 정상적인 종료, 그 외에는 비정상적인 종료를 의미

### 현재 시간 종료
| 리턴 타입       | 메소드 이름 및 매개 변수      | 설명                |
|-------------|---------------------|-------------------|
| static long | currentTimeMillis() | 현재 시간을 밀리초 단위로 리턴 |
| static long | nanoTime()          | 현재 시간을 나노초 단위로 리턴 |

- currentTimeMillis()는 현재 시간을 나타낼 때 매우 유용. UTC (Universal time)기준 1970년 1월 1일 00:00 부터 
지금까지의 밀리초 단위의 차이를 출력. 밀리초는 1 / 1,000초 이다.
- nanoTime() 메소드는 시간의 차이를 측정하기 위한 용도의 메소드. 시간은 나노초이며, 1 / 1,000,000,000 초이다.

```java
public void numberMinMaxElapsedCheck() {
        JavaLangNumber numberSample = new JavaLangNumber();
        long startTime = System.currentTimeMillis();
        long startNanoTime = System.nanoTime();
        numberSample.numberMinMaxCheck();
        System.out.println("Milli second=" + (System.currentTimeMillis() - startTime));
        System.out.println("Nano second=" + (System.nanoTime() - startNanoTime));
}
```
```text
Milli second=0
Nano second=21521916
```
- 밀리초는 0으로 출력되지만, 나노초는 매우 큰 숫자로 출력된다. 
- 시간을 측정할 필요가 있을 때, 나노초를 사용하는 것이 권장된다. nanoTime() 메소드가 시간 측정을 위해 만들어진 메소드이다. 
- System.currentTimeMillis() 메소드는 현재 시간을 확인하기 위한 메소드라고 생각하면 된다.

## System.out을 살펴보자
- System 클래스에 선언되어 있는 out, err 변수는 PrintStream 이라는 동일한 클래스 객체이다. 단지 정상 / 비정상 출력 결과를 나누기 위한 차이이다.
PrintStream 클래스는 static 하게 사용하므로 생성자 대신 메소드를 알아보자. 출력을 위한 주요 메소드 이름은 다음과 같다.
  - print()
  - println()
  - format()
  - printf()
  - write()
- write()는 System.out 으로 사용할 떄 많이 사용되지 않고, 가장 많이 사용되는 것이 print(), println() 이다.
- print()와 println() 의 차이는 두 가지이다. 
  - print() 메소드는 매개 변수 내용 출력하고 줄바꿈 X. println() 메소드는 매개 변수 내용 출력 및 줄바꿈 처리.
  - println() 메소드는 매개 변수가 없는 메소드 존재 - 줄바꿈만 처리하고 싶을 때에 사용
- 두 메소드 모두 기본 자료형, 참조 자료형 매개 변수 사용 가능
- 두 메소드는 다음과 같은 공통 매개 변수를 가짐 (println()은 매개 변수가 없는 메소드 포함)
  - boolean b, char c, char[] s, double d, float f, int i, long l, Object obj, String s
- byte, short는 찾아볼 수 없는데, 모두 정수형이기 때문에 전혀 문제 없이 출력된다.
  - int 타입을 매개 변수로 받는 메소드에서 알아서 처리해주기 때문.

```java
package _20.lang;

public class JavaLangSystemPrint {
        public static void main(String[] args) {
                JavaLangSystemPrint sample = new JavaLangSystemPrint();
                sample.printStreamCheck();
        }

        public void printStreamCheck() {
                byte b = 127;
                short s = 32767;
                System.out.println(b);
                System.out.println(s);
                printInt(b);
                printInt(s);
        }

        public void printInt(int value) {
                System.out.println(value);
        }
}
```
```text
127
32767
127
32767
```
- 127 과 32767이 아무런 문제없이 출력된다. 
- null 출력에 대해 짚고 넘어가야 할 점이 있다.
```java
public void printNull() {
        Object obj = null;
        System.out.println(obj);
        System.out.println(obj + " is object's value");
}
```
```text
null
null is object's value
```
- obj 객체가 null이다. 객체를 출력할 때, toString() 메소드를 단순히 호출한다고 생각하면 null 인 obj에 toString()을 호출하는 셈인데,
아무런 할당이 되어 있지 않은 경우 메소드를 호출할 수 없다.
- 그런데, 정상적으로 출력되었다. print() 메소드와 println() 메소드는 단순히 toString() 메소드 결과를 출력하는 것이 아닌, String의
valueOf() 라는 static 메소드를 호출하여 결과를 받은 후 출력한다. 즉, String.valueOf(obj)가 출력된 것이다. toString() 으로 바꾸어 보자.

```java
public void printNullToString() {
        Object obj = null;
        System.out.println(obj.toString());
}
```
```text
Exception in thread "main" java.lang.NullPointerException
        at _20.lang.JavaLangSystemPrint.printNullToString(JavaLangSystemPrint.java:32)
        at _20.lang.JavaLangSystemPrint.main(JavaLangSystemPrint.java:8)\
```
- 위와 같은 예외가 발생해버린다.
- obj가 null이고, null에 toString() 메소드를 불러 예외가 발생한 것이다. 따라서, 객체를 출력할 때에는 toString()보다 valueOf() 메소드를
사용하는 것이 훨씬 안전하다.
- 첫 번째 출력문 주석 처리 후, 두 번째 출력문은 예외를 발생시키지 않는다. null 과 문자열을 합쳤는데 예외가 발생하지 않는 이유는 컴파일러에서 이 더하기
문장을 StringBuilder로 변환하기 때문이다. `obj + " is object's value"` 문장을 
`new StringBuilder().append(obj).append(" is object's value") 과 같이 바꾸게 되는 것이다. append() 메소드에 null을 넣은 것과
동일하므로 문제 없이 null을 출력한 것이다.


- format()과 printf()는 JDK 5 부터 추가되었다. 두 메소드는 이름만 다르고 처리하는 것은 동일하다.

