# 이쯤에서 자바의 역사와 JVM에 대해서 알아보자
## 자바의 역사
- 1991년 자바의 모태 "Green" 프로젝트 - 제임스 고슬링, Mike Sheridan, Patrick Naughton 3명의 젊은이가 TV와 상호 작용 할 수 있는 것을 만들기 
위해 시작. 1992년 참나무의 단어를 따 "Oak"라는 언어로 시작
- 1995년 "Oak"에서 "자바 커피"를 본딴 "Java"로 바꾸고 자바 기술 시작. "Write Once, Run Anywhere" (WORA)라는 모토로, 여러 플랫폼에서 수행할 
수 있는 개발 언어 목표
- 1996년 JDK 1.0 출시. 1997년 JDK 1.1 3주만에 22만 다운로드 기록. (JDK : Java Development Kit)
- 1998년 12월 J2SE 라는 이름으로 바뀌고, J2SE 1.2 출시 (J2SE : Java 2 Standard Edition)
- 2000년 J2SE 1.3 출시. 2002년 J2SE 1.4 출시. 2004년부터 앞에 1.을 뺀 J2SE 5 출시
- 2006년 Java SE 6. 20011년 오랫동안 업그레이드 준비를 마친 Java SE 7. 그리고 2014년 3월에 Java SE 8 이 정식 릴리즈되었다.
- Java SE 6 까지는 Sun Microsystems 에서 자바와 자바에 대한 주요 스펙을 만들었지만, Java SE 7부터는 Oracle이 Sun Microsystems를
인수하여 지금에 이르렀다.

## JDK 플렛폼에 따른 차이
- 자바는 Sun, 즉 Oracle에서만 만들지 않고 우리나라에서 많이 사용하는 서버에는 IBM 및 HP, 그리고 Sun에서 만든 Solaris가 있다.
- 각 Java 버전에서 표준 문서가 만들어지면 그 기준에 해당하는 각 벤터에 맞는 JDK가 별도로 만들어진다.
- 어떤 OS에서 개발하든지 JDK의 버전만 맞으면 적용할 OS에서 컴파일만 하면 실행에 문제가 전혀 없다.
- 이외에 OpenJDK와 JRockit JDK가 있는데, OpenJDK는 말그대로 완전 오픈소스 버전이며, 우분투 리눅스에 설치되어있다. JRockit은 WebLogic 이라는
WAS 성능 최적화를 위한 JDK인데, 현재는 Oracle로 넘어갔다.

## JDK, J2SE, Java SE 외에 자바에서 사용되는 다른 용어들
- JDK : Java Development Kit
- J2SE : Java 2 Standard Edition
- Java SE : Java Standard Edition


- 여기서 Java 2에서 2가 빠진 이유는 Java SE 6 출시부터이며, 마케팅을 위해 부르기 쉽게 바꾸었다고 한다. 
- 자바를 개발하기 위해 설치를 하다 보면, JDK와 JRE로 분리되어 있다.
  - JDK : Java Development Kit
  - JRE : Java Runtime Environment
- JRE는 실행만을 위한 환경. JRE만 설치하면 자바를 컴파일하는 등의 각종 프로그램이 제외된 상태로 설치됨

## 자바 언어의 특징은 다음과 같다.
1. 자바는 "단순하고, 객체지향이며, 친숙"해야 한다. (It should be "simple, object-oriented and familiar")
- 여기서 이야기하는 단순함이란 자바에 대한 기본 컨셉을 배우는 것이 어렵지 않다는 것을 의미
- 자바는 처음 만들 때부터 객체지향으로 디자인되어 있다. 다형성, 캡슐화 등을 지원하지만, 객체지향 프로그램을 작성하지 않으면 물론 이러한 이점은 없다.
- 여러 기능들이 이미 API로 제공되어 있어 처음부터 모든 것을 만들 필요는 없다.
- C++과 비슷하지만, C++보다 쉽고 빠르게 개발할 수 있다는 장점

2. 자바는 "견고하며, 보안상 안전"하다. (It should be "robust and secure")
- 컴파일할 때와 실행할 때 문법적 오류에 대한 체크를 한다. 메모리 관리 모ㄹ이 매우 단순하고 C 계열의 포인터 개념이 없다. 따라서 매우 믿을 수 있고
  (reliable), 견고한 소프트웨어가 될 수 있도록 도와준다. 
- 분산환경에서 사용하기 위해 디자인되어 보안에네트워크 환경에서 클라이언트로 다운로드한 승인받지 않은 프로그램은 실행 불가능하도록 되어 있다.

3. 자바는 "아키텍처에 중립적이어야 하며 포터블"해야 한다. (It should be "architecture-neutral and portable")
- 자바로 작성한 프로그램은 매우 다양한 하드웨어 아키텍처에서 수행할 수 있도록 되어 있어, 아키텍처 중립적인 바이트 코드 생성. 따라서 자바 버전만 동일하다면
  동일한 프로그램은 어떤 플랫폼에서도 실행 가능, 동일한 결과가 나오며, 하드웨어와 소프트웨어 아키텍처에 따른 데이터 타입의 호환성에 문제 발생 X.

4. 자바는 "높은 성능"을 제공해야 한다. (It should execute with "high performance")
- 성능은 항상 고려해야 하는 부분인데, 자바는 실행 환경에서 최대한의 성능을 낼 수 있도록 되어 있다.
- 자동화된 가비지 컬렉터는 낮은 우선 순위의 쓰레드로 동작
- 네이티브한 언어로 작성한 부분을 자바에서 사용 가능

5. 자바는 "인터프리트 언어이며, 쓰레드를 제공하고, 동적인 언어"이다. (It should be "interpreted, threaded, and dynamic")
- 자바 인터프리터는 자바 바이트 코드를 어떤 장비에서도 수행할 수 있도록 해주어, 무거운 컴파일과 링크와 테스트 사이클 개발 환경보다 빠른 환경 구축 가능
- 멀티 쓰레드 환경 제공하여 동시에 여러 작업 수행 가능
- 자바 컴파일러는 컴파일시 매우 엄격한 정적인 점검 수행 및 실행시, 동적으로 필요한 프로그램 링크, 새로운 코드는 다양한 소스에서 요청에 의해서 연결 가능

## 자바의 버전별 차이
### JDK 1.0
- 가장 최초의 버전. JDK 1.0.2는 최초의 안정 버전이며 Java 1이라고 불림

### JDK 1.1에 추가된 것들
- AWT의 이벤트 모델의 확장 및 변경
  - AWT: Abstract Window Toolkit. 자바 UI 구성 기반 기술
- 내부 클래스 (inner class) 추가
- JavaBeans, JDBC, RMI 등 추가
  - JavaBeans : 자바에서 제공하는 컴포넌트 모델 중 하나
  - JDBC : Java Database Connectivity 자바에서 데이터베이스에 데이터를 담기 위한 API
  - RMI : Remote Method Invocation. 같은 JVM에 있는 메소드를 호출하는 것이 아니라, 원격 JVM 메소드 호출 기술

### JDK 1.2에서 달라진 것들과 추가된 것들
JDK 1.2 ~ 1.5는 J2SE로 불렸고, 새로운 자바라는 의미의 Java 2라는 이름이 생겼다.
- strictfp 예약어 추가
- GUI 제공 위한 Swing 이 코어 라이브러리에 추가
- JIT라는 컴파일러가 Sun JVM에 추가
  - Just-In-Time 약자로 어떤 메소드 일부 또는 전체를 네이티브 코드로 변환하여 JVM에서 번역하지 않도록 해 성능을 향상시키는 기술
- 자바 플러그인 (Java Plug-in) 추가
- CORBA 라는 기술 (지금 별로 사용 X)과 데이터를 주고 받기 위한 IDL 추가
- 자바에서 각종 자료 구조 쉽게 처리 위한 Collections 라는 프레임워크 추기

### JDK 1.3에서 추가된 것들
- HotSpot JVM 공식적인 추가
- CORBA와의 호환성 위한 RMI 수정
- 사운드 처리 위한 JavaSound 라이브러리 추가
- JNDI (Java Naming and Directory Interface) 코어 라이브러리에 추가
  - 어떤 객체를 쉽게 찾을 수 있도록 도와주는 이름을 지정한 후, 나중에 그 이름으로 객체를 찾아가는 것을 의미.
  - 각종 주소를 쉽게 지정하기 위해 사용
- 자바의 디버깅을 보다 쉽게 하기 위한 JPDA (Java Platform Debugger Architecture) 추가
- Synthetic 프록시 클래스 추가

### JDK 1.4 버전에서 추가된 것들
자바 커뮤니티 프로세스(JSR) 절차에 따라서 개발된 첫 번째 릴리즈
- assert 예약어 추가
- Perl 정규 표현식을 따르는 정규 표현식 (regular expression) 추가
  - 정규 표현식 : 어떤 문자열이 특정 조건에 맞는 값이 있는지 확인하는 데 사용
- exception chaining 이라는 것을 통하여 하위 레벨의 예외의 캡슐화가 가능해짐
- IPv6 (Internet Protocol version 6) 지원 시작
- NIO (New Input / Output)라는 non-blocking 추가
  - 이전 버전까지의 IO 처리할 때 사용한 java.io 패키지에서 제공하는 기능의 단점 보완
- JPEG 이나 PNG와 같은 이미지를 읽고 쓰기 위한 image I/O API 추가
- 통합 XML 파서와 JAXP 라는 XSLT 프로세서 추가
- JCE, JSSE, JAAS 와 같은 통합 보안 및 cryptography extension cnrl
- Java Web Start 추가 (1.3에서 처음 소개)
- 각종 설정 값들을 저장하고 읽는 데 사용되는 Preferences API (java.util.prefs) 추가

### Java 5 버전에서 추가 및 향상된 점들
- 보다 안전하게 컬렉션 데이터를 처리할 수 있는 제네릭(generic) 추가
- 어노테이션(annotation)이라 불리는 메타데이터 (metadata) 기능 추가
- 기본 자료형과 그 기본 자료형을 객체로 다루는 클래스 간의 데이터 변환이 자동으로 발생하는 autoboxing 및 unboxing 기능 추가
  - int <-> Integer 자동 변환 예
- 상수 타입을 나타내는 enum 추가
- 매개 변수의 개수를 가변적으로 선언할 수 있는 varargs 추가 
  - String ... strs 형식의 매개 변수 선언
- 향상된 for 문 추가
- static import 추가
- 쓰레드 처리를 위한 concurrent 패키지 (java.util.concurrent) 추가
- 스트림이나 버퍼로 들어오는 데이터의 분석(parse)을 보다 간편하게 할 수 있는 Scanner 추가

### Java 6 버전에서 향상된 점들
많은 변화가 아닌 안정성과 확장성
- 스크립팅 언어가 JVM 위에서 수행 가능
- 각종 코어 기능의 성능 개선
- Compiler API 가 추가되어 프로그램에서 자바 컴파일러 실행 가능

### Java 7, 8
- Java 7, 8에서는 추가된 부분들이 많다. 별도로 정리
- Java 8 에서 가장 큰 변화는 람다 (lambda) 표현식이 가능해졌다.

## JIT 컴파일러는 도대체 뭘까?
- Just-In-Time 약자로, 자바, .NET 등에서 사용. 쉬운 말로 "동적 변환 (dynamic translation)"
- 프로그램을 보다 빠르게 하기 위해서 사용. 명칭이 컴파일러이지만, 실행시에 적용되는 기술
- 컴퓨터 프로그램을 실행하는 방식은 인터프리트 (interpret), 정적 (static) 컴파일 방식 두 가지이다. 
  - 인터프리트 방식 : 프로그램 실행시마다 컴퓨터가 알아 들을 수 있는 언어로 변환하는 작업 수행. 간편, 느림
  - 정적 컴파일 방식 : 실행 전 컴퓨터가 알아 들을 수 있는 언어로 변환하는 작업을 미리 실행해, 딱 한 번만 수행한다.
- JIT는 이 두 가지 방식 혼합. 변환 작업은 인터프리터에 의해 지속 수행. 필요한 코드의 정보는 캐싱 후 재사용
- javac 명령어를 사용해 컴파일 시, 컴파일을 하는 단계에서 만들어진 class라는 파일은 바이트 코드이다. 이 바이트 코드를 컴퓨터가 알아듣게
변환하는 작업이 필요한데, 이 변환 작업을 JIT 컴파일러에서 한다고 보면 된다.
- JIT를 사용하면 반복적으로 수행되는 코드는 매우 빠른 성능을 보인다는 장점이 있지만, 반대로 처음에 시작할 때에는 변환 단계를 거쳐 성능이 느리다는 단점이
있다. 하지만 CPU 와 JDK 성능 향상으로 단점 또한 많이 개선됨

## HotSpot은 또 뭐야?
- JDK 1.3부터 HotSpot JVM이 제공되는데, 자바에서는 HotSpot 클라이언트 컴파일러와 HotSpot 서버 컴파일러의 두 가지 컴파일러를 제공한다.
- CPU 코어가 하나뿐인 사용자를 위해 만들어진 것이 HotSpot 클라이언트 컴파일러이다. 애플리케이션 시작 시간을 빠르게 하고, 적은 메모리를 점유하도록 한다.
- 코어가 많은 장비에서 애플리케이션을 돌리기 위한 HotSpot 서버 컴파일러는 애플리케이션 수행 속도에 초점이 맞추어져 있다.
- 2개 이상의 물리적 프로세서와 2GB 이상의 물리적 메모리를 만족하면 서버 장비로 인식한다. (Oracle JVM 기준)
- -client, -server 명령어를 포함하여 직접 지정도 가능 
  - `$ java -server Calculator`
- 이외에도 -Xms 옵션으로 시작크기 지정가능
  - `$ java -server -Xms512m Calculator`
- 윈도우 기준 디폴트로 클라이언트 컴파일러 사용

## 자바를 배우면 꼭 알아야 하는 용어
### JVM : Java Virtual Machine (자바 가상 머신)
- 작성한 자바 프로그램이 수행되는 프로세스 의미
- java 명령어로 실행시 JVM 위에서 동작
### GC : Garbage Collector (가비지 컬렉터)
- 자바의 메모리 관리를 JVM에서 알아서 하는데, 메모리 관리를 해주는 것을 "가비지 컬렉터"라고 부른다. 
- 가비지 : 사용하고 남아 있는 전혀 필요 없는 객체

## 자바의 GC는 어떻게 진행되나요?
- 어떤 객체를 생성하더라도 그 객체는 언젠가는 쓰레기가 되어 메모리에서 지워져야 한다. 만약 지워지지 않으면, 엄청난 메모리가 필요할 것이다.
- C를 사용할 때에는 메모리 해제 작업을 꼭 해주어야 하는데, 자바는 가비지 컬렉터에서 알아서 쓰레기들을 치워준다.
- Java 7 부터 공식적으로 G1 (Garbage First)라는 가비지 컬렉터를 제외한 나머지 JVM은 힙 공간에 객체들을 관리
- 가장 왼쪽의 Young 영역에는 젊은 객체 그 뒤의 Old 영역에는 늙은 객체가 자리잡고, Perm 영역에는 클래스나 메소드에 대한 정보가 쌓인다.
- Young 영역은 Eden과 두개의 Survivor 영역으로 나뉘고, 객체 생성 직후 Eden에 저장됨.
- 자바에서 메모리가 살아가는 과정은 다음과 같다.
  1. Eden 영역에서 객체가 생성된다.
  2. Eden 영역이 꽉 차면 살아있는 객체만 Survivor 영역으로 복사되고, 다시 Eden 영역을 채우게 된다.
  3. Survivor 영역이 꽉 차게 되면 다른 Survivor 영역으로 객체가 복사된다. 이때, Eden 영역에 있는 객체들 중 살아있는 객체들도 다른 Survivor
    영역으로 간다. 즉, Survivor 영역의 둘 중 하나는 반드시 비어있어야만 ㅎ나다.
- 이것을 마이너 GC 또는 영 GC 라고 한다. 
- 그러다가 오래 살아있는 객체들은 Old 영역으로 이동하는데, 지속적으로 이동하다가 Old 영역이 꽉 차면 GC가 발생하는데 이것을 메이저 GC, 풀 GC 라고 부름
- 영 GC가 일반적으로 더 작은 공간 할당, 객체들을 처리하는 방식의 차이로, 풀 GC보다 빠름. but, 전체 힙 영역을 영 영역으로 만들면 장애 발생 확률 높음
- 오라클 JDK 기준 GC 방식은 4가지가 있고 Java 7에서는 G1 포함 5가지 가비지 컬렉터가 있다.
  - Serial GC
  - Parallel Young Generation Collector
  - Parallel Old Generation Collector
  - Concurrent Mark & Sweep Collector (CMS)
  - G1 (Garbage First)
- WAS로 사용하는 JVM에서 사용하면 안 되는 것은 Serial GC. -client 옵션을 지정했을 때 사용되는데, WAS에서 사용 시 속도가 엄청 느려진다.
그 외 다른 GC들도 장단점이 존재해 어떤 것이 가장 적합한 지 이야기하기 어렵다.
