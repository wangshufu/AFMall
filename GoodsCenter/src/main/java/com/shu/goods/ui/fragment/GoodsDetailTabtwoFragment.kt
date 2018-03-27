package com.shu.goods.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.kotlin.goods.event.GoodsDetailImageEvent
import com.shu.base.ext.loadUrl
import com.shu.base.ui.fragment.BaseFragment
import com.shu.goods.R
import kotlinx.android.synthetic.main.fragment_goods_detail_tab_two.*

/**
 * Created by wangshufu on 2018/3/27.
 */
class GoodsDetailTabtwoFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_goods_detail_tab_two,null)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObserver()
    }

    private fun initObserver() {
        Bus.observe<GoodsDetailImageEvent>()
                .subscribe { t : GoodsDetailImageEvent -> run {
                    mGoodsDetailOneIv.loadUrl(t.imgOne)
                    mGoodsDetailTwoIv.loadUrl(t.imgTwo)
                }  }
                .registerInBus(this) //registers your subscription to unsubscribe it properly later
    }
}