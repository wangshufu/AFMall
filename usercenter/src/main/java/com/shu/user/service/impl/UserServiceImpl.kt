package com.shu.user.service.impl

import com.shu.base.data.protocol.BaseResp
import com.shu.base.ext.convert
import com.shu.base.rx.BaseFunc
import com.shu.base.rx.BaseFuncBoolean
import com.shu.user.data.protocol.UserInfo
import com.shu.user.data.repository.UserRepository
import com.shu.user.service.UserService
import rx.Observable
import rx.functions.Func1
import javax.inject.Inject

/**
 * Created by wangshufu on 2018/3/21.
 */
class UserServiceImpl @Inject constructor():UserService{


    @Inject
    lateinit var repository : UserRepository

    /**
     * 注册
     */
    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {

        return repository.register(mobile, pwd, verifyCode)
                .flatMap (BaseFuncBoolean())
    }

    /**
     * 登录
     */
    override fun login(mobile: String, pwd: String, pushId: String): Observable<UserInfo> {

        return repository.login(mobile, pwd, pushId).flatMap(BaseFunc<UserInfo>())
    }

    /**
     * 忘记密码
     */
    override fun forgetPwd(mobile: String, verifyCode: String): Observable<Boolean> {
        return repository.forgetPwd(mobile, verifyCode).flatMap(BaseFuncBoolean())
    }

    /**
     * 重置密码
     */
    override fun resetPwd(mobile:String, pwd:String): Observable<Boolean> {
        return repository.resetPwd(mobile, pwd).flatMap(BaseFuncBoolean())
    }


    /*
        修改用户资料
     */
    override fun editUser(userIcon: String, userName: String, userGender: String, userSign: String): Observable<UserInfo> {
        return repository.editUser(userIcon,userName,userGender,userSign).convert()
    }

}