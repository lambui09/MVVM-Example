package com.example.mvvm.base

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(resId: Int)
}