package com.shu.base.common

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.shu.base.injection.component.AppComponent
import com.shu.base.injection.component.DaggerAppComponent
import com.shu.base.injection.module.AppModule

/**
 * Created by wangshufu on 2018/3/22.
 */
class BaseApplication : Application() {

    lateinit var appComponent: AppComponent

    companion object {
        lateinit var context:Context
    }

    override fun onCreate() {
        super.onCreate()

        initAppInjection()

        context = this

        //初始化ARouter
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this);
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}