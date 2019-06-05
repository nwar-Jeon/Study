## RxJava?

+ 리액티브 프로그래밍
+ + 데이터 흐름과 변화의 전달에 관한 프로그래밍 패러다임.
  + 프로그램이 주도하는 것이 아니라 환경이 변하면 이벤트를 받아 동작.
+ why?
+ + Embrace Concurrency. 동시성의 필요
  + Java Futures are Expensive to Compose. 자바 Future 조합의 어려움.
  + Callbacks have their own problems. 콜백의 문제점을 해결해야함.

### RxJava 시작하기

```java
public static void main(String args[]){
  Observable.just("Hello","World!")
    .subscribe(System.out::println);
}
```

+ Observable 클래스를 통해 Observable.just()로 "Hello"와 "World!" 아이템 전달, 
+ Observable.subcribe()로 전달된 아이템 출력.

1. just() 

   데이터 소스에 데이터 발행.

2. subscribe()

   Observable을 구독하여, 구독자에게 발행.(just()함수만으로는 데이터 발행이 되지 않고, 이 함수가 실행되어야 비로소 발행이 됨.)

### 마블 다이어그램

![marblediagram](.\marblediagram.png)

### Function

```java
Function<기존타입, 리턴타입> 변수명 = 인자 -> 실행문;

Function<String, Integer> function = str -> Integer.parseInt(str);
Integer integer = 0;

try{
  integer = function.apply("10"); // function.apply can throw Exception
} catch(Exception e){}

System.out.println(integer)
```

Function은 인자타입, 리턴타입을 받고, .apply()를 하면 기존 타입 인자의 연산 결과를 결과타입으로 반환함.

### Consumer

```java

```
