package com.shu.base.rx

import rx.Subscriber

/**
 * Created by wangshufu on 2018/3/21.
 */
open class BaseSubscriber<T> : Subscriber<T>(){
    override fun onNext(t: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onError(e: Throwable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCompleted() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}