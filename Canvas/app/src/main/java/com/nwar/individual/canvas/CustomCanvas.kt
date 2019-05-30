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

const val WHITE = 0
const val BLACK = 1
const val RED = 2
const val GREEN = 3
const val BLUE = 4

class CustomCanvas(context : Context, attr : AttributeSet?) : View(context,attr) {
    constructor(context : Context) : this(context, null)
    var strokeWidth : Int = 10
    var drawX : Float? = null
    var drawY : Float? = null
    var color = Paint()
    var mCanvas : Canvas? = null
    var img : Bitmap? = null
    init {
        setColor(WHITE)
        setStrokeWidthF(strokeWidth)
        color.style = Paint.Style.FILL
    }

    fun setStrokeWidthF(width : Int){
        strokeWidth = width
        color.strokeWidth = width.toFloat()
    }

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
        val tempX = drawX
        val tempY = drawY
        drawX = event?.x
        drawY = event?.y
        if(drawX!=null&&drawY!=null) {
            when(event?.action){
                MotionEvent.ACTION_MOVE -> mCanvas?.drawLine(tempX as Float, tempY as Float, drawX as Float, drawY as Float, color)
                else -> mCanvas?.drawCircle(drawX as Float, drawY as Float, strokeWidth.toFloat()/2F,color)
            }
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