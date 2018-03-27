package com.shu.user.injection.module

import com.shu.user.service.UserService
import com.shu.user.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * Created by wangshufu on 2018/3/22.
 */
@Module
class UserModule {

    @Provides
    fun provideUserService(userService: UserServiceImpl): UserService {
        return userService
    }
}