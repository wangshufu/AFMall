package com.kotlin.user.injection.module

import com.shu.user.service.UploadService
import com.shu.user.service.impl.UploadServiceImpl
import dagger.Module
import dagger.Provides

/*
    上传Module
 */
@Module
class UploadModule {

    @Provides
    fun provideUploadService(uploadService: UploadServiceImpl): UploadService {
        return uploadService
    }

}
