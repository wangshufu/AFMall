package com.shu.user.ui.activity

import android.os.Bundle
import com.shu.base.ext.enable
import com.shu.base.ext.onClick
import com.shu.base.ui.activity.BaseMvpActivity
import com.shu.user.R
import com.shu.user.data.protocol.UserInfo
import com.shu.user.injection.component.DaggerUserComponent
import com.shu.user.injection.module.UserModule
import com.shu.user.presenter.LoginPresenter
import com.shu.user.presenter.RegisterPresenter
import com.shu.user.presenter.view.LoginView
import com.shu.user.presenter.view.RegisterView
import com.shu.user.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * 用户注册界面
 */
class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView {


    override fun loginSuc(userInfo:UserInfo) {
        toast("登录成功")
        UserPrefsUtils.putUserInfo(userInfo)
        finish()
    }

    override fun loginErr() {


    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
    }

    private fun initView() {
        mLoginBtn.enable(mMobileEt,{isBtnEnable()})
        mLoginBtn.enable(mPwdEt,{isBtnEnable()})

        mLoginBtn.onClick {
            mPresenter.login(mMobileEt.text.toString(),mPwdEt.text.toString(),"")
        }


        mHeaderBar.getRightView().onClick {
            startActivity<RegisterActivity>()
        }

        mForgetPwdTv.onClick {
            startActivity<ForgetPwdActivity>()
        }
    }

    private fun isBtnEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }




}