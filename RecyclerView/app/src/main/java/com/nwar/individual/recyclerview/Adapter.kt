package com.nwar.individual.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class Adapter(val context : Context, val list : ArrayList<String>) : RecyclerView.Adapter<Adapter.ViewHolder>(){
    var listener : () -> Unit = {Toast.makeText(context,"클릭",Toast.LENGTH_SHORT).show()}

    fun setOnClickListener(listener : () -> Unit){
        this.listener = listener
    }

    class ViewHolder(view : View, val parent : Adapter) : RecyclerView.ViewHolder(view){
        val textView = view.findViewById<TextView>(R.id.recycler_text)
        fun setItem(position : Int){
            textView.text = "item " + position.toString()
            textView.setOnClickListener {
                parent.listener()
            }
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(p0: Adapter.ViewHolder, p1: Int) {
        p0.setItem(p1+1)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder
            = ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item,p0,false), this)

    fun addItem(){
        list.add("" + list.size+1)
    }
}