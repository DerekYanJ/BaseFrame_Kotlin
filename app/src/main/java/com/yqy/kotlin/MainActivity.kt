package com.yqy.kotlin

import android.os.Bundle
import android.view.View
import android.widget.TextView
import butterknife.bindView
import com.yqy.kotlin.frame.AbstractActivity
import com.yqy.kotlin.listener.OnClickBackListener

class MainActivity : AbstractActivity() {

    override fun getOnBackClickListener(): OnClickBackListener {
        return object : OnClickBackListener {
            override fun onClickBack() {

            }
        }
    }

    override fun initView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addListener() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun preView(): Int = R.layout.activity_main

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val textview: TextView by bindView(R.id.textview)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

}
