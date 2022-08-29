# 매번 만들기 귀찮은데 누가 만들어 놓은 거 쓸 수 없나요?
## 미리 만들어 놓은 클래스들은 아주 많아요
- 설치해서 사용중인 JDK는 엄청나게 많은 클래스와 메소드들이 포함되어 있다. 이렇게 많은 클래스를 사용할 떄 참조하는 문서가 바로 API 라는 것이다.
- API는 Application Programming Interface의 약자로 "애플리케이션에 선언되어 있는 클래스와 메소드에 대한 상세한 설명이 포함된 문서"이다.
- JDK 뿐만아니라 다른 여러 자바 프레임워크에서 제공하는 문서도 API 라고 부름
- 이런 API는 소스 냐에 API애 명시되도록 하기 위한 주석을 상세하게 달고, javac, java 명령어가 있는 jdk/bin 디렉터리에 있는 javadoc
명령어를 실행하면 자동으로 API 문서인 HTML 파일이 생성된다.

## API를 열어보자.
- https://docs.oracle.com/javase/7/docs/api/
- 왼쪽 위에 모든 패키지의 링크 목록, 왼쪽 아래에 윗창에서 선택한 패키지의 클래스 링크 목록, 우측에는 선택한 패키지나 클래스에 대한 설명 제공
- 패키지를 하나 선택하고 우측 패키지에 대한 설명을 보면 다음 순서로 링크 목록이 제공된다.
  - 인터페이스 목록
  - 클래스 목록
  - ENUM 클래스 목록
  - 예외 클래스 목록
  - 에러 (Error) 클래스 목록
  - 어노테이션 타입 목록 (Annotation Types)

## 클래스 및 인터페이스의 상세 정보 화면을 살펴보자
아래 있는 순서대로 정보가 제공된다.

### 패키지와 클래스 / 인터페이스 이름
- 다음과 같이 제공됨 (java.lang.String)
```text
java.lang
Class String
```

### 클래스 상속 다이어그램 (Class Inheritance Diagram)
- 어떤 클래스들의 상속을 받았는지에 대한 관계를 간단한 계단식으로 보여준다.
```text
java.lang.Object
    java.lang.String
```
- 자식 클래스에서 별도로 Overriding 하지 않았으면 자식 클래스에 해당 메소드에 대한 내용을 자세히 알 수 없어, 부모 클래스에서 찾아야 한다.

### 직속 자식 클래스 (Direct Known Subclasses)
- 현재 보고 있는 클래스를 확장한 클래스들의 목록이 나타난다. final 클래스는 더 이상 자식을 갖지 못한다.
- java.lang.Throwable 클래스의 직속 자식 클래스는 다음과 같다.
```text
Direct Known Subclasses:
    Error, Exception
```

### 알려진 모든 하위 인터페이스 목록 (All Known Subinterfaces) : 인터페이스에만 존재함
- 인터페이스를 상속받은 인터페이스 목록을 나타낸다.
- java.lang.Runnable 인터페이스의 정보
```text
All Known Subinterfaces:
    RunnableFuture<V>, RunnableScheduledFuture<V>
```

### 알려진 모든 구현한 클래스 목록 (All Known Implementing Classes) : 인터페이스에만 존재함
- 해당 인터페이스를 구현한 클래스들의 목록이다.
- 어떤 인터페이스로 선언된 매개 변수를 메소드에 넘겨줘야 할 때, 여기에 구현된 클래스의 객체를 넘겨주면 된다.

### 구현한 모든 인터페이스 목록 (All Implements Interfaces) : 클래스에만 존재함
- 클래스에서 구현 (implements)한 모든 인터페이스의 목록을 나열한다.
- 여기에 명시되어 있는 모든 인터페이스의 메소드들은 해당 클래스에 반드시 구현되어 있을 것이다.

### 클래스 / 인터페이스의 선언 상태 (Class / Interface Declaration)
- 클래스의 선언 상태를 볼 수 있다.
```text
public final class String
extends Object
implements Serializable, Comparable<String>, CharSequence
```
- 즉, 클래스가 어떤 접근 제어자를 사용했는지, final 클래스인지 등을 확인할 수 있다.

### 클래스 / 인터페이스의 설명 (Class / Interface Description)
- 클래스에 대한 상세한 설명 (용도, 사용법, 사용 예)을 볼 수 있다.
- 가장 아래에 나오는 Since, See Also 부분은 주의 깊게 봐야 한다.
  - Since : 해당 클래스가 JDK에 추가된 버전 명시. Java 5 기반 시스템에서 6, 7 API 문서를 보면 컴파일이 안 될수 있다.
  - See also : 그 클래스와 관련되어 있는 모든 클래스나 인터페이, 메소드 등의 링크 제공

### 내부 클래스 종합 (Nested Class Summary)
- 자바는 클래스 안에 내부 클래스 선언이 가능해서 public 하게 선언할 경우 그에 대한 내용이 여기서 제공됨

### 상수 필드 종합 (Field Summary)
- 클래스에는 public static 으로 선언한 상수 필드가 존재할 수 있는데, 바뀌지 않는 값이여서 여러 모로 많이 사용된다.

### 생성자 종합 (Constructor Summary)
- 클래스에 어떤 생성자들이 선언되어 있는지를 목록으로 제공. (링크 또한 제공)

### 메소드 종합 (Method Summary)
- 클래스에 선언된 모든 public, protected 메소드에 대한 종합 정보 제공
- 어떤 메소드가 있는지, 리턴 타입은 무엇인지, 매개 변수로는 어떤 것을 넘겨줘야 하는지 쉽게 확인 가능
- Modifier and Type 부분에 Modifier가 public 이라면 리턴 타입만 표시된다. static 메소드라면 static이 추가로 명시됨

### 부모 클래스로부터 상속받은 메소드들
- 간단히 부모 클래스로부터 상속받은 메소드가 나열된다. 부모 클래스가 여러 개라면 각 클래스별로 목록 별도 제공

### 상수 필드 상세 설명 (Field Detail)
- 클래스에 선언된 상수 필드가 어떤 내용을 제공하는지에 대한 상세한 설명
- Since, See Also 제공되는 경우도 있다.

### 생성자 상세 설명 (Constructor Detail)
- 생성자를 어떻게 사용하고, 매개 변수에 어떤 값들이 제공되어야 하는지, 어떤 리턴 값을 제공하는지, 어떤 예외를 언제 발생하는지 확인 가능

### 메소드 상세 설명 (Method Detail)
```text
length

public int length()

Returns the length of the string. The length is equal to the number of Unicode code units in the string.

Specified by:
    length in interface CharSequence

Returns:
    the length of the sequence of characters represented by this object.
```

## Deprecated 라고 표시되어 있는 것은 뭐야?
- Deprecated 는 "이제 이건 안 쓰는 거야"라고 선언한 것이다. 사전적 의미는 "(강력히) 반대하다"라는 말이다.
- 생성자, 상수 필드, 메소드에 선언되어 있는데, JDK를 처음 만들었을 때, 이건 필요하다 생각해서 만든 것이 나중에 문제를 야기시킨다거나,
혼동을 가져올 때, 더 이상 가치가 없을 때, 처리하는 것.
- 왜 없애지 않고 놔둘까? -> "호환성" 문제 때문이다. JDK 버전을 올리고 다시 컴파일을 했을 때, Deprecated가 아닌 해당 메소드를 없애개 되면
없어진 메소드를 사용하는 모든 부분에서 컴파일 오류가 발생할 것이고, 버전 업을 포기할 수 있다.
- Deprecated 된 메소드를 사용해보자.
```java
package _11.api;

public class APICheck {
        public static void main(String[] args) {
                APICheck check = new APICheck();
                check.useDeprecated();
        }

        public void useDeprecated() {
                String str = "abcde";
                byte[] strBytes = str.getBytes();
                String convertedStr = new String(strBytes, 0);
        }
}
```
- 해당 파일을 컴파일 하면 다음과 같이 출력된다.
```text
Note: _11/api/APICheck.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
```
- 다음과같이 Note 라는 것이 나타난다.
- 첫 번째 노트에서 APICheck가 deprecated 된 API 를 사용 또는 override 한다고 알려준다.
- 두 번째 노트에서 -Xlint:deprecation 옵션을 주고 다시 컴파일 하라는 메시지가 나온다. 
```shell
$ javac -Xlint:deprecation _11/api/APICheck.java
_11/api/APICheck.java:12: warning: [deprecation] String(byte[],int) in String has been deprecated
                String convertedStr = new String(strBytes, 0);
                                      ^
1 warning
```
- 다음과 같이 에러가 아닌 warning 이 출력된다. 경고는 위험하다고 알려주는 것이지 문제가 있는 것은 아니다.
- 이렇게 하지 않을 경우 deprecated 되었다는 것을 모를 수 있기 때문에 알려준다.
- 앞으로 deprecated 메소드, 생성자 등을 보면 "그 메소드나 생성자는 더 이상 안쓰는 것이다." 라고 생각해야 한다.
- 꼭 기억해야 할 점은 "deprecated 된 것들은 다 이유가 있다"는 점이다.

## Header와 Footer에 있는 링크들은 뭘까?
- 헤더 먼저 살펴보자.
### Overview
- Overview는 전체 패키지에 대한 설명으로 이동.

### Package
- 패키지 메뉴는 현재 보고 있는 클래스가 속해 있는 패키지의 모든 인터페이스, 클래스, 예외 등의 목록 및 간단한 설명

### Class
- 앞에서 알아본 클래스에 대한 상세 설명

### Use
- JDK 에 포함되어 있는 패키지 및 클래스 중에서 현재 보고 있는 패키지, 클래스, 인터페이스 등을 사용하는 모든 목록을 나타냄

### Tree
- 지금 보고 있는 클래스가 속한 패키지에 있는 모든 클래스들이 어떤 상속 관계를 갖고 있는지 Tree 형태로 제공

### Deprecated
- JDK에 포함되어 있는 클래스나 메소드 중에서 앞에서 알아본 Deprecated 클래스나 메소드의 목록을 제공

### Index
- A ~ Z 까지 각 알파벳에 해당하는 클래스, 인터페이스, 메소드, static 변수 등의 색인을 오름차순으로 정렬하여 제공

### Help
- API 문서에 대한 설명을 아주 간단하게 정리해 놓은 화면


### 헤더의 두번 째 줄은 다음과 같다.
- Prev CLASS
  - API 목록 상에서 위에 선언된 클래스의 상세 정보로 이동
- NEXT CLASS
  - API 목록 상에서 아래에 선언된 클래스의 상세 정보로 이동
- FRAMES
  - 세개의 화면으로 분리된 화면
- NO FRAMES
  - 분리된 화면이 싫은 사람을 위해 제공되는 링크 -> 한 화면으로 제공
