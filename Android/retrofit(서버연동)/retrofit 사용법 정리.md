- 라이브러리 추가

```xml
<uses-permission android:name="android.permission.INTERNET"/>
```

```c
dependencies{
    implementation 'com.squareup.retrofit2:retrofit:{version}'
    implementation 'com.squareup.retrofit2:converter-gson:{version}'
      implementation 'com.squareup.retrofit2:adapter-rxjava2:${rxjava_version}' // retrofit을 rxjava로 사용.
}
```



- VO

```kotlin
class 클래스명2(val map : JsonObject, val myTeam : Int, val myTeamColor : String)
```



- API 인터페이스

```java
public interface 인터페이스명{
    @GET("Map")
    Call<클래스명2> getMap(
    	@Header("Authorization") String Authorization
    );
}
```



- URL 설정

```java
public class ServiceGenerator {

    private static final String URL = "BaseURL";
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build());
    private static Retrofit retrofit = builder.build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
```



- 데이터 가져오기

```kotlin
fun 메소드명() : Unit{
    var retrofit = ServiceGenerator.createService(인터페이스명.class)
    var call : Call<클래스명2> = retrofit.getMap("토큰")
    call.enqueue(object : Callback<클래스명2>{
        override fun onResponse(call : Call<클래스명2>, response : Response<클래스명2>){
            val repo : 클래스명2 = response.body() //repo.getMap()
        }
      	override fun onFailure(call : Call<클래스명2>, t : Throwable){
            
        }
    })
}
```



- 순회

```kotlin
val json = JsonObject()
var i = boothList.keys()
var keyList = ArrayList<String>()
while(i.hasNext()){
  var b = i.next().toString()
  keyList.add(b)
}
```



