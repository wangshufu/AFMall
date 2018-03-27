package com.shu.base.injection.module

import android.app.Activity
import com.shu.base.injection.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by wangshufu on 2018/3/22.
 */
@Module
class ActivityModule(private val activity: Activity) {

    @ActivityScope
    @Provides
    fun provideActivity(): Activity {
        return this.activity
    }
}