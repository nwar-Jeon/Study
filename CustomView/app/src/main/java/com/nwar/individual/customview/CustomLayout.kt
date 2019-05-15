package com.nwar.individual.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout

class CustomLayout(context: Context, attr : AttributeSet?) : LinearLayout(context,attr) {
    constructor(context: Context) : this(context,null)
    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.linear,this,true)
    }
}