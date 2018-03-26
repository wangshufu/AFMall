package com.shu.goods.service

import com.shu.goods.data.protocol.Category
import rx.Observable

/**
 * Created by wangshufu on 2018/3/21.
 */
interface CategoryService {

    //获取商品分类
    fun getCategory(parentId: Int): Observable<MutableList<Category>?>

}