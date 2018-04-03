package com.shu.alipay.data.repository


import com.shu.alipay.data.api.PayApi
import com.shu.alipay.data.protocol.GetPaySignReq
import com.shu.alipay.data.protocol.PayOrderReq
import com.shu.base.data.net.RetrofitFactory
import com.shu.base.data.protocol.BaseResp
import javax.inject.Inject

import rx.Observable


/*
   支付数据层
 */
class PayRepository @Inject constructor() {

    /*
        获取支付宝支付签名
     */
    fun getPaySign(orderId: Int, totalPrice: Long): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(PayApi::class.java).getPaySign(GetPaySignReq(orderId, totalPrice))
    }

    /*
        刷新订单状态已支付
     */
    fun payOrder(orderId: Int): Observable<BaseResp<String>> {
        return RetrofitFactory.instance.create(PayApi::class.java).payOrder(PayOrderReq(orderId))
    }


}
