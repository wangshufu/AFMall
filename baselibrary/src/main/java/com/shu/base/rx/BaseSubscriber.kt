package com.shu.base.rx

import rx.Subscriber

/**
 * Created by wangshufu on 2018/3/21.
 */
open class BaseSubscriber<T> : Subscriber<T>(){
    override fun onNext(t: T) {

    }

    override fun onError(e: Throwable?) {

    }

    override fun onCompleted() {

    }
}