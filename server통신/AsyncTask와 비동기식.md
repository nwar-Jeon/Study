<h1>
  메인쓰레드와 비동기 처리
</h1>

<h4>
  필요한 이유?
</h4>

무언가를 다운로드 할 때, 메인쓰레드가 이를 처리하면, 다운로드 중 UI는 먹통이 되어있을 것이다.

다운로드와 UI동작이 동시에 가능하도록 처리해야하며, 이것을 **비동기 처리**라고 한다.

이를 위한 것이 **AsyncTask**이다.

<h4>
  AsyncTask?
</h4>

- 메인쓰레드에서 수행될 작업을 수행해주는 비동기적 처리 방법 중 하나.

+ + 메인쓰레드의 작업을 더 효율적이게 해줄 수 있는 백그라운드 처리 기법.(오랜시간 작업의 경우 다른 방법을 권장.)

![2508A94158FF825A22](C:\Users\nwar0\Desktop\2508A94158FF825A22.png)

(AsyncTask에서 지원하는 메서드들과 쓰임.)

<h3>
  사용방법
</h3>

-----------------------------------------------------

```java
@Override
protected void onCreate(Bundle savedinstanceState){
  super.onCreate(savedinstanceState);
  setContentView(R.layout.~~~);
  DownLoadTask downLoadTask = new DownLoadTask();
  Integer[] arr = new Integer[3];
  downLoadTask.execute(arr);
  downLoadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, arr);
}
```



객체를 생성해 execute()메서드와 executeOnExecutor()메소드를 호출한다.

- excute() : 일반적인 수행방법이며, 여러 AsyncTask객체를 만들어 다수의 작업 수행. 호출된 순서대로 처리
- exevuteOnExecutor() : 병렬처리를 위한 수행 방법이며, 여러 AsyncTask객체를 만들어 다수의 작업 동시에 처리.

----------------------------------------------------------------

<h3>
  주의점
</h3>

+ AsyncTask 수행을 위해 생성된 객체는 execute()를 통해 한번만 실행가능
+ 메인쓰레드에서만 실행되고 호출되어야함.
+ Activity 종료 후에 memory leak이 발생할 수 있음. cancel()을 통해 doInBackground() 실행 후 onPostExcute()호출을 막고 onCancelled를 호출하도록 해야 함.

