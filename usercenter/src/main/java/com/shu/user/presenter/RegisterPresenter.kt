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
class RegisterPresenter @Inject constructor(): BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService : UserService


    fun register(){

        if (checkNetWork()){
            mView.onError("网络不可用")
            return
        }

        mView.showLoading()


        userService.register("","","")
                .excute(object : BaseSubscriber<Boolean>(){
                    override fun onNext(t: Boolean) {
                        super.onNext(t)

                        mView.hideLoading()
                        if (t){
                            mView.registerSuc()
                        }else{
                            mView.registerErr()
                        }
                    }
                },lifecycleProvider)
    }

}