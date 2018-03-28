package com.shu.goods.data.api

import com.shu.goods.data.protocol.Category
import com.shu.goods.data.protocol.GetCategoryReq
import com.shu.base.data.protocol.BaseResp
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * Created by wangshufu on 2018/3/26.
 */
interface CategoryApi {

    /**
     * 获取商品分类
     */
    @POST("category/getCategory")
    fun getCategory(@Body req: GetCategoryReq): Observable<BaseResp<MutableList<Category>?>>
}