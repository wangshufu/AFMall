package com.shu.goods.presenter.view

import com.shu.base.presenter.view.BaseView
import com.shu.goods.data.protocol.Goods

/**
 * Created by wangshufu on 2018/3/21.
 */
open interface GoodsDetailView : BaseView {


    fun getGoodsDetailResult(goods:Goods)

    //加入购物车
    fun onAddCartResult(result: Int)

}