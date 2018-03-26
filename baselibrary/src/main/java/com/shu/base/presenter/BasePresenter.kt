package com.shu.base.presenter

import android.content.Context
import com.shu.base.utils.NetWorkUtils
import com.shu.base.presenter.view.BaseView
import com.trello.rxlifecycle.LifecycleProvider
import javax.inject.Inject

/**
 * Created by wangshufu on 2018/3/20.
 */
open class BasePresenter<T:BaseView> {

    lateinit var mView:T

    @Inject
    lateinit var lifecycleProvider:LifecycleProvider<*>

    @Inject
    lateinit var context:Context


    /*
         检查网络是否可用
      */
    fun checkNetWork():Boolean{
        if(NetWorkUtils.isNetWorkAvailable(context)){
            return true
        }
        mView.onError("网络不可用")
        return false
    }
}