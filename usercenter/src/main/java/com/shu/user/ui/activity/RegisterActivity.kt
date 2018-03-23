package com.shu.user.ui.activity

import android.os.Bundle
import com.shu.base.ui.activity.BaseMvpActivity
import com.shu.user.R
import com.shu.user.injection.component.DaggerUserComponent
import com.shu.user.injection.module.UserModule
import com.shu.user.presenter.RegisterPresenter
import com.shu.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView {

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun registerSuc() {
        toast("注册成功")
    }

    override fun registerErr() {
        toast("注册失败")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


//        mRegister.setOnClickListener {
//            mPresenter.register()
//        }



    }




}
