package com.shu.user.service.impl

import com.shu.base.data.protocol.BaseResp
import com.shu.user.data.repository.UserRepository
import com.shu.user.service.UserService
import rx.Observable
import rx.functions.Func1

/**
 * Created by wangshufu on 2018/3/21.
 */
class UserServiceImpl :UserService{
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val repository = UserRepository()

        return repository.register(mobile, pwd, verifyCode)
                .flatMap (object :Func1<BaseResp<String>,Observable<Boolean>> {
                    override fun call(t: BaseResp<String>?): Observable<Boolean> {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.


                    }

                })
    }

    override fun forgetPwd(mobile: String, verifyCode: String): Observable<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resetPwd(mobile: String, pwd: String): Observable<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}