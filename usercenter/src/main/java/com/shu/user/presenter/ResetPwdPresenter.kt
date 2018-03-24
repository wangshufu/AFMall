package com.shu.user.presenter

import com.shu.base.ext.excute
import com.shu.base.presenter.BasePresenter
import com.shu.base.rx.BaseSubscriber
import com.shu.user.presenter.view.ForgetPwdView
import com.shu.user.presenter.view.ResetPwdView
import com.shu.user.service.UserService
import javax.inject.Inject

/**
 * Created by wangshufu on 2018/3/21.
 */
class ResetPwdPresenter @Inject constructor() : BasePresenter<ResetPwdView>() {

    @Inject
    lateinit var userService: UserService


    fun resetPwd(mobile:String, oldpwd:String,newPwd : String) {

        if (!checkNetWork()) {
            return
        }

        if (oldpwd != newPwd){
            mView.pwdNotEquals()
            return
        }


        mView.showLoading()

        userService.resetPwd(mobile, oldpwd).excute(object : BaseSubscriber<Boolean>(mView){
            override fun onNext(t: Boolean) {
                super.onNext(t)

                mView.resetPwdSuc()
            }
        },lifecycleProvider)

    }

}