package com.nwar.individual.httpconnect

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    val handler = Handler()
    lateinit var editText : EditText
    lateinit var textView : TextView
    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            val url = editText.text.toString()
            Thread{
                request(url)
            }.start()
        }
    }

    fun request(urlString : String){
        val output = StringBuilder()
        val url = URL(urlString)

        val connect = url.openConnection() as? HttpURLConnection
        connect?.let {
            it.connectTimeout = 10000
            it.requestMethod = "GET"
            it.doInput = true

            val resCode = it.responseCode
            val reader = BufferedReader(InputStreamReader(it.inputStream))
            while(true){
                val line = reader.readLine()
                line ?: break
                output.append(line + "\n")
            }
            reader.close()
            it.disconnect()
        }
        handler.post {
            textView.text = output
        }
    }
}