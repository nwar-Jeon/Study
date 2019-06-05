package com.nwar.individual.actionbar

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity

class CoordinatorTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coordinator)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.addTab(tabLayout.newTab().setText("첫 번째"))
        tabLayout.addTab(tabLayout.newTab().setText("두 번째"))
        tabLayout.addTab(tabLayout.newTab().setText("세 번째"))
    }
}