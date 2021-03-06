package com.nwar.individual.viewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val list = ArrayList<Fragment>().apply {
            add(FirstFragment())
            add(SecondFragment())
        }
        val adapter = ViewPagerAdapter(list,supportFragmentManager)
        viewPager.adapter = adapter
    }
}
