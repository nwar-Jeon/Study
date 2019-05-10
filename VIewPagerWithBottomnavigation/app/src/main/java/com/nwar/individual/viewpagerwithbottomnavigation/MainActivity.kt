package com.nwar.individual.viewpagerwithbottomnavigation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        val fragment1 = Fragment1()
        val fragment2 = Fragment2()
        val fragment3 = Fragment3()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container,fragment1).commit()
        navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item1 -> replace(fragment1)
                R.id.item2 -> replace(fragment2)
                R.id.item3 -> replace(fragment3)
            }
            true
        }
    }
    fun replace(fragment : Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit()
    }
}
