package com.nwar.individual.serialization

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intent = intent
        val textView = findViewById<TextView>(R.id.textView1)
        val data = intent.getParcelableExtra<Data>("data")
        textView.text = data.id.toString() + data.name
    }
}
