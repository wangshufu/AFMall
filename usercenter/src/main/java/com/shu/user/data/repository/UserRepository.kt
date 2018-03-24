package com.shu.user.data.repository

import com.kotlin.user.data.protocol.ForgetPwdReq
import com.kotlin.user.data.protocol.ResetPwdReq
import com.shu.base.data.net.RetrofitFactory
import com.shu.base.data.protocol.BaseResp
import com.shu.user.data.api.UserApi
import com.shu.user.data.protocol.EditUserReq
import com.shu.user.data.protocol.LoginReq
import com.shu.user.data.protocol.RegisterReq
import com.shu.user.data.protocol.UserInfo
import com.shu.user.service.UserService
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

    /**
     * 用户登录
     */
    fun login(mobile: String, pwd: String, pushId: String):Observable<BaseResp<UserInfo>>{
        return RetrofitFactory.instance.create(UserApi::class.java).login(LoginReq(mobile, pwd, pushId))
    }

    /**
     * 忘记密码
     */
    fun forgetPwd(mobile: String, verifyCode: String):Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UserApi::class.java).forgetPwd(ForgetPwdReq(mobile, verifyCode))
    }

    /**
     * 重置密码
     */
    fun resetPwd(mobile:String, pwd:String):Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UserApi::class.java).resetPwd(ResetPwdReq(mobile, pwd))
    }

    /*
        编辑用户资料
     */
    fun editUser(userIcon:String,userName:String,userGender:String,userSign:String):Observable<BaseResp<UserInfo>>{
        return RetrofitFactory.instance.create(UserApi::class.java).editUser(EditUserReq(userIcon,userName,userGender,userSign))
    }
}