package com.nwar.individual.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class CustomStroke(context: Context, attr : AttributeSet?) : View(context, attr) {
    constructor(context : Context) : this(context,null)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val pathPaint = Paint()
        pathPaint.isAntiAlias = true
        pathPaint.color = Color.BLACK
        pathPaint.style = Paint.Style.STROKE
        pathPaint.strokeWidth = 20.0F
        val path = Path()
        path.moveTo(100F,100F)
        path.lineTo(150F,125F)
        path.lineTo(170F,200F)

        canvas?.drawPath(path,pathPaint)
        pathPaint.color = Color.GREEN
        pathPaint.strokeCap = Paint.Cap.ROUND
        pathPaint.strokeJoin = Paint.Join.ROUND

        path.offset(100F,100F)
        canvas?.drawPath(path,pathPaint)

        canvas?.drawPath(path,pathPaint)
        pathPaint.color = Color.GREEN
        pathPaint.strokeCap = Paint.Cap.SQUARE
        pathPaint.strokeJoin = Paint.Join.BEVEL

        path.offset(100F,100F)
        canvas?.drawPath(path,pathPaint)
    }
}