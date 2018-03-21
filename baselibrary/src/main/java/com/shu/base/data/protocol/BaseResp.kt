package com.shu.base.data.protocol

/**
 * Created by wangshufu on 2018/3/21.
 */
class BaseResp<out T>(val status: Int,val message:String,val data:T) {
}