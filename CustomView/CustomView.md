# CustomView

### widget

```java
AppCompat$Widget 클래스 상속
(Widget : Button, EditText, TextView, etc.)

public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
  // 뷰가 스스로의 크기를 정할 때 호출.
public void onDraw(Canvas canvas)
  // 스스로를 레이아웃에 맞게 그림. 뷰를 원하는 모양으로 만들 수 있음.
void setMeasuredDimension(int measuredWidth, int measuredHeight)
  // onMeasure()에서 이 뷰를 담은 레이아웃에게 뷰의 크기 반환.
public boolean onTouchEvent(MotionEvent event)
  // 뷰가 클릭되었을 때 호출
```

1. onDraw()로 뷰가 그려짐
2. 사용자 클릭 onTouchEvent()
3. invalidate() 함수를 호출하여 onDraw()를 호출
4. 뷰를 다시 그림.

### Layout

```kotlin
Layout 상속(Constraint, Linear, etc.)
init{
  val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
  inflater.inflate(/*레이아웃 이름*/, this, true)
}
를 통해 레이아웃을 인플레이트함.


```

