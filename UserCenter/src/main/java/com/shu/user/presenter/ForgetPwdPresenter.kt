package com.shu.user.presenter

import com.shu.base.ext.excute
import com.shu.base.presenter.BasePresenter
import com.shu.base.rx.BaseSubscriber
import com.shu.user.data.protocol.UserInfo
import com.shu.user.presenter.view.ForgetPwdView
import com.shu.user.presenter.view.LoginView
import com.shu.user.service.UserService
import javax.inject.Inject

/**
 * Created by wangshufu on 2018/3/21.
 */
class ForgetPwdPresenter @Inject constructor() : BasePresenter<ForgetPwdView>() {

    @Inject
    lateinit var userService: UserService


    fun forgetPwd(mobile:String,verifyCode:String) {

        if (!checkNetWork()) {
            return
        }

        mView.showLoading()

        userService.forgetPwd(mobile,verifyCode).excute(object : BaseSubscriber<Boolean>(mView){
            override fun onNext(t: Boolean) {
                super.onNext(t)

                mView.ForgetPwdSuc()
            }
        },lifecycleProvider)

    }

}