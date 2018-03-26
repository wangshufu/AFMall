package com.shu.goods.presenter

import com.shu.goods.data.protocol.Category
import com.shu.base.ext.excute
import com.shu.base.presenter.BasePresenter
import com.shu.base.rx.BaseSubscriber
import com.shu.goods.data.protocol.Goods
import com.shu.goods.presenter.view.CategoryView
import com.shu.goods.presenter.view.GoodsListView
import com.shu.goods.service.CategoryService
import com.shu.goods.service.GoodsListService
import javax.inject.Inject

/**
 * Created by wangshufu on 2018/3/21.
 */
class GoodsListPresenter @Inject constructor() : BasePresenter<GoodsListView>() {

    @Inject
    lateinit var goodsListService: GoodsListService


    fun getGoodsList(categoryId: Int,pageNo: Int) {

        if (!checkNetWork()) {
            return
        }

        goodsListService.getGoodsList(categoryId, pageNo).excute(object : BaseSubscriber<MutableList<Goods>?>(mView){
            override fun onNext(t: MutableList<Goods>?) {
                super.onNext(t)

                mView.getGoodsListResult(t)
            }
        },lifecycleProvider)

    }

    /*
        根据关键字 搜索商品
     */
    fun getGoodsListByKeyword(keyword: String, pageNo: Int) {
        if (!checkNetWork()) {
            return
        }
        mView.showLoading()
        goodsListService.getGoodsListByKeyword(keyword,pageNo).excute(object : BaseSubscriber<MutableList<Goods>?>(mView) {
            override fun onNext(t: MutableList<Goods>?) {
                mView.getGoodsListResult(t)
            }
        }, lifecycleProvider)

    }

}