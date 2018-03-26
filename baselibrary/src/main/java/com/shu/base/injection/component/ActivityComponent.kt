package com.shu.base.injection.component

import android.app.Activity
import android.content.Context
import com.shu.base.injection.ActivityScope
import com.shu.base.injection.module.ActivityModule
import com.shu.base.injection.module.LifecycleProviderModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component

/**
 * Created by wangshufu on 2018/3/22.
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class,LifecycleProviderModule::class))
interface ActivityComponent {

    fun activity():Activity

    fun context():Context

    fun lifecyleProvider():LifecycleProvider<*>

}