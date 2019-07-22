package com.nwar.individual.socket

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var editText : EditText
    lateinit var sendTextView : TextView
    lateinit var serverTextView : TextView
    lateinit var sendButton : Button
    lateinit var serverButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editText)
        sendButton = findViewById(R.id.send_button)
        sendTextView = findViewById(R.id.send_textView)
        serverButton = findViewById(R.id.server_button)
        serverTextView = findViewById(R.id.server_textView)
    }
}
