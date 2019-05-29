package com.nwar.individual.canvas

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class CustomCanvas(context : Context, attr : AttributeSet?) : View(context,attr) {
    constructor(context : Context) : this(context, null)
    var strokeWidth : Int = 10
    var drawX : Float? = null
    var drawY : Float? = null
    val WHITE = 0
    val BLACK = 1
    val RED = 2
    val GREEN = 3
    val BLUE = 4
    var color = Paint()
    var mCanvas : Canvas? = null
    var img : Bitmap? = null
    init { setColor(WHITE) }

    fun setColor(color : Int){
        when(color){
            WHITE -> this.color.color = Color.rgb(255,255,255)
            BLACK -> this.color.color = Color.rgb(0,0,0)
            RED -> this.color.color = Color.rgb(255,0,0)
            GREEN -> this.color.color = Color.rgb(0,255,0)
            BLUE -> this.color.color = Color.rgb(0,0,255)
        }
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawBitmap(img,0F,0F,null)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_MOVE -> Log.e("Move",event?.x.toString() + event?.y.toString())
            else -> Log.e("Event", event?.x.toString() + event?.y.toString())
        }
        drawX = event?.x
        drawY = event?.y
        if(drawX!=null&&drawY!=null) {
            mCanvas?.drawCircle(drawX as Float, drawY as Float, strokeWidth.toFloat(),color)
        }
        invalidate()
        return super.onTouchEvent(event)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        this.img = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888)
        this.mCanvas = Canvas()
        mCanvas?.setBitmap(img)
        mCanvas?.drawColor(Color.WHITE)

    }
}