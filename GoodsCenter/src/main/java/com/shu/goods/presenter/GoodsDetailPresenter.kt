package com.shu.goods.presenter

import com.shu.base.ext.excute
import com.shu.base.presenter.BasePresenter
import com.shu.base.rx.BaseSubscriber
import com.shu.goods.data.protocol.Goods
import com.shu.goods.presenter.view.GoodsDetailView
import com.shu.goods.presenter.view.GoodsListView
import com.shu.goods.service.GoodsListService
import javax.inject.Inject

/**
 * Created by wangshufu on 2018/3/21.
 */
class GoodsDetailPresenter @Inject constructor() : BasePresenter<GoodsDetailView>() {

    @Inject
    lateinit var goodsListService: GoodsListService


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

}