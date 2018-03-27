package com.shu.user.ui.activity

import android.os.Bundle
import com.shu.base.ext.enable
import com.shu.base.ext.onClick
import com.shu.base.ui.activity.BaseMvpActivity
import com.shu.user.R
import com.shu.user.injection.component.DaggerUserComponent
import com.shu.user.injection.module.UserModule
import com.shu.user.presenter.ForgetPwdPresenter
import com.shu.user.presenter.LoginPresenter
import com.shu.user.presenter.view.ForgetPwdView
import com.shu.user.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_forget_pwd.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * 用户注册界面
 */
class ForgetPwdActivity : BaseMvpActivity<ForgetPwdPresenter>(), ForgetPwdView {


    override fun ForgetPwdSuc() {
        startActivity<ResetPwdActivity>("mobile" to mMobileEt.text.toString())
    }

    override fun ForgetPwdErr() {


    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pwd)
        initView()
    }

    private fun initView() {
        mNextBtn.enable(mMobileEt,{isBtnEnable()})
        mNextBtn.enable(mVerifyCodeEt,{isBtnEnable()})

        mNextBtn.onClick {
            ForgetPwdSuc()
//            mPresenter.forgetPwd(mMobileEt.text.toString(),mVerifyCodeEt.text.toString())
        }

        mVerifyCodeBtn.onClick {
            mVerifyCodeBtn.requestSendVerifyNumber()
        }


    }

    /**
     * 判断下一步按钮是否可点击
     */
    private fun isBtnEnable():Boolean{
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not()
    }




}