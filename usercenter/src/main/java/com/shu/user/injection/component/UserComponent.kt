package com.shu.user.injection.component

import android.support.v7.app.AppCompatActivity
import com.shu.base.injection.PerComponentScope
import com.shu.base.injection.component.ActivityComponent
import com.shu.user.injection.module.UserModule
import com.shu.user.ui.activity.RegisterActivity
import dagger.Component

/**
 * Created by wangshufu on 2018/3/22.
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity: RegisterActivity)
}