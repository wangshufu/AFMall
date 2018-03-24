package com.shu.user.ui.activity

import android.os.Bundle
import com.shu.base.ext.enable
import com.shu.base.ext.onClick
import com.shu.base.ui.activity.BaseMvpActivity
import com.shu.user.R
import com.shu.user.injection.component.DaggerUserComponent
import com.shu.user.injection.module.UserModule
import com.shu.user.presenter.ForgetPwdPresenter
import com.shu.user.presenter.ResetPwdPresenter
import com.shu.user.presenter.view.ForgetPwdView
import com.shu.user.presenter.view.ResetPwdView
import kotlinx.android.synthetic.main.activity_reset_pwd.*
import org.jetbrains.anko.*

/**
 * 用户注册界面
 */
class ResetPwdActivity : BaseMvpActivity<ResetPwdPresenter>(), ResetPwdView {
    override fun pwdNotEquals() {
        toast("密码不一致")
    }


    override fun resetPwdSuc() {
        toast("重置密码成功!!!")
        startActivity(intentFor<LoginActivity>().singleTop().clearTop())
    }


    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_pwd)
        initView()
    }

    private fun initView() {
        mConfirmBtn.enable(mPwdEt,{isBtnEnable()})
        mConfirmBtn.enable(mPwdConfirmEt,{isBtnEnable()})

        mConfirmBtn.onClick {
            mPresenter.resetPwd(intent.getStringExtra("mobile"),mPwdEt.text.toString(),mPwdConfirmEt.text.toString())
        }

    }

    /**
     * 判断下一步按钮是否可点击
     */
    private fun isBtnEnable():Boolean{
        return mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }




}