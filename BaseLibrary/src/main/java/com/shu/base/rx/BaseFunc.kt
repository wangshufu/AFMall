package com.shu.base.rx

import com.shu.base.common.ResultCode
import com.shu.base.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

/**
 * Created by wangshufu on 2018/3/22.
 */
class BaseFunc<T>: Func1<BaseResp<T>, Observable<T>> {
    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.status != ResultCode.SUCCESS){
            return Observable.error(BaseException(t.status,t.message))
        }

        return Observable.just(t.data)
    }
}