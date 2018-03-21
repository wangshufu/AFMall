package com.shu.base.ui.activity

import com.shu.base.presenter.BasePresenter
import com.shu.base.presenter.view.BaseView

/**
 * Created by wangshufu on 2018/3/20.
 */
open class BaseMvpActivity<T:BasePresenter<*>> : BaseActivity(),BaseView {
    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    lateinit var mPresenter:T
}