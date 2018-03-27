package com.user.data.respository

import com.shu.base.data.net.RetrofitFactory
import com.shu.base.data.protocol.BaseResp
import com.shu.user.data.api.UploadApi
import rx.Observable
import javax.inject.Inject

/*
    上传相关 数据层
 */
class UploadRepository @Inject constructor(){
    /*
        获取七牛云上传凭证
     */
    fun getUploadToken(): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(UploadApi::class.java).getUploadToken()
    }

}
