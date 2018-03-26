package com.shu.goods.injection.component

import com.shu.base.injection.PerComponentScope
import com.shu.base.injection.component.ActivityComponent
import com.shu.goods.injection.module.CategoryModule
import com.shu.goods.ui.fragment.CategoryFragment
import dagger.Component

/**
 * Created by wangshufu on 2018/3/22.
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(CategoryModule::class))
interface CategoryComponent {
    fun inject(fragment: CategoryFragment)
}