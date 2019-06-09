### just()

+ 인자로 넣은 데이터를 발행하기 위해 Observable 생성.(실제 발행은 .subsribe()함수를 호출할 때.)
+ 1~10개의 값을 넣을 수 있음.
+ 단, 데이터형은 모두 같아야함.

![just_marble_diagram](.\just_marble_diagram.png)

### subscribe()

+ 사전에 정의한 동작을 실행되는 시점을 조절하는 메서드.
+ 팩토리 함수로 데이터 흐름을 정의하면, 이 함수를 호출해야 실제로 데이터를 발행한다.

### create()

+ just()는 데이터를 인자로 넣으면 자동으로 알림 이벤트가 발생하지만, 이 메서드는 onNext, onComplete, onError를 직접 호출해야 함.
+ 원형 : 

```java
Observable<T> create(ObservableOnSubscribe<T> source)
```

+ ObservableOnSubscribe 인터페이스 : 

```java
public interface ObservableOnSubscribe<T>{
  void subscribe(ObservableEmitter<T> e) throws Exception;
}
```

