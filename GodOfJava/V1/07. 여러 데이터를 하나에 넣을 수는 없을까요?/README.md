# 여러 데이터를 하나에 넣을 수는 없을까요?
## 하나에 많은 것을 담을 수 있는 배열이라는 게 있다는데...
- 기본 자료형에는 하나의 값만 넣을 수 있다. int, long 등 값을 하나만 지정할 수 있다.
- 배열을 사용하여 한 변수에 여러 개의 값을 넣을 수 있다. 가장 일반적인 자료 구조 중 하나이다.
- 다음과 같이 변수를 선언할 수 있다.
```java
int[] lottoNumbers;
int lottoNumbers[];
```
- 이렇게 선언한 배열은 아직 몇 개의 데이터가 들어가는 지 알 수 없어 다음과 같은 초기화 과정이 필요하다.
```java
int[] lottoNumbers = new int[7];
```
- `new`를 써 준 후 타입 이름을 명시, 대괄호 안에 해당 배열의 크기를 지정해준다.
- 참조 자료형의 객체를 생성할 때에는 반드시 `new`를 붙여야 한다. 배열도 참조 자료형이므로 신규로 생성 시, `new`를 붙혀야 한다.
- 다음과 같이 선언해도 무방하다.
```java
int[] lottoNumbers;
lottoNumbers = new int[7];
```
- 배열에 값은 다음과 같이 지정한다.
```java
lottoNumbers[1] = 15;
```
- 배열의 시작은 0 부터 시작되기 때문에 lottoNumbers 2번째 자리에 15를 할당한 것이다.
- 배열의 크기가 7일 경우 배열 위치는 0~6이다.
- 코드로 알아보자
```java
public class ArrayLotto {
        public static void main(String[] args) {
                ArrayLotto array = new ArrayLotto();
                array.init();
        }

        public void init() {
                int[] lotto = new int[7];
                lotto[0] = 5;
                lotto[1] = 12;
                lotto[2] = 23;
                lotto[3] = 25;
                lotto[4] = 38;
                lotto[5] = 41;
                lotto[6] = 2;
                lotto[7] = 0;
        }
}
```
```text
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 7 out of bounds for length 7
        at ArrayLotto.init(ArrayLotto.java:16)
        at ArrayLotto.main(ArrayLotto.java:4)
```
- 컴파일은 잘 되지만 ArrayIndexOutOfBoundsException 예외가 발생한다.
  - 배열(Array)의 위치(index)를 벗어난(OutOfBounds) 예외(Exception)
- lottoNumbers 배열은 7개의 공간을 갖고, 0~6까지의 위치(index)를 가지기 떄문에 `lotto[7]`로 접근은 불가능하다.
- `lotto[7]`를 주석처리하면 잘 동작한다.

## 배열의 기본값
- 기본 자료형 배열의 기본값은 각 자료형의 기본값과 동일하다.
- 지역 변수의 경우 초기화를 하지 않으면 사용이 불가능하지만 배열은 배열의 크기만 정해주면 문제가 발생하지 않는다.
```java
public class ArrayInitValue {
        public static void main(String[] args) {
                ArrayInitValue array = new ArrayInitValue();
                array.primitiveTypes();
        }

        public void primitiveTypes() {
                byte[] byteArray = new byte[1];
                short[] shortArray = new short[1];
                int[] intArray = new int[1];
                long[] longArray = new long[1];
                float[] floatArray = new float[1];
                double[] doubleArray = new double[1];
                char[] charArray = new char[1];
                boolean[] booleanArray = new boolean[1];

                System.out.println("byteArray[0]=" + byteArray[0]);
                System.out.println("shortArray[0]=" + shortArray[0]);
                System.out.println("intArray[0]=" + intArray[0]);
                System.out.println("longArray[0]=" + longArray[0]);
                System.out.println("floatArray[0]=" + floatArray[0]);
                System.out.println("doubleArray[0]=" + doubleArray[0]);
                System.out.println("charArray[0]=[" + charArray[0] + "]");
                System.out.println("booleanArray[0]=" + booleanArray[0]);
        }
}
```
```text
byteArray[0]=0
shortArray[0]=0
intArray[0]=0
longArray[0]=0
floatArray[0]=0.0
doubleArray[0]=0.0
charArray[0]=[]
booleanArray[0]=false
```
- char 배야열의 기본값은 `₩u0000` 이며 공백이다.
- char 제외하고는 0 또는 0.0, boolean은 false 임을 알 수 있다.
- String 이나 클래스같은 참조 자료형은 어떻게 될까?
```text
public class ArrayInitValue {
        public static void main(String[] args) {
                ArrayInitValue array = new ArrayInitValue();
                //array.primitiveTypes();
                array.referenceTypes();
        }

        public void primitiveTypes() {
            // ... 
        }

        public void referenceTypes() {
                String[] strings = new String[2];
                ArrayInitValue[] array = new ArrayInitValue[2];
                System.out.println("strings[0]=" + strings[0]);
                System.out.println("array[0]=" + array[0]);
        }
}

```
```text
strings[0]=null
array[0]=null
```
- 모든 참조 자료형은 초기화 (new를 사용해 생성자를 부르는 작업)을 하지 않으면 모두 "null"이 된다.
- null 을 출력하지 않도록 다음과 같이 초기화 한다.
```java
public void referenceTypesSetValue() {
        String[] strings = new String[2];
        ArrayInitValue[] array = new ArrayInitValue[2];
        strings[0] = "GodOfJava";
        array[0] = new ArrayInitValue();

        System.out.println("strings[0]=" + strings[0]);
        System.out.println("strings[1]=" + strings[1]);
        System.out.println("array[0]=" + array[0]);
        System.out.println("array[1]=" + array[1]);
}
```
```text
strings[0]=GodOfJava
strings[1]=null
array[0]=ArrayInitValue@251a69d7
array10]=null
```
- 초기화한 값은 초기화한 결과, 하지 않은 값들은 null 출력
- 여기서 ArrayInitValue의 뒤에 @...는 무엇일까?
  - 참조 자료형은 public String toString() 메소드를 만들어주어야만 다음과 같이 나타나지 않는다.
  - 만들어주지 않을 경우 타입이름@고유번호 순으로 내용이 출력된다.

## 배열을 그냥 출력해보면 어떻게 나올까?
```java
public class ArrayPrint {
        public static void main(String[] args) {
                ArrayPrint array = new ArrayPrint();
                array.printString();
        }

        public void printString() {
                System.out.println("strings=" + new String[0]);
                System.out.println("array=" + new ArrayPrint[0]);
        }
}
```
```text
strings=[Ljava.lang.String;@251a69d7
array=[LArrayPrint;@6b95977
```
- `[L` : 가장 앞의 "["는 해당 객체가 배열이라는 의미, "L"은 해당 배열은 참조 자료형이라는 뜻이다.
- `java.lang.String` : 해당 배열이 어떤 타입의 배열인지를 보여준다.
- `@251a69d7` : 해당 배열의 고유번호이다.


- 기본 자료형 배열의 기본값을 출력하는 코드는 다음과 같다.
```java
public class ArrayPrint {
        public static void main(String[] args) {
                ArrayPrint array = new ArrayPrint();
                // array.printString();
                array.printPrimitiveArray();
        }

        public void printString() {
                // ...
        }

        public void printPrimitiveArray() {
                System.out.println("byteArray=" + new byte[1]);
                System.out.println("shortArray=" + new short[1]);
                System.out.println("intArray=" + new int[1]);
                System.out.println("longArray=" + new long[1]);
                System.out.println("floatArray=" + new float[1]);
                System.out.println("doubleArray=" + new double[1]);
                System.out.println("charArray=" + new char[1]);
                System.out.println("booleanArray=" + new boolean[1]);
        }
}
```
```text
byteArray=[B@7e9e5f8a
shortArray=[S@8bcc55f
intArray=[I@58644d46
longArray=[J@14dad5dc
floatArray=[F@18b4aac2
doubleArray=[D@764c12b6
charArray=[C@c387f44
booleanArray=[Z@4e0e2f2a
```
- `[` 다음에 있는 알파벳이 모두 다르다.
  - `[B`는 byte, `[S`는 short, `[I`는 int, `[f`는 float, `[D`는 double, `[C`는 char
  - `[J`는 long, `[Z`는 boolean

## 배열을 선언하는 또 다른 방법
- `new int[1]`와 같이 `new`를 사용하지 않고, 중괄호를 사용하여 한번에 배열을 선언할 수 있다.
```java
public class ArrayInitialize {
        public static void main(String[] args) {
                ArrayInitialize array = new ArrayInitialize();
                array.otherInit();
        }

        public void otherInit() {
                int[] lottoNumbers = {5, 12, 23, 25, 38, 41, 2};
                int[] lottoNumbers2 = {5, 12,
                        23, 25, 38, 41, 
                        2};
                /* compile error
                int[] lottoNumbers2;
                lottoNumbers2 = {5, 12, 23, 25, 38, 41, 2};
                */
        }
}
```
- 콤마 사이에 줄 바꿈을 하여도 상관 없다.
- 보통 '달'과 같이 절대 변경되지 않는 값을 지정할 때 중괄호로 선언한다.
```java
public class ArrayInitialize {
        public static void main(String[] args) {
                ArrayInitialize array = new ArrayInitialize();
                // array.otherInit();
                System.out.println(array.getMonth(3));
        }

        public void otherInit() {
                // ... 
        }

        public String getMonth(int monthInt) {
                String[] month = {"January", "Feburary", "March", "April", "May", "June", "July",
                                        "August", "September", "October", "November", "December"};
                return month[monthInt - 1];
        }
}
```
```text
March
```
- 그런데 보통 "달"과 같이 변하지 않는 값은 메소드 내 보다는 클래스 변수로 선언하는 것이 좋다.
```java
public class ArrayInitialize {
        String[] month = {"January", "Feburary", "March", "April", "May", "June", "July",
                                        "August", "September", "October", "November", "December"};
}
```
- 한 메소드 내에서만 사용할 때에는 밖으로 굳이 뺴낼 필요는 없다. 클래스 객체를 생성할 때마다 배열이 생성되어 낭비가 될 수 있기 떄문이다.
- 이러한 단점을 해결하기 위해 자바에는 `static` 예약어가 존재한다.
```java
public class ArrayInitialize {
        static String[] month = {"January", "Feburary", "March", "April", "May", "June", "July",
                                        "August", "September", "October", "November", "December"};
}
```
- static 을 이용하면 ArrayInitialize 클래스 객체를 생성할 때 마다 month 배열을 새로 생성하지 않는다.
- 이를 "클래스 변수"라고 한다.
- 하지만 이를 남용하면 심각한 문제를 야기시킬 수 있기 때문에 조심히 사용해야 한다.

## 별로 사용하지는 않지만, 알고 있어야 하는 2차원 배열
```java
public class ArrayTwoDimension {
        public static void main(String[] args) {
                ArrayTwoDimension array = new ArrayTwoDimension();
                array.twoDimensionArray();
        }

        public void twoDimensionArray() {
                int[][] twoDim;
                twoDim = new int[2][3];
        }
}
```
- 2차원 배열은 배열의 배열을 의미한다.
- 위의 예제에서 twoDim[0]은 int가 아닌 int 배열이다. 즉, twoDim[0][0]의 값이 int 값이다.
- twoDim은 2개의 층, twoDim[0]은 3개의 공간을 가지고 있어, 2 x 3 = 6개의 공간을 가지게 된다.
- 다음과 같이 1차원의 크기만 지정하고, 2차원의 크기를 지정하지 않고, 선언할 수도 있다. (반대는 불가능)
```java
twoDim = new int[2][];
```
- 이렇게 한다고 해서 정해주지 않아도 되는 것은 절대 아니고, 다음과 같이 서로 다르게 지정해 줄 수 있다.
```java
twoDim[0] = new int[3];
twoDim[1] = new int[2];
```
- 또한 1차원 배열처럼 중괄호로 바로 선언할 수도 있다.
```java
int[][] twoDim = {{1,2,3}, {4,5,6}};
```
- 위는 다음 코드와 같다.
```java
int[][] twoDim = new int[2][3];

twoDim[0][0] = 1;
twoDim[0][1] = 2;
twoDim[0][2] = 3;

twoDim[1][0] = 4;
twoDim[1][1] = 5;
twoDim[1][2] = 6;
```
- 배열 선언된 값을 출력하기 위해서는 for루프를 사용하면 간편하다. 그 전에 배열 길이를 어떻게 알 수 있을까?

## 배열의 길이는 어떻게 알 수 있을까요?
- 자바에서 배열의 길이를 알기 위해선 배열 이름에 `.length`를 붙여준다.
```java
public class ArrayLength {
        public static void main(String[] args) {
                ArrayLength array = new ArrayLength();
                array.printArrayLength();
        }

        public void printArrayLength() {
                int[] oneDim = new int[3];
                int[][] twoDim = new int[4][2];
                System.out.println(oneDim.length);
                System.out.println(twoDim.length);
                System.out.println(twoDim[0].length);
        }
}
```
```text
3
4
2
```
- 1차원 배열은 당연히 3으로 나오지만, 2차원 배열은 `twoDim.length`를 할 경우 1차원의 크기를 알려주고, 2차원의 크기는
`twoDim[0].length`와 같이 각 1차원 배열의 크기를 알려달라고 하면 된다.
- `twoDim[0][0].length`의 경우 배열 객체가 아닌 int 값이기 때문에 모든 기본 자료형에는 .length를 사용할 수 없다.
- 다음으로 for 루프를 사용하여 배열을 출력해보자.
```java
public class ArrayLength {
        public static void main(String[] args) {
                ArrayLength array = new ArrayLength();
                // array.printArrayLength();
                array.printArray();
        }

        public void printArrayLength() {
                //....
        }

        public void printArray() {
                int[][] twoDim = {{1,2,3}, {4,5,6}};
                System.out.println("twoDim.length = " + twoDim.length);
                System.out.println("twoDim[0].length = " + twoDim[0].length);
                
                for (int oneLoop = 0; oneLoop < 2; oneLoop++) {
                        for (int twoLoop = 0; twoLoop < 3; twoLoop++) {
                                System.out.println("twoDim[" + oneLoop + "][" + twoLoop + "]=" + twoDim[oneLoop][twoLoop]);
                        }
                }
        }
}
```
```text
twoDim.length = 2
twoDim[0].length = 3
twoDim[0][0]=1
twoDim[0][1]=2
twoDim[0][2]=3
twoDim[1][0]=4
twoDim[1][1]=5
twoDim[1][2]=6
```
- if, for, while, switch 문에 해당 구문을 선언하고 중괄호로 묶어준 모든 문장은 그 안에 다른 구문이 들어가도 괜찮다.
- 단, 다음과 같은 경우는 불가능하다.
```java
int[] oneDim = {if (a == 1) 1 else 0};
```
- 위 코드에서 for 루프의 조건 확인 부분에서 `oneLoop < 2`, `twoLoop < 3`과 같이 배열의 크기를 직접 지정하는 것은 좋지 않다.
메소드를 별도로 떼어낸다면 유연하지 못한 코드가 된다. 해당 부분에 `.length`로 바꾸면 다음과 같다.
```java
int twoDimLength = twoDim.length;
for (int oneLoop = 0; oneLoop < twoDimLength; oneLoop++) {
        int twoDimOneLength = twoDim[oneLoop].length;
        for (int twoLoop = 0; twoLoop < 3; twoLoop++) {
                System.out.println("twoDim[" + oneLoop + "][" + twoLoop + "]=" + twoDim[oneLoop][twoLoop]);
        }
}
```
- 결과는 같다.

## 배열을 위한 for 루프
- 배열 뿐 아니라 자바에서 제공되는 Collection 이라는 자료 구조를 처리할 때, for 루프를 보다 쉽게 사용할 JDK 5부터 추가된 문법은 다음과 같다.
```java
for (타입이름 임시변수명 : 반복 대상 객체) {

}
```
- 예제 코드는 다음과 같다.
```java
public class ArrayNewFor {
        public static void main(String[] args) {
                ArrayNewFor array = new ArrayNewFor();
                array.newFor();
        }

        public void newFor() {
                int[] oneDim = new int[] {
                        1, 2, 3, 4, 5, 6, 7, 8, 9, 10
                };
                for (int data : oneDim) {
                        System.out.println(data);
                }
        }
}
```
```text
1
2
3
4
5
6
7
8
9
10
```
- for 소괄호 내에 int data 뒤에 :, 배열이름 oneDim 이 들어간다.
- oneDim 배열의 각 데이터를 int data 변수에 담아 두고 각 data를 출력한 것을 볼 수 있다.
- 이 data 변수에 oneDim 배열의 0번째 부터 마지막까지 순서대로 for 루프를 돌면서 할당된다.
- 2차원 배열 또한 다음과 같이 사용할 수 있다.
```java
public void twoDimFor() {
        int[][] twoDim = {
                {1,2,3},
                {4,5,6}
        };
        for (int[] dimArray : twoDim) {
                for (int data : dimArray) {
                        System.out.println(data);
                }
        }
}
```
```text
1
2
3
4
5
6
```
- 첫 번째 for 루프에서 twoDim이라는 배열의 1차원 값은 배열이므로 int[] dimArray로 지정.
- 그 안에 for 루프에서는 dimArray 배열의 1차원 값이 int 타입이므로 int data로 지정.
- 하지만 이런 for 루프에서도 각 위치를 모른다는 단점이 있어 위치 확인을 위해서는 따로 임시 변수를 두어야 한다.
```java
public void twoDimForWithCounter() {
        int[][] twoDim = {
                {1,2,3},
                {4,5,6}
        };
        int oneCounter = 0;
        for (int[] dimArray : twoDim) {
                int twoCounter = 0;
                for (int data : dimArray) {
                        System.out.println(data);
                        twoCounter++;
                }
                oneCounter++;
        }
}
```
- 값 처리만 필요하면 다음과 같은 향상된 for문, 배열의 index도 필요하다면 일반적인 for문을 사용하면 된다.

## 자바 실행할 때 원하는 값들을 넘겨주자
```java
public class ArrayMain {
        public static void main(String[] args) {

        }
}
```
- main() 메서드의 매개변수에도 args 라는 String 배열이 존재한다. 이 값은 어떻게 전달할까?
- 먼저 출력문을 추가하면 다음과 같다.
```text
public class ArrayMain {
        public static void main(String[] args) {
                if (args.length > 0) {
                        for (String arg : args) {
                                System.out.println(arg);
                        }
                }
        }
}
```
```shell
$ javac ArrayMain.java
$ java ArrayMain
$ java ArrayMain a b c d
a
b
c
d
```
- 위와 같이 클래스 이름 뒤에 공백으로 분리한 문자열을 나열하면 이 문자열들이 args 라는 배열에 전달된다.

## 정리
- 배열은 무조건 선언할 때 크기가 지정되어야만 하고, 중간에 크기를 바꿀 수 없다.
- 이러한 단점을 보완하기 위해 자바에서는 Collection이 존재한다.
