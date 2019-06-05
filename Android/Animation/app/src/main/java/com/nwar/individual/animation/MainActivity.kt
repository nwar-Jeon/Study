package com.nwar.individual.animation
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var textView : TextView
    var isPageOpen = false
    lateinit var slide : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        val zoomIn = findViewById<Button>(R.id.zoomIn)
        val translate = findViewById<Button>(R.id.translate)
        val rotate = findViewById<Button>(R.id.rotate)
        val alpha = findViewById<Button>(R.id.alpha)
        slide = findViewById<ConstraintLayout>(R.id.slide)
        val slideButton = findViewById<Button>(R.id.pageSlide)
        val animListener = AnimListener()
        val showOutAnim = AnimationUtils.loadAnimation(this,R.anim.tranlate_showout)
        val showInAnim = AnimationUtils.loadAnimation(this,R.anim.translate_showin)
        showOutAnim.setAnimationListener(animListener)
        showInAnim.setAnimationListener(animListener)

        zoomIn.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this,R.anim.anim1)
            setAnim(anim)
        }
        translate.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this,R.anim.anim2)
            setAnim(anim)
        }
        rotate.setOnClickListener {
            val anim = AnimationUtils.loadAnimation(this,R.anim.rotate)
            setAnim(anim)
        }
        alpha.setOnClickListener {
            setAnim(AnimationUtils.loadAnimation(this,R.anim.alpha))
        }

        slideButton.setOnClickListener {
            if(isPageOpen){
                slide.startAnimation(showOutAnim)
            } else {
                slide.visibility = View.VISIBLE
                slide.startAnimation(showInAnim)
            }
            isPageOpen = !isPageOpen
        }
    }

    inner class AnimListener : Animation.AnimationListener{
        override fun onAnimationEnd(animation: Animation?) {
            if(!isPageOpen){
                slide.visibility = View.GONE
            }
        }

        override fun onAnimationRepeat(animation: Animation?) {
        }

        override fun onAnimationStart(animation: Animation?) {
        }
    }

    fun setAnim(anim : Animation){
        textView.startAnimation(anim)
    }
}