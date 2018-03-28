package com.shu.order.injection.module

import com.shu.order.service.OrderService
import com.shu.order.service.impl.OrderServiceImpl
import dagger.Module
import dagger.Provides

/*
    订单Module
 */
@Module
class OrderModule {

    @Provides
    fun provideOrderservice(orderService: OrderServiceImpl): OrderService {
        return orderService
    }

}
