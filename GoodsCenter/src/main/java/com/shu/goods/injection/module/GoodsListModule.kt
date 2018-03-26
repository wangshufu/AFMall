package com.shu.goods.injection.module

import com.shu.goods.service.CategoryService
import com.shu.goods.service.GoodsListService
import com.shu.goods.service.impl.CategoryServiceImpl
import com.shu.goods.service.impl.GoodsListServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by wangshufu on 2018/3/22.
 */
@Module
class GoodsListModule {

    @Provides
    fun provideUserService(goodsListServiceImpl: GoodsListServiceImpl): GoodsListService {
        return goodsListServiceImpl
    }
}