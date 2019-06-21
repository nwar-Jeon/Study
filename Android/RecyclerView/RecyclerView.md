# RecyclerView

### Data Module

```kotlin
class Data(val valueName : Type)
```

### RecyclerView Adapter

```kotlin
class MainAdapter (val context : Context, val items : ArrayList<Data>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
  
  final val DEFAULT_ITEM = 1
  
  inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
    fun bind(info : Data, context: Context){ // 사용자지정함수.
      //onBindViewHolder에서 호출.
    }
    //사용자지정 메서드 추가.(자유)
  }
  
  override fun getItemViewType(position : Int) : Int{ // 아이템 뷰타입을 결정할 수 있게해줌.
    return DEFAULT_ITEM
  }
  
  override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): RecyclerView.ViewHolder{ // 리사이클러뷰의 아이템 내용을 지정.
    view = ViewHolder(LayoutInflater.from(context).inflate(R.layout.item,p0,false))
    return view
  }
  
  override fun onBindViewHolder(p0: RecyclerView.ViewHolder, position: Int){
    //리사이클러뷰에서 동적으로 아이템을 지정할 코드. p0.bind(items[position],context)
  }
  
  override fun getItemCount():Int{
    return items.size
  }
}
//onCreateViewHolder를 오버라이드해야함.
```

### RecyclerView set

```kotlin
val adapter = MainAdapter(this : Context, list : arrayListOf<Data>)
val lm = LinearLayoutManager(this : Context)
val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

recyclerView.adapter = adapter
recyclerView.layoutManager = lm
recyclerView.setHasFixedSize(true)
```

### else

```kotlin
notifyItemInserted(index: Int) // index 원소에 아이템 삽입
notifyItemRemoved(index: Int) // index 번째 아이템 삭제
notifyItemChanged(index: Int) // index 번째 아이템 교체
notifyItemRange<Inserted>,<Removed>,<Changed>(start: Int, count: Int)// start부터 count개를 각각 위의 메소드와 같은 동작을 함.
notifyDataSetChanged() // 리사이클러뷰의 데이터가 변경되었을때.
notifyItemMoved(from:Int, to:Int) // from아이템을 to로 이동
```

```xml
<android.support.v7.widget.RecyclerView>
  tools:listitem="@layout/item"
</android.support.v7.widget.RecyclerView>
<!--  리사이클러뷰에 아이템 적용된 상태를 미리보기 하도록 함. -->
```

