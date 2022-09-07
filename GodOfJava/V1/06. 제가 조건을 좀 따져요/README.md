# 제가 조건을 좀 따져요
## 도대체 얼마나 조건을 따지길래...
- 가장 많이 사용하는 if문 : 가정을 할 때 사용
- 기본 if문
```java
if (boolean 값) 처리문장;
```
- if 다음에 소괄호 내에 boolean 형태의 결과가 있어야 하고, 해당 조건에 맞을 때 (소괄호 내의 내용이 true 일 때), 
처리하는 처리문장과 세미콜론이 온다.
```java
public class ControlIf {
    public static void main(String[] args) {
        ControlIf control = new ControlIf();
        control.ifStatement();
    }

    public void ifStatement() {
        if (true);
        if (true) System.out.println("It's true");
        if (true)
            System.out.println("It's also true");
        if (false)
            System.out.println("It's false");
    }
}
```
```text
It's true
It's also true
```
- if문 뒤의 소괄호 내의 boolean 조건식이 true인 경우에만 뒤의 처리문장이 실행된다. 줄바꿈 역시 문제 되지 않는다.
- 그 다음으로 if-else문을 알아본다.
```java
public class ControlIfElse {

    public static void main(String[] args) {
        ControlIfElse control = new ControlIfElse();
        control.ifElseStatement();
    }

    public void ifElseStatement() {
        // int intValue = 10;
        int intValue = 5;

        if (intValue > 5) System.out.println("It's bigger than 5.");
        else System.out.println("It's smaller than or equal to 5.");
        
        if (intValue <= 5)
            System.out.println("It's smaller than or equal to 5.");
        else 
            System.out.println("It's bigger than 5.");
    }
}
```
- intValue 가 10일 경우 다음과 같이 출력
```text
It's bigger than 5.
It's bigger than 5.
```
- intValue 가 5일 경우 다음과 같이 출력
```text
It's smaller than or equal to 5.
It's smaller than or equal to 5.
```

## if를 조금 더 다양하게 사용해보자
### if 다음에는 문장이 하나밖에 올 수 없나?
- NO.
- 소괄호를 닫은 후 중괄호 `{}` 내에 여러 처리 문장을 만들 수 있다.
```java
if (boolean 값) {
    처리문장1;
    처리문장2;
    ...
}
```
```java
if (boolean 값) {
    처리문장1;
    처리문장2;
    ...
} else {
    처리문장3;
    처리문장4;
    ...
}
```
### if의 조건이 여러개 일 때에는 어떻게 하지?
- 소괄호 내에 && , || 활용하여 여러 가지 조건을 한 번에 따질 수 있다.
```java
public class ControlIfAndOr {
    public static void main(String[] args) {
        ControlIfAndOr control = new ControlIfAndOr();
        control.ifAndOr();
    }
    
    public void ifAndOr() {
        int age = 25;
        boolean isMarried = true;
        
        if (age > 25 && isMarried) {
            System.out.println("Age is over 25 and Married");
        }
        if (age > 25 || isMarried) {
            System.out.println("Age is over 25 or Married");
        }
    }
}
```
```text
Age is over 25 or Married
```
- `if (age > 25 && isMarried)` 에서는 isMarried는 true 이지만 && 조건이므로 age 역시 25 초과여야 만족한다.
- `if (age > 25 || isMarried)` 에서는 isMarried 하나만 true여도 || 조건이므로 만족한다.
- && 의 경우 첫 번쨰 조건이 false 이면 어차피 그 결과도 false이기 때문에 두 번째 조건은 확인하지 않고 넘어간다.
- || 의 경우 첫 번쨰 조건이 true 이면 결과 역시 true 이기 때문에 두 번째 조건은 신경쓰지 않고 넘어간다.
- 여러 조건을 한 번에 사용 가능하다
```java
public void tripleOrAnd() {
    int age = 25;
    boolean isMarried = true;
    double height = 180;
    if (age > 25 || isMarried && height >= 180) {
        System.out.println("Age is over 25 or Married and height is over 180");
    }
}
```
- 이 경우 앞의 || 가 먼저 인지 height 조건이 먼저인지 혼동되므로 다음과 같이 괄호로 묶어주는 것이 좋다.
  (묶지 않아도 결과는 같지만 가독성 면에서 좋다.)
```java
if ((age > 25 || isMarried) && height >= 180)
```

### 값의 범위에 따라서 결과를 다르게 할 때도 있을 텐데, 그럴 떄는 어떻게 해야 하지?
- else 뒤에 if 를 붙여서 다시 조건을 따질 수 있다.
```java
public class ControlElseIf {
    public static void main(String[] args) {
        ControlElseIf control = new ControlElseIf();
        control.elseIf(85);
    }
    
    public void elseIf(int point) {
        if (point > 90) {               // 90점 초과일 경우
            System.out.println("A");
        } else if (point > 80) {        // 80점 초과일 경우 90점 이하일 경우
            System.out.println("B");
        } else if (point > 70) {        // 70점 초과일 경우 80점 이하일 경우
            System.out.println("C");
        } else if (point > 60) {        // 60점 초과일 경우 70점 이하일 경우
            System.out.println("D");
        } else {                        // 60점 이하일 경우
            System.out.println("F");
        }
    }
}
```
- 90점 초과이면 A, 80점 초과이면 B, 70점 초과이면 C, 60점 초과이면 D, 60점 이하이면 F
- else if 을 쓰면 지금까지 조건에 맞지 않는 다른 조건을 찾는 데 유용하다.
- else if를 쓰지 않으면 다음과 같이 복잡해진다.
```java
if (point > 90) {
    System.out.println("A");
} else {
    if (point > 80) {
        System.out.println("B");
    } else {
        if (point > 70) {
            System.out.println("C");
        } else {
            if (point > 60) {
                System.out.println("D");
            } else {
                System.out.println("F");
            }
        }
    }
}
```
- 위 보다는 양호하게 &&을 사용하여 코드를 작성할 수 있다.
```java
if (point > 90) {
    System.out.println("A");
}
if (point <= 90 && point > 80) {
    System.out.println("B");
}
if (point <= 80 && point > 70) {
    System.out.println("C");
}
if (point <= 70 && point > 60) {
    System.out.println("D");
}
if (point > 60) {
    System.out.println("F");
}
```
- 위 코드 또한 간결하다고 생각 할 수 있지만 예를 들어 앞의 두 if문은 90점이 넘으면 모든 if 문 점검이 끝난다.
- 하지만, 이 마지막 예는 90점이 넘어도, 나머지 조건에 해당하는 지 지속적으로 점검을 해야만 한다.
- 따라서 if-else if문을 활용하여 더 효율적으로 프로그래밍 할 수 있다.
- 해당 부분을 `? : `를 활용해 더 간결하게 할 수 있다.
```java
public void elseIf2() {
    System.out.println(point > 90 ? "A" : point > 80 ? "B" : point > 70 ? "C" : point > 60 ? "D" : "F");
}
```

## 자바의 switch와 불켜는 스위치는 별 상관 없다
- 하나의 값으로 분기하여 비교하는 switch 구문이 있다.
```text
switch(비교대상변수) {
    case 점검값1:
       처리문장1;
       ...
       break;
    case 점검값2:
       처리문장2;
       ...
       break;
       ...
    default:
       기본처리문장;
       ...
       break;
}
```
- switch(비교대상변수) 를 명시 후 중괄호 시작.
  - 비교대상변수는 long을 제외한 정수형과 몇몇 특별한 타입만이 들어갈 수 있음
- 중괄호 안에는 `case 점검값:` 또는 `default:`가 나오고 case 문장이 없으면 switch문의 의미가 없기 때문에
꼭 써주어야 하고, 각 case를 마무리하고 싶다면 반드시 `break;`를 추가해야만 한다.

```java
public class ControlSwitch {
    public static void main(String[] args) {
        ControlSwitch control = new ControlSwitch();
        control.switchStatement(1);
        control.switchStatement(2);
        control.switchStatement(3);
        control.switchStatement(4);
        control.switchStatement(6);
    }
    
    public void switchStatement(int numberOfWheel) {
        switch(numberOfWheel) {
            case 1:
                System.out.println(numberOfWheel + ": It is one foot bicycle.");
                break;
            case 2:
                System.out.println(numberOfWheel + ": It is a motor cycle or bicycle.");
                break;
            case 3:
                System.out.println(numberOfWheel + ": It is a three wheel car.");
                break;
            case 4:
                System.out.println(numberOfWheel + ": It is a car.");
                break;
            default:
                System.out.println(numberOfWheel + ": It is an expensive car.");
                break; 
        }
    }
}
```
```text
1: It is one foot bicycle.
2: It is a motor cycle or bicycle.
3: It is a three wheel car.
4: It is a car.
6: It is an expensive car.
```
- `case`에 해당하는 값에 걸리면 `case`의 콜론 뒤의 문장이 실행되고, `break;` 후에 빠져나온다.
- `default:` 의 경우 앞에 있는 조건에 맞지 않는 경우에 수행된다. 하지만 조건을 찾지 못했을 때만 수행되는 것은 아니다.
```java
public void switchStatement2(int numberOfWheel) {
    switch(numberOfWheel) {
        case 1:
            System.out.println(numberOfWheel + ": It is one foot bicycle.");
            // break;
        case 2:
            System.out.println(numberOfWheel + ": It is a motor cycle or bicycle.");
            // break;
        case 3:
            System.out.println(numberOfWheel + ": It is a three wheel car.");
            break;
        case 4:
            System.out.println(numberOfWheel + ": It is a car.");
            break;
        default:
            System.out.println(numberOfWheel + ": It is an expensive car.");
            break; 
    }
}
```
- case 1과 2의 break를 주석 처리하고 돌려보면
```text
1: It is one foot bicycle.
2: It is a motor cycle or bicycle.
3: It is a three wheel car.
```
- switch 문장에서는 한 번 조건을 만족시켜 줬다면, 그 다음 break가 올 때까지 어떤 case든 간에 계속 실행한다.
- 따라서 switch 문 내에 break 한 줄을 빼먹는 것을 조심하자.
- 다음 코드로 break문을 만든 이유에 대해 생각해보자.
```java
public class ControlOfFlow {
    public void switchCalendar(int month) {
        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(month + " has 31 days.");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(month + " has 30 days.");
                break;
            case 2:
                System.out.println(month + " has 28 or 29 days.");
                break;
            default:
                System.out.println(month + " is not a month.");
                break;
        }
    }
}
```
- 다음과 같은 상황에서 유용하다.
- default는 꼭 맨 마지막에 있어야 하는 것은 아니지만 맨 뒤에 넣는 것을 권장한다. (중간에 넣을 경우, 원치 않는
결과가 나올 수 있다.)
- Java 6 까지는 long을 제외한 정수와 Enum, 몇몇 참조 자료형에서만 switch를 사용할 수 있었지만,
Java 7부터 String도 사용 가능

## 반복문이라구요?
- for 루프, while 문 2가지 반복문 존재
```java
while (boolean 조건) {
    처리문장;
    ...
}
```
- boolean 조건이 true 일 경우에만 중괄호 안에 있는 내용 수행
- if 문과 다른점은 if 문의 경우, 중괄호가 끝나면 그 다음 아래줄로 넘어가지만, while 문의 경우, 중괄호가 끝난 이후에
다시 위로 올라가 `boolean 조건`을 확인해보고, 이 값이 true 이면 중괄호 안의 내용이 계속 실행된다.
```java
public class ControlWhile {
    public static void main(String[] args) {
        ControlWhile control = new ControlWhile();
        control.whileLoop1();
    }
    
    public void whileLoop() {
        ControlOfFlow control = new ControlOfFlow();
        int loop = 0;
        while (loop < 12) {
            loop++;
            control.switchCalendar(loop);
        }
    }
}
```
```text
1 has 31 days.
2 has 28 or 29 days.
3 has 31 days.
4 has 30 days.
5 has 31 days.
6 has 30 days.
7 has 31 days.
8 has 31 days.
9 has 30 days.
10 has 31 days.
11 has 30 days.
12 has 31 days.
```
- loop 이라는 int 변수를 만들어 0으로 할당 한 후 1씩 증가시키고, 12를 넘으면 수행이 멈춘다.
- while 문에서 6이 넘으면 더 이상 반복을 할 필요가 없을 경우에는 다음과 같이 break 문을 사용한다.
```java
public class ControlWhile {
    public static void main(String[] args) {
        ControlWhile control = new ControlWhile();
        control.whileLoop();
        System.out.println();
        control.whileBreak();
    }
    
    public void whileLoop() {
        ControlOfFlow control = new ControlOfFlow();
        int loop = 0;
        while (loop < 12) {
              loop++;
              control.switchCalendar(loop);
        }
    }
        
    public void whileBreak() {
        ControlOfFlow control = new ControlOfFlow(); 
        int loop = 0; 
        while (loop < 12) { 
              loop++; 
              control.switchCalendar(loop);
              if (loop == 6) break;
        }
    }
}
```
```text
1 has 31 days.
2 has 28 or 29 days.
3 has 31 days.
4 has 30 days.
5 has 31 days.
6 has 30 days.
```
- 6월이 되는 순간 반복문이 멈추었다.
- while 문을 빠져나오지 않고 건너뛰기 해서 사용할 수 있는 continue 도 존재한다.
```java
public class ControlWhile {
    public static void main(String[] args) {
        ControlWhile control = new ControlWhile();
        control.whileLoop();
        System.out.println();
        control.whileBreak();
        System.out.println();
        control.whileContinue();
    }
  
    public void whileContinue() {
            ControlOfFlow control = new ControlOfFlow(); 
            int loop = 0; 
            while (loop < 12) { 
                    loop++;
                    if (loop == 6) continue;
                    control.switchCalendar(loop);
            }
    }
}
```
```
1 has 31 days.
2 has 28 or 29 days.
3 has 31 days.
4 has 30 days.
5 has 31 days.
7 has 31 days.
8 has 31 days.
9 has 30 days.
10 has 31 days.
11 has 30 days.
12 has 31 days.
```
- 6월을 제외한 나머지 월이 몇 일까지 있는지 출력되었다.
- 단, continue, break는 매우 신중해야 한다.
```java
public class ControlWhile {
        public static void main(String[] args) {
                ControlWhile control = new ControlWhile();
                control.whileLoop();
                System.out.println();
                control.whileBreak();
                System.out.println();
                control.whileContinue();
                control.whileContinueInfinite();
        }
    
        public void whileLoop() {
                ControlOfFlow control = new ControlOfFlow();
                int loop = 0;
                while (loop < 12) {
                        loop++;
                        control.switchCalendar(loop);
                }
        }
        
        public void whileBreak() {
                ControlOfFlow control = new ControlOfFlow(); 
                int loop = 0; 
                while (loop < 12) { 
                        loop++; 
                        control.switchCalendar(loop);
                        if (loop == 6) break;
                }
        }

        public void whileContinue() {
                ControlOfFlow control = new ControlOfFlow(); 
                int loop = 0; 
                while (loop < 12) { 
                        loop++;
                        if (loop == 6) continue;
                        control.switchCalendar(loop);
                }
        }

        public void whileContinueInfinite() {
                ControlOfFlow control = new ControlOfFlow();
                int loop = 0;
                while (loop < 12) {
                        if (loop == 6) continue;
                        loop++;
                        control.switchCalendar(loop);
                }
        }
}
```
- 마지막 결과가 출력 된 후 무한루프에 빠진다.
- loop가 6일 경우 continue가 수행되는데, 다시 while문에 들어와도 똑같이 6으로 continue가 계속해서 수행되기 때문이다.
- 따라서, break와 continue를 사용할 때에는 조심해야 한다.
- 다음으로 while문의 변종인 do-while 문이다.
```java
public class ControlDoWhile {
        public static void main(String[] args) {
                ControlDoWhile control = new ControlDoWhile();
                control.doWhile();
        }

        public void doWhile() {
                ControlOfFlow control = new ControlOfFlow();
                int loop = 0;
                do {
                        loop++;
                        control.switchCalendar(loop);
                } while(loop < 12);
        }
}
```
```text
1 has 31 days.
2 has 28 or 29 days.
3 has 31 days.
4 has 30 days.
5 has 31 days.
6 has 30 days.
7 has 31 days.
8 has 31 days.
9 has 30 days.
10 has 31 days.
11 has 30 days.
12 has 31 days.
```
- do-while문은 적어도 한 번은 반복문장이 실행된다. while문은 시작부터 조건에 맞지 않으면 실행조차 되지 않지만,
do-while문은 한 번은 꼭 실행시키고 싶을 때 사용한다.
- while 의 소괄호 뒤에 `;`을 꼭 붙혀준다.

## 가장 확실한 for 루프
- while 루프의 경우 잘못 사용하면 무한 루프에 빠지지만 for 루프는 상대적으로 그럴 위험부담이 적어 더 자주 쓰이는 편이다.
- 기본 문법은 다음과 같다.
```text
for (초기화; 종료 조건; 조건값 증가) {
    반복문장
}

```
- 다음과 같은 순서로 for 반복문이 실행된다.
1. `초기화` 에서 변수를 초기화한다.
2. `종료 조건` 구문이 수행된다. boolean 결과값만이 올 수 있으며, true 이면 for 루프 내의 반복문장 실행,
false이면 for 루프가 종료된다.
3. `종료 조건`이 true 이면 반복 문장 실행
4. 중괄호 내의 작업이 종료되면 `조건값 증가`수행, 보통은 초기화 부분의 변수에 대한 조건값을 증가시킴
5. `반복 문장` 수행 전 다시 `종료 조건`확인
6. 5번의 결과가 true이면 다시 `반복 문장` tngod
7. `조건값 증가` 다시 수행
8. `종료 조건` 확인
9. 8번이 false 일 경우 for 루프 종료
- 2~4, 5~7 구문이 반복된다. (2~4 5~7은 동일하다)
```java
public class ControlFor {
        public static void main(String[] args) {
                ControlFor control = new ControlFor();
                control.forLoop(10);
        }

        public void forLoop(int until) {
                int sum = 0;
                for (int loop = 1; loop <= until; loop++) {
                        sum += loop;
                }
                System.out.println("1 to " + until + " = " + sum);
        }
}
```

## 많이 사용안하는 label
- 자주 사용되지는 않는 label 예약어는 두 개 이상의 for나 while문에서 사용
- 먼저 2중 for문을 이용한 구구단을 작성.
```java
public class ControlLabel {

        public static void main(String[] args) {
                ControlLabel control = new ControlLabel();
                control.printTimesTable();
        }

        public void printTimesTable() {
                for (int level = 2; level < 10; level++) {
                        for (int unit = 1; unit < 10; unit++) {
                                System.out.print(level + "*" + unit + "=" + level * unit + " ");
                        }
                        System.out.println();
                }
        }
}
```
```text
2*1=2 2*2=4 2*3=6 2*4=8 2*5=10 2*6=12 2*7=14 2*8=16 2*9=18 
3*1=3 3*2=6 3*3=9 3*4=12 3*5=15 3*6=18 3*7=21 3*8=24 3*9=27 
4*1=4 4*2=8 4*3=12 4*4=16 4*5=20 4*6=24 4*7=28 4*8=32 4*9=36 
5*1=5 5*2=10 5*3=15 5*4=20 5*5=25 5*6=30 5*7=35 5*8=40 5*9=45 
6*1=6 6*2=12 6*3=18 6*4=24 6*5=30 6*6=36 6*7=42 6*8=48 6*9=54 
7*1=7 7*2=14 7*3=21 7*4=28 7*5=35 7*6=42 7*7=49 7*8=56 7*9=63 
8*1=8 8*2=16 8*3=24 8*4=32 8*5=40 8*6=48 8*7=56 8*8=64 8*9=72 
9*1=9 9*2=18 9*3=27 9*4=36 9*5=45 9*6=54 9*7=63 9*8=72 9*9=81 
```
- 여기서 4가 들어간 것을 출력하지 않으려면 다음과 같이 작성한다.
```java
public void printTimesTableSkip4Case1() {
        for (int level = 2; level < 10; level++) {
                for (int unit = 1; unit < 10; unit++) {
                        if (level == 4 || unit == 4) continue;
                        System.out.print(level + "*" + unit + "=" + level * unit + " ");
                }
                System.out.println();
        }
}
```
```text
2*1=2 2*2=4 2*3=6 2*5=10 2*6=12 2*7=14 2*8=16 2*9=18 
3*1=3 3*2=6 3*3=9 3*5=15 3*6=18 3*7=21 3*8=24 3*9=27 

5*1=5 5*2=10 5*3=15 5*5=25 5*6=30 5*7=35 5*8=40 5*9=45 
6*1=6 6*2=12 6*3=18 6*5=30 6*6=36 6*7=42 6*8=48 6*9=54 
7*1=7 7*2=14 7*3=21 7*5=35 7*6=42 7*7=49 7*8=56 7*9=63 
8*1=8 8*2=16 8*3=24 8*5=40 8*6=48 8*7=56 8*8=64 8*9=72 
9*1=9 9*2=18 9*3=27 9*5=45 9*6=54 9*7=63 9*8=72 9*9=81 
```
- 가운데 공백을 없애기 위해서는 다음과 같이 작성한다.
```java
public void printTimesTableSkip4Case2() {
        for (int level = 2; level < 10; level++) {
                if (level == 4) continue;
                for (int unit = 1; unit < 10; unit++) {
                        if (unit == 4) continue;
                        System.out.print(level + "*" + unit + "=" + level * unit + " ");
                }
                System.out.println();
        }
}
```
```text
2*1=2 2*2=4 2*3=6 2*5=10 2*6=12 2*7=14 2*8=16 2*9=18 
3*1=3 3*2=6 3*3=9 3*5=15 3*6=18 3*7=21 3*8=24 3*9=27 
5*1=5 5*2=10 5*3=15 5*5=25 5*6=30 5*7=35 5*8=40 5*9=45 
6*1=6 6*2=12 6*3=18 6*5=30 6*6=36 6*7=42 6*8=48 6*9=54 
7*1=7 7*2=14 7*3=21 7*5=35 7*6=42 7*7=49 7*8=56 7*9=63 
8*1=8 8*2=16 8*3=24 8*5=40 8*6=48 8*7=56 8*8=64 8*9=72 
9*1=9 9*2=18 9*3=27 9*5=45 9*6=54 9*7=63 9*8=72 9*9=81
```
- 여기서 곱하는 숫자를 3까지만 출력하려면 다음과 같다.
```java
public void printTimesTableSkip4Case3() {
        for (int level = 2; level < 10; level++) {
                if (level == 4) continue;
                for (int unit = 1; unit < 10; unit++) {
                        if (unit == 4) break;
                        System.out.print(level + "*" + unit + "=" + level * unit + " ");
                }
                System.out.println();
        }
}
```
```text
2*1=2 2*2=4 2*3=6 
3*1=3 3*2=6 3*3=9 
5*1=5 5*2=10 5*3=15 
6*1=6 6*2=12 6*3=18 
7*1=7 7*2=14 7*3=21 
8*1=8 8*2=16 8*3=24 
9*1=9 9*2=18 9*3=27
```
- 이 상황에서 줄바꿈 출력문을 거치지 않고 level을 사용하는 for 루프로 바로 가려면 label을 사용한다.
```java
public void printTimesTableSkip4Case4() {
        startLabel:
        for (int level = 2; level < 10; level++) {
                if (level == 4) continue;
                for (int unit = 1; unit < 10; unit++) {
                        if (unit == 4) continue startLabel;
                        System.out.print(level + "*" + unit + "=" + level * unit + " ");
                }
                System.out.println();
        }
}
```
```text
2*1=2 2*2=4 2*3=6 3*1=3 3*2=6 3*3=9 5*1=5 5*2=10 5*3=15 6*1=6 6*2=12 6*3=18 7*1=7 7*2=14 7*3=21 8*1=8 8*2=16 8*3=24 9*1=9 9*2=18 9*3=27
```
- 다음과 같이 for / while 루프를 2개 이상 사용할 경우 바깥쪽 루프의 시작점으로 이동하려고 할 때에 label을 사용하면 된다.
- 자주 사용되진 않으나, 알아두면 좋다.
