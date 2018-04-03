package com.shu.alipay.data.api

import com.shu.alipay.data.protocol.GetPaySignReq
import com.shu.alipay.data.protocol.PayOrderReq
import com.shu.base.data.protocol.BaseResp
import retrofit2.http.Body
import rx.Observable
import retrofit2.http.POST


/*
    支付 接口
 */
interface PayApi {

    /*
        获取支付宝支付签名
     */
    @POST("pay/getPaySign")
    fun getPaySign(@Body req: GetPaySignReq): Observable<BaseResp<String>>

    /*
        刷新订单状态，已支付
     */
    @POST("order/pay")
    fun payOrder(@Body req: PayOrderReq): Observable<BaseResp<String>>

}
