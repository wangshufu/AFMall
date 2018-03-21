package com.shu.user.service

import rx.Observable

/**
 * Created by wangshufu on 2018/3/21.
 */
interface UserService {

    //用户注册
    fun register(mobile:String,pwd:String,verifyCode:String): Observable<Boolean>

    //用户登录
//    fun login(mobile:String,pwd:String,pushId:String):Observable<UserInfo>

    //忘记密码
    fun forgetPwd(mobile:String,verifyCode:String):Observable<Boolean>

    //重置密码
    fun resetPwd(mobile:String,pwd:String):Observable<Boolean>

    //编辑用户资料
//    fun editUser(userIcon:String,userName:String,userGender:String,userSign:String):Observable<UserInfo>
}