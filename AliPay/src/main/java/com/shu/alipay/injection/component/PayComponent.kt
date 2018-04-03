package com.shu.alipay.injection.component

import com.shu.alipay.injection.module.PayModule
import com.shu.alipay.ui.activity.CashRegisterActivity
import com.shu.base.injection.PerComponentScope
import com.shu.base.injection.component.ActivityComponent
import dagger.Component

/*
    支付Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(PayModule::class))
interface PayComponent {
    fun inject(activity: CashRegisterActivity)
}
