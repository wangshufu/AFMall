package com.shu.afmall.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shu.afmall.R
import com.shu.afmall.common.*
import com.shu.afmall.ui.adapter.HomeDiscountAdapter
import com.shu.afmall.ui.adapter.TopicAdapter
import com.shu.base.ext.onClick
import com.shu.base.ui.fragment.BaseFragment
import com.shu.base.widgets.BannerImageLoader
import com.shu.goods.ui.activity.SearchGoodsActivity
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_home.*
import me.crosswall.lib.coverflow.CoverFlow
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by wangshufu on 2018/3/25.
 */
class HomeFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container,savedInstanceState)
        return inflater?.inflate(R.layout.fragment_home,null)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //必须要在这个方法里调用,不然用anko库是拿不到banner的
        initView()
        initBanner()
        initNews()
        initDiscount()
        initTopic()
    }

    private fun initView() {
        mSearchEt.onClick {
            startActivity<SearchGoodsActivity>()
        }
    }

    /**
     * 初始化轮播图Banner
     */
    private fun initBanner() {
        mHomeBanner.setImageLoader(BannerImageLoader())
        mHomeBanner.setImages(listOf(HOME_BANNER_ONE, HOME_BANNER_TWO, HOME_BANNER_THREE, HOME_BANNER_FOUR))
        mHomeBanner.setBannerAnimation(Transformer.Accordion)
        mHomeBanner.setDelayTime(2000)
        //设置指示器位置（当banner模式中有指示器时）
        mHomeBanner.setIndicatorGravity(BannerConfig.RIGHT)
        //banner设置方法全部调用完毕时最后调用
        mHomeBanner.start()
    }

    /**
     * 初始化公告
     */
    private fun initNews(){
        //公告
        mNewsFlipperView.setData(arrayOf("夏日炎炎，第一波福利还有30秒到达战场",
                "新用户立领1000元优惠券","全球时尚悦实惠，领鲜共享悦品位","质优，平价，超新鲜，网购阿福商城","到阿福商城购物，享最新便利"))
    }

    /**
     * 初始化折扣
     */
    private fun initDiscount(){
        val manager = LinearLayoutManager(context)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        mHomeDiscountRv.layoutManager = manager

        val discountAdapter  = HomeDiscountAdapter(activity)
        mHomeDiscountRv.adapter = discountAdapter
        discountAdapter.setData(mutableListOf(HOME_DISCOUNT_ONE, HOME_DISCOUNT_TWO, HOME_DISCOUNT_THREE, HOME_DISCOUNT_FOUR, HOME_DISCOUNT_FIVE))
    }

    /**
     * 初始化主题
     */
    private fun initTopic(){
        //话题
        mTopicPager.adapter = TopicAdapter(context, listOf(HOME_TOPIC_ONE, HOME_TOPIC_TWO, HOME_TOPIC_THREE, HOME_TOPIC_FOUR, HOME_TOPIC_FIVE))
        mTopicPager.currentItem = 1
        mTopicPager.offscreenPageLimit = 5

        CoverFlow.Builder().with(mTopicPager).scale(0.3f).pagerMargin(-30.0f).spaceSize(0.0f).build()
    }


}