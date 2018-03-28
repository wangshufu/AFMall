package com.shu.order.event

import com.shu.order.data.protocol.ShipAddress


/*
    选择收货人信息事件
 */
class SelectAddressEvent(val address: ShipAddress)
