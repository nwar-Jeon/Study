package com.nwar.individual.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.support.v7.widget.AppCompatButton
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent

class CustomButton(context : Context, attr : AttributeSet?) : AppCompatButton(context, attr) {
    constructor(context: Context) : this(context, null)
    init {
        setBackgroundColor(Color.BLACK)
        setTextColor(Color.WHITE)
        setTextSize(resources.getDimension(R.dimen.textSize))
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        Log.i("CustomView","onTouchEvent")
        when(event?.action){
            MotionEvent.ACTION_DOWN -> {
                setBackgroundColor(Color.WHITE)
                setTextColor(Color.BLACK)
            }
            MotionEvent.ACTION_OUTSIDE, MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_UP -> {
                setBackgroundColor(Color.BLACK)
                setTextColor(Color.WHITE)
            }
        }
        invalidate()
        return true
    }

    override fun onDraw(canvas: Canvas?) {
        Log.i("CustomView","onDraw")
        super.onDraw(canvas)
    }
}