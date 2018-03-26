package com.shu.goods.presenter.view

import com.shu.goods.data.protocol.Category
import com.shu.base.presenter.view.BaseView
import com.shu.goods.data.protocol.Goods

/**
 * Created by wangshufu on 2018/3/21.
 */
open interface GoodsListView : BaseView {


    fun getGoodsListResult(list:MutableList<Goods>?)


}