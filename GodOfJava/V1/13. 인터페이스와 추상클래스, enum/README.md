# 인터페이스와 추상클래스, enum
## 메소드 내용이 없는 interface
- 자바에서 .class 파일은 클래스 외에 interface(인터페이스), abstract 클래스로 만들 수 있다. 이를 이해하기 위해 시스템을 만드는 절차를 알아보자.
- 어떤 시스템을 개발할 때 방법론 (시스템을 어떻게 만들 것인지에 대한 절차 설명, 어떻게 문서를 작성할지 정리한 공동 문서)을 사용해 개발한다.
- 일반적인 절차
  - 분석
  - 설계
  - 개발 및 테스트
  - 시스템 릴리즈

### 분석
- 시스템을 분석하는 단계에서는 시스템을 만들어 달라고 한 사람들에게 어떻게 개발을 원하는지 물어본다. 이런 과정이 요구사항 분석.
- 이외에도 여러가지가 있다.

### 설계
- 분석 단계에서 만든 대략적인 그림을 프로그램으로 만들 수 있도록 설계
- 어떤 메소드를 만들지, 데이터를 어떻게 저장할지 등의 세부사항

### 개발 및 테스트
- 설계에서 만들기로 한 것들 개발.
- 실제 시스템에서 제공해야 하는 기능을 만드는 작업을 개발, 제대로 동작하는지 확인하는 것을 테스트라고 함

### 시스템 릴리즈
- 시스템을 사용자에게 제공하는 단계
- 시스템 오픈 이후 운영 / 유지보수 단계를 거침


위 설계 단계에서 어떻게 만들 것인지 정리하는 단계에서 어떤 클래스, 메소드, 변수를 만들지 정리하는 작업을 같이 한다.
나중에 변경될 때 문서도 수정해야 하므로, 2중 3중 일이 되는데, 이 설계 단계에서 인터페이스라는 것을 만들어 두면 개발할 때 메소드의 이름을 어떻게 할지,
매개 변수를 어떻게 할지를 일일이 고민하지 않아도 된다. 그리고, 각 메소드, 매개 변수 이름을 통일 시킬 수 있다는 장점이 있다.

또, 인터페이스나 abstract 클래스를 사용하는 이유는 다음 메소드를 보고 생각해보자.
```java
public boolean equals(Object o);
```
누가 보더라도 매개 변수로 넘어온 객체와 현재 객체가 같은지를 boolean으로 리턴해 주는 역할이다. 개발자는 저 인터페이스가 구현된 클래스에서 이 메소드를
호출할 것이다. 중요한 것은 "인터페이스가 구현된 클래스"가 어떻게 되어 있는지 몰라도 사용하는 데에 아무 문제가 없다는 점이다.
- 가장 일반적인 것이 DAO (Data Object Object)라는 패턴이다. 이 패턴은 데이터를 저장하는 저장소에서 원하는 값을 요청하고 응답받는다.
- 예를 들어 MemberDAO로 회원정보를 확인하는 인터페이스가 있다고 하자. 회원 전화번호를 매개 변수로 넘겨주면 회원 상세 정보를 제공한다든지 하는
  메소드가 있을 것이다.
- 이런 메소드들은 어떤 DBMS를 사용해도 문제가 없을 것이다. 이렇게 인터페이스를 정해 놓으면, 선언과 구현을 구분할 수 있다.
- 마지막으로 정리해보자.

### 인터페이스와 abstract 클래스를 사용하는 이유
- 설계시 선언해 두면 개발할 때 기능을 구현하는 데에만 집중할 수 있다.
- 개발자의 역량에 따른 메소드의 이름과 매개 변수 선언의 격차를 줄일 수 있다.
- 공통적인 인터페이스와 abstract 클래스를 선언해 놓으면, 선언과 구현을 구분할 수 있다.

## 인터페이스를 직접 만들어보자
- MemberDTO를 관리하는 MemberManagerImpl 이라는 클래스를 만들어야 한다고 가정하자.
- MemberManager 인터페이스를 만들어보자. (먼저 _13.model 패키지에 MemberDTO 복사)
```java
package _13.model;

public class MemberDTO {
        public String name;
        public String phone;
        public String email;

        // ...
}
```
```java
package _13.service;

import _13.model.MemberDTO;

public interface MemberManager {
        public boolean addMember(MemberDTO member);
        public boolean removeMember(String name, String phone);
        public boolean updateMember(MemberDTO member);
}
```
- 정상적으로 컴파일이 된다. 컴파일을 하면 .class인 클래스 파일이 만들어지는데, 이것만 보고, 인터페이스 인지 클래스인지 알 방법이 없어, 클래스 이름 앞에
I를 붙여 IMemberManager 라고 표현하기도 한다. 개발 표준을 잡기 나름.
- MemberMangerImpl로 인터페이스를 활용해 보자.
```java
package _13.service;

public class MemberManagerImpl implements MemberManager {
        
}
```
- 다음과 같이 implements 예약어를 쓰고 인터페이스들을 나열하면 된다. implements는 "구현하다"라는 말이다.
- implements는 여러 개 할 수 있다.
- 위 MemberManagerImpl을 컴파일 하면 다음과 같은 에러 메시지가 나온다.
```text
_13/service/MemberManagerImpl.java:3: error: MemberManagerImpl is not abstract and does not override abstract method updateMember(MemberDTO) in MemberManager
public class MemberManagerImpl implements MemberManager {
       ^
1 error
```
- "MemberManagerImpl" 클래스는 abstract 클래스도 아니고, MemberManager에 정의되어 있는 updateMember() 라는 abstract 메소드도 구현하지 않았다.
라는 오류메시지이다.
  - abstract 란 "추상적인"이라는 뜻으로 인터페이스에 있는 메소드 선언문들과 같이 몸통이 없이 선언한 것을 말한다.
- MemberManagerImpl은 적어도 다음과 같이 구현해야만 한다.
```java
package _13.service;

import _13.model.MemberDTO;

public class MemberManagerImpl implements MemberManager {
        @Override
        public boolean addMember(MemberDTO member) {
                return false;
        }

        @Override
        public boolean removeMember(String name, String phone) {
                return false;
        }

        @Override
        public boolean updateMember(MemberDTO member) {
                return false;
        }
}
```
- MemberManger에 정의된 메소드들을 모두 구현해야만 정상적으로 컴파일됨
- 그리고 해당 메소드에 맞는 로직을 완성시키면 된다. 이 과정이 개발 프로세스 중에서 "개발"에 해당
- @Override는 Override 했다는 것을 명시적으로 표시하는 어노테이션이다.
- 정리하자면, 설계 단계에서 인터페이스만 만들어 놓고, 개발 단계에서 로직을 만들면 설계, 개발 단계의 산출물을 효율적으로 관리 가능
- 또다른 용도는 외부에 노출되는 것을 정의해 놓고자 할 때 사용함. 인터페이스는 MemberManagerImpl의 대변인 역할을 함
- 인터페이스는 구현이 되어 있는 코드가 없다. 따라서 .class 확장자를 가져도 그대로 사용할 수 없다. 다음 InterfaceExample 코드를 만들자
```java
package _13;

import _13.service.MemberManager;

public class InterfaceExample {
        public static void main(String[] args) {
                MemberManager member = new MemberManager();
        }
}
```
- 위 클래스를 컴파일하면 아래와 같은 컴파일 오류가 발생한다.
```text
_13/InterfaceExample.java:7: error: MemberManager is abstract; cannot be instantiated
                MemberManager member = new MemberManager();
                                       ^
1 error
```
- MemberManager가 abstract 이기 때문에 초기화가 되지 않는다는 메시지이다. 즉, 아무것도 구현하지 않았는데, 왜 이걸로 초기화 하나 라는 메시지이다.
- 아래와 같이 고쳐보자.
```java
package _13;

import _13.service.MemberManager;
import _13.service.MemberManagerImpl;

public class InterfaceExample {
        public static void main(String[] args) {
                MemberManager member = new MemberManagerImpl();
        }
}
```
- 컴파일하면 오류가 사라진다.

## 일부 완성되어 있는 abstract 클래스
- abstract는 "추상적인"의 의미. 자바에서 마음대로 초가화하고 실행할 수 없도록 되어 있다. 그래서, abstract를 구현해 놓은 클래스로 초기화 및 실행 가능
- abstract 클래스 전에 인터페이스를 다시 생각해보면, class 예약어를 사용하지 않고, interface 라는 예약어를 사용한다. 그리고, 각 메소드 선언문은
일반 메소드 선언문과 동일하지만, 메소드의 몸통이 없다. 
- abstract 클래스는 다음과 같다.
```java
package _13.service;

import _13.model.MemberDTO;

public abstract class MemberManagerAbstract {
        public abstract boolean addMember(MemberDTO member);
        public abstract boolean removeMember(String name, String phone);
        public abstract boolean updateMember(MemberDTO member);
        public void printLog(String data) {
                System.out.println("Data=" + data);
        }
}
```
### abstract 클래스에 대한 정리
- 클래스 선언시 abstract 예약어를 클래스 앞에 추가
- 클래스 안에는 abstract로 선언된 메소드가 0개 이상 있으면 됨
- abstract로 선언된 메소드가 하나라도 있으면, 그 클래스는 반드시 abstract로 선언되어야 함
- 몸통이 있는 메소드가 0개 이상이어도 상관 없으며, static 이나 final 메소드가 잇어도 된다. (인터페이스의 경우 불가능)
- implements가 아닌 extends를 사용하여 해당 클래스 확장하여 구현
```java
package _13.service;

import _13.model.MemberDTO;

public class MemberManagerImpl2 extends MemberManagerAbstract {

}
```
```text
_13/service/MemberManagerImpl2.java:5: error: MemberManagerImpl2 is not abstract and does not override abstract method updateMember(MemberDTO) in MemberManagerAbstract
public class MemberManagerImpl2 extends MemberManagerAbstract {
       ^
1 error
```
- abstract로 선언된 메소드를 구현하지 않아서 컴파일 에러가 발생한다.
```java
package _13.service;

import _13.model.MemberDTO;

public class MemberManagerImpl2 extends MemberManagerAbstract {
        public boolean addMember(MemberDTO member) {
                return false;
        }

        public boolean removeMember(String name, String phone) {
                return false;
        }

        public boolean updateMember(MemberDTO member) {
                return false;
        }
}
```
- 다음과 같이 구현해 놓으면 컴파일 에러가 사라진다. 왜 이런 abstract 클래스를 만들었을까?
- 인터페이스를 선언하다보니, 어떤 메소드는 미리 만들어 놓고 싶다는 생각이 들 경우가 있다. 그렇다고 클래스로 만들기는 애매한 경우가 있다.
특히 아주 공통적인 기능을 미리 구현해 놓으면 많은 도움이 된다. 이럴 때 사용하는 것이 abstract 클래스이다.

|                     | 인터페이스     | abstract 클래스  | 클래스     |
|---------------------|-----------|---------------|---------|
| 선언 시 사용하는 예약어       | interface | abstact class | class   |
| 구현 안 된 메소드 포함 가능 여부 | 가능 (필수)   | 가능            | 불가      |
| 구현된 메소드 포함 가능 여부    | 불가        | 가능            | 가능 (필수) |
| static 메소드 선언 가능 여부 | 불가        | 가능            | 가능      |
| final 메소드 선언 가능 여부  | 불가        | 가능            | 가능      |
| 상속 (extends) 가능     | 불가        | 가능            | 가능      |
| 구현 (implements) 가능  | 가능        | 불가            | 불가      |

## 나는 내 자식들에게 하나도 안 물려 줄꺼여
- final 이라는 예약어가 있다. final은 클래스, 메소드, 변수에 선언할 수 있다. "마지막"이라는 뜻이다.
### 클래스에 final을 선언할 때에는 ...
- 클래스 선언 시, 접근 제어자와 class 예약어 사이에 final을 추가할 수 있다.
```java
package _13.util;

public final class FinalClass {

}
```
- 아무런 차이가 없다고 생각할 수 있지만 이를 상속받은 다른 클래스를 만들고 컴파일 해보자.
```java
package _13.util;

public class FinalChildClass extends FinalClass {

}
```
```text
_13/util/FinalChildClass.java:3: error: cannot inherit from final FinalClass
public class FinalChildClass extends FinalClass {
                                     ^
1 error
```
- final인 FinalClass 에서 상속을 받을 수는 없어요. 라고 에러 메세지를 뱉는다. 
- 더 이상 확장해서는 안 되는 클래스, 누군가 이 클래스를 상속 받아서 내용을 변경해서는 안 되는 클래스를 선언할 때 final로 선언하면 된다.

### 메소드를 final로 선언하는 이유는...
- 메소드의 경우에도 클래스에 final을 사용하는 경우와 비슷하게 사용한다.
```java
package _13.util;

public abstract class FinalMethodClass {
        public final void printLog(String data) {
                System.out.println("Data=" + data);
        }
}
```
- 먼저 abstract 클래스를 만들고 final 메소드를 만든 뒤 상속을 받아 Overriding을 해보면
```java
package _13.util;

public class FinalMethodChildClass extends FinalMethodClass {
        public void printLog(String data) {
                System.out.println("Data=" + data);
        }
}
```
```text
_13/util/FinalMethodChildClass.java:4: error: printLog(String) in FinalMethodChildClass cannot override printLog(String) in FinalMethodClass
        public void printLog(String data) {
                    ^
  overridden method is final
1 error
```
- FinalMethodChildClass 클래스에 있는 printLog() 메소드는 final 이기 때문에 override 할 수 없다. 라고 되어 있다.
- 다른 사람이 변경하지 못하도록 하려면 final로 만들어 다른 개발자가 그 메소드를 덮어 쓰는 것을 간단하게 막을 수 있다.

### 변수에서 final을 쓰는 것은 메소드나 클래스에서 쓰는 것과 비교하면 많이 다르다.
- 클래스나 메소드에서의 final은 더 이상 상속을 못 받게 하고, Override를 할 수 없게 하는 것이지만, 변수에서 final은 조금 다르다.
- 변수에 final을 사용하면 "더 이상 바꿀 수 없다."라는 말이다. 그래서, 인스턴스 변수나 static으로 선언된 클래스 변수는 선언과 함께 값을 지정해야 한다.
```java
package _13.util;

public class FinalVariable {
        final int instanceVariable;
}
```
```text
_13/util/FinalVariable.java:4: error: variable instanceVariable not initialized in the default constructor
        final int instanceVariable;
                  ^
1 error
```
- final로 선언된 변수는 초기화를 하지 않으면 컴파일 에러가 발생한다. 다음과 같이 고쳐보자.
```java
package _13.util;

public class FinalVariable {
        final int instanceVariable = 1;
}
```
- 정상적으로 컴파일이 된다.
- "생성자나 메소드에서 초기화하면 되지 않나"라고 생각할 수도 있겠지만, 그러면 중복되어 변수값이 선언될 수도 있기 때문에 기존 의도를 벗어난다.
- 이렇게 초기화 하려면 지역변수를 선언해서 사용하면 된다. 매개 변수나 지역 변수 코드를 살펴보자.
```java
package _13.util;

public class FinalVariable {
        final int instanceVariable = 1;

        public void method(final int parameter) {
                final int localVariable;
        }
}
```
- 이렇게 사용해도 정상적으로 동작한다. 하지만 아래와 같이 사용해서는 안된다.
```java
package _13.util;

public class FinalVariable {
        final int instanceVariable = 1;

        public void method(final int parameter) {
                final int localVariable;
                localVariable = 2;
                localVariable = 3;
                parameter = 4;
        }
}
```
```text
_13/util/FinalVariable.java:9: error: variable localVariable might already have been assigned
                localVariable = 3;
                ^
_13/util/FinalVariable.java:10: error: final parameter parameter may not be assigned
                parameter = 4;
                ^
2 errors
```
- final로 선언된 매개 변수는 변경할 수 없고, final로 선언된 지역 변수는 값을 한 번 할당한 뒤로 변경할 수 없다.
- 변수는 이름 그대로 "변하는 수"인데 왜 final 키워드를 만들었을까? 달력의 1월, 12월은 31일까지 있다는 것은 변하지 않는다. 이와 같이 변하지 않는 값에
final로 선언하면 매우 유용하게 사용할 수 있다. 
- but, 남발하면 안된다.
- 참조 자료형에 대한 final을 알아보자.
```java
package _13.util;

import _13.model.MemberDTO;

public class FinalReferenceType {
        final MemberDTO dto = new MemberDTO();

        public static void main(String[] args) {
                FinalReferenceType referenceType = new FinalReferenceType();
                referenceType.checkDTO();
        }

        public void checkDTO() {
                System.out.println(dto);
                dto = new MemberDTO();
        }
}
```
```text
_13/util/FinalReferenceType.java:15: error: cannot assign a value to final variable dto
                dto = new MemberDTO();
                ^
1 error
```
- dto 가 final 이기 떄문에 값을 할당할 수 없다는 에러가 발생한다. 기본 자료형과 마찬가지로 참조 자료형도 두 번 이상 값을 할당하거나 새로 생성자를
사용하여 초기화할 수 없다. 그런데, 다음 코드를 보자.
```java
public void checkDTO() {
        System.out.println(dto);
        // dto = new MemberDTO();
        dto.name = "Sangmin";
        System.out.println(dto);
}
```
```text
Name=null Phone=null eMail=null
Name=Sangmin Phone=null eMail=null
```
- 문제가 없이 실행된다. dto 객체, 즉 MemberDTO 객체는 FinalReferenceType 에서 두 번 이상 생성할 수 없다.
- 하지만 그 객체 안의 객체들은 final로 선언되어 있지 않아, 제약이 없다. 즉, MemberDTO 내에 name, phone, email은 final 이 아니다.

## enum 클래스라는 상수의 집합도 있다.
- final로 String과 같은 문자열이나 숫자들을 다타내는 기본 자료형의 값을 고정할 수 있다. 이것을 "상수 (constant)"라고 한다.
- 어떤 클래스가 상수만으로 만들어져 있을 때, class가 아닌 `enum`으로 선언할 수 있는데, 이럴 경우 "이 객체는 상수의 집합이다."라는 것을
명시적으로 나타낸다.
- enum 클래스는 어떻게 보면 타입이지만 클래스의 일종이다.
```java
package _13.enums;

public enum OverTimeValues {
        THREE_HOUR,
        FIVE_HOUR,
        WEEKEND_FOUR_HOUR,
        WEEKEND_EIGHT_HOUR;
}
```
- 어떤 회사의 평일 3~5시간 야근 수당, 5~시간 야근 수당, 주말 4~8 야근 수당, 8~ 야근수당이 각각 있을 때, 위와 같이 OverTimeValues라는 enum
클래스로 선언할 수 있따. enum 클래스에 있는 상수들은 지금까지 살펴본 변수들과 다르게 별도로 타입을 지정할 필요도, 값을 지정할 필요 없이, 해당 상수들의
이름을 콤마로 구분하여 나열하면 된다.
- enum을 사용해보자.
```java
package _13.enums;

public class OverTimeManager {
        public static void main(String[] args) {
                OverTimeManager manager = new OverTimeManager();
                int myAmount = manager.getOverTimeAmount(OverTimeValues.THREE_HOUR);
                System.out.println(myAmount);
        }

        public int getOverTimeAmount(OverTimeValues value) {
                int amount = 0;
                System.out.println(value);
                switch(value) {
                        case THREE_HOUR:
                                amount = 18000;
                                break;
                        case FIVE_HOUR:
                                amount = 30000;
                                break;
                        case WEEKEND_FOUR_HOUR:
                                amount = 40000;
                                break;
                        case WEEKEND_EIGHT_HOUR:
                                amount = 60000;
                                break;
                }
                return amount;
        }
}
```
```text
THREE_HOUR
18000
```
- getOverTimeAmount()는 OverTimeValues enum을 매개 변수로 받고, 변수 value로 지정. 야근 수당을 amount를
switch 문을 사용하여 각 조건에 맞게 변경하고, 리턴한다.
- OverTimeValues enum은 매개 변수로 `OverTimeValues.THREE_HOUR`와 같이 넘겨 줄 수 있다. ("enum 클래스이름.상수이름")
- 결과를 보면 enum 값이 THREE_HOUR로 출력되었다. 그리고 해당 조건에 맞는 18000 이 출력되었다.

## enum을 보다 제대로 사용하기
- 앞에서 enum타입을 넘겨서 switch 문으로 확인하였다. 하지만 각 상수의 값을 지정하는 방법도 있다.
```java
package _13.enums;

public enum OverTimeValues2 {
        THREE_HOUR(18000),
        FIVE_HOUR(30000),
        WEEKEND_FOUR_HOUR(40000),
        WEEKEND_EIGHT_HOUR(60000);

        private final int amount;

        OverTimeValues2(int amount) {
                this.amount = amount;
        }

        public int getAmount() {
                return amount;
        }
}
```
- amount 라는 final 변수를 만들어 생성자에서 매개 변수로 넘겨받은 값을 할당할 때 사용.
- enum 클래스의 생성자는 package-private, private만 사용 가능
```java
package _13.enums;

public class OverTimeManager2 {
        public static void main(String[] args) {
                OverTimeValues2 value2 = OverTimeValues2.FIVE_HOUR;
                System.out.println(value2);
                System.out.println(value2.getAmount());
        }
}
```
```text
FIVE_HOUR
30000
```
- 정상적으로 동작한다. 앞의 코드보다 훨씬 간결해졌다.
- 앞의 코드는 enum 선언 자체는 매우 간단해지지만, 구현이 약간 복잡해진다. 그리고, 메소드 호출로 switch 값을 간단히 할당하기는 했지만, 원격서버에 해당
수당이 있을 때, 수당이 바뀌어도 코드가 바뀌지 않을 것이다.
- 이번 코드의 경우 수당이 바뀐다면 enum 클래스 내에서 값을 변경 후, 다시 컴파일 하고 실행해야 된다는 단점이 존재한다. 하지만 성능은 이번 코드가 훨씬
좋을 것이다.

## enum 클래스의 부모는 무조건 java.lang.Enum 이어야 해요
- 자바에서 다중 상속은 허용되지 않지만, 상속에 상속을 거쳐 여러 부모 클래스를 가질 수 있다. 하지만 enum 클래스는 java.lang.Enum 이라는
클래스의 상속을 받는다. 즉, extends java.lang.Enum 이라는 문장이 컴파일 시 추가된다. 따라서 마음대로 extends를 하면 안 된다.
- Enum 클래스의 생성자는 다음과 같다.


| 접근 제어자    | 메소드                            | 설명                                      |
|-----------|--------------------------------|-----------------------------------------|
| protected | Enum(String name, int ordinal) | 컴파일러에서 자동으로 호출되도록 해놓은 생성자로, 개발자는 호출 불가능 |

- name은 enum 상수의 이름. oridinal은 enum의 순서로 상수가 선언된 순서대로 0부터 증가한다.
- Enum 클래스의 부모 클래스는 Object 클래스이기 때문에 모든 Object 메소드가 사용 가능하지만 다음 4가지를 Override 하지 못하게 막아두었다.

| 메소드        | 내용                                                                        |
|------------|---------------------------------------------------------------------------|
| clone()    | 객체를 복제하기 위한 메스드지만, enum에서 사용 불가능. 호출될 시, CloneNotSupportedException 예외 발생 |
| finalize() | GC가 발생할 때 처리하기 위한 메소드                                                     |
| hashCode() | int 타입의 해시 코드 값을 리턴하는 메소드                                                 |
| equals()   | 두 개의 객체가 동일한지 확인하는 메소드                                                    |

- hashCode()와 equals()는 사용해도 무방하지만, clone()과 finalize()는 사용할 수 없다.
- Object 클래스의 메소드를 Overriding한 마지막 메소드는 toString()으로 상수 이름을 출력한다. toString()은 Enum 클래스에서
Overriding 한 Object 클래스의 메소드 중 유일하게 final로 선언되어 있지 않아 overriding 가능
- Enum 클래스의 메소드는 다음과 같다.

| 메소드                                     | 내용                                                                    |
|-----------------------------------------|-----------------------------------------------------------------------|
| compareTo()                             | 매개 변수로 enum 타입과의 순서(ordinal) 차이를 리턴                                   |
| getDeclaringClass()                     | 클래스 타입의 enum을 리턴                                                      |
| name()                                  | 상수의 이름을 리턴                                                            |
| ordinal()                               | 상수의 순서를 리턴                                                            |
| valueOf(Class<T> enumType, String name) | static 메소드다. 첫 번쨰 매개 변수로는 클래스 타입의 enum, 두 번째 매개 변수로는 상수의 이름을 넘겨주면 된다. |

- 여기서 compareTo()가 그나마 많이 사용된다. Enum이 선언된 순서대로 각 상수들의 순서가 정해지는데, 이 순서를 비교해서 같으면 0, 다르면 순서의 차이를
리턴. 매개 변수 기준으로 앞에 있으면 음수, 뒤에 있으면 양수를 리턴.

```java
package _13.enums;

public class OverTimeManager2 {
        public static void main(String[] args) {
                OverTimeValues2 value2 = OverTimeValues2.FIVE_HOUR;
                System.out.println(value2);
                System.out.println(value2.getAmount());

                OverTimeValues2 value3 = OverTimeValues2.THREE_HOUR;
                System.out.println(value2.compareTo(value3));
        }
}
```
```text
FIVE_HOUR
30000
1
```
- FIVE_HOUR가 THREE_HOUR보다 하나 뒤에 있으니 1을 출력한다.
- 이 외에 enum 에는 API 문서에 없는 특수한 메소드가 하나 있는데, 바로 values() 이다.
- values()는 enum 클래스에 선언되어 있는 모든 상수를 배열로 리턴해줌
```java
package _13.enums;

public class OverTimeManager3 {
        public static void main(String[] args) {
                OverTimeValues2[] valueList = OverTimeValues2.values();
                for (OverTimeValues2 value : valueList) {
                        System.out.println(value);
                }
        }
}
```
```text
THREE_HOUR
FIVE_HOUR
WEEKEND_FOUR_HOUR
WEEKEND_EIGHT_HOUR
```
## 정리
- 인터페이스와 abstract 클래스는 클래스의 골격을 잡아주고, 메소드를 선언해 놓을 때 매우 유용하게 사용 가능
