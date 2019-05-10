Fragment

+ Fragment?
+ + 부분 화면.

+ 액티비티와 마찬가지로, 액티비티가 액티비티 매니저를 통해 동작하듯, 프래그먼트는 프래그먼트 매니저를 통해 동작함.

![프래그먼트 작동](D:\Github\Android\Study\Fragment\프래그먼트 작동.png)

### Fragment method

```java
public final Activity getActivity()
  -> 프래그먼트를 포함하는 액티비티 반환
public final FragmentManager getFragmentManager()
  ->프래그먼트를 포함하는 액티비티의 프래그먼트 매니저를 반환.
public final Fragment getParentFragment()
  ->이 프래그먼트를 포함하는 프래그먼트를 반환/액티비티일 경우 null 반환.
public final int getId()
  ->프래그먼트 id 반환.
```

### FragmentManager method

```java
public abstract FragmentTransaction beginTransaction()
  ->프래그먼트를 변경하기 위한 트랜잭션 시작.
public abstract Fragment findFragmentById(int id)
  ->ID를 이용해 프래그먼트 객체를 찾아 반환
public abstract Fragment findFragmentByTag(String tag)
  ->태그 정보를 이용해 프래그먼트 객체를 찾아 반환
public abstract boolean executePendingTransactions()
  ->즉시 실행 시 호출
```

+ 프래그먼트를 액티비티에 add, replace, remove할 때 주로 사용.

### Fragment Lifecycle

1. onAttach(Activity) 프래그먼트와 액티비티 연결 시 호출
2. onCreate(Bundle) 프래그먼트 초기화 시 호출(객체생성 아님.)
3. onCreateView(LayoutInflator, ViewGroup, Bundle) 프래그먼트와 관련되는 뷰 생성, 반환
4. onActivityCreated(Bundle) 액티비티가 onCreate()가 끝났을 때 호출.
5. onStart() 액티비티의 onStart()가 호출될 때 호출.
6. onResume() 액티비티의 onResume()이 호출될 때 호출.
7. onPause() 액티비티의 onPause() 호출 시 호출.
8. onStop() 액티비티의 onStop() 호출 시 혹은 프래그먼트 기능 중지 시 호출.
9. onDestroyView() 프래그먼트와 관련된 뷰 리소스 해제
10. onDestroy() 프래그먼트 정리(완전히 삭제.)
11. onDetach() 액티비티와의 연결 끊음.

![fragment](D:\Github\Android\Study\Fragment\fragment.jpg)

```kotlin
val fragment = xxxFragment()
// 프래그먼트 객체생성. 동작하지는 않음.
supportFragmentManager.beginTransaction().add(fragment).commit()
//프래그먼트가 액티비티에 추가된 후, 프래그먼트로 동작.
```

  