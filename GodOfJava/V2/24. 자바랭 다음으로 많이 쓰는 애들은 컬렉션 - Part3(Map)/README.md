# 자바랭 다음으로 많이 쓰는 애들은 컬렉션 - Part3(Map)
## Map이란?
- 자바에서의 Map은 키(Key)와 값(Value)으로 이루어져 있다.
- 키와 값이 1 : 1로 저장된다. 여기서 키는 해당 Map에서 중복되지 않는다. 만약 키가 다르고, 값이 동일하다면 Map 에서는 다른 것이다.

### Map 특징
1. 모든 데이터는 키와 값이 존재한다.
2. 키가 없이 값만 저장될 수는 없다.
3. 값 없이 키만 저장할 수도 없다.
4. 키는 해당 Map에서 고유해야만 한다.
5. 값은 Map에서 중복되어도 전혀 상관 없다.

### Map 인터페이스에 선언된 메소드들의 주요 기능
| 리턴 타입                | 메소드 이름 및 매개 변수                         | 설명                                             |
|----------------------|----------------------------------------|------------------------------------------------|
| V                    | put(K key, V value)                    | 첫 번째 매개 변수인 키를 갖는, 두 번째 매개 변수인 값을 갖는 데이터를 저장   |
| void                 | putAll(Map<? extends K, ? extends V> m | 매개 변수로 넘어온 Map의 모든 데이터를 저장                     |
| V                    | get(Object key)                        | 매개 변수로 넘어온 키에 해당하는 값을 넘겨준다.                    |
| V                    | remove(Object key)                     | 매개 변수로 넘어온 키에 해당하는 값을 넘겨 주며, 해당 키와 값은 Map에서 삭제 |
| Set<K>               | keySet()                               | 키의 목록을 Set 타입으로 리턴                             |
| Collection<V>        | values()                               | 값의 목록을 Collection 타입으로 리턴                      |
| Set<Map.Entry<K, V>> | entrySet()                             | Map 안에 Entry 라는 타입의 Set을 리턴                    |
| int                  | size()                                 | Map의 크기를 리턴                                    |
| void                 | clear()                                | Map의 내용을 지운다.                                  |
- Map을 사용할 때 꼭 기억해야 하는 것은
  - Map에 데이터를 넣는 put()
  - 데이터를 확인하는 get()
  - 데이터를 삭제하는 remove()

## Map을 구현한 주요 클래스들을 살펴보자
- Map 인터페이스를 구현한 클래스는 매우 많은데, HashMap, TreeMap, LinkedHashMap이 가장 유명하고, hashtable 이라는 것도 있다.
- hashtable 클래스는 Map 인터페이스를 구현하긴 했지만, 다른 클래스들과 다음과 같은 차이가 있다.
  - Map은 컬렉션 뷰(Collection view)를 사용하지만, hashtable은 Enumeration 객체를 통해서 데이터를 처리한다.
  - Map은 키, 값, 키-값 쌍으로 데이터를 순환하여 처리 가능, hashtable은 이 중에서 키-값 쌍으로 데이터를 순환하여 처리할 수 없다.
  - Map은 이터레이션 처리 도중 데이터를 삭제하는 안전한 방법 제공, hashtable은 제공하지 않는다.
- HashMap과 hashtable 클래스는 다음과 같은 차이가 있다.

| 기능                  | HashMap | hashtable |
|---------------------|---------|-----------|
| 키나 값에 null 저장 가능 여부 | 가능      | 불가능       |
| 여러 쓰레드 안전 여부        | 불가능     | 가능        |
- 이러한 차이들이 발생한 이유는 자바에 Collection 인터페이스는 JDK 1.2 부터 추가되었고, LinkedHashMap은 JDK 1.4부터 추가되었는데, 
hashtable은 JDK 1.0부터 만들어진 뒤, 이후 1.2에 Map에 맞추어 보완되었기 때문에 이런 차이가 있다.
- 더 중요한 것은 각 클래스의 특징이다. hashtable을 제외한 Map으로 끝나는 클래스들을 여러 쓰레드에서 동시에 접근하여 처리할 필요가 있을 때에는 
다음과 같이 선언하여 사용해야만 한다.
```java
Map m = Collections.synchronizedMap(new HashMap(...));
```
- 추가로, JDK 1.0부터 제공되는 Hashtable, Vector 클래스는 쓰레드 안전, JDK 1.2부터 제공되는 Collection 관련 클래스들은 위와 같은 처리 또는,
Concurrent가 포함된 클래스여야만 쓰레드 안전하게 사용할 수 있다. 
(JDK 1.5 부터 ConcurrentHashMap, CopyOnWriteArrayList 등이 java.util.concurrent 패키지에 추가됨)

## HashMap 클래스에 대해서 자세히 알아보자
- 상속 관계는 다음과 같다.
```text
java.lang.Object
    - java.util.AbstractMap<K, V>
        - java.util.HashMap<K, V>
```
- AbstractMap이라는 abstract 클래스 확장, 대부분의 주요 메소드는 AbstractMap 클래스가 구현해 놓았다.
- 다음과 같은 인터페이스를 구현.

| 인터페이스        | 용도                                                                |
|--------------|-------------------------------------------------------------------|
| Serializable | 원격으로 객체를 전송하거나, 파일에 저장할 수 있음을 지정                                  |
| Cloneable    | Object 클래스의 clone() 메소드가 제대로 수행될 수 있음을 지정.<br/>즉, 복제가 가능한 객체임을 의미 |
| Map<E>       | 맵의 기본 메소드 지정                                                      |

- HashMap 생성자는 다음과 같다.

| 생성자                                            | 설명                                                       |
|------------------------------------------------|----------------------------------------------------------|
| HashMap()                                      | 16개의 저장 공간을 갖는 HashMap 객체를 생성                            |
| HashMap(int initialCapacity, float loadFactor) | 첫 매개 변수의 저장 공간을 갖고, 두 번째 매개 변수의 로드 팩터를 갖는 Hashmap 객체를 생성 |
| HashMap(Mpa<? extends K, ? extends V> m)       | 매개 변수로 넘어온 Map을 구현한 객체에 있는 데이터를 갖는 HashMap 객체를 생성        |

- 대부분 매개 변수가 없는 생성자를 사용. but, 담을 데이터의 개수가 많은 경우, 초기 크기 지정 권장
- HashMap에 저장하는 키가 되는 객체를 직접 만들었을 때, 유의해야 하는 것이 있다. 키는 기본, 참조 자료형 모두 가능한데, int나 long 또는 String 클래스를
많이 사용한다. 직접 어떤 클래스를 만들어 키로 사용할 때에, Object 클래스의 hashCode(), equals() 메소드를 잘 구현해 놓아야만 한다.
- HashMap에 객체가 들어가면 hashCode() 메소드 결과 값에 따른 버켓이라는 목록 형태의 바구니가 만들어진다. 만약 다른 키인데, hashCode()가 같아, 
여러 개의 값이 들어가버릴 수 있다. 따라서 get() 메소드 호출시, hashCode() 결과 확인 -> 버켓에 들어간 목록에 데이터가 여러 개일 경우 equals()
메소드를 호출하여 동일한 값을 찾게 된다. 따라서, ide에서 제공하는 hashCode(), equals() 자동완성 기능을 활용해 꼭 구현하자.

## HashMap 객체에 값을 넣고 확인해보자
- 주요 메소드는 대부분 Map 인터페이스에 정의되어 있다.
```java
package _24.collection;

import java.util.HashMap;

public class MapSample {
        public static void main(String[] args) {
                MapSample sample = new MapSample();
                sample.checkHashMap();
        }

        public void checkHashMap() {
                HashMap<String, String> map = new HashMap<>();
                map.put("A", "a");
                System.out.println(map.get("A"));
                System.out.println(map.get("B"));
        }
}
```
```text
a
null
```
- 데이터를 넣을 때에는 put() 메소드를 활용한다. `map.put("A", "a");`은 키-값은 각각 "A", "a"이다. 
- 값을 꺼낼 때에는 get() 메소드를 사용하면 된다. `map.get("A")`으로 "a"가 출력되었고, 존재하지 않는 키로 get() 을 한 `map.get("B")`에서는
null이 출력되었다. 
- 이미 존재하는 키로 put()을 실행하면 어떻게 될까?
```java
map.put("A", "1");
System.out.println(map.get("A"));
```
```text
1
```
- 이미 존재하는 키로 값을 넣을 떄에는 기존의 값을 새로운 값으로 대치한다. 새로운 값을 추가하거나 기존 값을 수정할 때 모두 put()을 사용한다.

## HashMap 객체의 값을 확인하는 다른 방법들을 알아보자
- HashMap에 어떤 키가 있는지 확인하려면 keySet() 메소드를 사용한다. 리턴 타입은 Set이고 제네릭 타입은 키의 제네릭 타입과 동일하게 지정하면 된다.
```text
public void checkKeySet() {
      HashMap<String, String> map = new HashMap<>();
      map.put("A", "a");
      map.put("B", "b");
      map.put("C", "c");
      Set<String> keySet = map.keySet();
      for (String tempKey : keySet) {
              System.out.println(tempKey + "=" + map.get(tempKey));
      }
}
```
```text
A=a
B=b
C=c
```
- keySet 이라는 Set 타입 변수로 map의 keySet() 메소드 수행 결과를 할당
- keySet 는 HashMap에 담겨 있는 key의 값이 될 것이므로 for 루프 내에 map.get() 으로 값을 확인하였다.


- 결과의 순서는 일정하지 않을 것이다. 자바의 자료 구조 중에서 List, Queue만이 저장 순서가 중요하고, Set, Map은 데이터 추가 순서가 중요치 않다.
따라서 순서대로 결과가 출력되지 않는다.
- 만약 key가 필요하지 않고, 객체에 담겨 있는 값만 필요한 경우, values() 메소드를 사용하면 된다.
```java
public void checkValues() {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "a");
        map.put("C", "c");
        map.put("D", "d");

        Collection<String> values = map.values();
        for (String tempValue : values) {
                System.out.println(tempValue);
        }
}
```
```text
a
c
d
```
- values() 메소드로, HashMap에 담겨있는 값의 목록을 Collection 타입의 목록으로 받아왔다.
- 이렇게 데이터를 꺼내는 방법 외에 entrySet() 이라는 메소드를 사용할 수도 있다. Map에 선언된 Entry라는 타입의 객체를 리턴한다.
이 Entry에는 단 하나의 키/값 만이 저장된다. 따라서, getKey(), getValues()를 사용하면 키/값을 간단하게 가져올 수 있다.

```text
public void checkHashMapEntry() {
      HashMap<String, String> map = new HashMap<>();
      map.put("A", "a");
      map.put("B", "b");
      map.put("C", "c");
      map.put("D", "d");

      Set<Map.Entry<String, String>> entries = map.entrySet();
      for (Map.Entry<String, String> tempEntry : entries) {
              System.out.println(tempEntry.getKey() + "=" + tempEntry.getValue());
      }
}
```
```text
A=a
B=b
C=c
D=d
```
- map의 entrySet() 으로 호출하면 Set 타입으로 리턴. Set 내에는 Entry 타입으로 데이터가 저장됨
- 다음으로는 containsKey(), containsValue() 가 있다.
```text
public void checkContains() {   
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "a");
        map.put("B", "b");
        map.put("C", "c");
        map.put("D", "d");

        System.out.println(map.containsKey("A"));
        System.out.println(map.containsKey("Z"));
        System.out.println(map.containsValue("a"));
        System.out.println(map.containsValue("z"));
}
```
```text
true
false
true
false
```
- 무작정 get() 메소드로 확인하는 것보다 contains...() 메소드를 사용하는 것이 효과적이다.
- 다음으로는 remove()이다.
```text
public void checkRemove() {
        HashMap<String, String> map = new HashMap<>();
        map.put("A", "a");
        map.remove("A");
        System.out.println(map.size());
}
```
```text
0
```
- "A"를 키로 갖는 데이터를 삭제하는 방법은 `map.remove("A");`, 따라서, `map.size()`의 결과는 0

## 정렬된 키의 목록을 원한다면 TreeMap을 사용하자
- 가장 간단한 방법은 Arrays 클래스를 사용하는 것인데, 불필요한 객체가 생긴다는 단점이 있다. 이러한 단점을 보완하는 TreeMap 클래스가 있다.
- TreeMap은 저장하면서, 키를 정렬한다. 정렬 순서는 숫자, 알파벳 대문자, 소문자, 한글 순으로 String tnstjdhk rkxek. 
```java
package _24.collection;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapSample {
        public static void main(String[] args) {
                TreeMapSample sample = new TreeMapSample();
                sample.checkTreeMap();
        }

        public void checkTreeMap() {
                TreeMap<String, String> map = new TreeMap<>();
                map.put("A", "a");
                map.put("가", "e");
                map.put("1", "f");
                map.put("a", "g");
                Set<Map.Entry<String, String>> entries = map.entrySet();
                for (Map.Entry<String, String> tempEntry : entries) {
                        System.out.println(tempEntry.getKey() + "=" + tempEntry.getValue());
                }
        }
}
```
```text
1=f
A=a
a=g
가=e
```
- 위와 같이 TreeMap은 키를 정렬하여 저장한다. 매우 많은 데이터를 TreeMap을 이용하여 보관, 처리할 때에는 정렬 과정으로, HashMap보다 느릴 것이다. 하지만 데이터가
많지 않고, 정렬이 필요한 상황이라면 HashMap 보단 TreeMap을 권장한다.
- TreeMap은 SortedMap을 구현했다. 키가 정렬되었을 때의 장점은 firstKey(), lastKey(), higherKey(), lowerKey() 등의 메소드를 제공한다는 점이다.

## Map을 구현한 Properties 클래스는 알아두면 편리하다
- Properties 클래스는 Hashtable을 확장(extends)하였다. 기본적으로, 자바에서는 시스템의 속성을 이 클래스로 제공한다.
- 시스템 속성값 확인 방법은 다음과 같다.
```java
package _24.collection;

import java.util.Properties;
import java.util.Set;

public class PropertiesSample {
        public static void main(String[] args) {
                PropertiesSample sample = new PropertiesSample();
                sample.checkProperties();
        }

        public void checkProperties() {
                Properties prop = System.getProperties();
                Set<Object> keySet = prop.keySet();
                for (Object tempObject : keySet) {
                        System.out.println(tempObject + "=" + prop.get(tempObject));
                }
        }
}
```
```text
// ...
os.name=Mac OS X
java.vm.specification.version=11
sun.java.launcher=SUN_STANDARD
user.country=KR
sun.boot.library.path=/Library/Java/JavaVirtualMachines/zulu-11.jdk/Contents/Home/lib
sun.java.command=_24.collection.PropertiesSample
// ...
java.runtime.version=11.0.11+9-LTS
user.name=kimjihun
path.separator=:
os.version=12.5.1
java.runtime.name=OpenJDK Runtime Environment
file.encoding=UTF-8
java.vm.name=OpenJDK 64-Bit Server VM
java.vendor.version=Zulu11.48+21-CA
// ...
```
- 매우 많은 데이터를 출력한다. Hashtable을 확장한 클래스이기 떄문에 키값 형태로 저장되어 있다. 
- 여러 속성 중 많이 사용할 속성은 다음과 같다

| 속성                      | 설명                |
|-------------------------|-------------------|
| user.language           | 사용자의 사용 언어        |
| user.dir                | 현재 사용중인 기본 디렉토리   |
| user.home               | 사용자 계정의 홈 디렉토리    |
| java.io.tmpdir          | 자바에서 사용하는 임시 디렉토리 |
| file.encoding           | 파일의 기본 인코딩        |
| sun.io.unicode.encoding | 유니코드 인코딩          |
| path.separator          | 경로 구분자            |
| file.separator          | 파일 구분자            |
| line.separator          | 줄(line) 구분자       |

- 대부분 디렉토리나 파일 관련 값들이다. 이 값들은 IO 관련 클래스의 상수로 지정되어 있따. 
- Properties 클래스를 왜 사용할까? 메소드로 알아보자

| 리턴 타입 | 메소드 이름 및 매개 변수                                               | 설명                     |
|-------|--------------------------------------------------------------|------------------------|
| void  | load(InputStream inStream)                                   | 파일에서 속성을 읽는다.          |
| void  | load(Reader reader)                                          |                        |
| void  | loadFromXML(InputStream in)                                  | XML로 되어 있는 속성을 읽는다.    |
| void  | store(OutputStream out, String comments)                     | 파일에 속성을 저장한다.          |
| void  | store(Writer writer, String comments)                        |                        |
| void  | storeToXML(OutputStream os, String comment)                  | XML로 구성되는 속성 파일을 생성한다. |
| void  | storeToXML(OutputStream os, String comment, String encoding) |                        |

- 여기서 comments 매개 변수는 저장되는 속성 파일에 주석으로 저장된다.
- Properties 클래스의 객체에 시스템 속성뿐만 아닌 애플리케이션에서 사용할 여러 속성값들을 Properties 클래스를 사용하여 데이터를 넣고, 빼고, 저장하고,
읽어들일 수 있다. 
- 예제를 확인해보자
```java
public void saveAndLoadProperties() {
        try {
                String fileName = "test.properties";
                File propertiesFile = new File(fileName);
                FileOutputStream fos = new FileOutputStream(propertiesFile);
                Properties prop = new Properties();
                prop.setProperty("Writer", "Sangmin, Lee");
                prop.setProperty("WriterHome", "http://www.GodOfJava.com");
                prop.store(fos, "Basic Properties file.");
                fos.close();

                FileInputStream fis = new FileInputStream(propertiesFile);
                Properties propLoaded = new Properties();
                propLoaded.load(fis);
                fis.close();
                System.out.println(propLoaded);
        } catch (Exception e) {
                e.printStackTrace();
        }
}
```
- FileOutputStream은 파일에 저장할 때, FileInputStream은 파일에서 읽을 때, File 클래스는 파일을 다룰 때 사용한다.
- test.properties 파일이 user.dir 경로에 생겼을 것이다.
```text
#Basic Properties file.
#Tue Sep 13 17:32:14 KST 2022
WriterHome=http\://www.GodOfJava.com
Writer=Sangmin, Lee
```
- `.properties`라는 확장자로 끝나는 각종 설정 파일들은 모두 이와 같은 형식의 파일로 되어 있다. 지정한 키는 왼쪽, 값은 오른쪽에 표시된다.
- 위의 두 줄 # 주석 중 첫 번째 줄은 store() 메소드를 사용할 때 지정한 주석 값이 바로 여기에 저장되고, 다음 줄은 해당 파일이 생성된 날짜가 자동으로 찍힌다.
- 다음으로 XML로 파일을 저장하고 읽어보자.
```java
public void saveAndLoadPropertiesXML() {
        try {
                String fileName = "text.xml";
                File propertiesFile = new File(fileName);
                FileOutputStream fos = new FileOutputStream(propertiesFile);
                Properties prop = new Properties();
                prop.setProperty("Writer", "Sangmin, Lee");
                prop.setProperty("WriterHome", "http://www.GodOfJava.com");
                prop.storeToXML(fos, "Basic XML Property file.");
                fos.close();

                FileInputStream fis = new FileInputStream(propertiesFile);
                Properties propLoaded = new Properties();
                propLoaded.loadFromXML(fis);
                System.out.println(propLoaded);
                fis.close();
        } catch (Exception e) {
                e.printStackTrace();
        }
}
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE properties SYSTEM "http://java.sun.com/dtd/properties.dtd">
<properties>
<comment>Basic XML Property file.</comment>
<entry key="WriterHome">http://www.GodOfJava.com</entry>
<entry key="Writer">Sangmin, Lee</entry>
</properties>
```
- properties 태그 내에 감싸여 있는 다른 태그들을 보면, 저장 할 때 사용한 주석은 comments 태그 내에 저장됨. 그리고 각 키와 값으로 선언되어 있는 값들은
entry 태그 내에 선언되어 있다.

## 자바의 자료 구조를 정리해보자
- Collection을 구현한 것은 List, Set, Queue 이며, Map은 별도의 인터페이스로 되어 있다.
- 배열처럼 목록 처리를 위한 List의 대표적인 클래스는 ArrayList, LinkedList가 있으며, ArrayList를 많이 사용
- 목록을 처리하지만, 데이터의 중복이 없고, 순서가 필요 없는 Set의 대표적인 클래스는 HashSet, TreeSet, LinkedHashSet이 있다.
- 데이터가 들어온 순서대로 처리하는 Queue의 대표적인 클래스는 KinkedList, PriorityQueue 등이 있으며, LinkedList는 List, Queue 둘 모두에 속한다.
- Map의 대표적인 클래스에는 HashMap, TreeMap, LinkedHashMap이 있으며, 대부분 HashMap을 많이 사용한다.
- Map은 keySet() 메소드로 키 목록의 Set 타입을 얻을 수 있고, values() 메소드를 통해 Collection 타입의 값 목록을 얻을 수 있다.
- Collection 데이터 처리를 위해 for 루프를 비롯해, iterator() 메소드로 Iterator 객체를 얻어 처리 가능
