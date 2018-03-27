package com.shu.base.presenter.view

/**
 * Created by wangshufu on 2018/3/20.
 */
interface BaseView {

    fun showLoading();
    fun hideLoading();
    fun onError(error:String);
}