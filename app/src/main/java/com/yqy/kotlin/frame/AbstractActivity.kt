package com.yqy.kotlin.frame

import android.app.ProgressDialog
import android.content.Context
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.yqy.kotlin.http.SubscriberResultListener
import com.yqy.kotlin.listener.OnClickBackListener

/**
 * acivity基类
 * Created by DerekYan on 2017/7/12.
 */
abstract class AbstractActivity : AppCompatActivity(), View.OnClickListener,SubscriberResultListener<Object>{
    var mProgressDialog: ProgressDialog? = null
    var mAlertDialog: AlertDialog? = null
    var mContext: Context? = null

    var pageNum: Int = 20 //分页 每页数量
    var isLoadMore: Boolean = true //是否可以加载更多

    var mOnClickBackListener: OnClickBackListener? = null

    /** 预备布局contenView id */
    protected abstract fun preView(): Int
    /** 初始化view */
    protected abstract fun initView()
    /** 添加监听事件 */
    protected abstract fun addListener()
    /** 初始化数据 */
    protected abstract fun initData()
    /** 返回键(标题栏、虚拟键) 点击事件 */
    protected abstract fun getOnBackClickListener(): OnClickBackListener

    /**
     * 设置刷新状态
     */
    fun setRefreshing(mSwipeRefreshLayout: SwipeRefreshLayout,flag: Boolean){
        mSwipeRefreshLayout.isRefreshing = flag
    }

    /**
     * 处理返回数据
     */
    fun <T> doData(data: T, id: Int){}
    fun <T> doData(data: T, id: Int, qid: String){}

    override fun onNext(t: Object, requestId: Int) {
        doData(t,requestId)
    }

    override fun onError(errorCode: Int, msg: String, requestId: Int) {
        if (msg.indexOf("session") != -1 || requestId == 1001) {
            //登录信息超时
            //            Intent intent = new Intent(this,LoginActivity.class);
            //            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            //            startActivity(intent);
        } else if (msg.indexOf("http.HttpRequest") != -1) {
            showToast("请求超时")
        } else if (msg.indexOf("HTTP 500 Internal Server Error") != -1) {
            showToast("请求异常")
        } else
            showToast(msg)
    }

    /**
     * Toast
     */
    fun showToast(tip: String) {
        Toast.makeText(this, tip, Toast.LENGTH_SHORT).show()
    }

}