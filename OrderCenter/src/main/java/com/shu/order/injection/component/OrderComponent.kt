package com.shu.order.injection.component

import com.shu.base.injection.PerComponentScope
import com.shu.base.injection.component.ActivityComponent
import com.shu.order.injection.module.OrderModule
import com.shu.order.ui.activity.OrderConfirmActivity
import com.shu.order.ui.activity.OrderDetailActivity
import com.shu.order.ui.fragment.OrderFragment
import dagger.Component

/*
    订单Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(OrderModule::class))
interface OrderComponent {
    fun inject(activity: OrderConfirmActivity)

    fun inject(fragment: OrderFragment)

    fun inject(activity: OrderDetailActivity)
}
