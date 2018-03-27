package com.shu.provider.common

import com.shu.base.common.BaseConstant
import com.shu.base.utils.AppPrefsUtils

/**
 * Created by wangshufu on 2018/3/26.
 */

/**
 * 用户是否登录  true:已登录  false:未登录
 */
fun isUserLogin(): Boolean {
    return AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN).isNotEmpty()
}