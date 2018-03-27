package com.shu.goods.data.repository

import com.kotlin.goods.data.protocol.GetGoodsDetailReq
import com.kotlin.goods.data.protocol.GetGoodsListByKeywordReq
import com.shu.goods.data.protocol.Category
import com.shu.goods.data.protocol.GetCategoryReq
import com.shu.base.data.net.RetrofitFactory
import com.shu.base.data.protocol.BaseResp
import com.shu.goods.data.net.CategoryApi
import com.shu.goods.data.net.GoodsListApi
import com.shu.goods.data.protocol.GetGoodsListReq
import com.shu.goods.data.protocol.Goods
import rx.Observable
import javax.inject.Inject

/**
 * Created by wangshufu on 2018/3/26.
 */
class GoodsListRepository @Inject constructor() {

    /**
     * 获取某类型下的商品集合
     */
    fun getGoodsList( categoryId: Int,pageNo: Int): Observable<BaseResp<MutableList<Goods>?>> {
        return RetrofitFactory.instance.create(GoodsListApi::class.java).getGoodsList(GetGoodsListReq(categoryId, pageNo))
    }

    /*
        根据关键字搜索商品
     */
    fun getGoodsListByKeyword(keyword: String, pageNo: Int): Observable<BaseResp<MutableList<Goods>?>> {
        return RetrofitFactory.instance.create(GoodsListApi::class.java).getGoodsListByKeyword(GetGoodsListByKeywordReq(keyword, pageNo))
    }

    /*
        商品详情
     */
    fun getGoodsDetail(goodsId: Int): Observable<BaseResp<Goods>> {
        return RetrofitFactory.instance.create(GoodsListApi::class.java).getGoodsDetail(GetGoodsDetailReq(goodsId))
    }
}