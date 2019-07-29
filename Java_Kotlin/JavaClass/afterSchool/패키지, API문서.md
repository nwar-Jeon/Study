# 패키지, API문서



### java, javax

+ java

  : 자바 기본 패키지

+ javax

  : 자바 확장 패키지



#### 자주 사용하는 자바의 기본, 확장 패키지

| 패키지      | 설명                      |
| ----------- | ------------------------- |
| java.awt    | 그래픽 API                |
| java.io     | 입출력 API                |
| java.lang   | 자바 프로그램 필수 API    |
| java.math   | 수학관련 API              |
| java.net    | 네트워크 API              |
| java.text   | 날짜, 시간, 문자열 API    |
| java.time   | 날짜 및 시간 API          |
| java.util   | 날짜, 리스트, 벡터 등 API |
| javax.swing | 스윙 컴포넌트 API         |



### [자바 독스 주소](http://docs.oracle.com/javase/8/docs/api/)



## java.lang 패키지



### 주 클래스

+ Class
+ Math
+ Object
+ String
+ StringBuffer
+ StringBuilder
+ System
+ Thread
+ Type Boxing Class



### Object 클래스

모든 클래스의 부모.

#### 메서드

```java
public String toString();
public boolean equals(Object o);
public int hashCode();
protected Object clone();
protected void finalize();
public final Class<?> getClass()
```



### Class 클래스

자바 프로그램 내부에 포함된 클래스/인터페이스 정보를 제공하기 위함.

getName(), getSimpleName(), getClass() 등의 메서드를 제공.



### Math 클래스

지수, 로그 등 기본 산술 연산하는 정적 메서드 제공.

#### 메서드

```java
static double abs(double a) // 절댓값
static double cos(double a) // sine값
static double exp(double a) // 아래 각주 참조
static double log(double a) // 자연 로그 값
static double log10(double a) // 10의 로그 값
static double max(double a, double b) // 둘 중 큰 값 반환
static double min(double a, double b) // 둘 중 작은 값 반환
static double pow(double a, double b) // 아래 각주 참조
static double random() // 0.0~1.0 난수
static double sin(double a) // cosine값
static double sqrt(double a) // 제곱근 값
static double tan(double a) // tangent값
```

[^exp()]: e<sup>a</sup>값
[^pow()]: a<sup>b</sup>값



### StringBuffer, StringBuilder 클래스

변경될 수 있는 문자열

+ StringBuffer : 다중 스레드 환경에서 안전.
+ StringBuilder : 다중 스레드 환경에서 안전하지 않음.

#### 메서드

```java
StringBuilder append(String s) // s를 버퍼에 덧붙임.
int capacity() //버퍼 크기 반환
StringBuilder delete(int start, int end) // 문자열 일부 제거
StringBuilder insert(int offset, String s) // offset위치에 s 문자열 삽입
StringBuilder replace(int start, int end, String s) // 문자열 일부를 s 문자열로 대체
StringBuilder reverse() // 문자열 뒤집기.
```



### System 클래스

표준 입출력 비롯, 실행 시스템과 관련된 필드, 메서드.

#### 필드

```java
static InputStream in
static PrintStream out
static PrintStream err
```

#### 메서드

```java
static void arraycopy(Object src, int srcPosition, Object dest, int destPosition, int length) // src배열의 srcPosition인덱스부터 length개를 dest배열의 destPosition인덱스에 복사.
static long currentTimeMillis() // 현재 시각을 밀리초 단위로 반환
static void exit() // JVM 종료
static void gc() // 가비지 컬렉터 실행
static String getenv(String name) // 지정된 환경 변수값 반환
static String getProperty(String k) // k에 해당하는 시스템 특성 반환
static long nanoTime() // 현재 시각 나노초 단위 반환.
```



### Type Boxing 클래스

기초 타입을 포장해 클래스화한 클래스.

| 기초타입 | 포장클래스 |
| -------- | ---------- |
| int      | Integer    |
| byte     | Byte       |
| short    | Short      |
| long     | Long       |
| float    | Float      |
| double   | Double     |
| char     | Character  |
| boolean  | Boolean    |

#### 계층 구조

+ Object
  + Boolean
  + Character
  + Number
    + Byte
    + Short
    + Integer
    + Long
    + Float
    + Double



#### Boxing과 UnBoxing

Boxing : 기초 타입 데이터를 객체화

UnBoxing : 객체화된 데이터를 기초타입으로 변환.



#### Boxing 방법

+ 생성자 활용
+ valueOf() 메서드 활용(정적 메서드임.)

#### UnBoxing 방법

+ typeValue()메서드 활용 (int : intValue(), double : doubleValue() ... )

#### 자동 Boxing

기초 타입 데이터를 포장 클래스 객체에 대입하거나 반대 상황일 경우, 자동으로 Boxing/UnBoxing을 수행.



## java.util 패키지



### 주 클래스

+ Arrays
+ Calendar
+ Date
+ StringTokenizer
+ Random



### Arrays 클래스

배열의 정렬, 복사, 탐색 등 배열 조작의 메서드 제공.

#### 메서드

| 메서드                                              | 설명                       |
| --------------------------------------------------- | -------------------------- |
| List asList(type[] arr)                             | 배열을 리스트로 변환       |
| int binarySearch(type[] arr, type k)                | 배열에서 k값의 인덱스 반환 |
| type[] copyOf(type[] arr, int length)               | 배열을 길이만큼 복사       |
| type[] copyOfRange(type[] arr, int start, int end)  | 배열을 지정 영역만큼 복사  |
| boolean equals(type[] arr1, type[] arr2)            | 두 배열 비교               |
| void fill(type[] arr, type obj)                     | 배열을 obj로 초기화        |
| void fill(type[] arr, int start, int end, type obj) | 지정 영역을 obj로 초기화   |
| void sort(type[] arr)                               | 배열 오름차순 정렬.        |



### Date, Calendar

+ Date

  Date클래스의 메서드는 대부분 Deprecated되는 중. 국제화에 맞지 않으므로 폐기 중.

+ Calendar

  지역/문화에 따라 달력 표시가 다르므로 추상 클래스로 이루어져 있음.

  표준 달력을 얻기 위해서는 Calendar.getInstance() 메서드(정적 메서드) 이용.

#### Calendar 상수 필드

+ AM
+ AM_PM
+ PM
+ DATE
+ JANUARY ... DECEMBER
+ SUNDAY ... SATURDAY
+ MINUTE, HOUR, MONTH, YEAR
+ ETC.

#### Calendar 메서드

| 메서드                        | 설명                              |
| ----------------------------- | --------------------------------- |
| boolean after(Object w)       | 주어진 시간보다 뒤면 true         |
| boolean before(Object w)      | 주어진 시간보다 앞이면 true       |
| void clear(int f)             | 지정 필드를 미정 상태로 변경      |
| boolean compareTo(Calendar a) | 객체, 주어진 객체 비교            |
| int get(int f)                | 주어진 필드값 반환                |
| int getFirstDayOfWeek()       | 첫 날의 요일 반환                 |
| static Calendar getInstance   | 현재시각 표시하는 객체 반환       |
| Date getTime()                | Date객체로 변환                   |
| void set(int f, int v)        | 주어진 필드를 주어진 값으로 변경. |
| void set(int y, int m, int d) | 연, 월, 일값 변경                 |
| void setTime(Date d)          | Date객체로 Calendar 객체 설정.    |



### StringTokenizer 클래스

문자열을 토큰으로 분리.

#### 생성자

+ StringTokenizer(String s) // 기본 구분자(tab, 공백, \n, 복귀, 용지 먹임)
+ StringTokenizer(String s, String d) // d를 구분자로 사용.

#### 메서드

+ int countTokens() // 남은 토큰 수 반환
+ boolean hasMoreTokens() // 토큰이 남았는지 여부.
+ String nextToken() // 다음 토큰을 꺼냄.



### Random 클래스

48비트 시드, 선형 혼합식 알고리즘으로 난수 반환.

동일 시드로 생성된 Random객체는 동일 난수 발생.

#### 메서드

+ nextBoolean,Float,Double,Int,Long() // 각 타입에 맞는 난수 반환
+ setSeed(long seed) // 시드 값 설정



## java.text 패키지



### SimpleDateFormat 클래스

#### 패턴 기호

| 기호 | 설명    | 기호 | 설명     |
| ---- | ------- | ---- | -------- |
| y    | 연      | h    | 시(1~12) |
| M    | 월      | H    | 시(0~23) |
| w    | 연의 주 | k    | 시(1~24) |
| W    | 월의 주 | K    | 시(0~11) |
| d    | 일      | m    | 분       |
| D    | 연의 일 | s    | 초       |
| E    | 요일    | S    | 밀리초   |
| a    | am/pm   | z    | 타임존   |

yyyy : 네자리 연도

MM : 두자리 월

#### 패턴 적용

+ 생성자 이용
+ format(String s) 메서드 이용해 문자열 반환.
+ parse(String s) 메서드 이용해 Date객체 반환



### MessageFormat 클래스

문자열을 특정 포맷에 맞추어 처리하기 위해 사용.

#### 예시

```java
MessageFormat.format("{0} * {1} = {2}", 3, 4, 3*4);
>>> 3 * 4 = 12
```



### DecimalFormat 클래스

정수, 실수, 등 다양한 종류의 수를 포맷함.

| 기호 | 설명             |
| ---- | ---------------- |
| #    | 10진수           |
| 0    | 선행 제로 10진수 |
| .    | 소수점           |
| ,    | 구분자           |
| +/-  | 양수/음수        |
| E    | 지수             |
| ;    | 패턴 구분        |
| %    | 백분율           |

