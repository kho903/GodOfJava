# 어노테이션이라는 것도 알아야 한다
## 어노테이션이란?
어노테이션(Annotation)은 클래스나 메소드 등의 선언시에 @를 사용하는 것이며, 메타데이터(Metadata)라고도 불림. JDK 5 부터 등장
어노테이션은
- 컴파일러에게 정보를 알려주거나
- 컴파일할 때와 설치 (deployment) 시의 작업을 지정하거나
- 실행할 때 별도의 처리가 필요할 때 사용


클래스, 메소드, 변수 등 모든 요소에 선언할 수 있다. 프로그램에 영향을 미칠수도 안 미칠수도 있다.

## 미리 정해져 있는 어노테이션들은 딱 3개뿐
자바 언어에는 사용하기 위해서 정해져 있는 어노테이션은 3개 (JDK 6 기준), 선언하기 위한 매타 어노테이션은 4개.
선언을 위해 존재하기 때문에 사용 가능한 어노테이션 3개는
- @Override
- @Deprecated
- @SuppressWarnings

### @Override
- 해당 메소드가 부모 클래스에 있는 메소드를 Override 했다는 것을 명시적으로 선언
- Override 할 때에는 메소드 이름과 매개 변수들을 동일하게 가져가야 하는데, 메소드가 많으면 어떤 것이 오버라이딩 한 것인지 알 수 없거나
매개 변수가 빠져 있을 수 있다. 따라서 "이 메소드는 Override 된 거니까 만약에 내가 잘못 코딩했으면 컴파일러가 알려줘"라는 것이다.
- Parent 클래스를 만들고 Override 해보자.
```java
package _17.annotation;

public class Parent {
        public Parent() {
                System.out.println("Parent Constructor");
        }

        public Parent(String name) {
                System.out.println("Parent(String) constructor");
        }

        public void printName() {
                System.out.println("printName() - Parent");
        }
}
```
```java
package _17.annotation;

public class AnnotationOverride extends Parent {
        @Override
        public void printName() {
                System.out.println("AnnotationOverride");
        }
}
```
- printName()을 AnnotationOverride 에 Override 하고 @Override로 명시해 주었다. 
- 다음으로 printName()에 매개 변수를 추가하고 컴파일 해본다.
```text
package _17.annotation;

public class AnnotationOverride extends Parent {
        @Override
        public void printName(String args) {
                System.out.println("AnnotationOverride");
        }
}
```
- 이렇게 변경하고 컴파일하면, 컴파일 에러가 발생한다.
```text
_17/annotation/AnnotationOverride.java:4: error: method does not override or implement a method from a supertype
        @Override
        ^
1 error
```
- 에러 메시지에는 "어노테이션으로 Override 한다고 했는데 그런 메소드가 부모 클래스에는 없다."라는 말이다. String을 매개 변수로 갖는 printName이 없으니
당연히 에러가 발생한다.
- 이처럼, 제대로 Override 했는지 확인하는 수단으로 사용할 수 있다.

### @Deprecated
- 미리 만들어져 있는 클래스나 메소드가 더 이상 사용되지 않는 경우에 사용
- "얘는 더 이상 사용하지 않으니까 그렇게 알아주고, 나중에 누가 이거 쓰면 경고 해줘." 라고 알려주는 것
```java
package _17.annotation;

public class AnnotationDeprecated {
        @Deprecated
        public void noMoreUse() {

        }
}
```
```java
package _17.annotation;

public class AnnotationSample {
        public void useDeprecated() {
                AnnotationDeprecated child = new AnnotationDeprecated();
                child.noMoreUse();
        }
}
```
```text
Note: _17/annotation/AnnotationSample.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
```
- Deprecated된 메소드를 컴파일하면, Deprecated API를 사용하는 메소드가 있으니 "-Xlint:deprecation"이라는 옵션을 추가하여 컴파일을 다시 해서 확인하라는
메시지가 나온다.
```shell
$ javac -Xlint:deprecation _17/annotation/AnnotationSample.java
_17/annotation/AnnotationSample.java:6: warning: [deprecation] noMoreUse() in AnnotationDeprecated has been deprecated
                child.noMoreUse();
                     ^
1 warning
```
- noMoreUse() 메소드가 Deprecated 되었으니 조심하라는 경고가 출력되고, 에러가 아닌 경고 이므로, 정상적으로 컴파일이 된다.
- 그냥 지우면 될 것을 왜 이런 어노테이션을 만들었을까?
- 메소드나 클래스를 참조하는 다른 개발자가 만든 프로그램이 변경된 사항을 모르고 있다면 컴파일 에러가 발생한다. 그러므로, 하위 호환성을 위해 Deprecated로 선언하고,
경고 메시지 알림을 준 후에 지우는 것이 바람직하다.

### @SuppressWarnings
- 컴파일러에서 컴파일 에러는 아니지만, 가끔 경고(warning)를 알리는 경우가 있다. 그럴 때 컴파일러에게 "얘는 내가 일부러 이렇게
코딩한 거니까 경고할 필요 없어"라고 이야기해주는 것

```java
package _17.annotation;

public class AnnotationSample {
        @SuppressWarnings("deprecation")
        public void useDeprecated() {
                AnnotationDeprecated child = new AnnotationDeprecated();
                child.noMoreUse();
        }
}
```
```shell
$ javac _17/annotation/AnnotationSample.java 

$ javac -Xlint:deprecation _17/annotation/AnnotationSample.java

```
- 하지만 이 어노테이션을 너무 남용할 경우 Deprecated된 메소드를 사용해도 모르고 넘어갈 수 있으니 유의해야 함

## 어노테이션을 선언하기 위한 메타 어노테이션
메타 어노테이션은 어노테이션을 선언할 때 사용한다. 메타 어노테이션은 다음 4개가 존재. 꼭 이 4개를 모두 사용해야 하는 것은 아니지만 알아두면 좋다.
- @Target
- @Retention
- @Documented
- @Inherited

### @Target
- 어노테이션을 어떤 것에 적용할지를 선언할 때 사용
```java
@Target(ElementType.METHOD)
```
- 소괄호 안에 적용대상을 지정하는데 다음과 같다.

| 요소 타입          | 대상                           |
|----------------|------------------------------|
| CONSTRUCTOR    | 생성자 선언시                      |
| FIELD          | enum 상수를 포함한 필드(field) 값 선언시 |
| LOCAL_VARIABLE | 지역 변수 선언시                    |
| METHOD         | 메소드 선언시                      |
| PACKAGE        | 패키지 선언시                      |
| PARAMETER      | 매개 변수 선언시                    |
| TYPE           | 클래스, 인터페이스, enum 등 선언시       |

### @Retention
- 얼마나 오래 어노테이션 정보가 유지되는지 선언

|         | 대상                                                                        |
|---------|---------------------------------------------------------------------------|
| SOURCE  | 어노테이션 정보가 컴파일시 사라짐                                                        |
| CLASS   | 클래스 파일에 있는 어노테이션 정보가 컴파일러에 의해서 참조 가능함. 하지만 가상 머신(Virtual Machine) 에서는 사라짐 |
| RUNTIME | 실행시 어노테이션 정보가 가상 머신에 의해서 참조 가능                                            |

### @Documented
- 해당 "어노테이션에 대한 정보가 Javadocs(API) 문서에 포함된다는 것"을 선언한다.

### @Inherited
- 모든 자식 클래스에서 부모 클래스의 어노테이션을 사용 가능하다는 것을 선언한다.

## 어노테이션을 선언해보자
```java
package _17.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAnnotation {
        public int number();
        public String text() default "This is first annotation";
}
```
- `@Target`은 해당 어노테이션 사용 대상을 지정한다. 여기서는 메소드에 사용할 수 있다고 지정했다.
- `@Retention`은 어노테이션 유지 정보를 지정하는 데 사용한다. 여기서는 실행시에 이 어노테이션을 참조하게 된다.
- `@interface`로 선언하면 `@UserAnnotation`으로 어노테이션 사용이 가능해진다.
- number()와 text() 메소드가 있다. number()는 int, text()는 String이 리턴 타입이다. 이렇게 메소드처럼 선언하면 이 어노테이션을
사용할 때 해당 항목에 대한 타입으로 값을 지정 가능하다.
- text() 뒤의 default라는 예약어를 쓴 뒤 문자열이 지정되었는데, 값을 지정하지 않으면 default 값으로 지정된다.

```java
package _17.annotation;

public class UserAnnotationSample {
        @UserAnnotation(number = 0)
        public static void main(String[] args) {
                UserAnnotationSample sample = new UserAnnotationSample();
        }
        
        @UserAnnotation(number = 1)
        public void annotationSample1() {
        }

        @UserAnnotation(number = 2, text = "second")
        public void annotationSample2() {
        }

        @UserAnnotation(number = 3, text = "third")
        public void annotationSample3() {
        }
}
```
- 이렇게 메소드를 선언할 때 직접 만든 어노테이션을 사용할 수 있다. number()와 text() 에 해당하는 어노테이션 값들을 지정해 주면 된다.
- number()의 경우, default를 지정해 주지 않았기 때문에 반드시 값을 정해 주어야 한다.
- 현재 @Target(ElementType.METHOD)으로 지정한 상태에서 이 범위를 벗어나면 어떻게 될까? 클래스 범위에 선언해본다.
```java
package _17.annotation;

@UserAnnotation(number = 0)
public class UserAnnotationSample {
    //...
}
```
```text
_17/annotation/UserAnnotationSample.java:3: error: annotation type not applicable to this kind of declaration
@UserAnnotation(number = 0)
^
1 error
```
- @Target 내에 두 개 이상의 어노테이션을 선언할 때에는 중괄호를 한 후 쉼표(,)로 구분해 주면된다.
```java
@Target({ElementType.METHOD, ElementType.TYPE})
```

## 어노테이션에 선언한 값은 어떻게 확인하지?
- 일반적으로 확인할 일은 거의 없지만 그래도 확인하는 방법이 있다.

```java
package _17.annotation;

import java.lang.reflect.Method;

public class UserAnnotationCheck {
        public static void main(String[] args) {
                UserAnnotationCheck sample = new UserAnnotationCheck();
                sample.checkAnnotation(UserAnnotationSample.class);
        }

        public void checkAnnotation(Class useClass) {
                Method[] methods = useClass.getDeclaredMethods();
                for (Method tempMethod : methods) {
                        UserAnnotation annotation = tempMethod.getAnnotation(UserAnnotation.class);
                        if (annotation != null) {
                                int number = annotation.number();
                                String text = annotation.text();
                                System.out.println(tempMethod.getName() + "() : number = " + number + " text = " + text);
                        } else {
                                System.out.println(tempMethod.getName() + "() : annotation is Null");
                        }
                }
        }
}
```
```text
main() : number = 0 text = This is first annotation
annotationSample1() : number = 1 text = This is first annotation
annotationSample2() : number = 2 text = second
annotationSample3() : number = 3 text = third
```
- Class, Method는 자바의 리플렉션(Reflection)이라는 API에서 제공하는 클래스들이다. Class는 클래스의 정보, Method는 메소드의 정보를 확인하는데 사용.


- Class 클래스에 선언되어 있는 getDeclaredMethods()를 호출하면, 해당 클래스에 선언되어 있는 메소드 목록을 배열로 리턴
- Method 클래스에 선언되어 있는 getAnnotation()을 호출하면, 해당 메소드에 선언되어 있는 매개 변수로 넘겨준 어노테이션이 있는지 확인하고, 있으면
그 어노테이션의 객체를 리턴
- 어노테이션에 선언된 메소드를 호출하면 그 값을 리턴

## 어노테이션도 상속이 안돼요
- 어노테이션에서도 미리 만들어 놓은 어노테이션을 extends로 확장하는 것이 불가능하다. 
- 어노테이션은 용도에 따라 다음과 같이 나눈다.
  - 제약사항 등을 선언하기 위해 : @Deprecated, @Override, @NotNull
  - 용도를 나타내기 위해 : @Entity, @TestCase, @WebService
  - 행위를 나타내기 위해 : @Stateful, @Transaction
  - 처리를 나타내기 위햬 : @Column, @XmlElement
- 어노테이션이 탄생하기 전에는 모든 자바 애플리케이션 설정을 XML이나 properties 파일에 지정해왔는데, 복잡해지면서 어떤 설정이 어디에 쓰이는지 한눈에 알아보기 힘들어졌다.
- 이러한 어노테이션으로 코드에 대한 가돇헝이 매우 좋아졌다.
- 나중에 롬복이라는 라이브러리로 어노테이션 선언만으로 여러가지 편리한 기능을 사용할 수 있다.
