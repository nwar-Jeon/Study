package com.nwar.individual.actionbar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_add -> showToast("add")
            R.id.menu_search -> showToast("search")
            R.id.menu_setting -> showToast("setting")
        }
        return super.onOptionsItemSelected(item)
    }
    fun showToast(str : String){
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show()
    }
}
