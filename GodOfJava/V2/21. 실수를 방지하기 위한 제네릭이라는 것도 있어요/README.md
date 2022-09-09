# 실수를 방지하기 위한 제네릭이라는 것도 있어요
## 실수를 방지할 수 있도록 도와주는 제네릭
- 예제 코드를 작성하면서, 실수 때문에 컴파일이 안 된 경우가 있다. 이클립스와 같은 에디터에서는 매우 쉽게 걸러낼 수 있다.
- 하지만, 이런 실수가 아닌 개발자가 미처 생각하지 못한 부분에서 프로그램이 예외를 발생시키는 경우가 있다. 이러한 경우 메소드 개발과 함께 JUnit과
같은 테스트 코드를 작성하는 것이 좋다.
- 그런데, 테스트를 하더라도, 개발자가 미처 생각지 못한 부분에 대해 테스트 케이스를 만들지 못할 수도 있다. 게다가 자바는 여러 타입들이 존재해,
형 변환에서 많은 예외가 발생할 수 있다.

```java
package _21.generic;

import java.io.Serializable;

public class CastingDTO implements Serializable {
        private Object object;

        public void setObject(Object object) {
                this.object = object;
        }

        public Object getObject() {
                return object;
        }
}
```
- 이렇게 private 변수, getter, setter, Serializable 구현을 구현해야만 제대로 DTO 클래스라고 할 수 있다.
```java
package _21.generic;

public class GenericSample {
        public static void main(String[] args) {
                GenericSample sample = new GenericSample();
                sample.checkCastingDTO();
        }

        public void checkCastingDTO() {
                CastingDTO dto1 = new CastingDTO();
                dto1.setObject(new String());

                CastingDTO dto2 = new CastingDTO();
                dto2.setObject(new StringBuffer());

                CastingDTO dto3 = new CastingDTO();
                dto3.setObject(new StringBuilder());
        }
}
```
- checkCastingDTO() 에서 dto1 ~ dto3 까지의 CastingDTO 클래스의 객체를 만들어 각각 String, StringBuffer, StringBuffer 객체를 각각
지정해도 문제없이 컴파일, 실행된다. Object는 모든 클래스의 부모 클래스이므로, 매개 변수로 어떤 참조 자료형을 넘겨도 상관 없다.
- 문제는 저장된 값을 꺼낼 때 발생. 각 객체의 getObject() 호출시, 리턴값은 Object 이므로 다음과 같이 형 변환을 해야 한다.
```text
String temp1 = (String)dto1.getObject(); 
StringBuffer temp2 = (StringBuffer)dto2.getObject(); 
StringBuilder temp3 = (StringBuilder)dto3.getObject();
```
- 그런데 만약, StringBuffer, StringBuilder 인지 혼동될 경우, instanceof 라는 예약어를 사용하여 점검할 수 있다.
```java
public void checkDTO(CastingDTO dto) {
        Object tempObject = dto.getObject();
        if (tempObject instanceof StringBuilder) {
                System.out.println("StringBuilder");
        } else if (tempObject instanceof StringBuffer) {
                System.out.println("StringBuffer");
        }
}
```
- 이렇게 번거롭게 타입을 점검하는 단점을 보완하기 위해 Java 5 부터 새롭게 추가된 제네릭(Generic)이라는 것이 있다.

## 제네릭이 뭐지?
- 형 변환에서 발생할 수 있는 문제점을 "사전"에 없애기 위해서 만들어짐. (실행시 예외 발생하는 것을 처리하는 것이 아니라, 컴파일할 때 점검할 수 있도록 한 것)
- CastingDTO 클래스에서 타입이 Object 이므로 어떤 타입이든 사용할 수 있는데, 이 클래스를 제네릭으로 선언하면 다음과 같다.
```java
package _21.generic;

import java.io.Serializable;

public class CastingGenericDTO<T> implements Serializable {
        private T object;
        public void setObject(T obj) {
                this.object = obj;
        }

        public T getObject() {
                return object;
        }
}
```
- 클래스 선언문에 꺽쇠가 열리고 닫힌 것(`<`, `>`)을 볼 수 있다. 그리고 타입 부분이 모두 T로 바뀌었다.
- T는 아무 이름이나 지정해도 컴파일하는 데 전혀 상관 없다. 하지만 자바에서 정의한 기본 규칙은 존재한다.
- 이렇게 선언한 클래스는 어떻게 사용할까?

```java
public void checkGenericDTO() {
        CastingGenericDTO<String> dto1 = new CastingGenericDTO<String>();
        dto1.setObject(new String());
        
        CastingGenericDTO<StringBuffer> dto2 = new CastingGenericDTO<StringBuffer>();
        dto2.setObject(new StringBuffer());
        
        CastingGenericDTO<StringBuilder> dto3 = new CastingGenericDTO<StringBuilder>();
        dto3.setObject(new StringBuilder());
}
```
- 별 차이없어 보인다. 오히려 객체 선언시 꺽쇠 안에 각 타입을 명시해줘서 더 복잡해 보일 수도 있지만 getObject()로 값을 가져올 때는 간단해진다.
```text
String temp1 = dto1.getObject();
StringBuffer temp2 = dto2.getObject();
StringBuilder temp3 = dto3.getObject();
```
- 각 제네릭 타입은 각각 String, StringBuffer, StringBuilder 이기 때문에 실수로 타입을 잘못 적으면 컴파일 자체가 되지 않는다. 따라서,
"실행시"에 다른 타입으로 잘못 형 변환하여 예외가 발생하는 일은 없다.

## 제네릭 타입의 이름 정하기
- 제네릭 타입 선언할 때에는 클래스 선언시 꺽쇠 안에 어떤 단어가 들어가도 상과없지만, 자바에서 정의한 기본 규칙은 있다.
  - E : 요소 (Element, 자바 컬렉션에서 주로 사용됨)
  - K : 키
  - N : 숫자
  - T : 타입
  - V : 값
  - S, U, V : 2, 3, 4 번째에 선언된 타입
- 꼭 지켜야 컴파일이 되는 규칙은 아니지만, 다른 사람의 이해를 돕기 위해 따르는 것이 좋다. 

## 제네릭에 ?가 잇는 것은 뭐야?
```java
package _21.generic;

public class WildcardGeneric<W> {
        W wildcard;
        public void setWildcard(W wildcard) {
                this.wildcard = wildcard;
        }
        public W getWildcard() {
                return wildcard;
        }
}
```
```java
package _21.generic;

public class WildcardSample {
        public static void main(String[] args) {
                WildcardSample sample = new WildcardSample();
                sample.callWildcardMethod();
        }

        public void callWildcardMethod() {
                WildcardGeneric<String> wildcard = new WildcardGeneric<String>();
                wildcard.setWildcard("A");
                wildcardStringMethod(wildcard);
        }

        public void wildcardStringMethod(WildcardGeneric<String> c) {
                String value = c.getWildcard();
                System.out.println(value);
        }
}
```
- callWildcardMethod() 메소드에서 방금 만든 WildcardGeneric 클래스에 String을 사용하는 제네릭한 객체 생성
- 생성한 객체로 wildcardStringMethod()를 호출할 때 넘겨준다.
- wildcardStringMethod() 에서는 해당 매개 변수를 받아서 결과를 출력한다.
- wildcardStringMethod() 에서 매개 변수는 반드시 String을 사용하는 WildcardGeneric 객체만 받을 수 있다. 만약 다른 타입으로 선언된
WildcardGeneric 객체를 받으려면 다음과 같은 방법이 존재한다.
```java
public void wildcardStringMethod(WildcardGeneric<?> c) {
        Object value = c.getWildcard();
        System.out.println(value);
}
```
- 이렇게 String 대신에 ?를 적어주면 어떤 타입이 제네릭 타입이 되더라도 상관 없다. 하지만, 메소드 내부에서는 해당 타입을 정확히 모르기 때문에 
값을 가져 올땐, Object로 처리해야 한다. ?로 명시한 타입을 wildcard 타입이라고 한다.
- 넘어 오는 타입이 두세가지라면 instanceof 예약어로 해당 타입을 확인할 수 있다.
- wildcard는 메소드의 매개 변수로만 사용하는 것이 좋다. wildcardStringMethod()를 호출한 callWildcardMethod() 에서 다음과 같이 사용한다면,
```text
public void callWildcardMethod() {
        WildcardGeneric<?> wildcard = new WildcardGeneric<String>();
        wildcard.setWildcard("A");
        wildcardStringMethod(wildcard);
}
```
```text
_21/generic/WildcardSample.java:12: error: incompatible types: String cannot be converted to CAP#1
                wildcard.setWildcard("A");
                                     ^
  where CAP#1 is a fresh type-variable:
    CAP#1 extends Object from capture of ?
```
- 다음과 같은 에러가 발생한다. 어떤 객체를 wildcard로 선언하고, 그 객체의 값은 가져올 수는 있지만, 와일드 카드로 객체를 선언했을 때에는
특정 타입으로 값을 지정하는 것이 불가능하다.

## 제네릭 선언에 사용하는 타입의 범위도 지정할 수 있다.
- <> 안에 어떤 타입도 상관없지만, wildcard로 사용하는 타입을 제한할 수는 있다. `?` 대신 `? extends 타입`으로 선택하는 것
```java
package _21.generic;

public class Car {
        protected String name;
        public Car(String name) {
                this.name = name;
        }
        public String toString() {
                return "Car name=" + name;
        }
}
```
```java
package _21.generic;

public class Bus extends Car {
        public Bus(String name) {
                super(name);
        }
        public String toString() {
                return "Bus name=" + name;
        }
}
```
```java
package _21.generic;

public class CarWildcardSample {
        public static void main(String[] args) {
                CarWildcardSample sample = new CarWildcardSample();
                sample.callBoundedWildcardMethod();
        }

        public void callBoundedWildcardMethod() {
                WildcardGeneric<Car> wildcard = new WildcardGeneric<Car>();
                wildcard.setWildcard(new Car("Mustang"));
                boundedWildcardMethod(wildcard);
        }

        public void boundedWildcardMethod(WildcardGeneric<? extends Car> c) {
                Car value = c.getWildcard();
                System.out.println(value);
        }
}
```
```text
Car name=Mustang
```
- `?` wildcard는 어떤 타입이 오더라도 상관이 없지만 `?` 대신 `? extends Car`라고 적어주면 제네릭 타입으로 Car 를 상속받은 모든 클래스를 사용할 수 있다는 의미.
따라서, boundWildcardMethod() 의 매개 변수에는 Car 클래스와 관련되어 있는 상속한 클래스가 넘어와야 한다.
```java
public void callBusBoundedWildcardMethod() {
        WildcardGeneric<Bus> wildcard = new WildcardGeneric<Bus>();
        wildcard.setWildcard(new Bus("6900"));
        boundedWildcardMethod(wildcard);
}
```
```text
Bus name=6900
```
- `? extends 타입`을 "Bounded Wildcards"라고 부른다. Bound는 "경계"라는 의미도 있어, 매개 변수로 넘어오는 제네릭 타입의 경계를 지정하는 데
사용한다는 의미로 해석 가능. 이것 역시 조회용으로는 사용 불가.

## 메소드를 제네릭하게 선언하기
- 앞서 wildcard로 메소드를 선언하는 방법에는 매개 변수로 사용된 객체에 값을 추가할 수 없었다. 다음과 같이 다른 방법이 있다.
```java
package _21.generic;

public class GenericWildcardSample {
        public static void main(String[] args) {
                GenericWildcardSample sample = new GenericWildcardSample();
        }

        public <T> void genericMethod(WildcardGeneric<T> c, T addValue) {
                c.setWildcard(addValue);
                T value = c.getWildcard();
                System.out.println(value);
        }
}
```
- 리턴 타입 앞에 <>로 제네릭 타입을 선언하고, 매개 변수에서는 그 제네릭 타입이 포함된 객체를 찾아서 처리하였다. 정상적으로 컴파일 된다.
- 호출 메소드는 다음과 같고, 다음과 같이 출력된다.
```text
public void callGenericMethod() {
        WildcardGeneric<String> wildcard = new WildcardGeneric<String>();
        genericMethod(wildcard, "Data");
}
```
```text
Data
```
- `?`를 사용하는 Wildcard 처럼 타입을 두루뭉실하게 하는 것보다 명시적으로 메소드 선언시 타입을 지정해 주면 보다 더 견고한 코드 작성 가능
- "Bounded Wildcards"처럼은 다음과 같이 사용 가능하다.<br>
`public <T extends Car> void boundedGenericMethod(WildcardGeneric<T> c, T addValue)`
- 제네릭 타입이 한 개 이상일 경우에는 콤마로 구분하여 나열하면 된다.<br>
`public <S, T extends Car> void multiGenericMethod(WildcardGeneric<T> c, T addValue, S another)`<br>
이렇게 하면, S, T라는 제네릭 타입을 메소드에서 사용 가능

