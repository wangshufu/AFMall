package com.shu.user.ui.activity

import android.os.Bundle
import com.shu.base.ext.enable
import com.shu.base.ext.onClick
import com.shu.base.ui.activity.BaseMvpActivity
import com.shu.user.R
import com.shu.user.injection.component.DaggerUserComponent
import com.shu.user.injection.module.UserModule
import com.shu.user.presenter.RegisterPresenter
import com.shu.user.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

/**
 * 用户注册界面
 */
class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView {

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun registerSuc() {
        toast("注册成功")
        finish()
    }

    override fun registerErr() {
        toast("注册失败")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initView()
    }

    private fun initView() {
        mRegisterBtn.enable(mMobileEt,{isBtnEnable()})
        mRegisterBtn.enable(mVerifyCodeEt,{isBtnEnable()})
        mRegisterBtn.enable(mPwdEt,{isBtnEnable()})
        mRegisterBtn.enable(mPwdConfirmEt,{isBtnEnable()})

        mVerifyCodeBtn.onClick {
            mVerifyCodeBtn.requestSendVerifyNumber()
            toast("发送验证码成功")
        }

        mRegisterBtn.onClick {
            mPresenter.register(mMobileEt.text.toString(),mPwdEt.text.toString(),mPwdConfirmEt.text.toString())
        }

    }

    private fun isBtnEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }




}
