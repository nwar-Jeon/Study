package com.nwar.individual.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

class CustomView(context : Context, attr : AttributeSet?) : View(context,attr) {
    constructor(context: Context) : this(context,null)
    val paint = Paint()
    init {
        paint.color = Color.RED
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event?.action==MotionEvent.ACTION_DOWN){
            Toast.makeText(context,event.x.toString() + " " + event.y.toString(), Toast.LENGTH_SHORT).show()
        }
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.style = Paint.Style.FILL
        canvas?.drawRect(10F,10F,100F,100F,paint)

        paint.style = Paint.Style.STROKE
        paint.color = Color.GREEN
        canvas?.drawRect(10F,10F,100F,100F,paint)

        paint.style = Paint.Style.FILL
        paint.setARGB(128,0,0,255)
        canvas?.drawRect(120F,10F,510F,400F,paint) // 좌우 120부터 510까지, 상하 10부터 400까지 그림.

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 30F
        paint.pathEffect = DashPathEffect(floatArrayOf(100F,5F),1F)    // 점선의 길이.
        paint.color = Color.GREEN
        canvas?.drawRect(120F,10F,510F,400F,paint)
        //drawLine(), drawCircle(), drawText() 등이 있음.


    }
}