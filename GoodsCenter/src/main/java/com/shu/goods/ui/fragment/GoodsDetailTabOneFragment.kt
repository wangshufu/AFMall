package com.shu.goods.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eightbitlab.rxbus.Bus
import com.kotlin.goods.event.GoodsDetailImageEvent
import com.shu.base.ui.fragment.BaseMvpFragment
import com.shu.base.utils.YuanFenConverter
import com.shu.base.widgets.BannerImageLoader
import com.shu.goods.R
import com.shu.goods.common.GoodsConstant
import com.shu.goods.data.protocol.Goods
import com.shu.goods.injection.component.DaggerGoodsListComponent
import com.shu.goods.injection.module.GoodsListModule
import com.shu.goods.presenter.GoodsDetailPresenter
import com.shu.goods.presenter.view.GoodsDetailView
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_goods_detail_tab_one.*
import kotlinx.android.synthetic.main.layout_goods_item.view.*

/**
 * Created by wangshufu on 2018/3/27.
 */
class GoodsDetailTabOneFragment : BaseMvpFragment<GoodsDetailPresenter>(),GoodsDetailView {


    override fun injectComponent() {
        DaggerGoodsListComponent.builder().activityComponent(activityComponent).goodsListModule(GoodsListModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_goods_detail_tab_one,null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBanner()
        loadData(activity.intent.getIntExtra(GoodsConstant.KEY_GOODS_ID, 1))
    }

    /**
     * 初始化轮播图Banner
     */
    private fun initBanner() {
        mGoodsDetailBanner.setImageLoader(BannerImageLoader())
        mGoodsDetailBanner.setBannerAnimation(Transformer.Accordion)
        mGoodsDetailBanner.setDelayTime(2000)
        //设置指示器位置（当banner模式中有指示器时）
        mGoodsDetailBanner.setIndicatorGravity(BannerConfig.RIGHT)
    }

    private fun loadData(goodsId: Int) {
        mPresenter.getGoodsDetail(goodsId)
    }

    private fun initView() {


    }


    override fun getGoodsDetailResult(goods: Goods) {
        goods?.let {
            //banner
            mGoodsDetailBanner.setImages(goods.goodsBanner.split(","))
            //banner设置方法全部调用完毕时最后调用
            mGoodsDetailBanner.start()
            //商品描述
            mGoodsDescTv.text = goods.goodsDesc
            //商品价格
            mGoodsPriceTv.text = YuanFenConverter.changeF2YWithUnit(goods.goodsDefaultPrice)
            mSkuSelectedTv.text = goods.goodsDefaultSku

            //同步数据到详情页
            Bus.send(GoodsDetailImageEvent(goods.goodsDetailOne,goods.goodsDetailTwo))
        }
    }
}