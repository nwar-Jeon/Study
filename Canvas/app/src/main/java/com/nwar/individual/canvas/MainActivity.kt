package com.nwar.individual.canvas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val WHITE = 0
    val BLACK = 1
    val RED = 2
    val GREEN = 3
    val BLUE = 4
    var selectColor = WHITE
    var width = 10
    lateinit var checkList : List<Int>
    lateinit var backgroundList : List<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkList = listOf(R.id.checkWhite, R.id.checkBlack, R.id.checkRed, R.id.checkGreen, R.id.checkBlue)
        backgroundList = listOf(R.id.backgoundWhite,R.id.backgoundBlack,R.id.backgoundRed,R.id.backgoundGreen,R.id.backgoundBlue)

        for(o : Int in backgroundList) {
            findViewById<LinearLayout>(o).setOnClickListener(this)
        }

    }

    override fun onClick(v: View?) {
        Toast.makeText(this,"클릭",Toast.LENGTH_SHORT).show()
        if(backgroundList.contains(v?.id)){
            findViewById<ImageView>(checkList[selectColor]).visibility = View.INVISIBLE
            selectColor = backgroundList.indexOf(v?.id)
            Log.e("indexInfo",selectColor.toString())
            findViewById<ImageView>(checkList[selectColor]).visibility = View.VISIBLE
            findViewById<CustomCanvas>(R.id.canvas).setColor(selectColor)
        }
    }
}
