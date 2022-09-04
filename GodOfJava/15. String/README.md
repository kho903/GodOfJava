# String
## 자바에서 가장 많이 사용하는 String
- String 관련 객체는 실제 시스템에서 상위 5개 안에는 항상 포함된다. String 클래스를 그만큼 많이 사용하고, 그만큼 String 클래스에 대해 잘 알고 있어야
하는 중요한 클래스이다.
- String 클래스는 다음과 같이 선언되어 있다.
```text
public final class String extends Object
    implements Serializable, Comparable<String>, CharSequence
```
- public final 로 선언되었다. final이므로, 더 이상 이 클래스는 확장될 수 없다. 그리고 모든 클래스의 부모인 Object 클래스만을 부모로 가지고 있어,
따로 확장한 클래스는 없다.
- 그리고, Serializable, Comparable<String>, CharSequence 를 구현헀다.
  - Serializable 인터페이스는 구현해야 하는 메소드가 하나도 없는 특이한 인터페이스로, 구현한다고 선언해 놓으면, 해당 객체를 파일로 저장하거나 다른
    서버에 전송 가능한 상태가 된다.
  - Comparable 인터페이스는 compareTo()라는 메소드 하나만 선언되어 있는데, 매개 변수로 넘어가는 객체와 현재 객체가 같은지를 비교. 현재 객체가
  같으면 0, 앞에 있으면 양수, 뒤에 있으면 음수를 리턴한다.
  - CharSequence 인터페이스는 해당 클래스가 문자열을 다루기 위한 클래스라는 것을 명시적으로 나타내는 데 사용됨.

## String의 생성자에는 이런 것들이 있다.
- 대부분 문자열을 만들 때에는 대부분 이렇게 간단히 만든다.
```java
String name = "Sangmin, Lee";
```
- 하지만 String의 생성자는 매우 많다. 
- 생성자에서 쓰이는 용어를 보면 
  - 캐릭터 셋은 문자의 집합. 한글, 일본어와 같이 특정 나라의 글자.
  - 디코딩은 암호화되어 있거나 컴퓨터가 이해할 수 있는 값들을 알아보기 쉽게 변환하는 것을 말한다.

| 생성자                                                              | 설명                                                             |
|------------------------------------------------------------------|----------------------------------------------------------------|
| String()                                                         | 비어있는 String 객체 생성. 의미 X. 비효율 -> String name = null; 이 더 효율적    |
| String(byte[] bytes)                                             | 현재 사용중인 플랫폼의 캐릭터 셋을 사용하여 제공된 byte 배열을 디코딩한 String 객체를 생성       |
| String(byte[] bytes, Charset charset)                            | 지정된 캐릭터 셋을 사용하여 제공된 byte 배열을 디코딩한 String 객체 생성                 |
| String(byte[] bytes, String charsetName)                         | 지정된 이름의 캐릭터 셋을 사용하여 지정한 byte 배열을 디코딩한 String 객체 생성             |
| String(byte[] bytes, int offset, int length)                     | 현재 사용중인 플랫폼의 기본 캐릭터 셋을 사용하여 지정한 byte 배열의 일부를 디코딩한 String 객체 생성 |
| String(byte[] bytes, int offset, int length, Charset charset)    | 지정된 캐릭터 셋을 사용하여 byte 배열의 일부를 디코딩한 String 객체 생성                 |
| String(byte[] bytes, int offset, int length, String charsetName) | 지정된 이름의 캐릭터 셋을 사용하여 byte 배열의 일부를 디코딩한 String 객체 생성             |
| String(char[] value)                                             | char 배열의 내용들을 붙여 String 객체를 생성                                 |
| String(char[] value, int offset, int count)                      | char 배열의 일부 내용들을 붙여 String 객체를 생성                              |
| String(int[] codePoints, int offset, int count)                  | 유니코드 코드 위치 (Unicode code point)로 구성되어 있는 배열의 일부를 새로운 객체로 생성    |
| String(String original)                                          | 매개 변수로 넘어온 String 과 동일한 값을 갖는 String 객체 생성. 다시 말해 복제본 생성       |
| String(StringBuffer buffer)                                      | 매개 변수로 넘어온 StringBuffer 클래스에 정의되어 있는 문자열의 값과 동일한 String 객체 생성  |
| String(StringBuilder builder)                                    | 매개 변수로 넘어온 StringBuilder 클래스에 정의되어 있는 문자열의 값과 동일한 String 객체 생성 |

- 여기서 많이 사용하는 생성자는 다음 두 가지이다.
  - String(byte[] bytes)
  - String(byte[] bytes, String charsetName)

## String 문자열을 byte로 변환하기
- 생성자의 매개 변수로 받는 byte 배열은 String 클래스에 현재의 문자열 값을 byte 배열로 변환하는 getBytes() 메소드로 생성한다.

| 리턴 타입  | 메소드 이름 및 매개 변수               | 설명                          |
|--------|------------------------------|-----------------------------|
| byte[] | getBytes()                   | 기본 캐릭터 셋의 바이트 배열을 생성        |
| byte[] | getBytes(Charset charset)    | 지정한 캐릭터 셋 객체 타입으로 바이트 배열 생성 |
| byte[] | getBytes(String charsetName) | 지정한 이름의 캐릭터 셋을 갖는 바이트 배열 생성 |

- 캐릭터 셋을 알고 있거나, 같은 시스템 내에서 문자열을 byte 배열로 만들 때에는 getBytes()를 사용하면 되고, 다른 시스템에서 전달 받은
문자열을 byte 배열로 변환할 때는 다른 캐릭터 셋으로 되어 있을 수 있기 때문에 2, 3번째 메소드를 사용하는 것이 좋다.
- java.nio.Charset 클래스 API 에 정의되어 있는 표준 캐릭터 셋은 다음과 같다.
    - US-ASCII : 7비트 아스키
    - ISO-8859-1 : ISO 라틴 알파벳
    - UTF-8 : 8비트 UCS 변환 포맷
    - UTF-16BE : 16비트 UCS 변환 포맷. big-endian 바이트 순서를 가진다.
    - UTF-16LE : 16비트 UCS 변환 포맷. little-endian 바이트 순서를 가진다.
    - UTF-16 : 16비트 UCS 변환 포맷. 바이트 순서는 byte-order mark 라는 것에 의해서 정해진다.
    - EUC-KR : 8비트 문자 인코딩으로, EUC의 일종이며 대표적인 "한글 완성형" 인코딩
    - MS949 : Microsoft 에서 만든 "한글 확장 완성형" 인코딩
- 한글 처리를 위해 자바에서 사용하는 인코딩은 UTF-16이다. 이전에는 EUC-KR, EUC-KR을 많이 사용했지만 요즘은 대부분 UTF-16을 많이 사용한다.

```java
package _15.string;

public class StringSample {
        public static void main(String[] args) {
                StringSample sample = new StringSample();
                sample.convert();
        }

        public void convert() {
                try {
                        String korean = "한글";

                        byte[] array1 = korean.getBytes();
                        for (byte data : array1) {
                                System.out.print(data + " ");
                        }
                        System.out.println();
                        String korean2 = new String(array1);
                        System.out.println(korean2);
                } catch(Exception e) {
                        e.printStackTrace();
                }
        }
}
```
- 시스템의 기본 캐릭터 셋이 EUC-KR일 경우 다음과 같이 출력된다.
```text
-57 -47 -79 -37
한글
```
- 시스템의 기본 캐릭터 셋이 UTF-8일 경우 다음과 같이 출력된다.
```text
-19 -107 -100 -22 -72 -128 
한글
```
- "UTF-16"으로 캐릭터 셋을 변경할 경우 다음과 같이 출력된다.
```java
public void convertUTF16() {
        try {
                String korean = "한글";

                byte[] array1 = korean.getBytes("UTF-16");
                for (byte data : array1) {
                        System.out.print(data + " ");
                }
                System.out.println();
                String korean2 = new String(array1);
                System.out.println(korean2);
        } catch(Exception e) {
                e.printStackTrace();
        }
}
```
```text
-2 -1 -43 92 -82 0 
���\�
```
- 문자열 결과가 이상하게 출력된다. 잘못된 캐릭터 셋으로 변환을 하면 알아볼 수 없는 문자로 표시된다.
- 이렇게 글자가 깨지는 현상을 방지하기 위해서 byte 배열로 생성할 때 사용한 캐릭터 셋을 문자열로 다시 전환할 때에도 동일하게 사용해야만 한다.
```java
public void convertUTF16() {
        try {
                String korean = "한글";

                byte[] array1 = korean.getBytes("UTF-16");
                for (byte data : array1) {
                        System.out.print(data + " ");
                }
                System.out.println();
                String korean2 = new String(array1, "UTF-16");
                System.out.println(korean2);
        } catch(Exception e) {
                e.printStackTrace();
        }
}
```
```text
-2 -1 -43 92 -82 0 
한글
```
- 여기서 알 수 있는 점은 한글은 어떤 캐릭터 셋을 썼느냐에 따라 byte 배열로 만들 떄 배열의 크기가 다르다.
- 한글 두글자를 표현하는데에 EUC-KR은 4바이트, UTF-16은 6바이트를 사용한다. 
- korean 값을 변경해 보면 글자 수와 상관없이 EUC-KR과 UTF-16은 무조건 2바이트씩 차이가 날 것이다. 실습으로 확인해보자.

```java
public void convertExample() {
        try {
                String korean = "자바의신";
                byte[] euckrArr = korean.getBytes("EUC-KR");
                byte[] utf16Arr = korean.getBytes("UTF-16");
                String koreanEuckr = new String(euckrArr, "EUC-KR");
                String koreanUtf16 = new String(utf16Arr, "UTF-16");
                printByteArray(euckrArr);
                System.out.println("EUC-KR : " + koreanEuckr);
                printByteArray(utf16Arr);
                System.out.println("UTF-16 : " + koreanUtf16);
        } catch(Exception e) {
                e.printStackTrace();
        }
}
```
```text
-64 -38 -71 -39 -64 -57 -67 -59 
EUC-KR : 자바의신
-2 -1 -57 -112 -68 20 -57 88 -62 -32 
UTF-16 : 자바의신
```
- 위 코드에서 convert() 메소드에 try-catch 블록으로 감쌌다. 그 이유는 캐릭터 셋을 지정하는 메소드 및 생성자들 때문이다.
  - byte 배열과 String 타입의 캐릭터 셋을 받는 생성자
  - getBytes() 메소드 중에서 String 타입의 캐릭터 셋을 받는 메소드
- 위의 생성자와 메소드에서 존재하지 않는 캐릭터 셋의 이름을 지정할 경우 UnsupportedEncodingException이 발생할 수 있어 try-catch 로 감싸주거나 
throws 구문을 추가해 주어야 한다.

## 객체의 널 체크는 반드시 필요하답니다.
- String 뿐만 아니라 모든 객체를 처리할 때에는 널 체크를 반드시 해야 한다. null로 표기하며, 어떤 참조 자료형도 null이 될 수 있다.
객체가 null이라는 것은 아무런 초기화가 되어 있지 않으며, 클래스에 선언되어 있는 메소드를 사용할 수 없는 상태를 말한다. 어떤 객체가
null이면 아무런 일을 못한다.

```java
package _15.string;

public class StringNull {
        public static void main(String[] args) {
                StringNull sample = new StringNull();
                sample.nullCheck(null);
        }

        public boolean nullCheck(String text) {
                int textLength = text.length();
                System.out.println(textLength);
                if (text == null) return true;
                else return false;
        }
}
```
```text
Exception in thread "main" java.lang.NullPointerException
        at _15.string.StringNull.nullCheck(StringNull.java:10)
        at _15.string.StringNull.main(StringNull.java:6)
```
- null 인 객체의 메소드에 접근하면 NullPointerException이 발생한다.
```java
public boolean nullCheck2(String text) {
        if (text == null) {
                return true;
        } else {
                int textLength = text.length();
                System.out.println(textLength);
                return false;
        }
}
```
- 이 메소드가 수행되도록 컴파일 및 실행흘 하면 true가 리턴된다.
- 아무리 강조해도 지나치지 않는 것이 바로 null체크 이므로, 메소드의 매개 변수로 넘어오는 객체가 널이 될 확률이 조금이라도 있다면 반드시 한 번씩
확인하는 습관을 갖고 있어야만 한다.

## String의 내용을 비교하고 검색하는 메소드들도 있어요
- String 클래스는 문자열을 나타낸다. 문자열 내에 특정 위치를 찾거나 값을 비교하는 등의 작업은 아주 빈번히 발생되는데 이에 따른 메소드들이 존재한다.
- String 클래스 객체에는 내용을 비교하고 검색하는 메소드가 있는데, 세밀하게 분류하면 다음과 같다.
  - 문자열의 길이를 확인하는 메소드
  - 문자열이 비어 있는지 확인하는 메소드
  - 문자열이 같은지 비교하는 메소드
  - 특정 조건에 맞는 문자열이 있는지를 확인하는 메소드
- 먼저 StringCompare 클래스를 만들어 놓고 각 메소드를 확인해본다.
```java
package _15.string;

public class StringCompare {
        public static void main(String[] args) {
                StringCompare sample = new StringCompare();
        }
}
```
### 문자열의 길이를 확인하는 메소드
| 리턴 타입 | 메소드 이름 및 매개 변수 | 설명             |
|-------|----------------|----------------|
| int   | length()       | 문자열의 길이를 리턴한다. |
```java
public void checkString() {
        String text = "You must know String class.";
        String korean = "한글";
        System.out.println("text.length() = " + text.length());
        System.out.println("korean.length() = " + korean.length());
}
```
```text
text.length() = 27
korean.length() = 2
```
- 공백이 포함된 길이를 출력한다. 한글 역시 정상적으로 글자수대로 출력된다.

### 문자열이 비어 있는지 확인하는 메소드
| 리턴 타입   | 메소드 이름 및 매개 변수 | 설명                                |
|---------|----------------|-----------------------------------|
| boolean | isEmpty()      | 문자열이 비어 있는지를 확인한다. 비어 있으면 true 리턴 |

- 문자열의 길이가 0인지 아닌지를 확인하는 것보다, 이 메소드를 사용하는 것이 간단하다. checkString() 메소드의 아랫줄에 다음 줄을 추가하자.
```java
System.out.println("text.isEmpty() = " + text.isEmpty());
```
```text
text.length() = 27
text.isEmpty() = false
```
- text는 27 개의 char로 구성되어 있으므로 isEmpty()는 false가 된다.
- text가 공백 하나로 이루어져 있는 문자열이라도, false를 리턴한다. 

### 문자열이 같은지 비교하는 메소드
| 리턴 타입   | 메소드 이름 및 매개 변수                      |
|---------|-------------------------------------|
| boolean | equals(Object anObject)             |
| boolean | equalsIgnoreCase(String anotherStr) |
| int     | compareTo(String anotherStr)        |
| int     | compareToIgnoreCase(String str)     |
| boolean | contentEquals(CharSequence cs)      |
| boolean | contentEquals(StringBuffer sb)      |

- equals, compareTo, contentEquals로 시작하는 세가지 메소드로 분류 가능
- 매개 변수와 String 객체가 같은 지를 비교하는 메소드로 IgnoreCase가 붙으면 대소문자를 구별하지 않는 메소드이다.

```java
public void checkCompare() {
        String text = "Check value";
        String text2 = "Check value";
        if (text == text2) {
                System.out.println("text==text2 result is same.");
        } else {
                System.out.println("text==text2 result is different");
        }
        if (text.equals(text2)) {
                System.out.println("text.equals(text2) result is same.");
        }
}
```
```text
text==text2 result is same.
text.equals(text2) result is same.
```
- 결과는 다음과 같이 나온다. String 클래스도 기본적으로 `==` 비교가 아닌 equals() 메소드를 사용하여 비교를 해야만 하는데 이렇게 결과가 나오는 이유는
자바에 Constant Pool이라는 것이 있고, String의 경우 동일한 값을 갖는 객체가 있으면, 이미 만든 객체를 재사용한다. 따라서 text==text2도 true.
- == 이 false가 나오려면 다음과 같이 변경하면 된다.
```java
public void checkCompare() {
        String text = "Check value";
        //String text2 = "Check value";
        String text2 = new String("Check value");
        if (text == text2) {
                System.out.println("text==text2 result is same.");
        } else {
                System.out.println("text==text2 result is different");
        }
        if (text.equals(text2)) {
                System.out.println("text.equals(text2) result is same.");
        }
}
```
```text
text==text2 result is different
text.equals(text2) result is same.
```
- 다음으로 equalsIgnoreCase()를 추가해본다.
```java
String text3 = "check value";
if (text.equalsIgnoreCase(text3)) {
        System.out.println("text.equalIgnoreCase(text3) result is same.");
}
```
```text
text==text2 result is different
text.equals(text2) result is same.
text.equalIgnoreCase(text3) result is same.
```
- 예상대로 대소문자 구별을 하지 않고 같으지 다른지 확인한 결과를 볼 수 있다.
- 다음으로 compareTo() 메소드를 살펴보는데, 이 메소드는 Comparable 인터페이스에 선언되어 있다.

```text
public void checkCompareTo() {
        String text = "a";
        String text2 = "b";
        String text3 = "c";
        System.out.println(text2.compareTo(text));
        System.out.println(text2.compareTo(text3));
        System.out.println(text.compareTo(text3));
}
```
```text
1
-1
-2
```
- compareTo() 메소드는 보통 정렬을 할 때 사용된다. 매개 변수로 넘겨준 String 객체가 알파벳 순으로 앞에 있으면 양수, 뒤에 있으면 음수를 리턴하고, 
그 순서 차이만큼 숫자값을 리턴한다.
- "b"가 "a"보다 1만큼 뒤에 있으므로 양수 1을 리턴, "b"와 "c", "a"와 "c"는 음수를 리턴한 것을 볼 수 있다.
- 이 메소드 역시 compareToIgnoreCase() 메소드로, 대소문자 구분 없이 비교 가능하다.
- String 클래스의 문자열을 비교하는 메소드 중 contentEquals() 메소드는 매개 변수로 넘어오는 CharSequence, StringBuffer 객체가 
String 과 같은 지 비교하는 데에 사용된다.

### 특정 조건에 맞는 문자열이 있는지를 확인하는 메소드
| 리턴 타입   | 메소드 이름 및 매개 변수                                                                     |
|---------|------------------------------------------------------------------------------------|
| boolean | startsWith(String prefix)                                                          |
| boolean | startsWith(String prefix, int offset)                                              |
| boolean | endsWith(String suffix)                                                            |
| boolean | contains(CharSequence s)                                                           |
| boolean | matches(String regex)                                                              |
| boolean | regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) |
| boolean | regionMatches(int toffset, String other, int ooffset, int len)                     |

- 가장 많이 사용되는 것이 startsWith()로 매개 변수로 넘겨준 값으로 시작하는 지 확인하는 메소드이다. indexOf()라는 메소드로 확인가능하지만,
indexOf()는 문자열의 모든 내용을 다 확인해봐야 한다는 단점이 있다.

```java
package _15.string;

public class StringCheck {
        public static void main(String[] args) {
                StringCheck sample = new StringCheck();
                String[] addresses = new String[] {
                        "서울시 구로구 신도림동",
                        "경기도 성남시 분당구 정자동 개발 공장",
                        "서울시 구로구 개봉동",
                };
                sample.checkAddress(addresses);
        }

        public void checkAddress(String[] addresses) {
                int startCount = 0, endCount = 0;
                String startText = "서울시";
                String endText = "동";
                for (String address : addresses) {
                        if (address.startsWith(startText)) {
                                startCount++;
                        }
                        if (address.endsWith(endText)) {
                                endCount++;
                        }
                }
                System.out.println("Starts with " + startText + " count is " + startCount);
                System.out.println("Ends with " + endText + " count is " + endCount);
        }
}
```
```text  
Starts with 서울시 count is 2
Ends with 동 count is 2
```
- "서울시"로 시작하는 문자열 2개, "동"으로 끝나느 문자열 2개로 다음과 같은 결과가 출력된다. 
- 그렇다면 중간에 있는 값은 어떻게 확인할까? -> contains() 메소드
```text
public void containsAddress(String[] addresses) {
        int containCount = 0;
        String containText = "구로";
        for (String address : addresses) {
                if (address.contains(containText)) {
                        containCount++;
                }
        }
        System.out.println("Contains " + containText + " count is " + containCount);
}
```
```text
Contains 구로 count is 2
```
- 다음으로는 regionMatches() 메소드이다. 
- regionMatches()는 문자열 중에서 특정 영역이 매개 변수로 넘어온 문자열과 동일한지를 확인하는 데 사용된다. 

| 리턴 타입   | 메소드 이름 및 매개 변수                                                                     |
|---------|------------------------------------------------------------------------------------|
| boolean | regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) |
| boolean | regionMatches(int toffset, String other, int ooffset, int len)                     |

- 하나는 대소문자를 구분할지 여부를 정할 수 있다. 매개 변수 하나하나 알아보자.

| 매개 변수      | 의미                              |
|------------|---------------------------------|
| ignoreCase | true 일 경우 대소문자를 구분 하지 않고, 값을 비교 |
| toffset    | 비교 대상 문자열의 확인 시작 위치를 지정         |
| other      | 존재하는지를 확인할 문자열을 의미              |
| ooffset    | other 객체의 확인 시작 위치를 지정          |
| len        | 비교할 char의 개수를 지정                |

```text
public void checkMatch() {
        String text = "This is a text";
        String compare1 = "is";
        String compare2 = "this";
        System.out.println(text.regionMatches(2, compare1, 0, 1)); // 매개 변수가 4개인 메소드
        System.out.println(text.regionMatches(5, compare1, 0, 2)); // 매개 변수가 4개인 메소드
        System.out.println(text.regionMatches(true, 0, compare2, 0, 4));
}
```
```text
true
true
true
```
- 먼저 text의 각 chard의 인덱스를 알아야 한다. 다음과 같다.

| T   | h   | i   | s   |     | i   | s   |     | a   |     | t   | e   | x   | t   |
|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|
| 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   | 10  | 11  | 12  | 13  |

- 먼저 첫번째 regionMatches() 문 `text.regionMatches(2, compare1, 0, 1)`에서 비교하려는 값은 "is"이다. 그런데, 세 번째 매개 변수가 0이고,
네 번째 매개 변수가 1이므로, 비교하려는 것은 "i"인지 아닌지만 확인하면 된다.
- 여기서 regionMatches() 잘못 사용하면 원하는 결과를 얻지 못할 수 있다.
- `regionMatches(boolean ignoreCase, int toffset, String other, int offset, int len)` 여러 매개 변수 중 값이 다음과 같은
경우에서 결과가 무조건 "false"로 나온다.
  - toffset 이 음수일때 
  - ooffset 이 음수일때
  - toffset + len이 비교 대상의 길이보다 클 때
  - ooffset + len이 other 객체의 길이보다 클 때
  - ignoreCase가 false인 경우에는 비교 범위의 문자들 중 같은 위치(index)에 있는 char가 다를 때
  - ignoreCase가 true인 경우에는 비교 범위의 문자들을 모두 소문자로 변경한 후 같은 위치(index)에 있는 char가 달라야 한다.

## String 내에서 위치를 찾아내는 방법은 여러 가지에요.
- 위치를 찾는 메소드는 다음과 같다. 리턴 타입은 모두 int 이다.
  - indexOf(int ch)
  - indexOf(int ch, int fromIndex)
  - indexOf(String str)
  - indexOf(String str, int fromIndex)
  - lastIndexOf(int ch)
  - lastIndexOf(int ch, int fromIndex)
  - lastIndexOf(String str)
  - lastIndexOf(String str, int fromIndex)

- 크게 두 분류로 indexOf()와 lastIndexOf() 두 가지로 나뉜다.
  - indexOf()는 앞에서부터 (가장 왼쪽 부터) 문자열이나 char를 찾는다.
  - lastIndexOf()는 뒤에서부터 (가장 오른쪽부터) 찾는다.
- int 매개변수는 char를 넘겨주면 자동으로 형 변환이 일어나기 때문에 걱정하지 않아도 된다.

```text
public void checkIndexOf() {
        String text = "Java technology is both a programming language and a platform.";
        System.out.println(text.indexOf('a'));
        System.out.println(text.indexOf("a "));
        System.out.println(text.indexOf('a', 20));
        System.out.println(text.indexOf("a ", 20));
        System.out.println(text.indexOf('z'));
}
```
```text
1
3
24
24
-1
```
- java의 "a" 중 첫 번째 "a"의 index는 1. 두 번째 출력문은 A 다음에 공백이 있는 index를 찾는 것이므로 3. 세 번째와 네 번째는 20번째부터 찾으므로,
제일 처음 나온 "a"는 관사 a의 위치가 24. z는 존재하지 않으므로 -1이다.
- lastIndexOf()는 다음과 같다.
```java
public void checkLastIndexOf() {
        String text = "Java technology is both a programming language and a platform.";
        System.out.println(text.lastIndexOf('a'));
        System.out.println(text.lastIndexOf("a "));
        System.out.println(text.lastIndexOf('a', 20));
        System.out.println(text.lastIndexOf("a ", 20));
        System.out.println(text.lastIndexOf('z'));
}
```
```text
55
51
3
3
-1
```
- "platform"의 "a"의 위치, 관사 "a"의 마지막 위치, "Java"의 뒤에 있는 "a" 위치 등을 출력하였고, "z"는 이 문장에 없으므로 -1 출력.
- lastIndexOf() 메소드의 검색 시작 위치 (fromIndex)는 가장 왼쪽에서부터의 위치를 말한다. 그 위치부터 왼쪽으로 값을 찾는다.

## String의 값의 일부를 추출하기 위한 메소드들은 얘네들이다.
특정 값을 추출하는 메소드의 종류는 다음과 같이 구분한다.
- char 단위의 값을 추출하는 메소드
- char 배열의 값을 String으로 변환하는 메소드
- String의 값을 char 배열로 변환하는 메소드
- 문자열의 일부 값을 잘라내는 메소드
- 문자열을 여러 개의 String 배열로 나누는 메소드

### char 단위의 값을 추출하는 메소드
| 리턴 타입 | 메소드 이름 및 매개 변수                                               | 설명                                                                                        |
|-------|--------------------------------------------------------------|-------------------------------------------------------------------------------------------|
| char  | charAt(int index)                                            | 특정 위치의 char 값을 리턴.                                                                        |
| void  | getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) | 매개 변수로 넘어온 dsf 라는 char 배열 내에 srcBegin에서 srcEnd에 있는 char을 저장. 이 때, dst 배열의 시작위치는 dstBegin. |
| int   | codePointAt(int index)                                       | 특정 위치의 유니코드 값을 리턴한다. 리턴 타입은 int 지만, 이 값을 char로 형 변환하면 char 값 출력가능.                        |
| int   | codePointBefore(int index)                                   | 특정 위치 앞에 있는 char 의 유니코드 값을 리턴. 리턴 타입은 int지만, char로 형 변환 가능                                |
| int   | codePointCount(int beginIndex, int endIndex)                 | 지정한 범위에 있는 유니코드 개수를 리턴.                                                                   |
| int   | offsetByCodePoints(int index, int codePointOffset)           | 지정된 index 부터 오프셋(offset)이 설정된 인덱스를 리턴.                                                    |

- offsetByCodePoints() 메소드는 문자열 인코딩과 관련된 문제를 해결하기 위하여 사용됨.
- 이외에 charAt()을 제외하고는 많이 사용되는 편이 아닌 메소드들이다.

### char 배열의 값을 String() 으로 변환하는 메소드
| 리턴 타입         | 메소드 이름 및 매개 변수                                  | 설명                                                            |
|---------------|-------------------------------------------------|---------------------------------------------------------------|
| static String | copyValueOf(char[] data)                        | char 배열에 있는 값을 문자열로 변환                                        |
| static String | copyValueOf(char[] data, int offset, int count) | char 배열에 있는 값을 문자열로 변환. 단 offset 위치부터 count 까지의 개수만큼만 문자열로 변환 |

- 자주 사용되지는 않지만 알고 있다면 좋은 메소드이다. static 메소드이기 때문에 static 하게 호출해야 한다.
```java
public void checkCopyValueOf() {
        char values[] = new char[] {'J', 'a', 'v', 'a'};
        String javaText = String.copyValueOf(values);
        System.out.println("value array");
        for (int i = 0; i < values.length; i++ ) {
                System.out.println("value[" + i + "] = " + values[i]);
        }
        System.out.println("use copyValueOf");
        System.out.println(javaText);
}
```
```text
value array
value[0] = J
value[1] = a
value[2] = v
value[3] = a
use copyValueOf
Java
```

### String의 값을 char 배열로 변환하는 메소드
| 리턴 타입  | 메소드 이름 및 매개 변수 | 설명                     |
|--------|----------------|------------------------|
| char[] | toCharArray()  | 문자열을 char 배열로 변환하는 메소드 |

- 우리가 String 객체를 만들더라도, 그 객체는 내부에 char 배열을 포함한다. String 을 char 배열로 변환하기 위한 메소드이다.
```text
public void checkToCharArray() {
        String javaStr = "Java";
        char[] values = javaStr.toCharArray();
        for (int i = 0; i < values.length; i++ ) {
                System.out.println("value[" + i + "] = " + values[i]);
        }
}
```
```text
value[0] = J
value[1] = a
value[2] = v
value[3] = a
```

### 문자열의 일부 값을 잘라내는 메소드
| 리턴 타입        | 메소드 이름 및 매개 변수                            | 설명                                                  |
|--------------|-------------------------------------------|-----------------------------------------------------|
| String       | substring(int beginIndex)                 | beginIndex부터 끝까지 대상 문자열을 잘라 String으로 리턴.            |
| String       | substring(int beginIndex, int endIndex)   | beginIndex부터 endIndex까지 대상 문자열을 잘라 String으로 리턴.     |
| CharSequence | subSequence(int beginIndex, int endIndex) | beginIndex부터 endIndex까지 대상 문자열을 잘라 CharSequence로 리턴 |

- "Java technology"라는 문자열이 있을 때, "technology"라는 단어를 추출하려고 하는 예제를 만들어보자.
```java
public void checkSubstring() {
        String text = "Java technology";
        String technology = text.substring(5);
        System.out.println(technology);
}
```
```text
technology
```
- `text.substring(5);`라고 지정하면 5번째부터 text 문자열이 끝날 때까지를 모두 잘라내라는 의미이다.
- "tech"랴는 단어만 잘라내고 싶으면 어떻게 해야 할까? 먼저 다음과 같이 해보자.
```java
public void checkSubstring() {
        String text = "Java technology";
        String technology = text.substring(5);
        System.out.println(technology);
        String tech = text.substring(5, 4);
        System.out.println(tech);
}
```
```text
technology
Exception in thread "main" java.lang.StringIndexOutOfBoundsException: begin 5, end 4, length 15
        at java.base/java.lang.String.checkBoundsBeginEnd(String.java:3319)
        at java.base/java.lang.String.substring(String.java:1874)
        at _15.string.StringCheck.checkSubstring(StringCheck.java:98)
        at _15.string.StringCheck.main(StringCheck.java:18)
```
- "tech"가 4개의 알파벳으로 되어 있는 문자여서 두 번째 매개변수 index를 4로 지정하면 다음과 같은 예외가 발생한다.
- 두 번째 매개 변수는 데이터의 길이가 아닌 substring이 끝나는 위치를 지정해 주어야 한다. 따라서 5 + 4 인 9를 지정해야 한다.<br>
`String tech = text.substring(5, 9);`
```text
technology
tech
```

### 문자열을 여러 개의 String 배열로 나누는 split 메소드
| 리턴 타입    | 메소드 이름 및 매개 변수                 | 설명                                                                              |
|----------|--------------------------------|---------------------------------------------------------------------------------|
| String[] | split(String regex)            | regex에 있는 정규 표현식에 맞추어 문자열을 잘라 String의 배열로 리턴                                    |
| String[] | split(String regex, int limit) | regex에 있는 정규 표현식에 맞추어 문자열을 잘라 String의 배열로 리턴. 이 때 String 배열의 크기는 limit 보다 커선 안됨 |

- 자바에서 문자열을 여러 개의 문자열의 배열로 나누는 방법은 String 클래스에 선언된 split()과 java.util.StringTokenizer라는 클래스 두 가지가 있다.
- 정규 표현식을 사용하려면 split() 메소드, 그냥 특정 String 으로 문자열을 나누려고 한다면 StringTokenizer 클래스를 쓰는 것이 편하다.
- 특정 알파벳, 기호 하나정도라면 무엇이든 상관 없다.
```java
public void checkSplit() {
        String text = "Java technology is both a programming language and a platform.";
        String[] splitArray = text.split(" ");
        for (String temp : splitArray) {
                System.out.println(temp);
        }
}
```
```text
Java
technology
is
both
a
programming
language
and
a
platform.
```

## String 값을 바꾸는 메소드들도 있어요.
String API 마지막으로 값을 바꾸는 메소드가 있다. 다음과 같이 구분한다.
- 문자열을 합치는 메소드와 공백을 없애는 메소드
- 내용을 교체(replace)하는 메소드
- 특정 형식에 맞춰 값을 치환하는 메소드
- 대소문자를 바꾸는 메소드
- 기본 자료형을 문자열로 변환하는 메소드

### 문자열을 합치는 메소드와 공백을 없애는 메소드
| 리턴 타입  | 메소드 이름 및 매개 변수     | 설명                                                |
|--------|--------------------|---------------------------------------------------|
| String | concat(String str) | 매개 변수로 받은 str을 기존 문자열의 우측에 붙인 새로운 문자열 객체를 생성하여 리턴 |
| String | trim()             | 문자열의 맨 앞과 맨 뒤에 있는 공백들을 제거한 문자열 객체 리턴              |

- concat()보다는 StringBuffer, StringBuilder가 권장됨
- trim()은 공백을 제거할 때 매우 유용하게 사용됨
```java
public void checkTrim() {
        String[] strings = new String[] {
                " a", " b ", "     c", "d     ", "e   f", "   "
        };
        for (String string : strings) {
                System.out.println("[" + string + "]");
                System.out.println("[" + string.trim() + "]");
        }
}
```
```text
[ a]
[a]
[ b ]
[b]
[     c]
[c]
[d     ]
[d]
[e   f]
[e   f]
[   ]
[]
```
- trim() 메소드의 용도는 매우 많지마, 작업하려는 문자열이 공백만으로 이루어진 값인지, 아니면 공백을 제외한 값이 있는지 확인하기에 매우 편하다.
```text
public void checkTrim2(String text) {
        if (text != null && text.trim().length() > 0) {
                System.out.println("text OK");
        } else {
                System.out.println("text NO");
        }
}
```
```text
text OK
text NO
```

### 내용을 교체 (replace)하는 메소드
| 리턴 타입  | 메소드 이름 및 매개 변수                                         | 설명                                                           |
|--------|--------------------------------------------------------|--------------------------------------------------------------|
| String | replace(char oldChar, char newChar)                    | 해당 문자열에 있는 oldChar의 값을 newChar로 대치                           |
| String | replace(CharSequence target, CharSequence replacement) | 해당 문자열에 있는 target과 같은 값을 replacement로 대치                     |
| String | replaceAll(String regex, String replacement)           | 해당 문자열의 내용 중 regex에 표현된 정규 표현식에 포함되는 모든 내용을 replacement로 대치  |
| String | replaceFirst(String regex, String replacement)         | 해당 문자열의 내용 중 regex에 표현된 정규 표현식에 포함되는 첫번째 내용을 replacement로 대치 |

- replace로 시작하는 메소드는 문자열에 있는 내용 중 일부를 변경하는 작업을 수행.
- 이 메소드를 수행해도 기존 문자열 값은 바뀌지 않음

```text
public void checkReplace() {
        String text = "The String class represents character strings.";
        System.out.println(text.replace('s', 'z'));
        System.out.println(text);
        System.out.println(text.replace("tring", "trike"));
        System.out.println(text.replaceAll(" ", "|"));
        System.out.println(text.replaceFirst(" ", "|"));
}
```
```text
The String clazz reprezentz character ztringz.
The String class represents character strings.
The Strike class represents character strikes.
The|String|class|represents|character|strings.
The|String class represents character strings.
```

### 특정 형식에 맞춰 값을 치환하는 메소드
| 리턴 타입         | 메소드 이름 및 매개 변수                                         | 설명                                                                                       |
|---------------|--------------------------------------------------------|------------------------------------------------------------------------------------------|
| static String | format(String format, Object... args)                  | format에 있는 문자열의 내용 중 변환해야 하는 부분을 args의 내용으로 변경.                                          |
| static String | format(String Locale l, String format, Object... args) | format에 있는 문자열의 내용 중 변환해야 하는 부분을 args의 내용으로 변경. 단, 첫 매개 변수인 Locale 타입의 l에 선언된 지역에 맞추어 출력 |

- format() 메소드는 정해진 기준에 맞춘 문자열이 있으면 그 기준에 있는 내용을 반환. %s는 string, %d는 정수형, %f는 소숫점이 있는 숫자, %%는 %를 의미

```text
public void checkFormat() {
        String text = "제 이름은 %s입니다. 지금까지 %d권의 책을 썼고, "
                + "하루에 %f %%의 시간을 책을 쓰는데 할애하고 있습니다.";
        String realText = String.format(text, "이상민", 7, 10.5);
        System.out.println(realText);
}
```
```text
제 이름은 이상민입니다. 지금까지 7권의 책을 썼고, 하루에 10.500000 %의 시간을 책을 쓰는데 할애하고 있습니다.
```
- 대치해야 할 문자열이 3개인데, 3개 이상으로 나열하는 것은 문제가 되지 않지만, 2개 이하로 매개 변수를 명시하면 실행시 예외가 발생한다.
```java
public void checkFormat() {
        String text = "제 이름은 %s입니다. 지금까지 %d권의 책을 썼고, "
                + "하루에 %f %%의 시간을 책을 쓰는데 할애하고 있습니다.";
        // String realText = String.format(text, "이상민", 7, 10.5);
        String realText = String.format(text, "이상민", 7);
        System.out.println(realText);
}
```
```text
Exception in thread "main" java.util.MissingFormatArgumentException: Format specifier '%f'
        at java.base/java.util.Formatter.format(Formatter.java:2672)
        at java.base/java.util.Formatter.format(Formatter.java:2609)
        at java.base/java.lang.String.format(String.java:2897)
        at _15.string.StringCheck.checkFormat(StringCheck.java:148)
        at _15.string.StringCheck.main(StringCheck.java:24)
```

### 대소문자를 바꾸는 메소드
| 리턴 타입  | 메소드 이름 및 매개 변수             | 설명                                 |
|--------|----------------------------|------------------------------------|
| String | toLowerCase()              | 모든 문자열의 내용을 소문자로 변경                |
| String | toLowerCase(Locale locale) | 지정한 지역 정보에 맞추어 모든 문자열의 내용을 소문자로 변경 |
| String | toUpperCase()              | 모든 문자열의 내용을 대문자로 변경                |
| String | toUpperCase(Locale locale) | 지정한 지역 정보에 맞추어 모든 문자열의 내용을 대문자로 변경 |
- toLower은 소문자 toUpper은 대문자로 변경하는 메소드

### 기본 자료형을 문자열로 변환하는 메소드
| 리턴 타입         | 메소드 이름 및 매개 변수                              |
|---------------|---------------------------------------------|
| static String | valueOf(boolean b)                          |
| static String | valueOf(char c)                             |
| static String | valueOf(char[] data)                        |
| static String | valueOf(char[] data, int offset, int count) |
| static String | valueOf(double d)                           |
| static String | valueOf(float f)                            |
| static String | valueOf(int i)                              |
| static String | valueOf(long l)                             |
| static String | valueOf(Object obj)                         |

- 기본 자료형을 String으로 변환하는 메소드들이다. 기본 자료형 값들을 문자열로 변경해도 되지만 다음과 같이 변환해도 상관없다.
```text
byte b = 1;
String byte1 = String.valueOf(b);
String byte2 = b + "";
```
- 이렇게 해도 동일하다. 대부분 기본 자료형을 String 타입으로 변환할 필요가 있을 때에는 String과 합치는 과정을 거친다. 그럴 경우에는 별도로
valueOf() 메소드를 사용할 필요 없다. 하지만, String으로 변환만 해놓고 문자열을 합치는 과정이 없을 때에는 valueOf() 메소드를 권장한다.
- 또한 매개 변수로 객체 (Object)가 넘어왔을 경우 toString()을 구현한 객체나 정상적인 객체를 넘겨주면 toString() 결과를 리턴해준다.
하지만 null인 객체를 넘겨줄 경우 앞에서 살펴본 것처럼 NPE가 날 수 있기 때문에 해당 메소드에서 "null"로 출력된다.

## 절대로 사용하면 안 되는 메소드가 하나 있어요!
- String 클래스에서 intern()은 자바로 구현되지 않고 C로 구현되어 있는 native 메소드 중 하나다. 심각한 성능 저하를 발생시킬 수 있기 때문에 사용하면 안 된다.
- 먼저 자바에서 String 객체를 생성하고 비교해보자.
```java
public void internCheck() {
        String text1 = "Java Basic";
        String text2 = "Java Basic";
        String text3 = new String("Java Basic");
        System.out.println(text1 == text2);
        System.out.println(text1 == text3);
        System.out.println(text1.equals(text3));
}
```
```text
true
false
true
```
- text1, text2와 같이 객체를 생성하면, String 클래스에서 관리하는 문자열 풀(pool)에 해당 값이 있으면 기존에 있는 객체를 참조하고, text3와 같이
String 객체를 생성하면 새로운 객체를 생성한다. 
- 여기에 intern() 메소드를 사용해보자.
```java
public void internCheck() {
        String text1 = "Java Basic";
        String text2 = "Java Basic";
        String text3 = new String("Java Basic");
        text3 = text3.intern();
        System.out.println(text1 == text2);
        System.out.println(text1 == text3);
        System.out.println(text1.equals(text3));
}
```
```text
true
true
true
```
- new String(String)으로 생성한 문자열 객체여도 풀에 해당 값이 있으면, 풀에 있는 값을 참조하는 객체를 리턴한다. 동일한 문자열이 존재하지 않으면
풀에 해당 값을 추가한다.
- equals()와 == 으로 비교하는 것의 성능차이는 많다. == 이 더 빠르다. 하지만 새로운 문자열을 쉴새 없이 만드는 프로그램에서 intern()으로 억지로
문자열 풀에 값을 할당하도록 만들면, 저장되는 영역에 한계로, 그 영역에 대한 별도의 메모리를 청소하는 단계를 거치게 된다. 작은 연산 하나를 
빠르게 하기 위해 전체 자바 시스템에 악영향을 줄 수 있어 사용하면 안 된다.

## immutable한 String의 단점을 보완하는 클래스에는 StringBuffer와 StringBuilder가 있다.
- String immutable한 객체다. immutable이라는 말은 사전적인 의미로 "불변의" 라는 의미. 한 번 만들어지면 더 이상 값을 바꿀 수 없다.
- 그렇다면 더하기는 어떻게 사용했을까? String 객체는 변하지 않고, 더할 때 새로운 String 객체가 생성되고, 기존 객체는 버려진다.
따라서 하나의 String 객체에 계속 더하는 작업을 한다면, 계속 쓰레기를 만드는 셈이다.
```java
String text = "Hello";
text = text + " world";
```
- 이 경우, "Hello" 객체는 더 이상 사용할 수 없고 쓰레기가 되며, 나중에 GC(Garbage Collection)의 대상이 된다.
- 이러한 단점을 보완하기 위해 StringBuffer, StringBuilder라는 클래스가 나왔다. 두 클래스의 메소드는 동일하지만 StringBuffer는
Thread safe 하고, StringBuilder는 Thread safe 하지 않다. 속도는 StringBuilder가 더 빠르다.
- 이 두 클래스는 문자열을 더하더라도 새로운 객체를 생성하지 않는다. + 가 아닌 append() 메소드를 제공하는데, 매개 변수로 모든 기본 자료형과
참조 자료형을 포함한다. 보통 다음과 같이 사용한다.
```java
StringBuilder sb = new StringBuilder();
sb.append("Hello");
sb.append(" world");
```
- append()를 한 줄에 여러 개 붙여서 사용가능
```java
StringBuilder sb = new StringBuilder();
sb.append("Hello").append(" world");
```
- append() 메소드를 수행한 후에는 해당 StringBuilder 객체가 리턴되므로 객체에 계속 붙이는 작업을 해도 무방하다.
- JDK 5 이상에서는 String 더하기 연산을 컴파일할 때 자동으로 StringBuilder로 변환해준다. 하지만 for 루프와 같은 반복 연산에서는
자동으로 변환을 해주지 않으므로, 꼭 필요하다.
- StringBuffer, StringBuilder 클래스의 공통점은 모두 문자열을 다루고, CharSequence 인터페이스를 구현했다는 점이다. 
- 하나의 메소드 내에서 문자열을 생성하여 더할 때에는 StringBuilder, 어떤 클래스에 문자열을 생성하여 더하기 위한 문자열을 처리하기 위한 인스턴스
변수가 선언되었고, 여러 쓰레드에서 이 변수를 동시에 접근하는 일이 있을 때에는 StringBuffer를 사용하여야 한다.
