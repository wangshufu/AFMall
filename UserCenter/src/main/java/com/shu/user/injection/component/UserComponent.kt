package com.shu.user.injection.component

import android.support.v7.app.AppCompatActivity
import com.kotlin.user.injection.module.UploadModule
import com.shu.base.injection.PerComponentScope
import com.shu.base.injection.component.ActivityComponent
import com.shu.user.injection.module.UserModule
import com.shu.user.ui.activity.*
import dagger.Component

/**
 * Created by wangshufu on 2018/3/22.
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class,UploadModule::class))
interface UserComponent {
    fun inject(activity: RegisterActivity)
    fun inject(activity: LoginActivity)
    fun inject(activity: ForgetPwdActivity)
    fun inject(activity: ResetPwdActivity)
    fun inject(activity: UserCenterActivity)
}