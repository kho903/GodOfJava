# 자바랭 다음으로 많이 쓰는 애들은 컬렉션 - Part1(List)
## 자바 컬렉션
- 자료 구조는 영어로 "Data Structure"로 어떤 정보를 담는 것을 의미하는데, 하나의 데이터가 아닌 여러 데이터를 담을 때 사용.
- 자바에서 지금까지 알아본 것중에, String 객체들을 하나의 객체에 담으려면 어떻게 해야 할까?
  - int의 최댓값에 해당하는 크기의 배열을 만든다.
  - 배열의 크기가 부족하면, 필요한 개수만큼 더 큰 배열을 하나 더 만들어서 거기다 복사해 버린다.
- 등등의 방법이 있지만 1번 방법은 메모리 낭비가 엄청나게 발생하기 때문에, 하면 안 된다. 그리고, 자바에는 다음과 같은 문제를 해결하는 클래스를 미리 만들어 놓았다.
- 자바에서 데이터를 담는 자료 구조는 다음과 같이 분류 가능
  - 순서가 있는 목록(List) 형
  - 순서가 중요하지 않은 셋(Set) 형
  - 먼저 들어온 것이 먼저 나가는 큐(Queue) 형
  - 키-값(key-value)으로 저장되는 맵(Map) 형
- 목록, 셋, 큐는 Collection 이라는 인터페이스를 구현하고 있는데, 이 인터페이스는 java.util 패키지에 선언되어 있으며, 여러 개의 객체를 하나의 객체에 담아
처리할 때 공통적으로 사용되는 여러 메소드들을 선언해 놓았다.
- 클래스 구현은 다음과 같다.
  - Collection
    - Set
      - HashSet
        - LinkedHashSet
      - TreeSet
    - List
      - ArrayList
      - LinkedList
    - Queue
      - LinkedList
      - PriorityQueue
  - Map
    - HashMap
      - LinkedHashMap
    - TreeMap

- Collection 인터페이스는 다음과 같이 선언되어 있다.<br>
`public interface Collection<E> extends Iterable<E>`
- Iterable<E> 인터페이스를 확장 헀다는 점이 특이한데, Iterable 인터페이스에 선언되어 있는 메소드는 한 가지 이다.

| 리턴 타입       | 메소드 이름 및 매개 변수 |
|-------------|----------------|
| Iterator<T> | iterator()     |

    Iterator 인터페이스에는 추가 데이터가 있는지 확인하는 hasNext() 메소드, 현재 위치를 다음 요소로 넘기고 그 값을 리턴해주는 next() 메소드,
    데이터를 삭제하는 remove() 메소드가 있다.
- 따라서, Collection 인터페이스가 Iterable 인터페이스를 확장했다는 의미는, Iterator 인터페이스를 사용하여 데이터를 순차적으로 가져올 수 있다는 의미
- 메소드 목록은 다음과 같다. 여기서 요소는 영어로 Element, 컬렉션에 저장되는 각각의 데이터이다.

| 리턴 타입    | 메소드 이름 및 매개 변수          | 설명                                                                             |
|----------|-------------------------|--------------------------------------------------------------------------------|
| boolean  | add(E e)                | 요소를 추가                                                                         |
| boolean  | addAll(Collection)      | 매개 변수로 넘어온 컬렉션의 모든 요소를 추가                                                      |
| void     | clear()                 | 컬렉션에 있는 모든 요소 데이터를 지운다.                                                        |
| boolean  | contains(Object)        | 매개 변수로 넘어온 객체가 해당 컬렉션에 있는지 확인. 동일한 값이 있으면 true 리턴                              |
| boolean  | containsAll(Collection) | 매개 변수로 넘어온 객체들이 해당 컬렉션에 있는지 확인. 매개 변수로 넘어온 컬렉션에 있는 요소들과 동일한 값들이 모두 있으면 true 리턴 |
| boolean  | equals()                | 매개 변수로 넘어온 객체와 같은 객체인지 확인                                                      |
| int      | hashCode()              | 해시 코드 값 리턴                                                                     |
| boolean  | isEmpty()               | 컬렉션이 비어있는지 확인. 비어있으면 true 리턴                                                   |
| Iterator | iterator()              | 데이터를 한 건씩 처리하기 위한 Iterator 객체를 리턴                                              |
| boolean  | remove(Object)          | 매개 변수와 동일한 객체를 삭제                                                              |
| boolean  | removeAll(Collection)   | 매개 변수로 넘어온 객체들을 컬렉션에서 삭제                                                       |
| boolean  | retainAll(Collection)   | 매개 변수로 넘어온 객체들만을 컬렉션에 남겨 둔다.                                                   |
| int      | size()                  | 요소의 개수 리턴                                                                      |
| Object[] | toArray()               | 컬렉션에 있는 데이터들을 배열로 복사                                                           |
| <T> T[]  | toArray(T[])            | 컬렉션에 있는 데이터들을 지정한 타입의 배열로 복사                                                   |

## List 인터페이스와 그 동생들
- 배열과 비슷한 "목록"은 List 인터페이스로부터 시작되며, 이 List는 위의 Collection 인터페이스를 확장하였다. 따라서, 몇몇 추가된 메소드 외에 Collection 메소드와
큰 차이가 없다. 
- Collection을 확장한 다른 인터페이스와 List 인터페이스의 가장 큰 차이점은 배열처럼 "순서"가 있다는 것이다.
- List 인터페이스를 구현한 클래스 중 java.util 패키지에서 ArrayList, Vector, LinkedList가 많이 쓰인다.
- ArrayList, Vector는 "확장 가능한 배열"로 사용법이 거의 동일하고 기능도 거의 비슷하다. Vector는 JDK 1.0, ArrayList는 JDK 1.2에서 추가되었다.
둘의 차이점은 ArrayList는 Thread safe 하지 않고, Vector는 Thread safe 하다.
- Stack의 경우 Vector를 확장하여 만든 클래스로, LIFO (Last-In-First-Out, 선입선출)을 지원한다. 프로그래밍 언어에서 "스택"은 보통 메소드가 호출된
순서를 기억하는 장소를 말한다. a() 메소드가 b() 메소드를 호출하고, b() 메소드는 c() 메소드를 호출한다고 가정하면 "스택"에는 a() 메소드가 가장 아래에
깔려 있고, b(), c() 메소드 순으로 c() 메소드가 가장 위에 있는 구조가 된다. c() 메소드의 호출이 끝나면, 스택에는 더 이상 c()를 호출했다는 정보가 필요없다.
따라서 c()를 호출했다는 정보가 가장 먼저 빠져 나가고 스택에는 가장 밑에 a(), 그 위에 b()만 존재하게 된다.

## ArrayList에 대해서 파헤쳐보자
- 컬렉션, 쓰레드, IO, 네트워크 등의 관련 클래스를 사용할 때, 그 클래스의 상속 관계를 살펴보는 것이 좋다. 
  - 부모 클래스에 선언되어 있는 메소드 또한 사용가능하기 때문이다.
- ArrayList 클래스의 상속 관계는 다음과 같다.
```text
java.lang.Object
    - java.util.AbstractCollection<E>
        - java.util.AbstractList<E>
            - java.util.ArrayList<E>
```
- 가장 상위의 Objet 아래에 AbstractCollection, AbstractList 순으로 확장
- Abstract가 붙은 클래스는 abstract 클래스로, 일반 클래스와 비슷하지만, 몇몇 메소드는 자식에서 구현하라고 abstract로 선언한 메소드들이 있는 클래스.
따라서, AbstractCollection은 Collection 인터페이스 중 일부 공통 메소드를 구현해 놓은것, AbstractList는 List 인터페이스 중 일부 공통 메소드를 
구현해 놓은 클래스를 말한다.
- ArrayList가 구현한 모든 인터페이스는 다음과 같다.
```text
Serializable, Cloneable, Iterable<E>, Collection<E>, List<E>, RandomAccess
```
| 인터페이스         | 용도                                                              |
|---------------|-----------------------------------------------------------------|
| Serializable  | 원격으로 객체를 전송하거나, 파일에 저장할 수 있음을 지정                                |
| Cloneable     | Object 클래스의 clone() 메소드가 제대로 수행될 수 있음을 지정. 즉, 복제가 가능한 객체임을 의미   |
| Iterable<E>   | 객체가 "foreach" 문장을 사용할 수 있음을 지정                                  |
| Collection<E> | 여러 개의 객체를 하나의 객체에 담아 처리할 때의 메소드 지정                              |
| List<E>       | 목록형 데이터를 처리하는 것과 관련된 메소드 지정                                     |
| RandomAccess  | 목록형 데이터에 보다 빠르게 접근할 수 있도록 임의로 (random)하게 접근하는 알고리즘이 적용된다는 것을 지정 |

## ArrayList의 생성자는 3개다
| 생성자                                  | 설명                                                         |
|--------------------------------------|------------------------------------------------------------|
| ArrayList()                          | 객체를 저장할 공간이 10개인 ArrayList를 만든다.                           |
| ArrayList(Collection<? extends E> c) | 매개 변수로 넘어온 컬렉션 객체가 저장되어 있는 ArrayList를 만든다.                 |
| ArrayList(int initialCapacity)       | 매개 변수로 넘어온 initialCapacity 개수만큼의 저장 공간을 갖는 ArrayList를 만든다. |

```java
package _22.collection;

import java.util.ArrayList;

public class ListSample {
        public static void main(String[] args) {
                ListSample sample = new ListSample();
                sample.checkArrayList1();
        }

        public void checkArrayList1() {
                ArrayList list1 = new ArrayList();
                list1.add(new Object());
                list1.add("ArrayListSample");
                list1.add(new Double(1));
        }
}
```
- 매개 변수가 없는 기본 생성자를 이용해 list1 객체를 생성하고, add() 메소드로 데이터를 추가하였다.
- 하지만 보통 이렇게 서로 다른 종류의 객체를 하나의 배열에 넣지 않고, 한 가지 종류의 객체만 저장한다. 여러 종류를 하나의 객체를 담을 때에는 되도록이면
DTO라는 객체를 만들어 담는 것이 좋다. 따라서, 컬렉션 객체들은 제네릭을 사용해서 선언하는 것을 권장한다.
- 위 코드에 String만 담는 ArrayList로 바꾸어 보면 다음과 같다.
```java
ArrayList<String> list1 = new ArrayList<String>();
```
- 여기서 JDK 7 부터는 생성자 호출부에 <> 내의 타입은 따로 적지 않아도 된다.
```java
ArrayList<String> list1 = new ArrayList<>();
```
- 위 코드를 다음과 같이 고치면 컴파일 에러가 발생한다.
```text
_22/collection/ListSample.java:13: error: incompatible types: Object cannot be converted to String
                list1.add(new Object());
                          ^
_22/collection/ListSample.java:15: error: incompatible types: Double cannot be converted to String
                list1.add(new Double(1));
                          ^
Note: _22/collection/ListSample.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
2 errors
```
- 컴파일러 입장에서 list1 객체에 String 만 넣는다고 했으면서 Object, Double을 왜 넣냐면서 에러를 발생시키는 것이다. 이렇게 제네릭을 사용하여 
컴파일 시점에 잘못 지정한 부분을 걸러낼 수 있다.
- ArrayList 객체를 선언할 때 매개 변수를 넣지 않으면, 초기 크기는 10이다. 10개 이상의 데이터가 들어가면 크기를 늘리는 작업이 내부에서 자동 수행된다.
이러한 작업시 성능에 영향을 줄 수 있기 때문에, 어느 정도 예측 가능한 데이터 크기라면 다음과 같이 미리 지정해 두는 것이 좋다.
```java
ArrayList<String> list2 = new ArrayList<>(100);
```
## ArrayList에 데이터를 담아보자
- 메소드는 add() 와 addAll() 메소드만 알면 된다. 하나의 데이터를 담을 때에는 add(), Collection 객체를 한꺼번에 담을 때에는 addAll() 메소드

| 리턴 타입   | 메소드 이름 및 매개 변수                              | 설명                                       |
|---------|---------------------------------------------|------------------------------------------|
| boolean | add(E e)                                    | 매개 변수로 넘어온 데이터를 가장 끝에 담는다.               |
| void    | add(int index, E e)                         | 매개 변수로 넘어온 데이터를 지정된 index 위치에 담는다.       |
| boolean | addAll(Collection<? extends E> c            | 매개 변수로 넘어온 컬렉션 데이터를 가장 끝에 담는다.           |
| boolean | addAll(int index, Collection<? extends E> c | 매개 변수로 넘어온 컬렉션 데이터를 index에 지정된 위치부터 담는다. |

### add(E e)
- 이 메소드로 데이터 저장시, 배열의 가장 끝에 데이터를 담고, 제대로 추가 되었는지 여부를 boolean 타입으로ㅓ 리턴
- 해당 메소드 호출시, false가 떨어지는 경우는 거의 없다.

### add(int index, E e)
- index로 지정된 위치에 데이터를 담는다. 이 경우, 지정된 위치에 있는 기존 데이터들은 위치가 하나씩 뒤로 밀려난다.
```java
public void checkArrayList2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add(1, "A1");
}
```
- list라는 ArrayList 객체에 "A"부터 "E"저장하고, 마지막에 1번 위치에 "A1"을 저장한다.
- 만약 여기서 마지막 메소드에 1이 아닌 10을 넣어보면 정상적으로 컴파일이 된다. 하지만 실행시 다음과 같은 에러가 발생한다.
```text
Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 10, Size: 5
        at java.base/java.util.ArrayList.rangeCheckForAdd(ArrayList.java:788)
        at java.base/java.util.ArrayList.add(ArrayList.java:513)
        at _22.collection.ListSample.checkArrayList2(ListSample.java:26)
        at _22.collection.ListSample.main(ListSample.java:9)
```
- "ArrayList의 크기는 5인데, 10번째 값을 왜 찾냐"는 예외가 발생한다.
- 다음으로 향상된 for문으로 출력문을 작성해보면,
```java
for (String tempData : list) {
        System.out.println(tempData);
}
```
```text
A
A1
B
C
D
E
```
- 예상대로 결과가 출력된다. 1번째 위치에 A1이 출력되고, 나머지는 뒤로 밀린 것을 볼 수 있다.
- 다음으로 addAll() 예제를 보자.
```java
public void checkArrayList3() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add(1, "A1");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("0 ");
        list2.addAll(list);
        for (String tempData : list2) {
                System.out.println("List2 " + tempData);
        }
}
```
```text
List2 0 
List2 A
List2 A1
List2 B
List2 C
List2 D
List2 E
```
- "0 " 추가 이후에 list 내용들이 list2에 복사된 것을 볼 수 있다.
- list 값을 list2에 복사하는 방법은 다음과 같이 생성자를 사용하면 편리하다/
```java
ArrayList<String> list2 = new ArrayList<>(list);
```
- Collection을 매개 변수로 가진 생성자와 메소드는 왜 존재할까? 자바 개발시 매우 다양한 타입의 객체를 저장하는데, 꼭 ArrayList를 사용하여 데이터를
담아 처리하는 것은 아니고, Set, Queue 등을 사용하여 데이터를 담을수도 있으므로 이렇게 제공하는 것이다.

```java
public void checkArrayList4() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");

        ArrayList<String> list2 = list;
        list.add("Ooops");
        for (String tempData : list2) {
                System.out.println("List2 " + tempData);
        }
}
```
```text
List2 A
List2 Ooops
```
- list2를 list로 치환해버리면 list에 데이터를 추가하면 list2에도 데이터가 추가된 것을 볼 수 있다.
```text
list2 = list
```
- 이 문장은 list2가 list 값만 사용하겠다는 것이 아닌 list 객체가 생성되어 참조되고 있는 주소까지도 사용하겠다는 말이다.
- 자바는 메모리를 할당하고 해제하는 것에 대해 신경 쓸 필요가 없는 것이 단점이 될 수 있다. JVM에서 알아서 처리해 주기 때문에 주소에 대한 생각을 하지 않는다.
자바의 모든 객체가 생성되면 그 객체가 위치하는 주소가 내부적으로 할당된다. toString() 메소드를 구현하지 않은 클래스의 toString() 호출시 주소가 출력된다.
- 따라서 list2 = list 라고 작성하면, 두 객체의 변수는 다르지만, 하나의 객체가 변경되면 다른 이름의 변수를 갖는 객체의 내용도 바뀐다.
  - 이렇게 다른 객체에 원본 객체의 주소값만을 할당하는 것은 Shallow copy 라고 하고, 객체의 모든 값을 복사하여 복제된 객체에 있는 값을 변경해도 원본에 영향이
  없도록 할 때에는 Deep copy를 수행하는데, 이와 관련해 예를 들어 배열 복사를 위한 System 클래스에 arraycopy() 메소드가 존재한다.
- 따라서 하나의 Collection 관련 객체를 복사할 일이 있을 때에는 생성자 또는 addall()을 이용하면 된다.

## ArrayList에서 데이터를 꺼내자
- 먼저 ArrayList 객체에 들어가 있는 데이터의 개수를 가져오는 size() 메소드가 있다. 배열의 경우 배열.length 를 사용하고, String의 길이도 length()
메소드를 사용하는데, Collection을 구현한 인터페이스는 size() 메소드를 사용한다.
- 배열.length는 배열의 저장 공간 개수를 의미하지만, size() 메소드의 결과는 저장 공간의 개수가 아닌 들어가 있는 데이터의 개수이다.
```java
public void checkArrayList5() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        int listSize = list.size();
        for (int loop = 0; loop < listSize; loop++) {
                System.out.println("list.get(" + loop + ") = " + list.get(loop));
        }
}
```
```text
list.get(0) = A
list.get(1) = B
```
- for 루프 내에서 ArrayList 객체에 있는 값을 가져오기 위해 get() 메소드를 사용했다.
- 메소드를 정리해보자.

| 리턴 타입 | 메소드 이름 및 매개 변수        | 설명                                 |
|-------|-----------------------|------------------------------------|
| int   | size()                | ArrayList 객체에 들어가 있는 데이터의 개수를 리턴   |
| E     | get(int index)        | 매개 변수에 지정한 위치에 있는 데이터를 리턴          |
| int   | indexOf(Object o)     | 매개 변수로 넘어온 객체와 동일한 데이터의 위치를 리턴     |
| int   | lastIndexOf(Object o) | 매개 변수로 넘어온 객체와 동일한 마지막 데이터의 위치를 리턴 |

- indexOf()는 객체의 앞에서부터 찾을 때, lastIndexOf()는 뒤에서부터 찾을 필요가 있을 때 사용한다.
- ArrayList 객체에 있는 데이터들을 배열로 뽑아낼 필요가 있을 때에는 toArray() 메소드를 사용한다.

| 리턴 타입    | 메소드 이름 및 매개 변수 | 설명                                             |
|----------|----------------|------------------------------------------------|
| Object[] | toArray()      | ArrayList 객체에 있는 값들을 Object[] 타입의 배열로 만든다.     |
| <T> T[]  | toArray(T[] a) | ArrayList 객체에 있는 값들을 매개 변수로 넘어온 T 타입의 배열로 만든다. |

- 매개 변수가 없는 toArray() 메소드는 리턴타입이 Object[] 이므로, 제네릭을 사용한 ArrayList 객체를 배열로 생성할 때에는 두 번째 메소드가 추천된다.
```text
public void checkArrayList6() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        String[] strList = list.toArray(new String[0]);
        System.out.println(strList[0]);
}
```
```text
A
```
- 이와 같이 toArray() 메소드의 매개 변수로 변환하려는 타입의 뱌열을 지정해주면 된다. 여기서 주의할 점은 매개 변수로 넘기는 배열의 객체에 값을 담아주어야 한다.
- 하지만, ArrayList 객체의 데이터 크기가 매개 변수로 넘어간 배열 객체의 크기보다 클 경우 매개 변수로 배열의 모든 값이 null로 채워진다.
```java
public void checkArrayList7() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        String[] tempArray = new String[3];
        String[] strList = list.toArray(tempArray);
        for (String temp : strList) {
                System.out.println(temp);
        }
}
```
```text
A
B
C
```
- 정상적으로 출력된다. 배열 크기를 5로 변경하고 실행해 보자.
```java
String[] tempArray = new String[5];
```
```text
A
B
C
null
null
```
- 3개의 데이터는 정상적으로 들어가지만, 나머지 값들은 모두 null로 저장되었다.

## ArrayList에 있는 데이터를 삭제하자
- 데이터 삭제 관련 메소드는 다음과 같다.

| 리턴 타입   | 메소드 이름 및 매개 변수             | 설명                                           |
|---------|----------------------------|----------------------------------------------|
| void    | clear()                    | 모든 데이터 삭제                                    |
| E       | remove(int index)          | 매개 변수에서 지정한 위치에 있는 데이터를 삭제하고, 삭제한 데이터를 리턴    |
| boolean | remove(Object o)           | 매개 변수에 넘어온 객체와 동일한 첫 번째 데이터를 삭제              |
| boolean | removeAll(Collection<?> c) | 매개 변수로 넘어온 컬렉션 객체에 있는 데이터와 동일한 모든 데이터를 삭제한다. |

- clear()는 ArrayList의 데이터들을 깨끗이 지운다. remove() 메소드는 get() 메소드와 마찬가지로 지정한 위치의 데이터를 리턴하지만, 그 위치의
데이터를 지우고 리턴한다.
- remove()는 매개 변수로 넘어 온 객체와 동일한 첫 번째 데이터만 삭제하지만, removeAll()는 매개 변수로 넘어온 컬렉션에 있는 데이터와 모든 데이터를 삭제한다.
```java
public void checkArrayList8() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("A");
        System.out.println("Removed " + list.remove(0));

        for (int loop = 0; loop < list.size(); loop++) {
                System.out.println("list.get(" + loop + ")=" + list.get(loop));

        }
}
```
```text
Removed A
list.get(0)=B
list.get(1)=C
list.get(2)=A
```
- 0 번째 값인 "A"를 삭제했고, 삭제한 값이 리턴했다.
```text
public void checkArrayList8() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("A");
        // System.out.println("Removed " + list.remove(0));
        System.out.println(list.remove("A"));
        for (int loop = 0; loop < list.size(); loop++) {
                System.out.println("list.get(" + loop + ")=" + list.get(loop));

        }
}
```
```text
true
list.get(0)=B
list.get(1)=C
list.get(2)=A
```
- remove("A")의 경우 "A" 값을 삭제하고, 그 결과인 true 값이 리턴되어 출력되었다. 하지만 마지막의 "A"는 삭제되지 않았다.
- 다음과 같이 추가해보자.
```text
public void checkArrayList8() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("A");
        // System.out.println("Removed " + list.remove(0));
        // System.out.println(list.remove("A"));
        ArrayList<String> temp = new ArrayList<>();
        temp.add("A");
        list.removeAll(temp);
        for (int loop = 0; loop < list.size(); loop++) {
                System.out.println("list.get(" + loop + ")=" + list.get(loop));

        }
}
```
```text
list.get(0)=B
list.get(1)=C
```
- "A"를 갖는 모든 데이터가 사라진 것을 볼 수 있다.
- 값을 변경하는 메소드는 다음과 같다.

| 리턴 타입 | 메소드 이름 및 매개 변수            | 설명                                                      |
|-------|---------------------------|---------------------------------------------------------|
| E     | set(int index, E element) | 지정한 위치에 있는 데이터를 두 번쨰 매개 변수로 넘긴 값으로 변경. 해당 위치에 있던 데이터 리턴 |
- 이 메소드가 없으면 특정 위치에 있는 데이터를 삭제하고, 그 위치에 데이터를 넣어야 할 것이다.
- 다음으로 trimToSize() 라는 메소드가 있는데, 이 메소드는 ArrayList 객체 공간의 크기를 데이터의 개수만큼으로 변경한다. 저장 할 수 있는 공간은
만들어 두었지만, 데이터가 저장되어 있지 않을 때 해당 공간을 없애버린다. 일반적으로 잘 사용하지 않지만, ArrayList를 원격으로 전송 또는 파일로 저장하는
일이 생겼을 때, 사용해서 데이터의 크기를 줄일 수 있다는 장점이 있따.
- 마지막으로 Vector는 ArrayList와 메소드는 상이하지만 거의 유사한 클래스인데, Vector는 Thread safe 하고, ArrayList는 그렇지 않다.
따라서 ArrayList를 여러 쓰레드에서 덤벼도 안전하게 만드려면 다음과 같이 객체를 생성해야 한다.
```java
List list = Collections.synchronizedList(new ArrayList());
```

## Stack 클래스는 뭐가 다른데?
- 마지막에 들어온 데이터를 가장 처음에 꺼내는 LIFO 기능을 구현하기 위한 클래스
- 이 클래스보다는 ArrayDeque 클래스가 더 빠르지만, 쓰레드에 안전하지 못하므로, 쓰레드에 안전한 LIFO 기능을 원한다면 Stack 클래스를 사용하면 된다.
- 상속관계는 다음과 같다.
```text
java.lang.Object
    - java.util.AbstractCollection<E>
        - java.util.AbstractList<E>
            - java.util.Vector<E>
                - java.util.Stack<E>
```
- Stack 클래스에서 구현한 인터페이스는 Serializable, Cloneable, Iterable<E>, Collection<E>, List<E>, RandomAccess로 ArrayList와 같다.
- Stack 클래스는 Vector를 상속 받았는데, 상속을 잘못 받은 클래스이지만, 자바의 하위 호환성을 위해 계속 유지하고 잇는 것이라고 생각하면 된다.
- 생성자는 다음과 같다.

| 생성자     | 설명                        |
|---------|---------------------------|
| Stack() | 아무 데이터도 없는 Stack 객체를 만든다. |

- 메소드는 다음과 같다.

| 리턴 타입   | 메소드 이름 및 매개 변수   | 설명                        |
|---------|------------------|---------------------------|
| boolean | empty()          | 객체가 비어있는지를 확인             |
| E       | peek()           | 객체의 가장 위에 있는 데이터를 리턴      |
| E       | pop()            | 객체의 가장 위에 있는 데이터를 지우고, 리턴 |
| E       | push(E item)     | 매개 변수로 넘어온 데이터를 가장 위에 저장  |
| int     | search(Object o) | 매개 변수로 넘어온 데이터의 위치 리턴     |

- peek()은 리턴만 하고, pop()은 지우고 리턴한다. 일반적인 Stack 클래스의 용도에는 pop()이 더 적합

```java
package _22.collection;

import java.util.Stack;

public class StackSample {
        public static void main(String[] args) {
                StackSample sample = new StackSample();
                sample.checkPeek();
        }

        public void checkPeek() {
                Stack<Integer> intStack = new Stack<>();
                for (int loop = 0; loop < 5; loop++) {
                        intStack.push(loop);
                        System.out.println(intStack.peek());
                }
                System.out.println("size=" + intStack.size());
        }
}
```
```text
0
1
2
3
4
size=5
```
- peek() 메소드로 가장 위의 값을 출력만 하였기 떄문에 size()는 5이다.
- pop()으로 변경하여 보자
```java
public void checkPeek() {
        Stack<Integer> intStack = new Stack<>();
        for (int loop = 0; loop < 5; loop++) {
                intStack.push(loop);
                //System.out.println(intStack.peek());
                System.out.println(intStack.pop());
        }
        System.out.println("size=" + intStack.size());
}
```
```text
0
1
2
3
4
size=0
```
- pop() 메소드로 데이터를 읽으면서 삭제하였으므로, size()의 결과가 0이 된다.
