package com.example.work11.animators

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.work11.R

/**
 * Created by anchaoguang on 2019-09-24.
 *
 */
class Animator1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animator1)
    initView()
    }
    private fun initView(){
        val  mButton = findViewById<Button>(R.id.animator1_button)
        mButton.setOnClickListener {
            val wrapper = Inner(mButton)
            ObjectAnimator.ofInt(wrapper,"width",500).setDuration(5000).start()
        }
    }

    class Inner(target: View){
    private var mTarget: View?= target
        fun getWidth():Int{
            return mTarget!!.layoutParams.width
        }

        fun setWidth(with:Int){
            mTarget!!.layoutParams.width = with
            mTarget?.requestLayout()
        }
    }
}