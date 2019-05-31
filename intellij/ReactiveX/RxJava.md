```java
Observable.just("asdf")
  .subscribe(System.out::println);
// asdf 출력.
```

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

