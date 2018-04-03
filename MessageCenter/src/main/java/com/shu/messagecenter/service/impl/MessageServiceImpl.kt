package com.shu.messagecenter.service.impl


import com.shu.base.ext.convert
import com.shu.messagecenter.data.protocol.Message
import com.shu.messagecenter.data.repository.MessageRepository
import com.shu.messagecenter.service.MessageService
import javax.inject.Inject

import rx.Observable

/*
   消息业务层
 */
class MessageServiceImpl @Inject constructor(): MessageService {

    @Inject
    lateinit var repository: MessageRepository

    /*
        获取消息列表
     */
    override fun getMessageList(): Observable<MutableList<Message>?> {
        return repository.getMessageList().convert()
    }

}
