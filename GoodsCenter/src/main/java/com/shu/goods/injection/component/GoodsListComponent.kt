package com.shu.goods.injection.component

import com.shu.base.injection.PerComponentScope
import com.shu.base.injection.component.ActivityComponent
import com.shu.goods.injection.module.CategoryModule
import com.shu.goods.injection.module.GoodsListModule
import com.shu.goods.ui.activity.GoodsListActivity
import com.shu.goods.ui.fragment.CategoryFragment
import com.shu.goods.ui.fragment.GoodsDetailTabOneFragment
import dagger.Component

/**
 * Created by wangshufu on 2018/3/22.
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(GoodsListModule::class))
interface GoodsListComponent {
    fun inject(activity: GoodsListActivity)
    fun inject(fragment: GoodsDetailTabOneFragment)
}