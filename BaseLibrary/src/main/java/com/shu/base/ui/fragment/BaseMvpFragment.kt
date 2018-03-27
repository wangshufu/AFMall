package com.shu.base.ui.fragment

import android.os.Bundle
import com.shu.base.common.BaseApplication
import com.shu.base.injection.component.ActivityComponent
import com.shu.base.injection.component.DaggerActivityComponent
import com.shu.base.injection.module.ActivityModule
import com.shu.base.injection.module.LifecycleProviderModule
import com.shu.base.presenter.BasePresenter
import com.shu.base.presenter.view.BaseView
import com.shu.base.widgets.ProgressLoading
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 * Created by wangshufu on 2018/3/22.
 */
open abstract class BaseMvpFragment<T: BasePresenter<*>> : BaseFragment(), BaseView {
    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    override fun onError(error: String) {
        toast(error)
    }


    @Inject
    lateinit var mPresenter:T

    lateinit var activityComponent: ActivityComponent

    private lateinit var mLoadingDialog:ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityComponent()
        injectComponent()

        mLoadingDialog = ProgressLoading.create(context)
    }

    abstract fun injectComponent()

    private fun initActivityComponent() {

        activityComponent = DaggerActivityComponent.builder().appComponent((activity.application as BaseApplication).appComponent)
                .activityModule(ActivityModule(activity))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()

    }
}