package com.shu.base.injection.component

import android.content.Context
import com.shu.base.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by wangshufu on 2018/3/22.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun context() : Context
}