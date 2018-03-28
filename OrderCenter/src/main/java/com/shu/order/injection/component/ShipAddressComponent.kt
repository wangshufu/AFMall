package com.shu.order.injection.component

import com.shu.base.injection.PerComponentScope
import com.shu.base.injection.component.ActivityComponent
import com.shu.order.injection.module.ShipAddressModule
import com.shu.order.ui.activity.ShipAddressActivity
import com.shu.order.ui.activity.ShipAddressEditActivity
import dagger.Component

/*
    收货人信息Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(ShipAddressModule::class))
interface ShipAddressComponent {
    fun inject(activity: ShipAddressEditActivity)
    fun inject(activity: ShipAddressActivity)
}
