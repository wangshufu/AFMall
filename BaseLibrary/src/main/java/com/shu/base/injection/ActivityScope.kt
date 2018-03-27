package com.shu.base.injection

import java.lang.annotation.Documented
import javax.inject.Scope
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * Created by wangshufu on 2018/3/22.
 */
@Scope
@Documented
@Retention(RUNTIME)
annotation class ActivityScope