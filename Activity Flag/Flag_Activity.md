# Flag_Activity

### 재사용 Activity 관리 메서드 -  onNewIntent()

1. onPause()
2. onNewIntent(intent : Intent)
3. onResume()



### FLAG_ACTIVITY_SINGLE_TOP

+ 액티비티를 생성할 때, 스택에 이미 그 액티비티가 있으면 그 액티비티를 그대로 사용.
+ 동일 액티비티가 연속적으로 사용되어야 적용.



### FLAG_ACTIVITY_CLEAR_TOP

+ RootActivity, 동일한 액티비티를 제외한 모든 액티비티를 onDestroy() 시킴.



### FLAG_ACTIVITY_REORDER_TO_FRONT

+ 동일한 액티비티를 최상위로 올리며, onResume()으로 재시작.

### FLAG_ACTIVITY_NO_HISTORY

+ 이후 실행되는 액티비티가 스택에 쌓이지 않음.