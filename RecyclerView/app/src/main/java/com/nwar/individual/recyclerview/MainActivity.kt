package com.nwar.individual.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity(){

    val stringArray = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        while(stringArray.size<20){
            stringArray.add("" + stringArray.size+1)
        }

        val adapter = Adapter(this,stringArray)
        val lm = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = lm
        recyclerView.setHasFixedSize(true)
        adapter.setOnClickListener{Toast.makeText(this,"클릭",Toast.LENGTH_SHORT).show()}
    }
}
