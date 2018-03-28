package com.shu.order.injection.module

import com.shu.order.service.ShipAddressService
import com.shu.order.service.impl.ShipAddressServiceImpl
import dagger.Module
import dagger.Provides

/*
    收货人信息Module
 */
@Module
class ShipAddressModule {

    @Provides
    fun provideShipAddressservice(shipAddressService: ShipAddressServiceImpl): ShipAddressService {
        return shipAddressService
    }

}
