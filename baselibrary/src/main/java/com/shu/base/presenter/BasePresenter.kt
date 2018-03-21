package com.shu.base.presenter

import com.shu.base.presenter.view.BaseView

/**
 * Created by wangshufu on 2018/3/20.
 */
open class BasePresenter<T:BaseView> {

    lateinit var mView:T
}