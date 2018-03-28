package com.shu.provider.common

import com.alibaba.android.arouter.launcher.ARouter
import com.shu.base.common.BaseConstant
import com.shu.base.utils.AppPrefsUtils
import com.shu.provider.router.RouterPath

/**
 * Created by wangshufu on 2018/3/26.
 */

/**
 * 用户是否登录  true:已登录  false:未登录
 */
fun isUserLogin(): Boolean {
    return AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN).isNotEmpty()
}

/*
如果已经登录，进行传入的方法处理
如果没有登录，进入登录界面
*/
fun afterLogin(method:()->Unit){
    if (isUserLogin()){
        method()
    }else{
        ARouter.getInstance().build(RouterPath.UserCenter.PATH_LOGIN).navigation()
    }
}