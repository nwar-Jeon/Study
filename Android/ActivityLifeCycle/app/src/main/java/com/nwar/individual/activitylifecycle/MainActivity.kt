package com.nwar.individual.activitylifecycle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("lifeCycle","onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("lifeCycle","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("lifeCycle","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("lifeCycle","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("lifeCycle","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("lifeCycle","onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("lifeCycle","onRestart")
    }
}
