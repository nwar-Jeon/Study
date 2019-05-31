# Unit Test

intellij, android studio의 경우, test폴더 내에 테스트 클래스 작성, 실행. 메소드는 모두 public이어야만 함.

*intellij: File-> Project Structure-> Modules -> Sources 에서 Test폴더 선택 -> Mark as: Tests.

```java
public class Test{
  @Test
  public void run(){
    System.out.println("Run!");
  }
  
  @Test(timeout=5000)
  public void sum(){
    System.out.println(5+5);
  }
  
  @Test(expected=xxxException.class)
  public void exception(){
    String str = null;
    System.out.println(str.toString())
  }
  
  int a, b;
  @BeforeClass
  public static void before() throws Exception{
    this.a = 6;
    this.b = 10;
  }
  
  @AfterClass
  public static void after() throws Exception{
    
  }
}
```

### @Test

+ 테스트 대상 메소드 지정(바로 아래 메서드를 테스트.)

+ @Test(timeout=5000) :  메서드가 5000밀리세컨드 안에 끝나는지 체크.

+ @Test(expected=xxxException.class) : xxxException이 발생하는지 체크(발생해야 성공.)

+ + #### Test 성공 여부 판단 메서드

  + assertArrayEquals(a,b) : 배열 a와 b가 일치하는지 확인

  + assertEquals(a,b) : 객체 a와 b의 값이 같은지 확인

  + assertSame(a,b) : 객체 a와 b가 같은 객체인지 확인

  + assertTrue(a) : a가 true인지 확인

  + assertNotNull(a) : 객체가 null이 아님을 확인

  + 등등..

### @BeforeClass

+ 테스트 클래스에서 딱 한번씩만 실행.
+ 테스트 클래스 시작 직전에 실행되며, 정적메서드로 지정.

### @AfterClass

+ 테스트 클래스에서 딱 한번씩만 실행.
+ 테스트 클래스가 끝나면 실행되며, 정적메서드로 지정.

### @Before, @After

+ 해당 테스트 클래스 안의 메소드 테스트 전, 후에 각각 실행되는 어노테이션.

![hjkwon-140729-JUnit_-11](D:\Github\Android\Study\intellij\UnitTest\hjkwon-140729-JUnit_-11.png)

