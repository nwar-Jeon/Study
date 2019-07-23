# 소켓 통신



### 소켓?

서버와 클라이언트 간에 통신할 수 있도록 추상화한 연결 통로. 즉, 종단 간의 연결을 의미.

자바 클라이언트와 서버는 Socket 클래스를 이용해 상호 데이터를 전송.

따라서 양쪽 모두 Socket 객체가 있어야 함.



##### Socket 생성자

```java
Socket()
Socket(InetAddress address, int port)
Socket(String host, int port)
```

+ address : 접속할 서버의 IP주소
+ host : 접속할 서버의 호스트 이름
+ port : 접속할 서버의 포트 번호.

※ **소켓을 생성할 때, 호스트를 찾을 수 없거나 서버의 포트가 열려 있지 않으면 UnknownHostException, 네트워크에 연결되어있지 않으면 IOException 예외가 발생한다.**



##### Socket 메서드

| 메서드                               | 설명                                    |
| ------------------------------------ | --------------------------------------- |
| void close()                         | 소켓을 닫음.                            |
| void connect(SocketAddress endpoint) | 소켓과 서버를 연결.                     |
| InetAddress getInetAddress()         | 원격 컴퓨터의 InetAddress 객체를 가져옴 |
| InetAddress getLocalAddress()        | 로컬 컴퓨터의 InetAddress 객체를 가져옴 |
| InputStream getInputStream()         | 소켓에서 InputStream 객체를 가져옴      |
| OutputStream getOutputStream()       | 소켓에서 OutputStream 객체를 가져옴     |
| int getLocalPort()                   | 로컬 컴퓨터의 포트 번호를 가져옴        |
| int getPort()                        | 원격 컴퓨터의 포트 번호를 가져옴        |



#### Socket 통신 과정

![socket](./img/socketOverview.jpg)

1. 서버가 ServerSocket 객체를 생성. 클라이언트가 접속할 때까지 대기. 블로킹되어 스레드가 대기상태로 진입.
2. 클라이언트가 Socket객체를 생성함과 동시에 서버에 연결을 요청
3. 서버가 ServerSocket 객체의 accept() 메서드로 클라이언트의 연결을 승인하며, 클라이언트 소켓의 정보로 서버가 사용할 Socket 객체 생성
4. 입출력 스트림 생성. 서버, 클라이언트 각각의 Socket 객체로 getInputStream()과 getOutputStream() 메서드를 호출해 입출력 스트림을 가져옴.
5. 서로가 입출력 스트림을 이용해 데이터를 교환.
6. 한쪽이 소켓 연결을 끊으면, 입출력 스트림과 소켓을 닫음.