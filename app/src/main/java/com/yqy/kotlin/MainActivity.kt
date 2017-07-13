package com.yqy.kotlin

import android.view.View
import com.yqy.kotlin.frame.BaseActivity
import com.yqy.kotlin.listener.OnClickBackListener

class MainActivity : BaseActivity() {
    override fun preView(): Int = R.layout.activity_main

    override fun initView() {
    }

    override fun addListener() {
    }

    override fun initData() {
    }

    override fun getOnBackClickListener(): OnClickBackListener = null!!

    override fun onClick(v: View?) {
    }

}
