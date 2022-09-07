# 모든 클래스의 부모 클래스는 Object에요
## 모든 자바 클래스의 부모인 java.lang.Object 클래스
- 모든 클래스는 부모 클래스가 있다.
```java
package _12.inheritance;

public class InheritanceObject {
        public static void main(String[] args) {
                InheritanceObject object = new InheritanceObject();
                System.out.println(object.toString());  
        }
}
```
- extends로 직접 확장한 부모 클래스가 없으면 자바는 기본적으로 java.lang.Object 클래스를 확장한다.
- 이것을 알 수 있는 방법으로 Object 클래스에 있는 메소드를 사용하는 것이다.
- 위 코드에서 toString() 메소드를 실행해도 전혀 문제가 없었다.
- 자바는 한번에 이중 상속을 받을 수는 없지만 여러 단계로 상속받을 수는 있다. 부모클래스를 상속받은 자식 클래스의 경우 부모 클래스는 Object를 상속 받고,
자식 클래스는 부모 클래스를 상속 받으면 자동으로 Object 메소드들도 상속을 받을 수 있는 것이다. (다시 말해 자식의 자식이다.)
- 왜 모든 클래스는 Object 클래스의 상속을 받을까?
- Object 클래스에 메소드들을 정의하여 클래스의 기본적인 행동을 정의할 수 있기 때문이다.
- 클래스라면 "이 정도의 메소드는 정의되어 있어야 하고, 처리해 주어야 한다."는 것을 정의한 작업

## Object 클래스에서 제공하는 메소드들의 종류는?
- 객체를 처리하기 위한 메소드와 쓰레드를 위한 메소드로 나뉜다.
  - 쓰레드란 프로그램이 실행되는 작은 단위 중 하나.
- 객체 처리를 위한 메소드는 다음과 같다. "접근제어자 리턴타입 메소드이름(매개변수)" 순으로 나열

| 메소드                               | 설명                                                       | 
|-----------------------------------|----------------------------------------------------------|
| protected Object clone()          | 객체의 복사본을 만들어 리턴한다.                                       | 
| public boolean equals(Object obj) | 현재 객체와 매개 변수로 넘겨받은 객체가 같은지 확인. 같으면 true, 다르면 false 리턴    |
| protected void finalize()         | 현재 객체가 더 이상 쓸모가 없어졌을 때 가비지 컬렉터에 의해 이 메소드가 호출됨            | 
| public Class<?> getClass()        | 현재 객체의 Class 클래스의 객체를 리턴                                 | 
| public int hashCode()             | 객체에 대한 해시 코드 값을 리턴한다. 해시 코드란 "16진수로 제공되는 객체의 메모리 주소"를 말함 |
| public String toString()          | 객체를 문자열로 표현하는 값을 리턴                                      |

- 자바로 개발할 때에는 "넌 필요 없는 객체니까 죽어"라고 개발자가 직접 지정해 줄 수 없다. 이럴 때 필요한 것이 바로 가비지 컬렉터.
  - 자바의 메모리에 있는 쓰레기를 청소하는 로봇. 
- 쓰레드 처리를 위한 메소드는 다음과 같다.

| 메소드                                       | 설명                                                                                                         | 
|-------------------------------------------|------------------------------------------------------------------------------------------------------------|
| public void notify()                      | 이 객체의 모니터에 대기하고 있는 단일 쓰레드를 깨운다                                                                             | 
| public void notifyAll()                   | 이 객체의 모니터에 대기하고 있는 모든 쓰레드를 깨운다                                                                             |
| public void wait()                        | 다른 쓰레드가 현재 객체에 대한 notify() 메소드나 notifyAll() 메소드를 호출할 때까지 현재 쓰레드가 대기하고 있도록 한다                               |
| public void wait(long timeout)            | wait()과 동일. 매개 변수에 지정한 시간만큼 대기. 즉, 시간을 넘어서면 현재 쓰레드는 다시 깨어난다. 시간은 밀리초로 1/1,000초 단위                          |
| public void wait(long timeout, int nanos) | wait()과 동일. wait(timeout)에서 밀리초 단위의 대기시간이고 이 메소드는 밀리초 + 나노초(1/1,000,000,000초)만큼 대기. (나노초 범위 : 0 ~ 999,999) |

## Object 클래스에서 가장 많이 쓰이는 toString() 메소드
- 먼저 가장 많이 쓰이는 메소드 순서는 다음과 같다.
  - toString()
  - equals()
  - hashCode()
  - getClass()
  - clone()
  - finalize()
- toString() 메소드는 Object 클래스의 메소드 중에서 가ㅣ장 많이 사용되는데, 어떤 객체인지 쉽게 나타낼 수 있는 중요한 매소드
- 자동으로 호출되는 경우는
  - System.out.println()의 매개 변수로 들어가는 경우
  - 객체에 대하여 더하기 연산을 하는 경우
```java
package _12.inheritance;

public class ToString {
        public static void main(String[] args) {
                ToString thisObject = new ToString();
                thisObject.toStringMethod(thisObject);
        }

        public void toStringMethod(Object obj) {
                System.out.println(obj);
                System.out.println(obj.toString());
                System.out.println("plus " + obj);
        }
}
```
```text
_12.inheritance.ToString@7ad041f3
_12.inheritance.ToString@7ad041f3
plus _12.inheritance.ToString@7ad041f3
```
- 객체를 그냥 출력하는 것과 toString() 메소드를 호출하는 것은 동일한 것을 볼 수 있고, "plus " 뒤에 toString() 한 것과 동일한 결과가 출력되었다.
- 즉, String을 제외한 참조 자료형에 더하기 연산을 수행하면 자동으로 toString()이 호출되어 객체의 위치에는 String 값이 놓이게 된다.
- 위 코드는 객체에 대한 참조를 하는 'this'를 활용하여 보다 깔끔하게 작성할 수 있다.
```java
public void toStringMethod2() {
        System.out.println(this);
        System.out.println(toString());
        System.out.println("plus " + this);
}
```
- this 키워드를 사용하므로, 굳이 자기 자신을 나타내는 객체를 매개 변수로 넘겨주지 않아도 된다.
- 여기서 toString()으로 출력된 결과를 알아보자. 실제 Object 클래스에 구현되어 있는 toString() 메소드이다.
```java
getClas().getName() + '@' + Integer.toHexString(hashCode);
```
- Object 클래스에 있는 getClass() 결과에 getName() 메소드를 부르면 현재 클래스의 패키지 이름과 클래스 이름이 나온다.
- 그 다음 at`@`이 붙고, 객체의 해시 코드 값을 출력한다. hashCode() 메소드에서 int 타입을 리턴해주고, toHexString()으로 16진수로 변환한다.
- 이렇게 구현되어 있지만 원하는 대로 toString()을 활용하기 위해서 Overriding 해서 다시 구현해야 한다. 
```java
package _12.inheritance;

public class ToString {
        public static void main(String[] args) {
                ToString thisObject = new ToString();
                thisObject.toStringMethod(thisObject);
        }

        public void toStringMethod(Object obj) {
                System.out.println(obj);
                System.out.println(obj.toString());
                System.out.println("plus " + obj);
        }

        public String toString() {
                return "ToString class";
        }
}
```
```text
ToString class
ToString class
plus ToString class
```
- toString() 메소드 선언부(public), 리턴타입(String)을 맞추어 Overriding을 하고 실행한 결과.
- toString()을 Overriding 한 내용대로 출력된다. toString()은 언제 Overriding 해야 할까? 앞에서 보았던 DTO를 사용할 때, Overriding 하면 좋다.
```java
package _12.inheritance;

public class MemberDTO {
        private String name;
        public String phone;
        public String email;

        // ...

        public String toString() {
                return "Name=" + name + " Phone=" + phone + " eMail=" + email;
        }
}
```
- 실행 코드
```java
package _12.inheritance;

public class ToStringMemberDTO {
        public static void main(String[] args) {
                ToStringMemberDTO toString = new ToStringMemberDTO();
                toString.noToString();
                toString.toStringOverriding();
        }

        public void noToString() {
                MemberDTO dto = new MemberDTO("jihun", "01012345678", "gmldnr2222@naver.com");
                System.out.println("-----------noToString---------------");
                System.out.println("Name=" + dto.getName() + " Phone=" + dto.phone + " eMail=" + dto.email);
        }

        public void toStringOverriding() {
                MemberDTO dto = new MemberDTO("jihun", "01012345678", "gmldnr2222@naver.com");
                System.out.println("-----------toString---------------");
                System.out.println(dto);
        }
}
```
```text
-----------noToString---------------
Name=jihun Phone=01012345678 eMail=gmldnr2222@naver.com
-----------toString---------------
Name=jihun Phone=01012345678 eMail=gmldnr2222@naver.com
```
- toString()을 오버라이딩하여 더 간단하게 똑같은 결과를 나타낼 수 있다.
- 또한 변수가 수십개라고 하더라도, 이클립스, 인텔리제이와 같은 개발툴 (IDE)을 활용하면 toString()을 자동으로 만들 수 있다.

## 객체는 ==만으로 같은지 확인이 안 되므로, equals()를 사용하죠
- `==` 과 `!=`를 활용해 같은지 다른지 비교하는 연산을 할 수 있지만, 이 연산자는 기본 자료형에서만 가능
- 더 정확하게 말하면 사용할 수 있지만 "값"을 비교하는 것이 아닌 "주소값"을 비교한다.
```java
package _12.inheritance;

public class Equals {
        public static void main(String[] args) {
                Equals thisObject = new Equals();
                thisObject.equalMethod();
        }

        public void equalMethod() {
                MemberDTO obj1 = new MemberDTO("Sangmin");
                MemberDTO obj2 = new MemberDTO("Sangmin");
                if (obj1 == obj2) {
                        System.out.println("obj1 and obj2 is same");
                } else {
                        System.out.println("obj1 and obj2 is different");
                }
        }
}
```
```text
obj1 and obj2 is different
```
- MemberDTO 객체 obj1, obj2를 두개 모두 name이 Sangmin 이라고 넘겨주었지만 두 객체는 각각의 생성자를 사용하여 만들었기 때문에 주소값이 다르다.
그래서 결과는 다른 객체이다.
- equals() 메소드로 비교해보자.
```java
public void equalMethod2() {    
        MemberDTO obj1 = new MemberDTO("Sangmin");
        MemberDTO obj2 = new MemberDTO("Sangmin");
        if (obj1.equals(obj2)) {
                System.out.println("obj1 and obj2 is same");
        } else {
                System.out.println("obj1 and obj2 is different");
        }
}
```
```text
obj1 and obj2 is different
```
- equals()로 비교하긴 했지만, 비교 대상 객체인 MemberDTO 클래스에서 equals() 메소드를 Overriding 하지 않아 다음과 같은 결과가 나왔다.
- equals() 메소드 내에서는 hashCode()값을 비교해서, 해당 객체의 주소값을 비교하는데, 서로 다른 생성자로 객체를 생성했으면, 다를 수 밖에 없다.
- 이제 MemberDTO에서 equals() 메소드를 Overriding 하자.
```java
public boolean equals(Object obj) {
        if (this == obj) return true; // 주소가 같으므로 당연히 true
        if (obj == null) return false; // obj가 null이므로 당연히 false
        if (getClass() != obj.getClass()) return false; // 클래스의 종류가 다르므로 false;
        MemberDTO other = (MemberDTO) obj; // 같은 클래스이므로 형 변환 실행

        // 이제부터는 각 인스턴스 변수가 같은지 비교하는 작업 수행

        if (name == null) { // name이 null 일때
                if (other.name != null) return false; // 비교 대상의 name이 null이 아니면 false
        } else if (!name.equals(other.name)) return false;

        // name과 같은 비교 수행
        if (email == null) {
                if (other.email != null) return false;
        } else if (!email.equals(other.email)) return false;

        if (phone == null) {
                if (other.phone != null) return false;
        } else if (!phone.equals(other.phone)) return false;

        // 모든 난관을 거쳐 false를 리턴하지 않은 객체는 같은 값을 가지는 객체로 생각해서 true를 리턴
        return true;
}
```
- equals() 메소드를 Overriding() 할 때에는 다음 다섯가지의 조건을 만족시켜야만 한다.
1. 재귀 (reflexive) : null이 아닌 x라는 객체의 x.equals(x) 결과는 항상 true여야 한다.
2. 대칭 (symmetric) : null이 아닌 x와 y가 있을 때, y.equals(x)가 true 이면 x.equals(y)도 반드시 true 여야 한다.
3. 타동적 (transitive) : null이 아닌 x,y,z가 있을 때, x.equals(y)가 true, y.equals(z)가 true일 때, x.equals(z)는 반드시 true여야 한다.
4. 일관 (consistent) : null이 아닌 x와 y가 있을 때, 객체가 변경되지 않은 상황에서는 몇 번을 호출하더라도, x.equals(y)의 결과는 항상 true이거나
항상 false 여야 한다.
5. null과의 비교 : null이 아닌 x라는 객체의 x.equals(null) 결과는 항상 false 여야 한다.
- 한가지 유념해야 할 사항은 equals() 메소드를 Overriding 할 때에는 hashCode() 메소드도 같이 Overriding 해야 한다.
- equals() 메소드를 Overriding 해서 객체가 서로 같다고 이야기 할 수는 있지만 그 값이 같다고 해서 그 객체의 주소값이 같지는 않기 때문이다.
- 따라서 equals()의 결과가 true인 객체들의 hashCode()를 같게 하기 위해 Overriding 해서 재정의 해준다. (ide 자동 설정 사용)
```java
public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        return result;
}
```
- 위에서 알아본 equals() 메소드를 반드시 Overriding 할 필요는 없고, 꼭 필요할 때만 Overriding 하면 된다.

## 객체의 고유값을 나타내는 hashCode()
- Object 클래스에 선언된 메소드 중 toString()이 가장 많이 쓰이고 hashCode()는 보통 직접 구현할 일은 없다.
- hashCode() 메소드는 기본적으로 객체의 메모리 주소를 16진수로 리턴한다. 따라서, equals() 메소드를 override 하면 hashCode() 메소드도
override 하여 동일한 결과가 나오도록 만들어야 한다.
- 자바 API 문서에는 hashCode()를 Override 하기 위한 조건을 명시하고 있다.
  - 자바 애플리케이션이 수행되는 동안에 어떤 객체에 대해서 이 메소드가 호출될 때에는 항상 동일한 int 값을 리턴해 주어야 한다. 하지만 자바를 
    실행할 때마다 같은 값일 필요는 없다.
  - 어떤 두 개의 객체에 대하여 equals() 메소드를 사용하여 비교한 결과가 true일 경우에, 두 객체의 hashCode() 메소드를 호출하면 동일한 int 값을 리턴해야만 한다.
  - 두 객체를 equals() 메소드를 사용하여 비교한 결과 false 를 리턴했다고 해서, hashCode() 메소드를 호출한 int 값이 무조건 달라야 할 필요는 없다.
    하지만, 이 경우에 서로 다른 int 값을 제공하면 hashtable 의 성능을 향상시키는 데에 도움이 된다.
- 이러한 제약사항 때문에 직접 equals(), hashCode()를 작성하기 보다, 개발 툴에서 자동으로 생성해주는 기능을 사용하는 것이 좋다.
