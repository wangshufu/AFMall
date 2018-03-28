package com.shu.order.presenter.view

import com.shu.base.presenter.view.BaseView
import com.shu.order.data.protocol.Order


/*
    订单详情页 视图回调
 */
interface OrderDetailView : BaseView {

    fun onGetOrderByIdResult(result: Order)
}
