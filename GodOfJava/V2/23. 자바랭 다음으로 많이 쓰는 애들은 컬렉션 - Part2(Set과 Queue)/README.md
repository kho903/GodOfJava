# 자바랭 다음으로 많이 쓰는 애들은 컬렉션 - Part2(Set과 Queue)
## Set이 왜 필요하지?
- Collection을 확장한 배열과 비슷한 역할을 하는 3개의 인터페이스는 List, Set, Queue. 여기서 List는 순서가 중요한 데이터를 담을 때 사용
- Set은 순서에 상관 없이, 어떤 데이터가 존재하는지를 확인하기 위한 용도로 많이 사용됨. 중복을 방지하고, 원하는 값이 포함되어 있는지 확인하는 용도
- 자바에서 Set 인터페이스를 구현한 주요 클래스는 HashSet, TreeSet, LinkedHashSet이 있다.
  - HashSet : 순서가 전혀 필요 없는 데이터를 해시 테이블에 저장한다. Set 중 가장 성능이 좋음
  - TreeSet : 저장된 데이터 값에 따라 정렬되는 셋. red-black 이라는 트리 타입으로 값이 저장되며, HashSet 보다 약간 느림
    - red-black 트리는 각 노드의 색을 붉은색/검은색으로 구분하여 데이터를 빠르고, 쉽게 찾을 수 있는 구조의 이진(binary) 트리
  - LinkedHashSet : 연결된 목록 타입으로 구현된 해시 테이블에 데이터 저장. 저장된 순서에 따라 값이 정렬되며 성능이 셋 중 가장 느림
- HashSet은 별도의 정렬 작업이 없어 가장 빠르다.

## HashSet에 대해서 파헤쳐 보자
- HashSet의 상속 관계
```text
java.lang.Object
    - java.util.AbstractCollection<E>
        - java.util.AbstractSet<E>
            - java.util.HashSet<E>
```
- AbstractCollection을 확장한 것은 ArrayList와 동일. 하지만 HashSet은 AbstrcatSet을 확장. AbstractSet에는 구현되어 있는 메소드는
Object 클래스에 선언되어 있는 equals(), hashCode()와 이 클래스에서 추가한 removeAll() 뿐이다.
- Set은 무엇보다 데이터 중복을 불허하므로, 데이터가 같은지를 확인하는 작업은 Set의 핵심. equals()와 hashCode() 메소드는 서로 떨어질 수 없는
관계이므로 Set에서 매우 중요한 두 메소드이다.
- 추가로, removeAll() 메소드는 컬렉션을 매개 변수로 받아, 매개 변수 컬렉션에 포함된 모든 데이터를 지울 때 사용
- HashSet은 다음과 같은 인터페이스를 구현

| 인터페이스        | 용도                                                            |
|--------------|---------------------------------------------------------------|
| Serializable | 원격으로 객체를 전송하거나, 파일에 저장할 수 있음을 지정                              |
| Cloneable    | Object 클래스의 clone() 메소드가 제대로 수행될 수 있음을 지정. 즉, 복제가 가능한 객체임을 의미 |
| Iterable<E>  | 객체가 "foreach" 문장을 사용할 수 있음을 지정                                |
| Collection   | 여러 개의 객체를 하나의 객체에 담아 처리할 때의 메소드 지정                            |
| Set<E>       | 셋 데이터를 처리하는 것과 관련된 메소드 지정                                     |

- List에는 정의되어 있지만, Set에는 정의되어 있지 않는 메소드는 무엇이 있을까?
  - Set은 순서가 없다. 따라서 순서가 매개 변수로 넘어가는 메소드나, 수행 결가가 데이터의 위치와 관련된 메소드는 Set 인터페이스에서 필요없다.
  - 따라서, get(int index), indexOf(Object o)와 같은 메소드는 존재하지 않는다.

## HashSet의 생성자들도 여러 종류가 있다
| 생성자                                            | 설명                                                               |
|------------------------------------------------|------------------------------------------------------------------|
| HashSet()                                      | 데이터를 저장할 수 있는 16개의 공간과 0.75의 로드 팩터(load factor)를 갖는 객체를 생성       |
| HashSet(Collection<? extends E> c)             | 매개 변수로 받은 컬렉션 객체의 데이터를 HashSet에 담는다.                             |
| HashSet(int initialCapacity)                   | 매개 변수로 받은 개수만큼의 데이터 저장 공간과 0.75 로드 팩터를 갖는 객체를 생성                 |
| HashSet(int initialCapacity, float loadFactor) | 첫 매개 변수로 받은 개수만큼의 데이터 저장 공간과 두 번째 매개 변수로 받은 만큼의 로드 팩터를 갖는 객체를 생성 |

- 로드 팩터는  (데이터의 개수) / (저장 공간)을 의미. 데이터의 개수가 증가하여 로드 팩터보다 커지면, 저장 공간의 크기는 증가되고 해시 재정리 작업(refresh)을
해야만 한다. 해시 재정리 작업시, 내부 자료 구조를 다시 생성하는 단계를 거쳐야 하므로 성능에 영향을 미친다.
- 로드 팩터가 클수록 공간은 넉넉해지지만, 데이터를 찾는 시간은 증가하므로, 초기 공간 개수와 로드 팩터는 데이터의 크기를 고려하여 산정하는 것이 좋다. 초기 크기가
  (데이터 개수) / (로드 팩터)보다 클 경우 해시 재정리 작업이 발생하지 않기 때문이다. 따라서 대량의 데이터를 여기에 담아 처리할 때에는 초기 크기와 로드 팩터의
값을 조절해 가면서 가장 적당한 크기를 찾아야 한다.

## HashSet의 주요 메소드를 살펴보자
- HashSet은 부모 클래스인 AbstractSet과 AbstractCollection에 선언 및 구현되어 있는 메소드를 그대로 사용하는 경우가 많다.

| 리턴 타입       | 메소드 이름 및 매개 변수     | 설명                                     |
|-------------|--------------------|----------------------------------------|
| boolean     | add(E e)           | 데이터를 추가                                |
| void        | clear()            | 모든 데이터를 삭제                             |
| Object      | clone()            | HashSet 객체를 복제. 하지만, 담겨 있는 데이터들은 복제 X. |
| boolean     | contains(Object o) | 지정한 객체가 존재하는지 확인                       |
| boolean     | isEmpty()          | 데이터가 있는지 확인                            |
| Iterator<E> | iterator()         | 데이터를 꺼내기 위한 Iterator 객체를 리턴            |
| boolean     | remove(Object o)   | 매개 변수로 넘어온 객체를 삭제                      |
| int         | size()             | 데이터의 개수를 리턴                            |

- 어느 회사에 직원들이 보유하고 있는 차의 종류가 몇개나 되는지 예제를 통해 확인해보자.
```java
package _23.collection;

import java.util.HashSet;
import java.util.Set;

public class SetSample {
        public static void main(String[] args) {
                SetSample sample = new SetSample();
                String[] cars = new String[] {
                        "Tico", "Sonata", "BMW", "Benz",
                        "Lexus", "Mustang", "Grandeure",
                        "The Beetle", "Mini Cooper", "i30",
                        "BMW", "Lexus", "Carnibal", "SM5",
                        "SM7", "SM3", "Tico"
                };
                System.out.println(sample.getCarKinds(cars));
        }

        public int getCarKinds(String[] cars) {
                if (cars == null) return 0;
                if (cars.length == 1) return 1;
                Set<String> carSet = new HashSet<String>();
                for (String car: cars) {
                        carSet.add(car);
                }
                return carSet.size();
        }
}
```
```text
14
```
- getCarsKinds() 내에서 먼저 cars가 null이라면 0을 리턴. (null일 경우, NullPointerException 발생). cars.length가 1이면 1 리턴. (확인 불필요)
- carSet 이라는 HashSet 객체 생성 후 cars 배열의 값을 하나씩 담아, 중복을 제거해주었다. 마지막으로, carSet 크기를 리턴.


- HashSet에 저장되어 있는 값은 어떻게 꺼낼까? 가장 편한 방법은 for 루프를 사용하는 것이다.

```text
public void printCarSet(Set<String> carSet) {
        for (String car : carSet) {
                System.out.print(car + " ");
        }
        System.out.println();
}
```
- 해당 메소드를 getCarKinds() for 루프 이후 추가 후 실행하면 다음과 같다.
```text
Mustang Lexus Tico i30 Grandeure Carnibal Sonata BMW Benz SM3 The Beetle SM5 Mini Cooper SM7 
14
```
- 결과를 보면 Set에 저장한 순서가 아닌 뒤죽박죽으로 출력된 것을 볼 수 있다. Set은 데이터가 보관되어 있는 순서가 전혀 중요하지 않을 때 사용해야 한다.
- 이 방법 외에 출력하는 방법으로 Iterator 객체를 만들어도 된다.
```text
public void printCarSet2(Set<String> carSet) {
        Iterator<String> iterator = carSet.iterator();
        while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
        }
        System.out.println();
}
```
- HashSet에 존재하는지를 확인하기 위해서는 contains() 메소드, 해당 객체를 HashSet에서 삭제하기 위해서는 remove() 메소드를 사용하면 된다.
```text
public void containsEx(Set<String> carSet) {
        String tico = "Tico";
        if (carSet.contains(tico)) 
                System.out.println("contains Tico");
        else System.out.println("not contains Tico");
        String morning = "Morning";
        if (carSet.contains(morning)) 
                System.out.println("contains Morning");
        else System.out.println("not contains Morning");
}

public void removeEx(Set<String> carSet) {
        String tico = "Tico";
        System.out.println("remove Tico = " + carSet.remove(tico));
}
```

## Queue는 왜 필요할까?
- LinkedList를 먼저 이해하자.
- 열차로 예를 들면 LinkedList에 A라는 값이 추가되면 열차의 맨 앞칸에 데이터를 집어 넣는다. 이 때, LinkedList의 가장 앞, 끝 값 모두 A이다.
- B라는 데이터를 넣으면 가장 앞은 A, 뒤는 B다. 여기서 A는 뒤에 B가 있다는 것. B는 A가 앞에 있다는 것을 기억한다.
- C라는 값을 집어넣으면, `A-B-C`가 되는데, LinkedList에서는 앞에 있는 애와 뒤에 있는 애만 기억한다. 따라서 A는 뒤에 있는 값이 B라는 것만 알고, C가
있다는 것은 생각도 안하고, C 역시, 앞에 B가 있다는 것만 기억한다.
- 만약 간단하게 데이터를 담아서 순차적으로 뺄 경우에는 배열이 더 효율적. 하지만, 배열 중간에 있는 데이터가 지속적으로 삭제되고, 추가될 경우에는
LinkedList가 배열보다 메모리 공간 측면에서 훨씬 유리.
  - 배열과 같은 ArrayList, Vector는 각 위치가 정해져 있고, 그 위치로 데이터를 찾는다. 그런데, 맨 앞의 값을 삭제하면, 그 뒤의 값은 한칸씩 앞으로 밀린다.
  - 그에 반해, LinkedList는 중간에 있는 데이터를 삭제하면, 지운 데이터의 앞, 뒤 데이터를 연결하면 그만이다. 위치를 맞추기 위해서 값을 이동하는 단계가
  필요없다.
- LinkedList는 List 인터페이스뿐만 아니라 Queue, Deque 인터페이스도 구현하고 있다. 즉, List 이면서도 Queue, Deque도 된다.
- Queue는 FIFO(First In First Out)의 용도로 먼저 들어온 애가 먼저 나가는 것을 말한다. 큐는 왜 사용할까? 웹 서버에 100명의 사용자가 요청했다고 가정시,
만약 LIFO 처리로 했다면 가장 먼저 와서 줄 서 있는 사용자가 가장 마지막에 응답을 받게 되어 불만족할 것이다. 이렇게 사용자들의 요청을 들어온 순서대로
처리할 때 큐를 사용.
- LinkedList 클래스가 구현한 인터페이스 중 Java 6에 추가된 Deque(덱)은 "Double Ended Queue"의 약자로, Queue 인터페이스를 확장하여 맨 앞, 뒤에 값을 
넣거나 빼는 작업을 수행하는 데 용이하다.

## LinkedList를 파헤쳐보자
- 상속 관계는 다음과 같다.
```text
java.lang.Object
    - java.util.AbstractCollection<E>
        - java.util.AbstractList<E>
            - java.util.AbstractSequentialList<E>
                - java.util.LinkedList
```
- ArrayList, Vector 클래스와 비슷하지만 AbstractSequentialList가 부모이다. AbstractList와 차이점은 add(), set(), remove() 등의 
메소드 구현 내용이 상이하다는 점이다. 
- LinkedList가 구현한 인터페이스 목록은 다음과 같다.

| 인터페이스         | 용도                                                            |
|---------------|---------------------------------------------------------------|
| Serializable  | 원격으로 객체를 전송하거나, 파일에 저장할 수 있음을 지정                              |
| Cloneable     | Object 클래스의 clone() 메소드가 제대로 수행될 수 있음을 지정. 즉, 복제가 가능한 객체임을 의미 |
| Iterable<E>   | 객체가 "foreach" 문장을 사용할 수 있음을 지정                                |
| Collection<E> | 여러 개의 객체를 하나의 객체에 담아 처리할 때의 메소드 지정                            |
| Deque<E>      | 맨 앞과 맨 뒤의 값을 용이하게 처리하는 큐와 관련된 메소드 지정                          |
| List<E>       | 목록형 데이터를 처리하는 것과 관련된 메소드 지정                                   |
| Queue<E>      | 큐를 처리하는 것과 관련된 메소드 지정                                         |

## LinkedList의 생성자와 주요 메소드를 살펴보자
- LinkedList는 일반적인 배열 타입과 다르게 처음부터 크기를 지정하지 않는다. 앞뒤 연결 구조이기 때문에, 미리 공간을 만들 필요가 없다.

| 생성자                                   | 설명                                     |
|---------------------------------------|----------------------------------------|
| LinkedList()                          | 비어 있는 LinkedList 객체를 생성                |
| LinkedList(Collection<? extends E> c) | 매개 변수로 받은 컬렉션 객체의 데이터를 LinkedList에 담는다 |

- LinkedList 클래스는 구현한 인터페이스가 많기 때문에, 메소드의 종류도 다양하다.
- 먼저 객체에 데이터를 추가하는 메소드이다.

| 리턴 타입   | 메소드 이름 및 매개 변수          | 설명                                                    |
|---------|-------------------------|-------------------------------------------------------|
| void    | addFirst(Object)        | LinkedList 객체의 가장 앞에 데이터를 추가                          |
| boolean | offerFirst(Object)      |                                                       |
| void    | push(Object)            |                                                       |
| boolean | add(Object)             | LinkedList 객체의 가장 뒤에 데이터를 추가                          |
| void    | addLast(Object)         |                                                       |
| boolean | offer(Object)           |                                                       |
| boolean | offerLast(Object)       |                                                       |
| void    | add(int, Object)        | LinkedList 객체의 특정 위치에 데이터를 추가                         |
| Object  | set(int, Object)        | LinkedList 객체의 특정 위치에 있는 데이터를 수정. 그리고, 기존에 있는 데이터를 리턴 |
| boolean | addAll(Collection)      | 매개 변수로 넘긴 컬렉션의 데이터를 추가                                |
| boolean | addAll(int, Collection) | 매개 변수로 넘긴 컬렉션의 데이터를 지정된 위치에 추가                        |

- LinkedList가 여러 종류의 인터페이스를 구현했기 때문에 매우 중복된 기능을 수행하는 메소드가 많은 것을 알 수 있다.
```java
package _23.collection;

import java.util.LinkedList;

public class QueueSample {
        public static void main(String[] args) {
                QueueSample sample = new QueueSample();
                sample.checkLinkedList1();
        }

        public void checkLinkedList1() {
                LinkedList<String> link = new LinkedList<String>();
                link.add("A");
                link.addFirst("B");
                System.out.println(link);
                link.offerFirst("C");
                System.out.println(link);
                link.addLast("D");
                System.out.println(link);
                link.offer("E");
                System.out.println(link);
                link.offerLast("F");
                System.out.println(link);
                link.push("G");
                System.out.println(link);
                link.add(0, "H");
                System.out.println(link);
                System.out.println("EX=" + link.set(0, "I"));
                System.out.println(link);
        }
}
```
```text
[B, A]
[C, B, A]
[C, B, A, D]
[C, B, A, D, E]
[C, B, A, D, E, F]
[G, C, B, A, D, E, F]
[H, G, C, B, A, D, E, F]
EX=H
[I, G, C, B, A, D, E, F]
```
- LinkedList 소스를 보면 맨 앞에 추가하는 메소드는 동일한 기능을 수행하는 어떤 메소드를 호출해도 addFirst() 메소드를 호출한다. 맨 뒤에 추가하는
메소드는 동일한 기능을 수행하는 offer() 관련 메소드를 호출하면 add()나 addLast() 메소드를 호출하도록 되어 있다. 따라서, 여러 메소드를 혼용하지 말고
add가 붙은 메소드를 사용하는 것이 오해의 소지가 가장 적다.
- 주요 메소드는 다음과 같다.

| 리턴 타입  | 메소드 이름 및 매개 변수 | 설명                                |
|--------|----------------|-----------------------------------|
| Object | getFirst()     | LinkedList 객체의 맨 앞에 있는 데이터를 리턴    |
| Object | peekFirst()    |                                   |
| Object | peek()         |                                   |
| Object | element()      |                                   |
| Object | getLast()      | LinkedList 객체의 맨 뒤에 있는 데이터를 리턴    |
| Object | peekLast()     |                                   |
| Object | get(int)       | LinkedList 객체의 지정한 위치에 있는 데이터를 리턴 |

- LinkedList에 어떤 객체가 포함되어 있는지를 확인하는 메소드는 다음과 같다.

| 리턴타입    | 메소드 이름 및 매개 변수      | 설명                                            |
|---------|---------------------|-----------------------------------------------|
| boolean | contains(Object)    | 매개 변수로 넘긴 데이터가 있을 경우 true를 리턴                 |
| int     | indexOf(Object)     | 매개 변수로 넘긴 데이터의 위치를 앞에서부터 검색하여 리턴. 없을 경우 -1 리턴 |
| int     | lastIndexOf(Object) | 매개 변수로 넘긴 데이터의 위치를 끝에서부터 검색하여 리턴. 없을 경우 -1 리턴 |

- 데이터의 값으로 위치를 찾거나 존재하는지 확인하려면 위 메소드를 사용하면 된다.
- 데이터를 삭제하는 메소드는 아래와 같다. 대부분의 삭제 관련 메소드는 LinkedList 객체에서 삭제하고, 데이터를 리턴해주기 때문에, 살펴본 조회용
메소드보다 많이 사용.

| 리턴 타입   | 메소드 이름 및 매개 변수                | 설명                                                |
|---------|-------------------------------|---------------------------------------------------|
| Object  | remove()                      | LinkedList 객체의 가장 앞에 있는 데이터를 삭제하고 리턴              |
| Object  | removeFirst()                 |                                                   |
| Object  | poll()                        |                                                   |
| Object  | pollFirst()                   |                                                   |
| Object  | pop()                         |                                                   |
| Object  | pollLast()                    | LinkedList 객체의 가장 끝에 있는 데이터를 삭제하고 리턴              |
| Object  | removeLast()                  |                                                   |
| Object  | remove(int)                   | 매개 변수에 지정된 위치에 있는 데이터를 삭제하고 리턴                    |
| boolean | remove(Object)                | 매개 변수로 넘겨진 객체와 동일한 데이터 중 앞에서부터 가장 처음에 발견된 데이터를 삭제 |
| boolean | removeFirstOccurrence(Object) |                                                   |
| boolean | removeLastOccurrence(Object)  | 매개 변수로 넘겨진 객체와 동일한 데이터 중 끝에서부터 가장 처음에 발견된 데이터를 삭제 |

- 이외에도 크기를 확인하는 size(), 모든 데이터를 삭제하는 clear(), 데이터를 복제하는 clone(), 배열로 만드는 toArray() 메소드가 있다.
- LinkedList 객체를 하나씩 검색하기 위한 Iterator 객체는 다음과 같다.

| 리턴 타입        | 메소드 이름 및 매개 변수       | 설명                                                |
|--------------|----------------------|---------------------------------------------------|
| ListIterator | listIterator(int)    | 매개 변수에 지정된 위치부터의 데이터를 검색하기 위한 ListIterator 객체를 리턴 |
| Iterator     | descendingIterator() | LinkedList의 데이터를 끝에서부터 검색하기 위한 Iterator 객체를 리턴    |

- ListIterator는 Iterator 인터페이스가 다음 데이터만을 검색할 수 있따는 단점을 보완하여, 이전 데이터도 검색할 수 있는 이터레이터다.
따라서 next() 외에도 previous() 메소드로 이전 데이터 확인 가능.
