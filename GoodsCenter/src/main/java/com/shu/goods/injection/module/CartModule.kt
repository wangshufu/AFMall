package com.shu.goods.injection.module

import com.shu.goods.service.CartService
import com.shu.goods.service.impl.CartServiceImpl
import dagger.Module
import dagger.Provides

/*
    购物车Module
 */
@Module
class CartModule {

    @Provides
    fun provideCartService(cartService: CartServiceImpl): CartService {
        return cartService
    }

}
