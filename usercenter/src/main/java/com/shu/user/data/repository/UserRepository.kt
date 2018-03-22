package com.shu.user.data.repository

import com.shu.base.data.net.RetrofitFactory
import com.shu.base.data.protocol.BaseResp
import com.shu.user.data.api.UserApi
import com.shu.user.data.protocol.RegisterReq
import rx.Observable
import javax.inject.Inject

/**
 * Created by wangshufu on 2018/3/21.
 */
class UserRepository @Inject constructor(){

    /**
     * 用户注册
     */
    fun register(mobile:String,pwd:String,verifyCode:String): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UserApi::class.java).register(RegisterReq(mobile,pwd,verifyCode))
    }
}