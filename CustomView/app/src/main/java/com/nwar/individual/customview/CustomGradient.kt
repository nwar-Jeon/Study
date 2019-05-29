package com.nwar.individual.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Shader
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.util.AttributeSet
import android.view.View
import android.view.WindowManager

class CustomGradient(context: Context, attr : AttributeSet?) : View(context, attr) {
    constructor(context : Context) : this(context,null)

    val upperDrawable = ShapeDrawable()
    val lowerDrawable = ShapeDrawable()

    init {
        val manager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = manager.defaultDisplay
        val width = display.width
        val height = display.height
        val curRes = resources
        val black = curRes.getColor(R.color.color01)
        val gray = curRes.getColor(R.color.color02)
        val darkGray = curRes.getColor(R.color.color03)

        val rectangle = RectShape()
        rectangle.resize(width.toFloat(), height*2/3.toFloat())
        upperDrawable.shape = rectangle
        upperDrawable.setBounds(0,0,width,height*2/3)

        val gradient = LinearGradient(0F,0F,0F,height*2F/3F,gray,darkGray, Shader.TileMode.CLAMP)
        val paint = upperDrawable.paint
        paint.shader = gradient

        val rectangle2 = RectShape()
        rectangle2.resize(width.toFloat(),height/3F)
        lowerDrawable.shape = rectangle2
        lowerDrawable.setBounds(0,height*2/3,width,height)
        val gradient2 = LinearGradient(0F,0F,0F,height/3F,darkGray,black,Shader.TileMode.CLAMP)
        val paint2 = lowerDrawable.paint
        paint2.shader = gradient2
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        upperDrawable.draw(canvas)
        lowerDrawable.draw(canvas)
    }
}