package com.yqy.kotlin

import android.app.Application
import com.blankj.utilcode.utils.AppUtils

/**
 *
 * Created by DerekYan on 2017/7/13.
 */
object App : Application() {
    var VERSIONNAME = ""

    override fun onCreate() {
        super.onCreate()
        VERSIONNAME = AppUtils.getAppVersionName(this)
    }
}