package com.shu.goods.injection.module

import com.shu.goods.service.CategoryService
import com.shu.goods.service.impl.CategoryServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by wangshufu on 2018/3/22.
 */
@Module
class CategoryModule {

    @Provides
    fun provideUserService(categoryServiceImpl: CategoryServiceImpl): CategoryService {
        return categoryServiceImpl
    }
}