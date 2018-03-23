package com.shu.base.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import com.shu.base.common.BaseApplication
import com.shu.base.injection.component.ActivityComponent
import com.shu.base.injection.component.DaggerActivityComponent
import com.shu.base.injection.module.ActivityModule
import com.shu.base.injection.module.LifecycleProviderModule
import com.shu.base.presenter.BasePresenter
import com.shu.base.presenter.view.BaseView
import com.shu.base.widgets.ProgressLoading
import org.jetbrains.anko.progressDialog
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by wangshufu on 2018/3/20.
 */
abstract open class BaseMvpActivity<T:BasePresenter<*>> : BaseActivity(),BaseView {
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

    lateinit var activityComponent:ActivityComponent

    private lateinit var mLoadingDialog:ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityComponent()
        injectComponent()

        mLoadingDialog = ProgressLoading.create(this)
    }

    abstract fun injectComponent()

    private fun initActivityComponent() {

        activityComponent = DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()

    }
}