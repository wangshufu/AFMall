package com.shu.goods.service.impl

import com.shu.base.ext.convert
import com.shu.goods.data.protocol.Goods
import com.shu.goods.data.repository.CategoryRepository
import com.shu.goods.data.repository.GoodsListRepository
import com.shu.goods.service.GoodsListService
import rx.Observable
import javax.inject.Inject

/**
 * Created by wangshufu on 2018/3/26.
 */
class GoodsListServiceImpl @Inject constructor():GoodsListService {


    @Inject
    lateinit var repository : GoodsListRepository


    override fun getGoodsList(categoryId: Int, pageNo: Int): Observable<MutableList<Goods>?> {
        return repository.getGoodsList(categoryId, pageNo).convert()
    }

    /*
        根据关键字查询商品
     */
    override fun getGoodsListByKeyword(keyword: String, pageNo: Int): Observable<MutableList<Goods>?> {
        return repository.getGoodsListByKeyword(keyword,pageNo).convert()
    }
}