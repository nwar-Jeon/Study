package com.nwar.individual.canvas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
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
    lateinit var canvas : CustomCanvas
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkList = listOf(R.id.checkWhite, R.id.checkBlack, R.id.checkRed, R.id.checkGreen, R.id.checkBlue)
        backgroundList = listOf(R.id.backgoundWhite,R.id.backgoundBlack,R.id.backgoundRed,R.id.backgoundGreen,R.id.backgoundBlue)

        canvas = findViewById<CustomCanvas>(R.id.canvas)
        findViewById<EditText>(R.id.inputWidth).apply {
            addTextChangedListener(object : TextWatcher{
                override fun afterTextChanged(s: Editable?) {
                    val width = if(s?.toString()!="") s?.toString()?.toInt() else 0
                    if(null!=width)
                    canvas.setStrokeWidthF(width)
                }
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                }
            })
        }

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
            canvas.setColor(selectColor)
        }
    }
}
