package com.shu.goods.injection.component

import com.shu.base.injection.PerComponentScope
import com.shu.base.injection.component.ActivityComponent
import com.shu.goods.injection.module.CartModule
import com.shu.goods.ui.fragment.CartFragment
import dagger.Component

/*
    购物车Component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(CartModule::class))
interface CartComponent {
    fun inject(fragment: CartFragment)
}
