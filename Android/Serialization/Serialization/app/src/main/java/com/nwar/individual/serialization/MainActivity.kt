package com.nwar.individual.serialization

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, Main2Activity::class.java)
        intent.putExtra("data", Data(1234,"asdf"))
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            startActivity(intent)
        }
    }
}
