package com.shu.base.ui.fragment

import android.os.Bundle
import com.shu.base.common.BaseApplication
import com.shu.base.injection.component.ActivityComponent
import com.shu.base.injection.component.DaggerActivityComponent
import com.shu.base.injection.module.ActivityModule
import com.shu.base.presenter.BasePresenter
import com.shu.base.presenter.view.BaseView
import com.shu.base.ui.activity.BaseActivity
import com.trello.rxlifecycle.components.support.RxFragment
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 * Created by wangshufu on 2018/3/22.
 */
open abstract class BaseMvpFragment<T: BasePresenter<*>> : BaseFragment(), BaseView {
    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(error: String) {
        toast(error)
    }


    @Inject
    lateinit var mPresenter:T

    lateinit var activityComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityComponent()
        injectComponent()
    }

    abstract fun injectComponent()

    private fun initActivityComponent() {

        activityComponent = DaggerActivityComponent.builder().appComponent((activity.application as BaseApplication).appComponent)
                .activityModule(ActivityModule(activity))
                .build()

    }
}