package com.shu.goods.service

import com.shu.goods.data.protocol.Category
import com.shu.goods.data.protocol.Goods
import rx.Observable

/**
 * Created by wangshufu on 2018/3/26.
 */
interface GoodsListService {
    //获取商品分类
    fun getGoodsList(categoryId: Int,pageNo: Int): Observable<MutableList<Goods>?>


    //根据关键字查询商品
    fun getGoodsListByKeyword(keyword: String, pageNo: Int): Observable<MutableList<Goods>?>

}