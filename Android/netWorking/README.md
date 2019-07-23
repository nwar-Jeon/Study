# 자바 네트워킹(Android)

##### java.net 패키지 사용.



## IP주소?

네트워크에 연결된 컴퓨터가 상호 통신하기 위해 각 컴퓨터마다 부여된 고유의 주소.

IP주소는 8비트씩 4개로 끊어 32비트(4바이트)로 표현.

사람이 사용하기에는, 문자가 편하기 때문에 (ex : www.google.com) 문자로 이루어진 주소를 사용한다.(URL) 이를 사용하면 IP주소로 변환하는 DNS(Domain Name Server)가 필요하다.



## 포트?

하나의 IP주소에도 여러 개의 서버 프로그램을 실행하면, 이를 구분해야 하는데, 이를 구분하기 위하여 사용하는 것. 마치 한 아파트에서의 호수와 같음.



## java에서 IP주소 얻기

```java
static InetAddress[] getAllByName(String host)
static InetAddress getByAddress(Byte[] address)
static InetAddress getByAddress(String host, byte[] address)
static InetAddress getByName(String host)
static InetAddress getLocalHost()
```

+ InetAddress는 생성자가 public이 아님. 따라서 위의 정적 메서드를 이용해 객체를 생성해야함.
+ 이 메서드는 모두 UnknownHostException을 throw할 수 있기 때문에 예외처리가 필요함.
+ 매개변수의 host는, 호스트 이름(ex : www.google.com)이다.
+ 매개변수의 address는 IP주소이며, IP주소가 127.0.0.1 이라면 아래와 같이 지정한다.

```java
byte[] address = new byte[]{127,0,0,1};
```



#### InetAddress의 메서드

```java
byte[] getAddress() // IP주소를 배열 타입으로 변환
String getHostAddress() // IP주소를 String타입으로 변환
String getHostName() // 호스트 이름을 String 타입으로 변환
```

