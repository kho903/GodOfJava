# 자바는 상속이라는 것이 있어요
- Parent, Child 클래스를 만들면서 알아보자.
```java
package _10.inheritance;

public class Parent {
        public Parent() {
                System.out.println("Parent Constructor");
        }

        public void printName() {
                System.out.println("Parent printName()");
        }
}
```
```java
package _10.inheritance;

public class Child extends Parent {
        public Child() {
                System.out.println("Child Constructor");
        }
}
```
- Child 뒤에 `extends`는 그 다음에 나오는 클래스 이름의 클래스를 상속받는다는 말이다.
- `extends Parent` 이렇게 확장하면 Parent 클래스에 선언되어 있는 public 및 protected로 선언되어 있는 모든 변수와 메소드를
Child 클래스가 가지고 있는 것처럼 사용할 수 있다. 접근 제어자가 없거나 private으로 선언된 것들은 사용 불가능
- InheritancePrint.java
```java
package _10.inheritance;

public class InheritancePrint {
        public static void main(String[] args) {
                Child child = new Child();
                child.printName();
        }
}
```
```text
Parent Constructor
Child Constructor
Parent printName()
```
- Parent 클래스를 호출하지 않아도 확장을 한 클래스에서 생성자를 호출하면, 자동으로 부모 클래스의 기본 생성자가 호출됨
- 부모 클래스에 있는 printName() 메소드를 자식 클래스에서 호출할 수 있다.
- 정리하면 다음과 같다.
  - 부모 클래스에서는 기본 생성자를 만들어 놓는 것 이외의 상속을 위해 아무런 작업이 필요없다.
  - 자식 클래스는 클래스 선언 시 extends 부모 클래스 이름 순으로 적어준다.
  - 자식 클래스의 생성자 호출 시, 자동으로 부모 클래스의 기본 생성자가 실행됨
  - 자식 클래스에서는 부모 클래스에 있는 public, protected로 선언된 모든 인스턴스 / 클래스 변수, 메소드 사용 가능
- 다음과 같은 상속을 만든 이유는 하나의 클래스를 제대로 만들어 놓고, 그 클래스를 상속받아 손쉽게 추가적인 기능을 넣을 수 있기 때문이다.
```java
package _10.inheritance;

public class ChildPrint extends Parent {
        public ChildPrint() {
                System.out.println("ChildPrint Constructor");
        }

        public void printAge() {
                System.out.println("printAge() - 18 month");
        }
}
```
- 확장한 클래스는 추가적인 메소드를 만들어도 전혀 문제가 없다.
- 상속이 없다면 모든 클래스에 printName()이 필요할 경우, 모든 클래스에 printName()을 만들어야 한다. 또한, 수정 사항이 생겼을 경우, 모든 클래스에
printName()을 하나하나 고쳐야 한다. 상속은 이런 단순 반복의 일을 없애주는 장점이 있다.
- 기억해야 할 것은 자바에서는 다중 상속이 안 된다. extends 뒤에 여러 개를 나열하면 컴파일이 되지 않는다. 단일 상속만 가능

## 상속과 생성자
- 기본 생성자를 만드는 것 외에는 부모 클래스가 할 일은 없다.
- 부모 클래스에 기본 생성자가 없다면 어떻게 될까?
```java
package _10.inheritance;

public class Parent {
        //public Parent() {
        //      System.out.println("Parent Constructor");
        //}

        public void printName() {
                System.out.println("Parent printName()");
        }
}
```
- 컴파일 후 InheritancePrint를 실행하면
```java
Child Constructor
Parent printName()
```
- 컴파일과 실행 모두 정상적으로 작동한다.
- 문제가 없다고 생각할 수 있지만, 매개 변수를 가진 생성자를 만들게 되면 이야기가 달라진다.
```java
package _10.inheritance;

public class ParentArg {
        public ParentArg(String name) {
                System.out.println("ParentArg(" + name + ") Constructor");
        }

        public void printName() {
                System.out.println("printName() - ParentArg");
        }
}
```
```java
package _10.inheritance;

public class ChildArg extends ParentArg {
        public ChildArg() {
                System.out.println("ChildArg Constructor");
        }
}
```
```text
_10/inheritance/ChildArg.java:4: error: constructor ParentArg in class ParentArg cannot be applied to given types;
        public ChildArg() {
                          ^
  required: String
  found:    no arguments
  reason: actual and formal argument lists differ in length
1 error
```
- ChildArg 생성자를 실행할 때 ParentArg 클래스의 매개 변수가 없는 기본 생성자가 없다는 에러가 발생
- ParentArg 클래스의 상속을 받은 ChildArg 클래스의 모든 생성자가 실행될 때 ParentArg() 기본 생성자를 찾는데, String name를 매개 변수로 받는
생성자 뿐이기 때문이다. (매개 변수가 있는 생성자를 만들 경우, 기본 생성자가 자동으로 생성되지 않는다.)
- 이를 해결하기 위한 방법은
1. 부모 클래스에 "매개 변수가 없는" 기본 생성자를 만든다.
2. 자식 클래스에서 부모 클래스의 생성자를 명시적으로 지정하는 super()를 사용한다.
- super() 예약어는 부모 클래스의 생성자를 호출한다는 것을 의미. super.printName()과 같이 메소드 호출도 가능
- super()는 생략하게 되도 컴파일 시, 자동으로 포함된다. ChildArg만 다음과 같이 고쳐서 정상 동작도 가능하다.
```java
package _10.inheritance;

public class ChildArg extends ParentArg {
        public ChildArg() {
                super("Child");
                System.out.println("ChildArg Constructor");
        }
}
```
- `super("ChildArg")`의 경우 ParentArg 생성자 중 String을 매개변수로 갖는 생성자를 찾아 호출해 준다.
- but, 다음과 같이 생성자의 매개 변수가 더 존재한다면 어떻게 될까?
```java
package _10.inheritance;

public class ParentArg {
        public ParentArg(String name) {
                System.out.println("ParentArg(" + name + ") Constructor");
        }

        public ParentArg(InheritancePrint obj) {
                System.out.println("ParentArg(InheritancePrint) Constructor");
        }

        public void printName() {
                System.out.println("printName() - ParentArg");
        }
}
```
```java
package _10.inheritance;

public class ChildArg extends ParentArg {
        public ChildArg() {
                // super("Child");
                super(null);
                System.out.println("ChildArg Constructor");
        }
}
```
```text
_10/inheritance/ChildArg.java:6: error: reference to ParentArg is ambiguous
                super(null);
                ^
  both constructor ParentArg(String) in ParentArg and constructor ParentArg(InheritancePrint) in ParentArg match
1 error
```
- `reference to ParentArg is ambiguous` : 클래스로의 참조가 매우 모호하다 (ambiguous)라는 의미
- super()를 사용하여 생성자를 호출할 때에는 모호하게 null을 넘기는 것보다는 호출하고자 하는 생성자의 기본 타입을 넘겨주는 것이 좋다.
- 여기서는 null을 넘겨주면, String과 InheritancePrint 클래스 중 어떤 매개 변수를 받는 생성자를 찾아야 할 지 컴파일러가 정할 수 없다.
- 자바는 부모의 매개 변수가 없는 기본 생성자를 찾는 것이 기본이므로, 매개 변수가 있는 생성자만 있을 경우에는 super(매개변수)를 이용해서
부모 생성자를 꼭 호출해야만 한다.
- super()를 명시적으로 지정하지 않으면 기본 생성자가 컴파일러에서 자동으로 호출된다. 그리고, super()는 반드시 자식 클래스의 생성자에서
가장 첫줄에 위치해야 한다.

## 메소드 overriding
- 부모의 기능을 자식이 모두 (private 제외) 포함한다고 볼 수 있다. 좀 더 유연하게 사용하기 위한 Overriding 이 있다.
- 부모 클래스에 선언되어 있는 메소드와 동일한 메소드를 자식 클래스에서 동일하게 선언하는 것을 "메소드 Overriding"이라고 한다. 접근 제어자, 리턴 타입,
메소드 이름, 매개 변수 타입 모두 동일해야 한다.
```java
package _10.inheritance;

public class ParentOverriding {
        public ParentOverriding() {
                System.out.println("ParentOverriding Constructor");
        }

        public void printName() {
                System.out.println("printName() - ParentOverriding");
        }
}
```
```java
package _10.inheritance;

public class ChildOverriding extends ParentOverriding {
        public ChildOverriding() {
                System.out.println("ChildOverriding Constructor");
        }
        public void printName() {
                System.out.println("ChildOverriding printName()");
        }
}
```
```text
ParentOverriding Constructor
ChildOverriding Constructor
ChildOverriding printName()
```
- ParentOverriding에 선언된 printName()이 아닌 ChildOverriding에 선언된 printName() 메소드가 호출되었다.
- 즉, 부모 클래스에 선언된 메소드를 자식 클래스에서 동일하게 선언하면 자식 클래스 메소드만 실행된다. 메소드의 경우 super()가 자동으로 추가되지만,
메소드는 그렇지 않다. 이것이 "메소드 Overriding"
- "동일하게 선언되어 있다."는 "동일한 시그니처를 가진다."고 표현하는데, 시그니처는 메소드 이름, 매개 변수의 타입 및 개수를 의미
- 리턴 타입을 바꾸고 컴파일 하면 어떻게 될까?
```java
package _10.inheritance;

public class ChildOverriding extends ParentOverriding {
        public ChildOverriding() {
                System.out.println("ChildOverriding Constructor");
        }
        public String printName() {
                System.out.println("ChildOverriding printName()");
                return "";
        }
}
```
```text
_10/inheritance/ChildOverriding.java:7: error: printName() in ChildOverriding cannot override printName() in ParentOverriding
ChildArgpublic String printName() {int.java             InheritancePrint.java       ParentArg.java                                        
                      ^
  return type String is not compatible with void
1 error
```
- "return type String is not compatible with void"
- 리턴 타입을 다르게 리턴하면 컴파일 에러가 밣생
- 접근 제어자의 경우는 어떻게 될까?
```java
package _10.inheritance;

public class ChildOverriding extends ParentOverriding {
        public ChildOverriding() {
                System.out.println("ChildOverriding Constructor");
        }
        private void printName() {
                System.out.println("ChildOverriding printName()");
        }
}
```
```text
_10/inheritance/ChildOverriding.java:7: error: printName() in ChildOverriding cannot override printName() in ParentOverriding
        private void printName() {
                     ^
  attempting to assign weaker access privileges; was public
1 error
```
- 부모 클래스에서 public으로 되어 있는 printName() 메소드를 private로 선언하고 컴파일 하면 다음과 같은 오류가 발생한다.
- `attempting to assign weaker access privileges; was public`, 접근 제어자가 더 확대되는 것은 문제가 안 되지만,
축소되는 것은 문제가 된다.
- 즉, public > protected > package-private > private 순으로 public일 경우 자식이 private이면 안 된다. 
- 부모가 private일 경우 자식은 어떤 것이든 상관없다.
```java
package _10.inheritance;

public class ParentOverriding {
        public ParentOverriding() {
                System.out.println("ParentOverriding Constructor");
        }

        private void printName() {
                System.out.println("printName() - ParentOverriding");
        }
}
```
```java
package _10.inheritance;

public class ChildOverriding extends ParentOverriding {
        public ChildOverriding() {
                System.out.println("ChildOverriding Constructor");
        }
        public void printName() {
                System.out.println("ChildOverriding printName()");
        }
}
```
- 다음과 같이 자식에서 접근 권한이 확장되면 문제 없이 컴파일된다.
- Overriding에 대해 정리하면
  - 메소드 Overriding은 부모 클래스의 메소드와 동일한 시그니처를 갖는 자식 클래스의 메소드가 존재할 때 성립된다.
  - Overriding 된 메소드는 부모 클래스와 동일한 리턴 타입을 가져야만 한다.
  - Overriding 된 메소드의 접근 제어자는 부모 클래스에 있는 메소드와 달라도 되지만, 접근 권한이 확장되는 경우에만 허용된다. 축소되면 컴파일 에러 발생.
- Overriding과 Overloading이 헷갈릴 수 있는데, 차이점은 다음과 같다.
  - Overloading : 확장 (메소드의 매개 변수들을 확장하기 때문에, 확장)
  - Overriding : 덮어 씀 (부모 클래스의 메소드 시그니처를 복제해서 자식 클래스에서 새로운 것을 만들어 내어 부모 클래스의 기능은 무시하고, 자식 클래스에서 
    덮어 씀)

## 참조 자료형의 형 변환
```java
package _10.inheritance;

public class ParentCasting {
        public ParentCasting() {
        }

        public ParentCasting(String name) {
        }

        public void printName() {
                System.out.println("printName() - Parent");
        }
}
```
```java
package _10.inheritance;

public class ChildCasting extends ParentCasting {
        public ChildCasting() {
        }

        public ChildCasting(String name) {
        }

        public void printName() {
                System.out.println("printName() - Child");
        }

        public void printAge() {
                System.out.println("printAge() - 18 month");
        }
}
```
- 지금까지 위와 같은 코드의 객체 생성은 아래와 같이 하였다.
```java
ParentCasting parent = new ParentCasting();
ChildCasting child = new ChildCasting();
```
- 상속 관계가 성립되면, 다음과 같이 객체 생성 가능
```java
ParentCasting obj = new ChildCasting();
```
- 하지만 아래와 같은 객체 생성은 불가능
```java
ChildCasting obj2 = new ParentCasting();
```
- ChildCasting 에서는 부모 클래스인 ParentCasting 에 있는 메소드와 변수들을 모두 사용할 수 있다.
- 거꾸로 부모 클래스인 ParentCasting 에서는 자식 클래스인 ChildCasting 에 있는 메소드와 변수들을 사용할 수 없다.
- 앞에서 보았던 기본 자료형의 형 변환에서 int에서 long 으로 형 변환을 할 때 별도의 작업을 하지 않았다. 데이터의 범위가 넓어져 값이 바뀌지 않기 때문이다.
하지만, long에서 int로 형 변환을 하려면 값이 바뀔 수 있어 명시적으로 형 변환을 해야한다.
```java
int intValue = 10;
long longValue = 101;
long casted1 = intValue;
int casted2 = (int) longValue;
```
- 동일한 값이 된다는 보장이 없다.
- 참조 자료형은 자식 클래스의 타입을 부모 클래스 타입으로 형 변환하면 전혀 문제가 없다. (부모의 모든 메소드, 변수는 자식에서 사용 가능), 따라서 명시적으로
표기 X
```java
package _10.inheritance;

public class InheritanceCasting {
        public static void main(String[] args) {
                InheritanceCasting inheritance = new InheritanceCasting();
                inheritance.objectCast();
        }

        public void objectCast() {
                ParentCasting parent = new ParentCasting();
                ChildCasting child = new ChildCasting();

                ParentCasting parent2 = child;
                ChildCasting child2 = parent;
        }
}
```
```text
_10/inheritance/InheritanceCasting.java:14: error: incompatible types: ParentCasting cannot be converted to ChildCasting
                ChildCasting child2 = parent;
                                      ^
1 error
```
- `incompatible types`라는 에러를 발생시킨다. parent 객체는 ParentCasting 클래스의 객체이며, ChildCasting 클래스에 선언되어 있는
메소드 / 변수를 완전히 사용 불가능하기 때문이다. 다음과 같이 형 변환을 해보자.
```java
package _10.inheritance;

public class InheritanceCasting {
        public static void main(String[] args) {
                InheritanceCasting inheritance = new InheritanceCasting();
                inheritance.objectCast();
        }

        public void objectCast() {
                ParentCasting parent = new ParentCasting();
                ChildCasting child = new ChildCasting();

                ParentCasting parent2 = child;
                ChildCasting child2 = (ChildCasting) parent;
        }
}
```
- `ChildCasting child2 = (ChildCasting) parent;`에서 parent 객체에게 ChildCasting 클래스인 것처럼 행동하라는 명시적 선언.
- 컴파일은 정상적이지만 실행 시, 다음 오류가 발생.
```text
Exception in thread "main" java.lang.ClassCastException: class _10.inheritance.ParentCasting cannot be cast to class _10.inheritance.ChildCasting (_10.inheritance.ParentCasting and _10.inheritance.ChildCasting are in unnamed module of loader 'app')
        at _10.inheritance.InheritanceCasting.objectCast(InheritanceCasting.java:14)
        at _10.inheritance.InheritanceCasting.main(InheritanceCasting.java:6)
```
- parent 객체가 실제 ParentCasting 객체이므로 사용할 수 없다는 오류이다. 명시적 형 변환은 다음과 같은 경우에 사용할 수 있다.
```java
package _10.inheritance;

public class InheritanceCasting {
        public static void main(String[] args) {
                InheritanceCasting inheritance = new InheritanceCasting();
                // inheritance.objectCast();
                inheritance.objectCast2();
        }

        // ...

        public void objectCast2() {
                ChildCasting child = new ChildCasting();
                ParentCasting parent2 = child;
                ChildCasting child2 = (ChildCasting) parent2;
        }
}
```
- 정상적으로 실행된다. ChildCasting 객체를 ParentCasting 객체 parent2에 대입하게 되면 겉모습은 ParentCasting 이지만, 실제로는
  ChildCasting 객체인 parent2를 ChildCasting 클래스로 형 변환해도 전혀 문제는 없다.
- 왜 이렇게 써야 할까?
```java
package _10.inheritance;

public class InheritanceCasting {
        public static void main(String[] args) {
                InheritanceCasting inheritance = new InheritanceCasting();
                // inheritance.objectCast();
                // inheritance.objectCast2();
                inheritance.objectCastArray();
        }

        // ...

        public void objectCastArray() {
                ParentCasting[] parentArray = new ParentCasting[3];
                parentArray[0] = new ChildCasting();
                parentArray[1] = new ParentCasting();
                parentArray[2] = new ChildCasting();
        }
}
```
- ParentCasting 배열에서 0, 2번째는 ChildCasting 클래스의 객체를 할당하였다. 전혀 문제 없는 코드이다.
- 이와 같이 여러 개의 값을 처리하거나, 매개 변수로 값을 전달할 때에는 보통 부모 클래스의 타입으로 보낸다.
- 이렇게 하지 않으면 배열과 같이 여러 값을 한 번에 보낼 때 각 타입별로 구분해서 메소드를 만들어야 하는 문제가 생길 수 있다.
- 그렇다면 배열의 타입 구분은 어떻게 할까?
```java
package _10.inheritance;

public class InheritanceCasting {
        public static void main(String[] args) {
                InheritanceCasting inheritance = new InheritanceCasting();
                // inheritance.objectCast();
                // inheritance.objectCast2();
                inheritance.objectCastArray();
        }
		
        // ...

        private void objectTypeCheck(ParentCasting[] parentArray) {
                for (ParentCasting tempParent : parentArray) {
                        if (tempParent instanceof ChildCasting) {
                                System.out.println("ChildCasting");
                        } else if (tempParent instanceof ParentCasting) {
                                System.out.println("ParentCasting");
                        }
                }
        }
}
```
```text
ChildCasting
ParentCasting
ChildCasting
```
- `instanceof` 예약어로 타입을 구분할 수 있다.
- `instanceof` 앞에는 객체, 뒤에는 클래스 (타입)을 지정해 줄 수 있다. boolean 결과 제공
- 따라서 parentArray[0], parentArray[2]는 `if (tempParent instanceof ChildCasting)`에서 true,
parentArray[1]은 `else if (tempParent instanceof ParentCasting)`에서 true여야 한다.
- 다음을 추가하자.
```java
private void objectTypeCheck(ParentCasting[] parentArray) {
        for (ParentCasting tempParent : parentArray) {
                if (tempParent instanceof ChildCasting) {
                        System.out.println("ChildCasting");
                        ChildCasting tempChild = (ChildCasting) tempParent;
                        tempChild.printAge();
                } else if (tempParent instanceof ParentCasting) {
                        System.out.println("ParentCasting");
                }
        }
}
```
- ParentCasting 인 객체는 printAge() 메소드가 없으므로 instanceof를 사용하여 원하는 메소드 호출이 가능하다.
- 유의점은 다음과 같다. ParentArray[0]의 값은 ChildCasting 이지만 다음 결과는 true 이다.
```java
parentArray[0] instanceof ParentCasting
```
- 상속 받은 자식은 당연히 부모 클래스의 instance 이기도 한 것이다. 따라서, if 문에서 instanceof의 타입을 점검할 때에는 가장 하위에
있는 자식 타입부터 확인을 해야 제대로 타입 점검이 가능하다.
- 코드로 확인하면 다음과 같다.
```java
private void objectTypeCheck(ParentCasting[] parentArray) {
        for (ParentCasting tempParent : parentArray) {
                if (tempParent instanceof ParentCasting) {
                        System.out.println("ParentCasting");
                } else if (tempParent instanceof ChildCasting) {
                        System.out.println("ChildCasting");
                        ChildCasting tempChild = (ChildCasting) tempParent;
                        tempChild.printAge();
                }
        }
}
```
- 다음과 같이 실행하면 모두 ParentCasting 으로 출력될 것이다.
- 따라서 가장 하위 자식 타입부터 확인을 해야 한다.
### 중간 정리
- 참조 자료형도 형 변환이 가능하다.
- 자식 타입의 객체를 부모 타입으로 형 변환 하는 것은 자동으로 된다.
- 부모 타입의 객체를 자식 타입으로 형 변환을 할 때에는 명시적으로 타입을 지정해 주어야 한다. 이때, 부모 타입의 실제 객체는 자식 타입이어야만 한다.
- instanceof 예약어를 사용하면 객체의 타입 확인 가능
- instanceof로 타입 확인을 할 때 부모 타입도 true 라는 결과를 제공한다.

## Polymorphism (다형성)
- 다형성은 형태가 다양하다는 말로, 앞부분의 Overriding 과 형 변환과 관련된 개념
```java
package _10.inheritance;

public class ChildOther extends Parent {
        public ChildOther() {
        }

        public void printName() {
                System.out.println("ChildOther - printName()");
        }
}
```
```java
package _10.inheritance;

public class InheritancePoly {
        public static void main(String[] args) {
                InheritancePoly inheritance = new InheritancePoly();
                inheritance.callPrintNames();
        }

        public void callPrintNames() {
                Parent parent1 = new Parent();
                Parent parent2 = new Child();
                Parent parent3 = new ChildOther();

                parent1.printName();
                parent2.printName();
                parent3.printName();
        }
}
```
```text
Parent Constructor
Parent Constructor
Child Constructor
Parent Constructor
Parent printName()
Parent printName()
ChildOther - printName()
```
- parent1, parent2, paretn3 는 모두 Parent 로 선언되었고, 각 객체의 printName() 메소드를 호출하였다.
- 선언 시, 모두 Parent로 선언하였지만, 실제로 호출된 메소드는 생성자를 사용한 클래스에 있는 것이 호출되었다. 왜냐하면 각 객체의 실제 타입은 다르기 때문이다.
- "형 변환을 하더라도, 실제 호출되는 것은 원래 객체에 있는 메소드가 호출된다." 이것이 바로 다형성이고, Polymorphism 이다.

## 자식 클래스에서 할 수 있는 일들을 다시 정리해보자
### 생성자에 관한 내용
- 자식 클래스의 생성자가 호출되면 자동으로 부모 클래스의 매개 변수가 없는 기본 생성자가 호출됨. 명시적으로 super()라고 사용 가능
- 부모 클래스의 생성자를 명시적으로 호출하려면 super() 를 사용하면 된다.

### 변수와 관련된 내용
- 부모 클래스에 private로 선언된 변수를 제외한 모든 변수가 자신의 클래스에 선언된 것처럼 사용 가능
- 부모 클래스에 선언된 변수와 동일한 이름을 가지는 변수 선언 가능, 하지만 권장하지 않는다.
- 부모 클래스에 선언되어 있지 않는 이름의 변수 선언 가능

### 메소드와 관련된 내용
- 변수처럼 부모 클래스에 선언된 메소드들이 자신의 클래스에 선언된 것처럼 사용할 수 있다.
- 부모 클래스에 선언된 메소드와 동일한 시그니처를 사용함으로써 메소드를 overriding 할 수 있다.
- 부모 클래스에 선언되어 있지 않은 이름의 새로운 메소드를 선언할 수 있다.
