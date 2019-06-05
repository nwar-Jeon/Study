### Observable

+ 데이터의 변화가 발생하는 데이터 소스.
+ 리액티브 프로그래밍의 기초.
+ 라이프사이클 존재하지 않음.
+ 옵저버 패턴 구현
  1. 객체의 상태 변화를 관찰하는 관찰자(옵저버) 목록을 객체에 등록
  2. 상태 변화가 있을 때마다 메서드를 호출하여 객체가 직접 목록의 옵저버에게 변화를 알림.

+ ##### Observed가 관찰을 통해 얻은 결과라면, Observable은 앞으로 관찰할 가능성을 의미한다.

+   Observable의 알림
+ + onNext : Observable이 데이터의 발행을 알림.
  + onComplete : 모든 데이터의 발행을 완료했음을 알림. 단 한번만 발생. 이후 onNext가 발생하지 않음.
  + onError : 어떤 이유로 에러가 발생함을 알림. 이후 Observable의 실행을 바로 종료함.
+ Observable의 팩토리 함수

| 버전                      | 팩토리 함수                                                  |
| ------------------------- | ------------------------------------------------------------ |
| RxJava 1.x                | create(), just(), from()                                     |
| RxJava 2.x(from() 세분화) | fromArray(), fromIterable(), fromCallable(), fromFuture(), frompublisher() |
| 기타                      | interval(), range(), timer(), defer() 등                     |



### Flowable

+ Observable + backpressure buffer(backpressure 이슈 대응.)
+ + backpressure(배압)?
  + 생산자의 생성속도(element 생성)가 소비자의 소비속도(element를 꺼내감)보다 빠르면, 언젠가 OutOfMemoryException이 발생할 수 있음.

### Maybe

### Single