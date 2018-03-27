package com.shu.user.presenter

import com.shu.base.ext.excute
import com.shu.base.presenter.BasePresenter
import com.shu.base.rx.BaseSubscriber
import com.shu.user.presenter.view.RegisterView
import com.shu.user.service.UserService
import javax.inject.Inject

/**
 * Created by wangshufu on 2018/3/21.
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserService


    fun register(mobile: String, pwd: String, verifyCode: String) {

        if (!checkNetWork()) {
            return
        }

        mView.showLoading()


        userService.register(mobile, pwd, verifyCode)
                .excute(object : BaseSubscriber<Boolean>(mView) {
                    override fun onNext(t: Boolean) {
                        super.onNext(t)
                        if (t) {
                            mView.registerSuc()
                        }

                    }
                }, lifecycleProvider)
    }

}