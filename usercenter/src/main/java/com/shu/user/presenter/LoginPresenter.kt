package com.shu.user.presenter

import com.shu.base.ext.excute
import com.shu.base.presenter.BasePresenter
import com.shu.base.rx.BaseSubscriber
import com.shu.user.data.protocol.UserInfo
import com.shu.user.presenter.view.LoginView
import com.shu.user.presenter.view.RegisterView
import com.shu.user.service.UserService
import javax.inject.Inject

/**
 * Created by wangshufu on 2018/3/21.
 */
class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
    lateinit var userService: UserService


    fun login(mobile:String,pwd:String,pushId:String) {

        if (!checkNetWork()) {
            return
        }

        mView.showLoading()

        userService.login(mobile,pwd,pushId).excute(object : BaseSubscriber<UserInfo>(mView){
            override fun onNext(t: UserInfo) {
                super.onNext(t)

                mView.loginSuc(t)
            }
        },lifecycleProvider)

    }

}