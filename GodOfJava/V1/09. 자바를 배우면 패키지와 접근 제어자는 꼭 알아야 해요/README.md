# 자바를 배우면 패키지와 접근 제어자는 꼭 알아야 해요
## 패키지는 그냥 폴더의 개념이 아니에요
- 자바에는 패키지 (package)라는 것이 있는데, 사전적 의미는 "상자, 포장물"이라는 의미
- 작성한 클래스들을 구분 짓는 폴더와 비슷한 개념
- 중학교를 예를 들어 보면 다음과 같이 나타낼 수 있다.
```text
- 중학교
    - 1학년
        - 1반
        - 2반
        - 3반
    - 2학년
        - 1반
        - 2반
    - 3학년
        - 1반
        - 2반
```
- 이와 같은 다음과 같이 패키지를 만들어 보자.
- `.../godofjava/code/_09/javapackge/Package.java`
```java
package _09.javapackage;

public class Package {
        public static void main(String[] args) {
                System.out.println("Package class.");
        }
}
```
- 해당 파일을 컴파일 하기 위해서는 `.../godofjava/code`내에서 컴파일을 해야 정상적으로 동작
- 자바는 해당 패키지의 가장 상위 디렉터리, 즉, root 디렉토리에서 실행을 해야만 한다는 약속이 있다.
  - ...은 개인 랩탑의 경로이므로 생략
```shell
$ pwd
.../godOfJava/code
$ java _09.javapackage.Package 
Package class.
```
`_09/javapackge/Package.java`를 다시 살펴보면 가장 첫줄에 `package _09.javapackage;`이 바로 패키지 선언문이다. 패키지 선언에는 제약사항이 있다.
- 소스의 가장 첫 줄에 있어야 한다. (선언 위에 주석, 공백 있어도 상관은 없지만, 다른 자바 문장이 있을 경우 컴파일 오류)
- 패키지 선언은 소스 하나에는 하나만 있어야 한다.
- 패키지 이름과 위치한 폴더 이름이 같아야 한다. 다를 경우, javac 컴파일 시, 파일을 찾지 못한다.


- 패키지 이름을 지정할 때 유의점은 java로 시작하면 안 된다.
```java
package java;

public class JavaPackage {
}
```
```text
Error: A JNI error has occurred, please check your installation and try again
Exception in thread "main" java.lang.SecurityException: Prohibited package name: java
        at java.base/java.lang.ClassLoader.preDefineClass(ClassLoader.java:895)
        at java.base/java.lang.ClassLoader.defineClass(ClassLoader.java:1010)
        at java.base/java.security.SecureClassLoader.defineClass(SecureClassLoader.java:150)
        at java.base/jdk.internal.loader.BuiltinClassLoader.defineClass(BuiltinClassLoader.java:862)
        at java.base/jdk.internal.loader.BuiltinClassLoader.findClassOnClassPathOrNull(BuiltinClassLoader.java:760)
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClassOrNull(BuiltinClassLoader.java:681)
        at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:639)
        at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:520)
        at java.base/java.lang.Class.forName0(Native Method)
        at java.base/java.lang.Class.forName(Class.java:467)
        at java.base/sun.launcher.LauncherHelper.loadMainClass(LauncherHelper.java:780)
        at java.base/sun.launcher.LauncherHelper.checkAndLoadMain(LauncherHelper.java:675)
```
- `java.lang.SecurityException`이라는 것이 발생되었고, `Prohibited package name: java` 메세지가 나타난다.

## 패키지 이름은 이렇게 지어요.
- java : 자바 기본 패키지 (Java 벤더에서 개발)
- javax : 자바 확장 패키지 (Java 벤더에서 개발)
- org : 일반적으로 비 영리단체(오픈 소스)의 패키지
- com : 일반적으로 영리단체(회사)의 패키지
- 꼭 지켜야 하는 것은 아니지만 보통 이렇게 시작된다.
- 유의점은 다음과 같다.
  - 패키지 이름은 모두 소문자로 지정해야 한다. 반드시는 아니지만 그렇게 약속되어 있고, 대부분 소문자로 사용
  - 자바의 예약어를 사용하면 절대 안된다.

## import를 이용하여 다른 패키지에 접근하기
- 자바에서는 같은 패키지 내 및 java.lang 패키지에 있는 클래스들만 찾을 수 있다.
- 다른 패키지에 있는 클래스에 접근하는 방법을 알아보자.
- 먼저 sub 디렉토리를 추가로 생성하고 Sub 클래스를 만든다.
```java
package _09.javapackage.sub;

public class Sub {
        public Sub() {

        }

        public void subClassMethod() {

        }
}
```
- javapackage 내에 있는 Package 클래스에서 Sub 클래스 객체를 생성하고, 메소드를 호출한다.
```java
package _09.javapackage;

public class Package {
        public static void main(String[] args) {
                // System.out.println("Package class.");
                Sub sub = new Sub();
                sub.subClassMethod();
        }
}
```
```text
_09/javapackage/Package.java:6: error: cannot find symbol
                Sub sub = new Sub();
                ^
  symbol:   class Sub
  location: class Package
_09/javapackage/Package.java:6: error: cannot find symbol
                Sub sub = new Sub();
                              ^
  symbol:   class Sub
  location: class Package
2 errors
```
- 위와 같은 컴파일 에러가 발생한다.
- `cannot find symbol`은 Sub 클래스를 찾지 못했다는 의미이다. 즉, 다른 패키지의 클래스는 찾지 못한다는 것이다.
- `import` 예약어를 이용해 보자.
```java
package _09.javapackage;

import _09.javapackage.sub.Sub;

public class Package {
        public static void main(String[] args) {
                // System.out.println("Package class.");
                Sub sub = new Sub();
                sub.subClassMethod();
        }
}
```
- import 단어 뒤에 "패키지이름.클래스이름"을 명시하면 해당 패키지 내의 클래스를 컴파일러에게 알려주고, 컴파일을 한다.
- 위와 같이 컴파일 하면 sub 패키지 내의 Sub 클래스도 같이 컴파일된다.
- import 하고 싶은 패키지 내의 모든 클래스를 import 하는 것 역시 아래와 같이 가능하다.
  - 하위 클래스는 import 하지 않고, 해당 패키지에 선언된 클래스들만 import
```java
import _09.javapackage.sub.*;
```
### import static
- JDK 5 부터 추가된 import static 은 static한 변수(클래스 변수)와 static 메소두를 사용하고자 할 때 용이
- import static이 없다면 다음과 같이 사용해야 한다.
```java
package _09.javapackage;

import _09.javapackage.sub.SubStatic;

public class PackageStatic {
        public static void main(String[] args) {
                SubStatic.subStaticMethod();
                System.out.println(SubStatic.CLASS_NAME);
        }
}
```
- SubStatic 클래스에 선언된 subStaticMethod()를 사용하겠다는 것을 명시적으로 지정하기 위해 `SubStatic.subStaticMethod();`같이 사용
- import static으로 고쳐보자.
```java
package _09.javapackage;

// import _09.javapackage.sub.SubStatic;
import static _09.javapackage.sub.SubStatic.subStaticMethod;
import static _09.javapackage.sub.SubStatic.CLASS_NAME;

public class PackageStatic {
        public static void main(String[] args) {
                // SubStatic.subStaticMethod();
                // System.out.println(SubStatic.CLASS_NAME);
                subStaticMethod();
                System.out.println(CLASS_NAME);
        }
}
```
- import static을 활용하면 굳이 클래스 이름을 지정하지 않아도 PackageStatic 클래스에 선언된 것처럼 사용 가능하다.
- 다음과 같이 *를 사용하여 해당 클래스의 모든 것들을 static으로 지정할 수도 있다.
```java
import static _09.javapackage.sub.SubStatic.*;
```
- 만약 Package 클래스에 import 한 동일한 이름의 static 변수나 static 메소드나 자신의 클래스에 있으면 우선순위는 자신의 클래스 내에 있는
변수나 메소드가 우선이 된다.
- import를 하지 않아도 되는 패키지는 같은 패키지와 java.lang 패키지가 있다.
  - String, System 모두 java.lang 패키지에 있다.
- 마지막으로, 중요한 것은 상위 패키지에 있는 클래스와 하위 패키지에 있는 클래스의 상관관계는 자바 언어 상에서는 전혀 상관 관계가 없다.

## 자바의 접근 제어자
- 자바의 접근 제어자에는 4개가 있다.
```java
package _09.javapackage.sub;

public class AccessModifier {
        public void publicMethod() {
        }

        protected void protectedMethod() {
        }

        void packagePrivateMethod() {
        }

        private void privateMethod() {
        }
}
```
- public : 누구나 접근할 수 있도록 할 때 사용
- protected : 같은 패키지 내에 있거나 상속받은 경우에만 접근 가능
- package-private : 아무런 접근 제어자가 없으면 package-private 라고 불리며, 같은 패키지 내에 있을 때만 접근 가능
- private : 해당 클래스 내에서만 접근 가능하다.
```java
package _09.javapackage;

import _09.javapackage.sub.AccessModifier;

public class AccessCall {
        public static void main(String[] args) {
                AccessModifier accessModifier = new AccessModifier();
                accessModifier.publicMethod();
                accessModifier.protectedMethod();
                accessModifier.packagePrivateMethod();
                accessModifier.privateMethod();
        }
}
```

```text
_09/javapackage/AccessCall.java:9: error: protectedMethod() has protected access in AccessModifier
                accessModifier.protectedMethod();
                              ^
_09/javapackage/AccessCall.java:10: error: packagePrivateMethod() is not public in AccessModifier; cannot be accessed from outside package
                accessModifier.packagePrivateMethod();
                              ^
_09/javapackage/AccessCall.java:11: error: privateMethod() has private access in AccessModifier
                accessModifier.privateMethod();
                              ^
3 errors
```
- 다음과 같은 컴파일 에러를 발생시킨다.
- 에러 메시지에는 각 메소드에 대한 접근 (access) 권한에 대한 이야기를 하고 있다.
  - protected, package-private 접근자는 동일한 패키지 내에서만 접근 가능
  - private은 자신의 클래스에서만 접근 가능
- 왜 이런 접근 제어자를 만들었을까?
  - 어떤 메소드를 구현했는데, 다른 사람들이 그 메소드를 마음대로 호출하면 안 될 경우 접근 제어자로 통제할 수 있다.
  - 변수의 경우 직접 접근해서 변수를 변경하지 못하게 하고, 꼭 메소드를 통해서 변경이나 조회만 할 수 있도록 할 때, 많이 사용
```java
public class MemberDTO {
        private String name;

        // ...

        public MemberDTO(String name) {
                // 이름만 알 때;
                this.name = name;
        }

        //...

        public String getName() { // 조회용
                return name;
        }
}
```
- 다음과 같이 name은 private로 하고, 생성자로만 name 값을 지정할 수 있고, 조회를 위한 메소드 getName()을 만들 수 있다.
- 접근 제어자를 누가 접근할 수 있는 지 정리한 표는 다음과 같다.

|                   |  해당 클래스 안에서  |  같은 패키지 안에서  |  상속 받은 클래스에서  |  import한 클래스에서  |
|-------------------|:------------:|:------------:|:-------------:|:---------------:|
| public            |      O       |      O       |       O       |        O        |
| protected         |      O       |      O       |       O       |        X        |
| (package private) |      O       |      O       |       X       |        X        |
| private           |      O       |      X       |       X       |        X        |

## 클래스 접근 제어자 선언할 때의 유의점
- 메소드 외에 인스턴스 변수와 클래스 변수에도 접근 권한은 동일하게 적용됨
- 접근 제어자는 클래스 선언문에서도 사용. 몇가지 제약이 존재.
```java
package _09.javapackage;

class PublicClass {
        public static void main(String[] args) {
        }
}

class PublicSecondClass {
}
```
- 두 클래스 모두 package-private 으로 해도 컴파일은 정상적으로 되고, 클래스 파일이 두 개 생성된다.
- 다음과 같이 변경해 보자.
```java
package _09.javapackage;

public class PublicClass {
        public static void main(String[] args) {
        }
}

class PublicSecondClass {
}
```
- 클래스 파일 이름에 해당하는 클래스만 public 이기 때문에 전혀 문제가 없다. 하지만 다음과 같이 선언하면 안 된다.
```java
package _09.javapackage;

class PublicClass {
        public static void main(String[] args) {
        }
}

public class PublicSecondClass {
}
```
```text
_09/javapackage/PublicClass.java:8: error: class PublicSecondClass is public, should be declared in a file named PublicSecondClass.java
public class PublicSecondClass {
       ^
1 error
```
- PublicSecondClass 라는 클래스가 public 이므로, 이 클래스의 파일 이름은 PublicSecondClass.java 여야 한다.
- 즉, public으로 선언된 클래스가 있다면 해당 파일의 이름은 public 클래스 이름과 동일해야 한다.

## 정리
- 자바의 접근 제어자는 기억해야 하고, 메소드나 변수가 어디에서 사용될 것인지를 고려하여 접근 제어자를 지정해야만 한다.
