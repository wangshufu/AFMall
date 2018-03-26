package com.shu.goods.data.repository

import com.shu.goods.data.protocol.Category
import com.shu.goods.data.protocol.GetCategoryReq
import com.shu.base.data.net.RetrofitFactory
import com.shu.base.data.protocol.BaseResp
import com.shu.goods.data.net.CategoryApi
import rx.Observable
import javax.inject.Inject


/**
 * Created by wangshufu on 2018/3/26.
 */
class CategoryRepository @Inject constructor() {

    /**
     * 获取商品分类
     */
    fun getCategory( parentId: Int): Observable<BaseResp<MutableList<Category>?>> {
        return RetrofitFactory.instance.create(CategoryApi::class.java).getCategory(GetCategoryReq(parentId))
    }
}