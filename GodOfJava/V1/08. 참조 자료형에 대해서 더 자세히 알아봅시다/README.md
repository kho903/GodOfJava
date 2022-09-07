# 참조 자료형에 대해서 더 자세히 알아봅시다
## 참조 자료형은 나머지 다에요
- 자바의 타입은 기본 자료형과 참조 자료형이 있고, 기본 자료형 (byte, short, int, long, float, double, char, boolean) 8개를 제외한
나머지 타입은 모두 참조 자료형(reference type). 기본 자료형과 가장 큰 차이는 new를 사용해서 객체를 생성하는지 여부의 차이. (String 제외)
- 각종 연산자는 대부분 기본 자료형을 위해서 존재. + 는 참조 자료형 중 String 에서만 사용 가능. 그 참조자료형에서 사용 가능한 연산자는
값을 할당핟기 위한 등호(=)뿐.
- if, switch 같은 조건문, for, while 같은 반복문에서는 참조 자료형이 제공하는 메소드에서 boolean 타입의 리턴값을 제공한다면 사용 가능
- 참조 자료형은 new를 사용하여 객체를 사용하는데, new 뒤에 나오는 것이 생성자. 클래스를 만들면 보통 인스턴스 변수와 클래스 변수를 만들고,
생성자와 메소드를 만들어야 함.

## 기본 생성자
- 자바는 생성자를 만들지 않아도 자동으로 기본 생성자가 만들어진다.
```java
public void ReferenceDefault {
        public static void main(String[] args) {
                ReferenceDefault reference = new ReferenceDefault();
        }
}
```
- 지금까지 main() 메소드 내에 클래스 이름으로 객체를 생성한 것이 기본 생성자. new 뒤의 `ReferenceDefault()`.
- 아무 매개변수가 없는 기본 생성자는 다른 생성자가 없을 경우 기본으로 컴파일할 때 만들어짐
```java
public class ReferenceString {
        public ReferenceString(String arg) {
        }

        public static void main(String[] args) {
                ReferenceString reference = new ReferenceString();
        }
}
```
```text
ReferenceString.java:6: error: constructor ReferenceString in class ReferenceString cannot be applied to given types;
                ReferenceString reference = new ReferenceString();
                                            ^
  required: String
  found:    no arguments
  reason: actual and formal argument lists differ in length
1 error
```
- `String arg`를 매개 변수로 가지는 생성자를 만들고 기본 생성자를 호출하면 `actual and formal argument lists differ in length`라는
컴파일 오류가 발생한다. 기본 생성자는 "아무런 매개 변수가 없는 생성자는 다른 생성자가 없을 경우 기본으로 컴파일할 때 만들어진다". 따라서, 다른 생성자가
있으면 자동으로 만들어지지 않는다. 기본 생성자를 사용하고 싶으면 기본 생성자도 직접 만들어주면 된다.
```java
public class ReferenceString {
        public ReferenceString() {
        }

        public ReferenceString(String arg) {
        }

        public static void main(String[] args) {
                ReferenceString reference = new ReferenceString();
        }
}
```
- 컴파일 오류가 발생하지 않는다.

### 자바에서 생성자는 왜 필요할까?
- 자바의 생성자는 자바 클래스의 객체 (또는 인스턴스)를 생성하기 위해서 존재
  - 위 코드의 `main()`내의 `reference`가 바로 객체
- 생성자의 리턴 타입이 없는 이유는 리턴 타입이 바로 클래스의 객체이기 때문에, 클래스와 이름이 동일해야 컴파일러가 인식할 수 있다.
- 되도록이면 생성자는 다른 메소드들보다 위에 가장 윗부분에 선언하는 것이 좋다.
```java
public class ReferenceString {
        String instanceVariable; // 인스턴스 변수

        // 생성자 영역
        public ReferenceString() {
        }

        public ReferenceString(String arg) {
        }

        // 메소드 영역
        public static void main(String[] args) {
                ReferenceString reference = new ReferenceString();
                reference.setString("instanceVariable");
                System.out.println(reference.getString());
        }

        public String getString() {
                return instanceVariable;
        }

        public void setString(String str) {
                instanceVariable = str;
        }
}
```
- 위와 같이 위치시키는 것이 알아보기 쉽다. 위의 순서를 맞추지 않아도 컴파일 에러가 발생하거나 하는 등의 문제가 발생하지는 않지만, 암묵적인 약속하에
지켜주는 것이 좋다.
- 꼭 생성자가 없어도 객체를 생성할 수 없는 것은 아니다.

## 생성자는 몇 개까지 만들 수 있을까?
- 자바는 클래스의 객체를 보다 간편하게 만들기 위해 여러 가지 매개 변수를 갖는 여러 생성자를 가질 수 있다.
- 자바의 패턴 중 DTO 라는 것이 있는다. Data Transfer Object의 약자로, 어떤 속성을 갖는 클래스를 만들고, 그 속성들을 전달하기 위한 패턴이다.
- VO(Value Object) 비슷한 클래스도 있는데, VO는 데이터를 담아두기 위한 목적, DTO는 데이터를 다른 서버로 전달하기 위한 목적 
  - DTO가 VO를 포함한다고 볼 수 있기 때문에 대부분 DTO 명칭을 선호
- 한 사람의 개인정보 (이름, 전화번호, 이메일)를 가지는 MemberDTO를 만들어 보자.
```java
public void MemberDTO {
        public String name;
        public String phone;
        public String email;
}
```
- 자바의 메소드 리턴 타입은 한 가지만 선언할 수 있기 때문에 이런 복합적인 데이터를 리턴하려면 String[], int[] 와 같이 한가지 타입만으로 된 배열을
리턴하는 방법 이외에 없고, 이렇게 DTO를 만들어 놓으면 아래와 같이 그 객체를 리턴하면 된다.
```java
public MemberDTO getMemberDTO() {
        MemberDTO dto = new MemberDTO();
        // 생략
        return dto;
}
```
- 해당 MemberDTO에서 객체 생성 시, 모든 정보가 아닌 일부 정보만을 알 경우가 있어, 각각의 생성자를 생성해 주면 다음과 같다.
```java
public class MemberDTO {
        public String name;
        public String phone;
        public String email;

        public MemberDTO() {
                // 아무 정보도 모를 때
        }

        public MemberDTO(String name) {
                // 이름만 알 때;
                this.name = name;
        }

        public MemberDTO(String name, String phone) {
                // 이름, 전화번호만 알 떄
                this.name = name;
                this.phone = phone;
        }

        public MemberDTO(String name, String phone, String email) {
                // 모든 정보를 알고 있을 때
                this.name = name;
                this.phone = phone;
                this.email = email;
        }
}
```
- 자바의 생성자는 매개 변수 개수 제한이 없고, 몇 개를 만들어도 상관없다. 하지만 너무 많으면 관리가 힘드므로, 꼭 필요한 생성자만 만드는 것이 좋다.
- 매개 변수가 없는 생성자를 제외하면 모두 this 예약어로 객체의 변수와 매개 변수의 이름이 동일할 때, 구분을 위해 사용한다.
- 위의 MemberDTO 객체를 생성해 보자.
```java
public class ReferenceConstructor {
        public static void main(String[] args) {
                ReferenceConstructor reference = new ReferenceConstructor();
                reference.makeMemberObject();
        }

        public void makeMemberObject() {
                MemberDTO dto1 = new MemberDTO();
                MemberDTO dto2 = new MemberDTO("Jihun");
                MemberDTO dto3 = new MemberDTO("Jihun", "01012345678");
                MemberDTO dto4 = new MemberDTO("Jihun", "01012345678", "gmldnr2222@naver.com");
        }
}
```
- dto1 : 아무런 속성값이 지정되어 있지 않다. (모두 null)
- dto2 : 이름만 지정되어 있다. (전화번호, 이메일 null)
- dto3 : 이름과 전화번호가 지정되어 있다. (이메일 null)
- dto4 : 모든 속성값이 지정되어 있다.

## 이 객체의 변수와 매개 변수를 구분하기 위한 this
- this는 의미 그대로 "이 객체"의 의미이다. 생성자와 메소드 안에서 사용할 수 있다.
- MemberDTO에서 하나의 매개 변수만을 받는 생성자를 살펴보자.
```java
public class MemberDTO {
        public String name;
        public String phone;
        public String email;

        public MemberDTO(String name) {
                this.name = name;
        }
}
```
- 여기서 this가 없으면 다음과 같다.
```java
public class MemberDTO {
        public String name;
        public String phone;
        public String email;

        public MemberDTO(String name) {
                name = name;
        }
}
```
- 컴파일러는 다음과 같은 코드에서 생성자 안에서 사용하는 변수이기 때문에, 중괄호 안에 있는 name 은 모두 매개 변수로 넘겨준 name이라고 생각한다.
- 이러한 혼동을 피하는 가장 쉬운 방법은 매개 변수와 인스턴스 변수의 이름을 다르게 하는 것이다.
```java
public class MemberDTO {
        public String name;
        public String phone;
        public String email;

        public MemberDTO(String paramName) {
                name = paramName;
        }
}
```
- 하지만 이것보다 간단한 방법이 this 라는 예약어를 사용하는 것이다.
```java
public class MemberDTO {
        public String name;
        public String phone;
        public String email;

        public MemberDTO(String name) {
                this.name = name;
        }
}
```
- 이렇게 this.name 이라고 지정해 주면, 매개 변수 안에 있는 name 이 아닌 "이 객체의 name"이라고 명시적으로 지정해 주는 것이다.
- 이와 같이 변수 뿐만 아니라, 메소드에서도 this를 지정할 수 있다.

## 메소드 overloading
- 클래스의 생성자는 매개 변수들을 서로 다르게 선언할 수 있다. 메소드 또한 가능하다.
```java
public class ReferenceOverloading {

        public static void main(String[] args) {
                ReferenceOverloading reference = new ReferenceOverloading();
        }

        public void print(int data) {
        }

        public void print(String data) {
        }

        public void print(int intData, String stringData) {
        }

        public void print(String stringData, int intData) {
        }
}
```
- 이름이 동일한 메소드들이 여러 개 있지만, 각 메소드의 매개 변수의 종류와 개수, 순서가 다르다.
  - 첫 번째 print() 메소드는 int 매개 변수
  - 두 번쨰 print() 메소드는 String 매개 변수
  - 세 번째 print() 메소드는 int, String 순서의 매개 변수
  - 네 번째 print() 메소드는 String, int 순서의 매개 변수
- 개수가 같아도 타입의 순서가 다르면 다른 메소드로 인식된다.
- 이와 같이 메소드의 이름을 같도록 하고, 매개 변수만을 다르게 하는 것을 바로 오버로딩 (Overloading) 이라고 한다.
- overload는 사전에 "과적하다. 너무 많이 부하를 주다. 지나치다"라는 뜻으로, 하나의 메소드 이름을 사용하면서 여러 기능을 제공한다는 의미 또는
하나의 메소드 이름으로 많은 부하를 준다고 할 수 있다.
- 왜 이런 기능을 제공할까?
  - System.out.println() 출력 메소드를 보면 매개 변수로 int, long, String 모두 가능하다. 이게 바로 오버로딩의 이점이다.
  - 만약 int를 넘기려면 System.out.printlnInt(), long를 넘기려면 System.out.printlnLong() 이라는 메소드를 사용해야 한다고 가정해 보면
    매우 복잡할 것이다.
- 즉, 메소드 오버로딩은 "같은 역할을 하는 메소드는 같은 이름을 가져야 한다."는 모토로 사용하는 것이라고 기억하면 된다.
- 생성자도 매개 변수에 따라서 다르게 인식된다. 이것 역시 오버로딩의 일종이라고 생각하면 편하다.

## 메소드에서 값 넘겨주기
- 자바 메소드 종료 조건은 다음과 같다.
  - 메소드의 모든 문장이 실행되었을 때
  - return 문장에 도달했을 때
  - 예외가 발생 (throw) 했을 때
- 지금까지 대부분 메소드를 선언할 때 리턴 타입을 void로 사용하였는데, void의 사전적인 뜻은 다음과 같다.
  - 빈 공간, 공동; 공허감
  - ...이 하나도 없는
  - 무효의, 법적 효력이 없는
- 즉, void는 자바에서 "이 메소드는 아무것도 돌려주지 않습니다."라는 의미이다.
- 자바는 void 외에 모든 타입을 한 개만 리턴 타입으로 넘겨줄 수 있다. (모든 기본 자료형과 참조 자료형 중 하나를 리턴할 수 있다.)
```java
public class ReferenceReturn {
        public static void main(String[] args) {
                ReferenceReturn reference = new ReferenceReturn();
                System.out.println(reference.intReturn());
                System.out.println(reference.intArrayReturn());
                System.out.println(reference.stringReturn());
        }

        public int intReturn() {
                int returnInt = 0;
                return returnInt;
        }

        public int[] intArrayReturn() {
                int[] returnArray = new int[10];
                return returnArray;
        }

        public String stringReturn() {
                String returnString = "Return value";
                return returnString;
        }
}
```
```text
0
[I@7ad041f3
Return value
```
- 이렇게 메소드 이름 앞에 변수의 타입 지정 -> 메소드 내에서 그 타입을 생성 / 가공 -> "return" 예약어로 리턴해 주면 -> 요청한 메소드로 그 값이 전달됨
- 까먹고 return 문을 빠뜨린다면 다음과 같은 컴파일 오류가 발생한다.
```text
ReferenceReturn.java:12: error: missing return statement
        }
        ^
1 error
```
- 그리고 return 문 뒤에 다른 문장이 오는 것은 어떻게 될까?
```java
public int intReturn() {
        int returnInt = 0;
        return returnInt;
        returnInt++;
}
```
```text
ReferenceReturn.java:12: error: unreachable statement
                returnInt++;
                ^
1 error
```
- 마찬가지로 컴파일 에러가 발생한다. unreachable statement 라는 메시지로 리턴 문장 이후에는 어떤 문장도 있으면 안된다.
- 하지만 다음과 같은 경우가 있을 수 있다.
```java
public int ifConditionIntReturn() {
        int returnInt = 0;
        if (returnInt == 0) {
                return ++returnInt;
        } else {
                return --returnInt;
        }
}
```
- 이 예제는 정상적으로 컴파일 된다. 만약 "if문 안에 리턴 문장이 있을 경우"에는 그 이외의 경우가 존재하기 때문에 리턴 문장이 하나의 메소드
내에 두 개 이상 있어야 한다. 만약 if 이후에 return을 하지만 않는다면 컴파일 에러가 발생된다. 
- if문이 하나일 경우에는 다음과 같이 더 깔끔하게 할 수 있다.
```java
public int ifConditionNoElseIntReturn() {
        int returnInt = 0;
        if (returnInt == 0) {
                return ++returnInt;
        }
        return --returnInt;
}
```
- 명시적으로 else 없이 더 깔끔하게 나타낼 수 있다.


- 위처럼 리턴은 한 개의 타입만 할 수 있어서 여러 개를 넘겨주고 싶다면 앞에서 보았던 DTO로 리턴 타입을 만들어 주면 된다.
  - 앞에서 보았던 MemberDTO를 사용하면 3개의 데이터 (이름, 이메일, 전화번호)를 한 번에 넘겨줄 수 있다.


- void의 경우에는 더 이상 실행하고 싶지 않을 때 break 예약어가 아닌 return; 문을 활용할 수 있다.
```java
public void wantToStopInTheMiddle(boolean flag) {
        System.out.println("before return");
        if (flag) return;
        System.out.println("after return");
}
```
```text
before return
```
- return; 전의 "before return"만 출력된 것을 볼 수 있다.
- 다음과 같이 `return` 뒤에 아무것도 없이 세미콜론을 적어주면, "메소드 수행을 종료해라"라고 인식한다.

## static 메소드와 일반 메소드의 차이
- `System.out.println()`출력문 메소드를 보면 왜 객체를 생성하지 않아도 될까? 바로 `static`예약어 때문이다.
- static을 사용하면 객체를 생성하지 않아도 메소드를 호출할 수 있다.
```java
public class ReferenceStatic {
        public static void main(String[] args) {
                ReferenceStatic.staticMethod();
        }

        public static void staticMethod() {
                System.out.println("This is a staticMethod");
        }
}
```
```text
This is a staticMethod
```
- static 은 객체를 생성하지 않고 메소드를 호출할 수 있지만, 클래스 변수만 사용할 수 있다는 단점이 있다.
```java
public class ReferenceStatic {
        String name = "Min";

        public static void main(String[] args) {
                ReferenceStatic.staticMethod();
        }

        public static void staticMethod() {
                System.out.println("This is a staticMethod");
        }

        public static void staticMethodCallVariable() {
                System.out.println(name);
        }
}
```
```text
ReferenceStatic.java:13: error: non-static variable name cannot be referenced from a static context
                System.out.println(name);
                                   ^
1 error
```
- non-static variable name cannot be referenced from a static context
- 즉, static 이 아닌 이름은 static context 에서 참조할 수 없다. 이러한 컴파일 에러를 잡기 위한 방법에는 두 가지가 있다.
  - staticMethod()의 선언에 static을 빼는 방법
  - ReferenceStatic의 name 이라는 변수 선언 시 static으로 선언해야 한다.(인스턴수 변수 -> 클래스 변수로 변경) `public static String name;`
- 하지만 인스턴스 변수에 static을 붙히는 방법은 조심해야 한다.
```java
public class ReferenceStaticVariable {
        static String name;

        public ReferenceStaticVariable() {
        }

        public ReferenceStaticVariable(String name) {
                this.name = name;
        }

        public static void main(String[] args) {
                ReferenceStaticVariable reference = new ReferenceStaticVariable();
                reference.checkName();
        }

        public void checkName() {
                ReferenceStaticVariable reference1 = new ReferenceStaticVariable("Sangmin");
                System.out.println(reference1.name);
                ReferenceStaticVariable reference2 = new ReferenceStaticVariable("Sungchoon");
                System.out.println(reference1.name);
        }
}
```
```text
Sangmin
Sungchoon
```
- reference1 의 name 은 "sangmin", reference2 의 name 은 "Sungchoon"으로 설정한 것 처럼 보이지만, 출력문을 보면 reference1.name을
두 번째 출력한 것에서 "Sungchoon"이 나오게 된다.
- "name"이라는 변수가 인스턴스 변수가 아닌 static 으로 선언한 클래스 변수이기 때문에, 같은 name을 바라보게 된다.
- name의 static을 제거하고 다시 실행하면
```text
Sangmin
Sangmin
```
- 원하는 결과가 나온다.

## static 블록
- 어떤 클래스의 객체가 생성되면서 딱 한 번만 불려야 하는 코드가 있다고 생각해보자.
- 객체는 여러 개를 생성하지만, 한 번만 호출되어야 하는 코드가 있다면 static 블록을 다음과 같이 선언하면 된다.
```java
static {
    // 딱 한 번만 수행되는 코드
}
```
- 한 번 호출되고 난 뒤에는 호출하려고 해도 호출할 수가 없다.
- 클래스 내에 선언되어 있어야 하며, 메소드 내에 선언 불가.
- 즉, 인스턴스 변수나 클래스 변수와 같이 어떤 메소드나 생성자에 속해 있으면 안 된다.
```java
public class StaticBlock {
        static int data = 1;
        public StaticBlock() {
                System.out.println("StaticBlock Constructor.");
        }

        static {
                System.out.println("--- First static block ---");
                data = 3;
        }

        static {
                System.out.println("--- Second static block ---");
                data = 5;
        }

        public static int getData() {
                return data;
        }
}
```
- static 블록은 여러 개 선언할 수 있으며, 선언된 순서대로 호출된다.
- StaticBlockCheck 클래스를 다음과 같이 만든다.
```java
public class StaticBlockCheck {
        public static void main(String[] args) {
                StaticBlockCheck check = new StaticBlockCheck();
                check.makeStaticBlockObject();
        }

        public void makeStaticBlockObject() {
                System.out.println("Creating block1");
                StaticBlock block1 = new StaticBlock();
                System.out.println("Created block1");
                System.out.println("-------------------");
                System.out.println("Creating block2");
                StaticBlock block2 = new StaticBlock();
                System.out.println("Created block2");
        }
}
```
```text
Creating block1
--- First static block ---
--- Second static block ---
StaticBlock Constructor.
Created block1
-------------------
Creating block2
StaticBlock Constructor.
Created block2
```
- 두 개의 static 블록들은 생성자가 호출되기 전에 딱 한 번만 호출됨
- static 블록은 클래스를 초기화할 때 꼭 수행되어야 하는 작업이 있을 때 유용
- 추가로, static 블록 안에서는 static 한 것들만 호출할 수 있다.
- data 값을 확인해보자.
```java
public void makeStaticBlockObject() {
        System.out.println("Creating block1");
        StaticBlock block1 = new StaticBlock();
        System.out.println("Created block1");
        System.out.println("-------------------");
        System.out.println("Creating block2");
        StaticBlock block2 = new StaticBlock();
        System.out.println("Created block2");
}
```
- 이와 같이 static 블록은 생성자가 불리지 않더라도, 클래스에 대한 참조가 발생하자마자 호출되는 것을 알 수 있다.
- static 블록에서는 static 변수 뿐 아니라 getData와 같은 static 메소드 또한 호출할 수 있다.

## Pass by value, Pass by reference
- callPassByValue() 메소드에 int 값으로 10, String 값으로 "b"를 선언한 후 passByValue()로 넘겨주는 예제이다.
```java
public class ReferencePass {
        public static void main(String[] args) {
                ReferencePass reference = new ReferencePass();
                reference.callPassByValue();
        }

        public void callPassByValue() {
                int a = 10;
                String b = "b";
                System.out.println("before passByValue");
                System.out.println("a=" + a);
                System.out.println("b=" + b);
                passByValue(a, b);      
                System.out.println("after passByValue");
                System.out.println("a=" + a);
                System.out.println("b=" + b);
        }

        public void passByValue(int a, String b) {
                a = 20;
                b = "z";
                System.out.println("in passByValue");
                System.out.println("a=" + a);
                System.out.println("b=" + b);
        }
}
```
```text
before passByValue
a=10
b=b
in passByValue
a=20
b=z
after passByValue
a=10
b=b
```
- PassByValue() 메소드를 보면 매개 변수로 받은 값들을 다른 값으로 변경하고 출력하였다.
- "Pass by Value" 라는 말은 "값을 전달한다"는 말이다. 더 정확히는 "값만 전달한다"는 말이다. 메소드의 매개 변수로 넘길 때에는 원래 값은 놔두고, 전달되는
갑싱 진짜인 것처럼 보이게 한다. 그래서 매개 변수를 받은 메소드에서 값을 변경해도 원래의 값은 변하지 않는다.
- 기본 자료형은 무조건 "Pass by Value", 참조 자료형은 "Pass by Reference"로 데이터를 전달한다.
- 그런데 위의 코드에서 String의 경우 참조 자료형인데, 왜 값이 변경되지 않았을까?
```java
b = "z";
```
- 다음 코드에서 Stirng은 이렇게 따옴표로 값을 할당하면 new를 사용하여 객체를 생성한 것과 같다. 즉, 아래 코드와 같다.
```java
b = new String("z");
```
- String이 아닌 다른 참조 자료형들도 이처럼 호출된 메소드에서 다른 객체로 대체하여 처리하면 기존 값은 바뀌지 않는다.
- Pass by Reference의 경우 값이 전달되면, 호출한 메소드의 데이터에도 영향이 있다.
- 매개 변수로 받은 참조 자료형 안에 있는 객체를 변경하면, 호출한 참조 자료형 안에 있는 객체는 호출된 메소드에서 변경한 대로 데이터가 바꾸니다.
  - 이와 같이 값(value)이 아닌 객체에 대한 참조 (reference)가 넘어가는 것을 "Pass by Reference"라고 한다.
```java
public class ReferencePass {
        public static void main(String[] args) {
                ReferencePass reference = new ReferencePass();
                // reference.callPassByValue();
                reference.callPassByReference();
        }

        public void callPassByValue() {
                int a = 10;
                String b = "b";
                System.out.println("before passByValue");
                System.out.println("a=" + a);
                System.out.println("b=" + b);
                passByValue(a, b);      
                System.out.println("after passByValue");
                System.out.println("a=" + a);
                System.out.println("b=" + b);
        }

        public void passByValue(int a, String b) {
                a = 20;
                b = "z";
                System.out.println("in passByValue");
                System.out.println("a=" + a);
                System.out.println("b=" + b);
        }

        public void callPassByReference() {
                MemberDTO member = new MemberDTO("Sangmin");
                System.out.println("before passByReference");
                System.out.println("member.name=" + member.name);
                passByReference(member);
                System.out.println("after passByReference");
                System.out.println("member.name=" + member.name);
        }

        public void passByReference(MemberDTO member) {
                member.name = "SungChoon";
                System.out.println("in passByReference");
                System.out.println("member.name=" + member.name);
        }
}
```
```text
before passByReference
member.name=Sangmin
in passByReference
member.name=SungChoon
after passByReference
member.name=SungChoon
```
- member.name 이 "Sangmin"에서 passByReference() 메소드 안에서 "SungChoon"으로 바뀌고 호출 이후에도 "SungChoon"로 변경되어 있는 것을 볼 수 있다.
- 이처럼 메소드의 매개 변수로 참조 자료형을 넘길 경우에는 메소드 안에서 객체의 상태를 변경한 결과에 영향을 받게 된다.

## 매개 변수를 지정하는 특이한 방법
- 매개 변수가 몇 개가 될지, 호출마다 바뀔수 있게 만들 수 있을까?
  - 가장 쉬운 방법은 배열을 넘겨주는 방법
```java
public class MethodVarargs {
        public static void main(String[] args) {
                MethodVarargs varargs = new MethodVarargs();
                varargs.calculateNumbersWithArray(new int[] {1,2,3,4,5});
        }

        public void calculateNumbersWithArray(int[] numbers) {
                int total = 0;
                for (int number : numbers) {
                        total += number;
                }
                System.out.println("Total=" + total);
        }
}
```
- 이렇게 배열을 사용하면 매개 변수로 넘겨 줄 때 계산할 숫자들을 모두 배열로 만든 후 넘겨주어야 한다는 단점이 존재한다.
- 그래서 자바에서는 임의 개수의 매개 변수를 넘겨 줄 수 있는 방법을 제공한다.
```java
public void calculateNumbers(int... numbers) {
        int total = 0;
        for (int number : numbers) {
                total += number;
        }
        System.out.println("Total=" + total);
}
```
- 이와 같이 "타입... 변수명"으로 선언해 주면 nubmers는 배열로 인식하고, 그 값을 처리할 수 있다. (...은 연속해서 적어주어야 한다.)
- 배열과 뭐가 다를까?
```
varargs.calculateNumbers(1);
varargs.calculateNumbers(1, 2);
varargs.calculateNumbers(1, 2, 3);
varargs.calculateNumbers(1, 2, 3, 4);
varargs.calculateNumbers(1, 2, 3, 4, 5);
```
- 위와 같이 필요에 따라 매개 변수 수를 정하기 어려울 때, 사용할 수 있다.
- 한 가지 주의점은 하나의 메소드에서 한 번 사용 가능하며, 여러 매개 변수가 있을 때에 가장 마지막에 선언해야 한다는 것이다.
```java
public void arbitrary(String message, int... numbers) {
	
}
```
```java
public void arbitrary(int... numbers, String message) {
	
}
```
- 아래와 경우 컴파일 에러가 발생한다.
- 이런 메소드는 어디에서 사용할까?
- System.out.println() 외에 System.out.printf() 라는 메소드가 있다. 다음과 같이 정의되어 있다.
```java
printf(String format, Object... args)
```
- 가장 앞에는 출력하는 포맷(format)을 선언하고 그 뒤에는 Object 타입의 args를 임의의 개수만큼 받는다.
- printf() 사용예제
```java
MemberDTO dto = new MemberDTO("Sangmin", "01012345678", "javatuning@gmail.com");
System.out.println("Name:%s Phone:%s E-Mail:%s\n", dto.name, dto.phone, dto.email);
```
```text
Name:Sangmin Phone:01012345678 E-Mail:javatuning@gmail.com
```
- printf()의 가장 앞에 지정하는 format 에는 화면에 출력할 메시지 포맷을 정해준다. (%s : String)
- 줄바꿈이 포함되어 있지 않으므로 "\n" 포함시켜 주면 줄바꿈을 할 수 있다.
