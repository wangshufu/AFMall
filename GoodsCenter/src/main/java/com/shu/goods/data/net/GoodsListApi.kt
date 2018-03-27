package com.shu.goods.data.net

import com.kotlin.goods.data.protocol.GetGoodsDetailReq
import com.kotlin.goods.data.protocol.GetGoodsListByKeywordReq
import com.shu.base.data.protocol.BaseResp
import com.shu.goods.data.protocol.GetGoodsListReq
import com.shu.goods.data.protocol.Goods
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * Created by wangshufu on 2018/3/26.
 */
interface GoodsListApi {

    /**
     * 获取商品分类
     */
    @POST("goods/getGoodsList")
    fun getGoodsList(@Body req: GetGoodsListReq): Observable<BaseResp<MutableList<Goods>?>>

    /*
    获取商品列表
    */
    @POST("goods/getGoodsListByKeyword")
    fun getGoodsListByKeyword(@Body req: GetGoodsListByKeywordReq): Observable<BaseResp<MutableList<Goods>?>>

    /*
        获取商品详情
     */
    @POST("goods/getGoodsDetail")
    fun getGoodsDetail(@Body req: GetGoodsDetailReq): Observable<BaseResp<Goods>>


}