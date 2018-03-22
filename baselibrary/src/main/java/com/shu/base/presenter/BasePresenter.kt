package com.shu.base.presenter

import android.content.Context
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
}