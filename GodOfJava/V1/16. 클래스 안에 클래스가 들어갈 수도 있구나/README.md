# 클래스 안에 클래스가 들어갈 수도 있구나
## 클래스 안의 클래스
- 자바에서는 클래스 안에 클래스가 들어갈 수도 있는데, 이를 "Nested 클래스"라고 부름
- 가장 큰 이유는 코드를 간단하게 표현하기 위함. 자바 기반 UI 처리에서 주로 사용됨
- 선언 방법에 따라 "Static nested 클래스"와 "내부(inner) 클래스"로 구분됨 static으로 선언되어 있는 지의 여부에 따라 구분됨
- 내부 클래스는 또 이름이 있는 내부 클래스인 "로컬(지역) 내부 클래스 (local inner class)", 이름이 없는 "익명 내부 클래스 (anonymous inner class)"로
나뉜다. 간단하게 "내부 클래스", "익명 클래스"라고 부른다.

```java
package _16.inner;

public class PublicClass {

}

class JustNotPublicClass {

}
```
- 하나의 파일에 두가지 클래스를 포함시켰다. 파일 이름은 PublicClass.java로 public 으로 선언된 클래스의 이름을 따라야 한다.
- 여기서 JustNotPublicClass는 public한 클래스가 아닐 뿐, 내부 클래스가 아니다.
- Nested 클래스를 사용하는 이유는 다음과 같다.
  - 한 곳에서만 사용되는 클래스를 논리적으로 묶어서 처리할 필요가 있을 때 - Static Nested 클래스를 사용하는 이유
  - 캡슐화가 필요할 때 (예 : A라는 클래스에 private 변수가 있고, 이 변수에 접근하고 싶은 B라는 클래스를 선언하고, B 클래스를 외부에 노출시키고 싶지 않는 경우)
    즉, 내부 구현을 감추고 싶을 때 - 내부 (inner) 클래스 사용 이유
  - 소스의 가독성과 유지보수성을 높이고 싶을 때

## Static nested 클래스의 특징
- 내부 클래스는 감싸고 있는 외부 클래스의 어떤 변수도 접근 가능. (private 변수까지도 가능) 하지만, Static nested 클래스를 그렇게 사용하는 것은 불가능
```java
package _16.inner;

public class OuterOfStatic {
        static class StaticNested {
                private int value = 0;
                public int getValue() {
                        return value;
                }
                public void setValue(int value) {
                        this.value = value;
                }
        }
}
```
1. OuterOfStatic 클래스를 선언했다.
2. 내부에 static으로 선언된 StaticNested 클래스가 선언되어 있다. 그 안에는 인스턴스 변수의 값을 지정하고 조회하는 작업을 수행
- nested 클래스는 별도 컴파일이 필요없다. 이 파일을 컴파일하면 다음과 같이 두 개의 클래스가 만들어진다.
```text
OuterOfStatic.class
OuterOfStatic$StaticNested.class
```
- `클래스 이름$Nested 클래스 이름`으로 만들어진다. static nested 클래스의 객체는 다음과 같이 생성한다.
```java
package _16.inner;

public class NestedSample {

        public static void main(String[] args) {
                NestedSample sample = new NestedSample();
                sample.makeStaticNestedObject();
        }

        public void makeStaticNestedObject() {
                OuterOfStatic.StaticNested staticNested = new OuterOfStatic.StaticNested();
                staticNested.setValue(3);
                System.out.println(staticNested.getValue());
        }
}
```
```text
3
```
- `OuterOfStatic.StaticNested staticNested = new OuterOfStatic.StaticNested();`와 같이 감싸고 있는 클래스이름 뒤에 .(점)을 찍고
사용하면 된다. 이외에는 일반 클래스와 동일하다.
- Static nested 클래스는 왜 사용할까? 일반적인 이유로 클래스를 묶기 위해서다.
  - 예로 학교를 관리하는 School 클래스를 만들고 대학을 관리하는 University라는 클래스를 만들었을 때를 생각해보면 Student 클래스를 만들면 School
    의 학생인지 University의 학생인지가 불분명해진다. 하지만 School 내에 static nested 클래스로 Student 를 만든다면 이 클래스의 용도가 명확해진다.
    이렇게 하면 School.Student 클래스는 School 클래스에 만들었기 떄문에 University 클래스에서는 사용할 수가 없다.
- 겉으로 보기에는 유사하지만, 내부적으로 구현이 달라야 할 때, static nested 클래스를 사용

## 내부 클래스와 익명 클래스
```java
package _16.inner;

public class OuterOfInner {
        class Inner {
                private int value = 0;
                public int getValue() {
                        return value;
                }
                public void setValue(int value) {
                        this.value = value;
                }
        }
}
```
- StaticNested 와 Inner 클래스의 내부 내용을 동일하지만 static이 붙어 있지 않아 객체 생성 방법이 다르다.
```java
package _16.inner;

public class InnerSample {
        public static void main(String[] args) {
                InnerSample sample = new InnerSample();
                sample.makeInnerObject();
        }

        public void makeInnerObject() {
                OuterOfInner outer = new OuterOfInner();
                OuterOfInner.Inner inner = outer.new Inner();
                inner.setValue(3);
                System.out.println(inner.getValue());
        }
}
```
```text
3
```
- 객체를 생성한 다음에 사용 방법은 같지만 Inner 클래스의 객체를 생성하기 전에는 먼저 Inner 클래스를 감싸고 있는 OuterOfInner 클래스 객체를
만들어야 한다. 그 객체를 통해 Inner 클래스의 객체를 만들어 낼 수 있다.
- 이러한 내부 클래스를 만드는 이유는 캡슐화 때문이다. 하나의 클래스에서 공통 작업을 수행하는 클래스가 필요한데, 다른 클래스에서는 전혀 필요가
없을 때 사용한다. 내부 클래스는 GUI 프로그램에서 가장 많이 사용한다.
- GUI에서 주로 리스너(Listener) 처리할 때 많이 사용되는데, 사용자 버튼 클릭, 키보드 입력 등의 이벤트(Event) 처리를 위한 작업이다. 하나의 애플리케이션에서
이벤트 처리 작업은 대부분 달라 하나의 별도 클래스가 아닌 내부 클래스를 사용하는 것이 훨씬 편하다. 더 간단한 방법으로는 "익명 클래스"도 있다.
- 익명 클래스는 말 그래도 이름이 없는 클래스이다.

```java
package _16.inner;

public class MagicButton {
        public MagicButton() {

        }

        private EventListener listener;

        public void setListener(EventListener listener) {
                this.listener = listener;
        }

        public void onClickProcess() {
                if (listener != null) {
                        listener.onClick();
                }
        }
}
```
```java
package _16.inner;

public interface EventListener {
        public void onClick();
}
```
- 이 클래스들을 적용해보자. 먼저 익명 클래스를 사용하지 않고 적용해보자.
```java
package _16.inner;

public class AnonymousSample {
        public static void main(String[] args) {
                AnonymousSample sample = new AnonymousSample();
                sample.setButtonListener();
        }

        public void setButtonListener() {
                MagicButton button = new MagicButton();
                MagicButtonListener listener = new MagicButtonListener();
                button.setListener(listener);
                button.onClickProcess();
        }

        class MagicButtonListener implements EventListener {
                public void onClick() {
                        System.out.println("Magic Button Clicked!!");
                }
        }
}
```
- EventListener를 구현한 MagicButtonListener 클래스를 만들어 setListener() 메소드의 매개 변수로 넘겨주면 된다.
- 하지만 다음과 같이 클래스를 별도로 만들지 않고, 익명 클래스를 만들어 매개 변수로 넘겨줄 수도 있다.
```java
public void setButtonListenerAnonymous() {
        MagicButton button = new MagicButton();
        button.setListener(new EventListener() {
                public void onClick() {
                        System.out.println("Magic Button Clicked !!!");
                }
        });
        button.onClickProcess();
}
```
- setListener() 매개 변수로 new EventListener() 생성자 호출 후 바로 중괄호를 열어 메소드를 구현할 수 있다. 이것이 "익명 클래스"이다.
- setListener() 메소드가 호출되어 onClick() 메소드가 호출될 필요가 있을 때, 중괄호 내에 구현된 내용들로 실행된다. 이렇게 구현하면
클래스 이름도, 객체 이름도 없기 때문에 재사용을 하려면 다음과 같이 객체를 생성한 후 사용하면 된다.
```java
public void setButtonListenerAnonymousObject() {        
        MagicButton button = new MagicButton();
        EventListener listener = new EventListener() {
                public void onClick() {
                        System.out.println("Magic Button Clicked !!!");
                }
        };
        button.setListener(listener);
        button.onClickProcess();
}
```
- 자바에서 익명 클래스를 왜 제공할까?
- 우리가 클래스를 만들고, 그 클래스를 호출하면 그 정보는 메모리에 올라간다. 즉, 클래스를 많이 만들면 만들수록 메모리가 많이 필요해져 애플리케이션
시작 시 더 오래 걸린다. 따라서 자바에서는 이렇게 간단한 방법으로 객체를 생성할 수 있도록 해 놓았다.
- 익명 클래스와 내부 클래스 모두 재사용하지 않을 때만 주의해서 사용하면 된다.

## Nested 클래스의 특징은 꼭 알아야 한다.
- Nested 클래스에서 참조 가능한 변수들에 대해 알아야 한다.
```java
package _16.inner;

public class NestedValueReference {
        public int publicInt = 0;
        protected int protectedInt = 1;
        int justInt = 2;
        private int privateInt = 3;
        static int staticInt = 4;

        static class StaticNested {
                public void setValue() {
                        staticInt = 14;
                }
        }

        class Inner {
                public void setValue() {
                        publicInt = 20;
                        protectedInt = 21;
                        justInt = 22;
                        privateInt = 23;
                        staticInt = 24;
                }
        }

        public void setValue() {
                EventListener listener = new EventListener() {
                        public void onClick() {
                                publicInt = 30;
                                protectedInt = 31;
                                justInt = 32;
                                privateInt = 33;
                                staticInt = 34;
                        }       
                };
        }
}
```
- Static Nested 클래스에서는 감싸고 있는 클래스의 static 변수만 참조 가능. 부모 클래스의 static하지 않은 변수 참조 불가능 (참조시, 컴파일 에러)
- Static Nested 클래스와는 다르게, 내부 클래스 (여기서는 Inner 클래스)와 익명 클래스는 감싸고 있는 클래스의 어떤 변수라도 참조 가능
- 반대로 감싸고 있는 클래스에서 Static Nested 클래스의 인스턴스 변수나 내부 클래스의 인스턴스로의 접근도 가능
```java
package _16.inner;

public class ReferenceAtNested {
        static class StaticNested {
                private int staticNestedInt = 99;
        }

        class Inner {
                private int innerValue = 100;
        }

        public void setValue(int value) {
                StaticNested nested = new StaticNested();
                nested.staticNestedInt = value;
                Inner inner = new Inner();
                inner.innerValue = value;
        }
}
```
- 이렇게 각 클래스의 객체를 생성한 후 그 값을 참조하는 것은 가능 (private도 가능)
