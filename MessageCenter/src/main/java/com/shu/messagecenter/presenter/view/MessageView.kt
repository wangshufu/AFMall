package com.shu.messagecenter.presenter.view

import com.shu.base.presenter.view.BaseView
import com.shu.messagecenter.data.protocol.Message


/*
    消息列表 视图回调
 */
interface MessageView : BaseView {

    //获取消息列表回调
    fun onGetMessageResult(result:MutableList<Message>?)
}
