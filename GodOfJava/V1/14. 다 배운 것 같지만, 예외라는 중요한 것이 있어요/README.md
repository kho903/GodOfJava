# 다 배운 것 같지만, 예외라는 중요한 것이 있어요
## 자바에서 매우 중요한 예외
- 자바에는 예외(Exception)이라는 것이 있다. 자바에서 예외는 "우리가 예상한, 혹은 예상치도 못한 일이 발생하는 것을 미리 예견하고 안전장치를 하는 것"이다.
- 자바에서는 예상을 했든, 예상을 하지 않았든, 예외적인 일이 발생하게 되면 "예외"라는 것을 던져버린다.
- 일반적인 예로, null인 객체에 메소드를 호출한다든지, 5개 공간의 배열에 6번째 값을 읽으려고 한다든지, 어떤 파일을 읽으려는데 파일이 존재하지 않는 등의 경우

## try-catch는 짝이다
```java
package _14.exception;

public class ExceptionSample {
        public static void main(String[] args) {
                ExceptionSample sample = new ExceptionSample();
                sample.arrayOutOfBounds();
        }

        public void arrayOutOfBounds() {
                int[] intArray = new int[5];
                System.out.println(intArray[5]);
        }
}
```
- 5개의 공간을 가지는 배열에 6번째 값을 출력하면 어떻게 될까?
- 컴파일은 잘 되지만 실행해보면
```text
$ java _14.exception.ExceptionSample
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
        at _14.exception.ExceptionSample.arrayOutOfBounds(ExceptionSample.java:11)
        at _14.exception.ExceptionSample.main(ExceptionSample.java:6)
```
- ArrayIndexOutOfBoundsException : 배열 범위 밖에 있는 위치를 요청한 예외 이다.
- 첫 줄에는 어떤 예외가 발생했는지, 다음 줄부터는 앞에 탭을 주고 at 으로 시작하는 스택 호출 추적 (call stack trace, 스택트레이스)가 출력됨
- 위 예제를 보면
```text
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
```
- 첫째줄에 예외가 발생한 클래스와 메소드 이름(main)과 줄 번호(5) 출력
```text
        at _14.exception.ExceptionSample.arrayOutOfBounds(ExceptionSample.java:11)
```
- 그 아래에는 메소드를 호출한 클래스 (_14.exception.ExceptionSample)와 메소드 이름(arrayOutOfBounds) 및 줄 번호(11) 출력
- 호출관계가 복잡한 실제 시스템에서는 몇 십 ~ 몇 백 줄이 출력되기도 한다.
- 예외를 처리하기 위한 메소드를 살펴보자.
```java
public void arrayOutOfBoundsTryCatch() {
        try {
                int[] intArray = new int[5];
                System.out.println(intArray[5]);
        } catch (Exception e) {

        }
}
```
- 위 예제 처럼 모두 try로 묶지 않고, 예외가 발생하는 부분만 묶어줘도 된다.
```java
public void arrayOutOfBoundsTryCatch() {
        int[] intArray = new int[5];
        try {
                System.out.println(intArray[5]);
        } catch (Exception e) {

        }
}
```
- 이렇게 컴파일 후 실행해도 아무것도 출력되지 않는다. 
- 정상적으로 실행이 되는 것으로 보이지만 실제로 예외는 발생한 것이다. 추가 출력문을 넣어주자.
```java
public void arrayOutOfBoundsTryCatch() {
        int[] intArray = new int[5];
        try {
                System.out.println(intArray[5]);
                System.out.println("This code should run.");
        } catch (Exception e) {

        }
}
```
- 추가 출력문을 추가하고 컴파일 후 실행해도 아무것도 출력되지 않는다.
- try-catch 의 try 블록 안에서 예외가 발생되면 그 이하의 문장은 실행되지 않고, 바로 catch 블록으로 넘어간다.
```java
public void arrayOutOfBoundsTryCatch() {
        int[] intArray = new int[5];
        try {
                System.out.println(intArray[5]);
                System.out.println("This code should run.");
        } catch (Exception e) {
                System.err.println("Exception occurred.");
        }
        System.out.println("This code must be run.");
}
```
```text
Exception occurred.
This code must be run.
```
- `System.err.println()`은 일반적인 콘솔 화면에서는 구별되지 않지만, IDE에서는 출력 결과가 다르게 표시되어 오류출력에 사용하는 것이 좋다.
- try-catch를 사용할 때 try 블록 내에서 예외가 발생하면, 예외가 발생한 줄 이후에 있는 try 블록은 실행되지 않고 바로 catch 블록으로 넘어가
catch 블록 내의 문장이 실행되고 try-catch 밖의 문장을 실행한다.

### try-catch 정리
- try-catch에서 예외가 발생하지 않을 경우
  - try 내에 있는 모든 문장이 실행되고 try-catch 문장 이후의 내용이 실행된다.
- try-catch에서 예외가 발생하는 경우
  - try 내에서 예외가 발생한 이후의 문장들은 실행되지 않는다.
  - catch 내에 있는 문장은 반드시 실행되고, try-catch 문장 이후의 내용이 실행된다.

## try-catch를 사용하면서 처음에 적응하기 힘든 변수 선언
- try-catch 문을 처음 사용할 때, 변수 지정이 실수하기 쉽다.
```java
package _14.exception;

public class ExceptionVariable {
        public static void main(String[] args) {
                ExceptionVariable sample = new ExceptionVariable();
                sample.checkVariable();
        }

        public void checkVariable() {
                int[] intArray = new int[5];
                try {
                        System.out.println(intArray[5]);
                } catch(Exception e) {
                        System.out.println(intArray.length);
                }
                System.out.println("This code must run.");
        }
}
```
```text
5
This code must run.
```
- 정상적으로 예외가 발생해서 intArray의 길이를 출력하고 try-catch문 이후 출력문이 실행되었다. 
- 다음으로 다음과 같은 메소드를 만들어보자.
```java
public void checkVariable2() {
        try {
                int[] intArray = new int[5];
                System.out.println(intArray[5]);
        } catch(Exception e) {
                System.out.println(intArray.length);
        }
        System.out.println("This code must run.");
}
```
- 컴파일을 해보면
```text
_14/exception/ExceptionVariable.java:25: error: cannot find symbol
                        System.out.println(intArray.length);
                                           ^
  symbol:   variable intArray
  location: class ExceptionVariable
1 error
```
- intArray가 try 블록 안에서 선언되었기 때문에 catch 에서는 intArray가 누군지 모른다. 
- 그래서 "cannot find symbol"과 intArray가 누구냐는 메시지가 출력된다.
- 이런 문제를 해결하기 위해서 일반적으로 catch 문장에서 사용할 변수 초기화를 try 전에 해놓는다.
```java
public void checkVariable3() {
        int[] intArray = null;
        try {
                intArray = new int[5];
                System.out.println(intArray[5]);
        } catch(Exception e) {
                System.out.println(intArray.length);
        }
        System.out.println("This code must run.");
}
```
```text
5
This code must run.
```
- try 전에 변수를 미리 선언해 놓으면 정상적으로 실행된다.
- try 앞에서 null이라고 했지만, try 안에서 `new int[5]`로 초기화를 해 주었다. 예외는 그 다음줄인,
`intArray[5]`를 출력하는 줄에서 발생되므로 해당 초기화 부분은 정상적으로 동작한다.

## finally야 ~ 넌 무슨 일이 생겨도 반드시 실행되야 돼
- try-catch 구문에 추가로 finally 블록이 붙을 수 있는데, 자바에서 finally는 "어떠한 경우에도 넌 반드시 실행해"라는 의미이다.
```java
package _14.exception;

public class FinallySample {
        public static void main(String[] args) {
                FinallySample sample = new FinallySample();
                sample.finallySample();
        }

        public void finallySample() {
                int[] intArray = new int[5];
                try {
                        System.out.println(intArray[5]);
                } catch (Exception e) {
                        System.out.println(intArray.length);
                } finally {
                        System.out.println("Here is finally");
                }
                System.out.println("This code must run.");
        }
}
```
```text
5
Here is finally
This code must run.
```
- 예외가 발생한 후 catch 블록이 실행되고, finally 블록이 실행된 후 try-catch 이후의 문장이 실행되었다.
- 예외가 발생하지 않도록 바꾸어 보자.
```java
System.out.println(intArray[4]);
```
```text
0
Here is finally
This code must run.
```
- finally는 예외 발생 여부와 관계없이 실행된다.
- finally 블록은 코드의 중복을 피하기 위해서 반드시 필요하다.

## 두 개 이상의 catch
- try-catch 문을 쓸 때 catch에 `Exception e`를 아무 생각 없이 썼다. 예외의 종류를 명시하는 곳이므로, 다른 예외를 작성할 수 있다.
```java
package _14.exception;

public class MultiCatchSample {
        public static void main(String[] args) {
                MultiCatchSample sample = new MultiCatchSample();
                sample.multiCatch();
        }

        public void multiCatch() {
                int[] intArray = new int[5];
                try {
                        System.out.println(intArray[5]);
                } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("ArrayIndexOutOfBoundsException occurred");
                } catch (Exception e) {
                        System.out.println(intArray.length);
                }
        }
}
```
```text
ArrayIndexOutOfBoundsException occurred
```
- 앞에 있는 catch 에 있는 것만 처리되는구나라고 생각할 수도 있다. 맞는 말인데 틀린 말이기도 하다.
- catch 블록은 순서를 따진다. 위에서 두 개의 순서를 바꿔본다.
```java
public void multiCatch() {
        int[] intArray = new int[5];
        try {
                System.out.println(intArray[5]);
        } catch (Exception e) {
                System.out.println(intArray.length);
        } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException occurred");
        }
}
```
```text
_14/exception/MultiCatchSample.java:15: error: exception ArrayIndexOutOfBoundsException has already been caught
                } catch (ArrayIndexOutOfBoundsException e) {
                  ^
1 error
```
- 컴파일 에러가 발생한다. `already been caught`
- 여기서 알아야 할 것은 먼저, 모든 객체의 부모 클래스는 java.lang.Object 이다. 모든 예외의 부모 클래스는 java.lang.Exception 클래스다.
- 예외는 부모 예외 클래스가 이미 catch를 하고, 자식 클래스가 그 아래에서 catch를 하게 되면 자식 클래스가 예외를 처리할 기회가 없다.
- ArrayIndexOutOfBoundsException은 Exception 클래스의 자식 클래스이기 때문에 절대로 Exception 클래스로 처리한 catch 블록 이후
처리될 일이 없다. 그래서 필요없는 것을 만들지 말라고, 컴파일러가 에러를 던진 것이다.
- 그렇다면 다중 catch를 왜 하는 지 알아보자.
```java
public void multiCatchThree() {
        int[] intArray = new int[5];
        try {
                System.out.println(intArray[5]);
        } catch (NullPointerException e) {
                System.out.println("NullPointerException occurred");
        } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException occurred");  
        } catch (Exception e) {
                System.out.println(intArray);
        }
}
```
```text
ArrayIndexOutOfBoundsException occurred
```
- `NullPointerException`을 추가했다. 여기서 `NullPointerException`은 발생하지 않는다. 그렇다면 해당 catch를 건너 뛰고, 그 다음에 있는
catch 문장을 살펴보도록 되어 있어서 두 번째 예외가 처리되었다. NullPointerException이 발생하도록 코드를 고쳐보자.
```java
public void multiCatchThreeWithNull() {
        int[] intArray = new int[5];
        try {
                intArray = null;
                System.out.println(intArray[5]);
        } catch (NullPointerException e) {
                System.out.println("NullPointerException occurred");
        } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException occurred");  
        } catch (Exception e) {
                System.out.println("Exception occurred");
        }
}
```
```text
NullPointerException occurred
```
- intArray의 5번째 값을 찾는 작업을 하기 전에 해당 객체가 null인지를 먼저 확인해야 한다. 따라서, 두 번째에 있는
ArrayIndexOutOfBoundsException 예외가 발생하기 전에, NullPointerException이 발생하는 것이다.
- 예외가 발생해 버리면 나머지 try 블록에 있는 내용이 무시되므로 다른 예외가 발생하지 않는다.
- 그리고, catch 문을 사용할 때에는 위와 같이 제일 아래에 Exception 클래스로 catch 해 주는 것을 권장한다.
예상치 못한 예외가 발생하면 제대로 처리되지 않기 때문에 밖으로 빠져나가지 못하게 꽁꽁 묶는 역할을 한다.
- 위 코드에서 NullPointerException을 주석 처리 해주면 결과는 다음과 같이 나온다.
```java
public void multiCatchThreeWithNull() {
        int[] intArray = new int[5];
        try {
                intArray = null;
                System.out.println(intArray[5]);
        //} catch (NullPointerException e) {
        //      System.out.println("NullPointerException occurred");
        } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException occurred");  
        } catch (Exception e) {
                System.out.println("Exception occurred");
        }
}
```
```text
Exception occurred
```
- 실제로 NullPointerException이 발생했지만, Exception 클래스가 가장 마지막에 버티고 있어서 예외가 걸러졌다.
- Exception catch 블록이 없다면 예외 로그가 발생한다.
```java
public void multiCatchThreeWithNull() {
        int[] intArray = new int[5];
        try {
                intArray = null;
                System.out.println(intArray[5]);
        //} catch (NullPointerException e) {
        //      System.out.println("NullPointerException occurred");
        } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ArrayIndexOutOfBoundsException occurred");  
        }
}
```
```text
Exception in thread "main" java.lang.NullPointerException: Cannot load from int array because "<local1>" is null
        at _14.exception.MultiCatchSample.multiCatchThreeWithNull(MultiCatchSample.java:39)
        at _14.exception.MultiCatchSample.main(MultiCatchSample.java:8)
```
- 정리하면 다음과 같다.
  - try 다음에 오는 catch 블록은 1개 이상 올 수 있다.
  - 먼저 선언한 catch 블록의 예외 클래스가 다음에 선언한 catch 블록의 부모에 속하면, 자식에 속하는 catch 블록은
  절대 실행될 일이 없으므로 컴파일 되지 않는다.
  - 하나의 try 블록에서 예외가 발생하면 그 예외와 관련된 catch 블록을 찾아서 실행한다.
  - catch 블록 중 발생한 예외와 관련이 있는 블록이 업승면, 예외가 발생되면서 해당 쓰레드는 끝난다.

## 예외의 종류는 세 가지다
- 자바에는 세 종류의 예외가 존재하며 각 예외는 다음과 같다.
  - checked exception
  - error
  - runtime exception 또는 unchecked exception
- error와 unchecked exception을 제외하고 모든 예외는 checked exception 이다.

### error
- 에러는 자바 프로그램 밖에서 발생한 예외
- 서버 디스크 고장, 메인보드 고장나 자바 프로그램이 동작하지 못하는 경우가 이에 해당
- Exception 클래스는 에러가 아니다. 자바 프로그램에 오류가 발생했을 때, 오류의 이름이 Error로 끝나면 에러, Exception으로 끝나면 예외
- Error와 Exception의 가장 큰 차이는 프로그램 안/밖 중 어디에서 발생했는지 여부이다. 더 큰 차이는 프로그램이 멈추는지 여부이다.
더 정확하게는 Error는 프로세스에 Exception은 쓰레드에만 영향을 준다.

### runtime exception (런타임 예외)
- 런타임 예외는 예외가 발생할 것을 미리 감지하지 못했을 때 발생
- 이에 해당하는 모든 예외들은 RuntimeException을 확장한 예외들
- 이 예외를 묶어두지 않아도 컴파일 에러는 발생하지 않지만 실행 시에 발생 가능성 있어, 런타임 예외라고 부른다. 그리고 컴파일시에 체크를 하지 않기 때문에
unchecked exception 이라고 부른다.
- 예외들의 상관관계를 생각해보면 Exception을 확장한 클래스들이 Checked 예외이며, RuntimeException 및에 확장되어 있는 클래스들이 런타임 예외들이다.

```text
지금까지 jdk 17 로 진행하였고, 에러 메시지등이 상이한 것으로 보여 여기서부터 jdk 11로 변경하여 실습 진행.
(이전과 조금 달라질 수 있음)
```
## 모든 예외의 할아버지는 java.lang.Throwable 클래스다.
- Exception과 Error의 공통 부모 클래스는 Object 외에 java.lang 패키지에 있는 Throwable 클래스이다.
- 상속 관계가 이런 이유는 예외와 에러 성격은 다르지만 동일한 이름의 메소드를 사용하여 처리할 수 있게 하기 위함이다.
- Throwable의 생성자는 다음과 같다.
  - Throwable()
  - Throwable(String message)
  - Throwable(String message, Throwable cause)
  - Throwable(Throwable cause)
- message는 예외 메시지, cause는 예외의 원인을 말한다.
- Throwable에 선언되어 있고, Exception 클래스에서 Overriding한 메소드는 10개가 넘는데, 주요 메소드는 다음과 같다.
  - getMessage()
  - toString()
  - printStackTrace()

### getMessage()
- 예외 메시지를 String으로 반환. 어떤 예외가 발생하였는 지 볼 수 있따.
- 메시지를 활용하여 별도의 예외 메시지를 사용자에게 보여주기 좋음

### toString()
- getMessage() 보다 더 자세하게 예외 클래스 이름도 같이 제공

### printStackTrace()
- 첫줄에 예외 메시지 출력, 이후 예외가 발생하게 된 메소드들의 호출 관계 (스택 트레이스) 출력

```java
package _14.exception;

public class ThrowableSample {
        public static void main(String[] args) {
                ThrowableSample sample = new ThrowableSample();
                sample.throwable();
        }

        public void throwable() {
                int[] intArray = new int[5];
                try {
                        intArray = null;
                        System.out.println(intArray[5]);
                } catch(Throwable t) {
                        System.out.println(t.getMessage());
                        System.out.println(t.toString());
                        t.printStackTrace();
                }
        }
}
```
```text
null
java.lang.NullPointerException
java.lang.NullPointerException
        at _14.exception.ThrowableSample.throwable(ThrowableSample.java:13)
        at _14.exception.ThrowableSample.main(ThrowableSample.java:6)
```
- 위에서 알아본 것처럼 getMessage()는 간단한 예외 메시지, toString()은 getMessage()보다 어떤 예외가 발생했는지 자세하게 확인할 수 있고,
printStackTrace()는 toString()보다 제세한 메시지와 메시지 호출 정보가 출력되는 것을 볼 수 있다.
- printStackTrace()의 경우 개발할 때만 사용하는 것을 권장. 너무 많은 양의 로그가 쌓일 수 있기 떄문

## 난 예외를 던질 거니까 throws 라고 써 놓을게
- 자바에는 예외를 발생시키는 방법이 있다. 정확히는 예외를 던질 수 있다.
```java
package _14.exception;

public class ThrowSample {

        public static void main(String[] args) {
                ThrowSample sample = new ThrowSample();
                sample.throwException(13);
        }

        public void throwException(int number) {
                try {
                        if (number > 12) {
                                throw new Exception("Number is over than 12");
                        }
                        System.out.println("Number is " + number);
                } catch(Exception e) {
                        e.printStackTrace();
                }
        }
}
```
```text
java.lang.Exception: Number is over than 12
        at _14.exception.ThrowSample.throwException(ThrowSample.java:13)
        at _14.exception.ThrowSample.main(ThrowSample.java:7)
```
- try 블록 내에서 throw 라고 명시한 후 예외 클래스의 객체를 생성하면 된다. 그러면 다른 예외와 동일하게 throw 문장 이후 try 블록은 수행되지 않고,
catch 블록으로 이동한다.
- 앞에서 알아봤던 대로 try-catch 문으로 e.printStackTrace()를 호출하였기 때문에 예외 스택 정보가 출력되었다.
- 만약 해당하는 예외가 없다면 발생된 예외는 메소드 밖으로 던져버린다. 즉, 예외가 발생한 메소드를 호출한 메소드로 던진다는 말이다. 이럴 때
사용하는 것이 throws이다.
```java
public class ThrowSample {

        public static void main(String[] args) {
                ThrowSample sample = new ThrowSample();
                //sample.throwException(13);
                sample.throwsException(13);
        }

        public void throwException(int number) {
                // ...
        }

        public void throwsException(int number) throws Exception {
                if (number > 12) {
                        throw new Exception("Number is Over than 12");
                }
                System.out.println("Number is " + number);
        }
}
```
```text
_14/exception/ThrowSample.java:8: error: unreported exception Exception; must be caught or declared to be thrown
                sample.throwsException(13);
                                      ^
1 error
```
- try-catch로 묶지 않아도 예외를 throws한다고 할지라도, throws가 선언되어 있기 때문에 컴파일 및 실행이 가능하다.
- 하지만 말 그래도, 예외를 던졌기 때문에, throwsException()을 호출한 부분에서 try-catch 블록으로 감싸주어야만 하는데, 감싸주지 않아
컴파일 에러가 발생하였다.
- 두 가지 방법으로 해결하는 방법이 있다.
- 하나는 try-catch로 묶는 것이다.
```java
public static void main(String[] args) {
        ThrowSample sample = new ThrowSample();
        try {
                sample.throwsException(13);
        } catch (Exception e) {

        }
}
```
- 다른 한가지 방법은 호출한 메소드에서도 다시 throws 해버리면 된다.
```java
public static void main(String[] args) throws Exception {
        ThrowSample sample = new ThrowSample();
        sample.throwsException(13);
}
```
```text
Exception in thread "main" java.lang.Exception: Number is Over than 12
        at _14.exception.ThrowSample.throwsException(ThrowSample.java:24)
        at _14.exception.ThrowSample.main(ThrowSample.java:8)
```
- 다음과 같이 예외 메시지가 나타난다.

### throws 와 throw 정리
- 메소드를 선언할 때 매개 변수 소괄호 뒤에 throws 예약어를 적어준 뒤 예외를 선언하면, 해당 메소드에서 선언한 예외가 발생했으 때, 호출한 메소드로 예외가
전달된다. `,`를 사용해 여러 개의 예외 throws 가능
- try 블록 내에서 예외를 발생시킬 경우에는 throw 예약어를 적어주고, 예외 객체를 생성하거나 생성된 예외 명시. throw한 예외 클래스가
catch 블록에 선언되어 있지 않거나, throws에 선언되어 있지 않으면 컴파일 에러 발생
- catch 블록에서 예외를 throws 할 경우에도 메소드 선언의 throws 구문에 해당 예외가 정의되어 있어야만 한다.
- 예외를 throw 하는 이유는 해당 메소드에서 예외를 처리하지 못하는 상황이거나, 미처 처리하지 못한 예외가 있을 경우를 대비하기 위함

## 내가 예외를 만들 수도 있다구?
- Throwable을 직접 상속 받는 클래스는 Exception과 Error가 있었다. Error는 개발자가 손대면 안되고, Exception을 처리하는 예외 클래스는
임의로 만들 수 있다.
```java
package _14.exception;

public class MyException extends Exception {
        public MyException() {
                super();
        }

        public MyException(String message) {
                super(message);
        }
}
```
```java
package _14.exception;

public class CustomException {

        public static void main(String[] args) {
                CustomException sample = new CustomException();
                try {
                        sample.throwMyException(13);
                } catch (MyException mye) {
                        mye.printStackTrace();
                }
        }

        public void throwMyException(int number) throws MyException {
                try {
                        if (number > 12) {
                                throw new MyException("Number is over than 12");
                        }
                } catch (MyException e) {
                        e.printStackTrace();
                }
        }
}
```
```text
_14.exception.MyException: Number is over than 12
        at _14.exception.CustomException.throwMyException(CustomException.java:17)
        at _14.exception.CustomException.main(CustomException.java:8)
```
- 직접 java.lang.Exception 클래스의 상속을 받아 직접 만든 예외를 던지고 catch 블록에서 사용하면 된다. 정상적으로 작동한다.
- MyException은 위와 같이 예외 클래스가 되려면 Throwable 자식 클래스가 되어야 하는데, 클래스를 확장하지 않으면 다음과 같은 컴파일 오류가 발생한다.
```text
package _14.exception;

public class MyException /*extends Exception*/ {
        public MyException() {
                super();
        }

        public MyException(String message) {
                //super(message);
        }
}
```
```text
_14/exception/CustomException.java:9: error: incompatible types: MyException cannot be converted to Throwable
                } catch (MyException mye) {
                         ^
_14/exception/CustomException.java:10: error: cannot find symbol
                        mye.printStackTrace();
                           ^
  symbol:   method printStackTrace()
  location: variable mye of type MyException
_14/exception/CustomException.java:14: error: incompatible types: MyException cannot be converted to Throwable
        public void throwMyException(int number) throws MyException {
                                                        ^
_14/exception/CustomException.java:17: error: incompatible types: MyException cannot be converted to Throwable
                                throw new MyException("Number is over than 12");
                                ^
_14/exception/CustomException.java:19: error: incompatible types: MyException cannot be converted to Throwable
                } catch (MyException e) {
                         ^
_14/exception/CustomException.java:20: error: cannot find symbol
                        e.printStackTrace();
                         ^
  symbol:   method printStackTrace()
  location: variable e of type MyException
6 errors
```
- 따라서 예외 클래스를 만들 때에는 Throwable의 직계 자손인 클래스들을 상속받아 만들어야만 한다.

## 자바 예외 처리 전략
자바에 예외를 처리할 때에는 표준을 잡고 진행해야 한다. 예외 처리 전략은 다음과 같다.
```text
- 임의의 예외 클래스를 만들 때에는, 반드시 try-catch로 묶어줄 필요가 있을 경우에만 Exception 클래스를 확장한다.
일반적으로 실행시 예외를 처리할 수 있는 경우에는 RuntimeException 클래스를 확장하는 것을 권장한다.
- catch문 내에 아무런 작업 없이 공백을 놔두면 예외 분석이 어려워지므로 꼭 로그 처리와 같은 예외 처리를 해줘야만 한다.
```
- 아주 일반적인 예외 처리 전략으로 수많은 예외 처리 전략이 존재한다.
