# WebView

+ 퍼미션 추가하기

```xml
<uses-permission android:name="android.permission.INTERNET"/>
<application
             android:usesCleartextTraffic="true">
</application>
```

```kotlin
웹뷰.webViewClient = WebViewClient()
웹뷰.loadUrl(url)
```

