package com.shu.base.injection.module

import android.content.Context
import com.shu.base.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by wangshufu on 2018/3/22.
 */
@Module
@Singleton
class AppModule(private val context : BaseApplication) {


    @Provides
    @Singleton
    fun providersContext():Context{
        return context
    }
}