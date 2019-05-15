package com.nwar.individual.animation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        val zoomIn = findViewById<Button>(R.id.zoomIn)
        val translate = findViewById<Button>(R.id.translate)
        zoomIn.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this,R.anim.anim1)
            textView.startAnimation(anim)
        }
        translate.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this,R.anim.anim2)
            textView.startAnimation(anim)
        }
    }
}
