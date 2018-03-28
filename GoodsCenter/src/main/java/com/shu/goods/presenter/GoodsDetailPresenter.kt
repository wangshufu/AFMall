package com.shu.goods.presenter

import com.shu.base.ext.excute
import com.shu.base.presenter.BasePresenter
import com.shu.base.rx.BaseSubscriber
import com.shu.base.utils.AppPrefsUtils
import com.shu.goods.common.GoodsConstant
import com.shu.goods.data.protocol.Goods
import com.shu.goods.presenter.view.GoodsDetailView
import com.shu.goods.presenter.view.GoodsListView
import com.shu.goods.service.CartService
import com.shu.goods.service.GoodsListService
import javax.inject.Inject

/**
 * Created by wangshufu on 2018/3/21.
 */
class GoodsDetailPresenter @Inject constructor() : BasePresenter<GoodsDetailView>() {

    @Inject
    lateinit var goodsListService: GoodsListService
    @Inject
    lateinit var cartService: CartService


    fun getGoodsDetail(goodsId: Int) {

        if (!checkNetWork()) {
            return
        }

        mView.showLoading()

        goodsListService.getGoodsDetail(goodsId).excute(object : BaseSubscriber<Goods>(mView){
            override fun onNext(t: Goods) {
                super.onNext(t)

                mView.getGoodsDetailResult(t)
            }
        },lifecycleProvider)

    }

    /*
        加入购物车
     */
    fun addCart(goodsId: Int, goodsDesc: String, goodsIcon: String, goodsPrice: Long,
                goodsCount: Int, goodsSku: String) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        cartService.addCart(goodsId,goodsDesc,goodsIcon,goodsPrice,
                goodsCount,goodsSku).excute(object : BaseSubscriber<Int>(mView) {
            override fun onNext(t: Int) {
                //保存购物车数量
                AppPrefsUtils.putInt(GoodsConstant.SP_CART_SIZE,t)
                mView.onAddCartResult(t)
            }
        }, lifecycleProvider)

    }

}