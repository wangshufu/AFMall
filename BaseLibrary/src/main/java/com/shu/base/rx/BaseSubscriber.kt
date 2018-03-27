package com.shu.base.rx

import com.shu.base.presenter.view.BaseView
import rx.Subscriber

/**
 * Created by wangshufu on 2018/3/21.
 */
open class BaseSubscriber<T>(val baseView: BaseView) : Subscriber<T>(){


    override fun onNext(t: T) {

    }

    override fun onError(e: Throwable?) {

        baseView.hideLoading()

        if (e is BaseException){
            baseView.onError(e.msg)
        }

    }

    override fun onCompleted() {
        baseView.hideLoading()
    }
}