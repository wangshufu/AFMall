package com.shu.user.presenter.view

import com.shu.base.presenter.view.BaseView
import com.shu.user.data.protocol.UserInfo

/**
 * Created by wangshufu on 2018/3/21.
 */
open interface LoginView : BaseView {


    fun loginSuc(userInfo: UserInfo)

    fun loginErr()

}