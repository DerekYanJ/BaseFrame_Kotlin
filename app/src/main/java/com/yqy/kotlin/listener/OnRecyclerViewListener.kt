package com.yqy.kotlin.listener

/**
 *
 * Created by DerekYan on 2017/7/13.
 */
interface OnRecyclerViewListener {
    fun onItemClick(position: Int)
    fun onItemLongClick(position: Int)
}