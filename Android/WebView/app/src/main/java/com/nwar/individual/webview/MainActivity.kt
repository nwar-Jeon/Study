package com.nwar.individual.webview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val inputUrl = findViewById<EditText>(R.id.inputUrl)
        val openWeb = findViewById<Button>(R.id.openWeb)
        val webView = findViewById<WebView>(R.id.webview)
        webView.webViewClient = ViewClient()
        openWeb.setOnClickListener {
            webView.loadUrl(inputUrl.text?.toString())
        }
    }
    inner class ViewClient : WebViewClient(){
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return true
        }
    }
}
