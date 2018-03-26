package com.shu.goods.presenter.view

import com.shu.goods.data.protocol.Category
import com.shu.base.presenter.view.BaseView

/**
 * Created by wangshufu on 2018/3/21.
 */
open interface CategoryView : BaseView {


    fun getCategoryResult(list:MutableList<Category>?)


}