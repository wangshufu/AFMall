package com.shu.goods.ui.activity

import android.os.Bundle
import com.shu.base.common.BaseApplication.Companion.context
import com.shu.base.ext.onClick
import com.shu.base.ui.activity.BaseActivity
import com.shu.goods.R
import com.shu.goods.ui.adapter.GoodsDetailVpAdapter
import kotlinx.android.synthetic.main.activity_goods_detail.*

/**
 * Created by wangshufu on 2018/3/27.
 */
class GoodsDetailActivity : BaseActivity() {


    private lateinit var mAdapter : GoodsDetailVpAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods_detail)


        initView()


    }

    private fun initView() {
        //Back键
        mLeftIv.onClick {
            finish()
        }
        mAdapter = GoodsDetailVpAdapter(supportFragmentManager,context)
        mGoodsDetailVp.adapter = mAdapter
        mGoodsDetailTab.setupWithViewPager(mGoodsDetailVp)

    }
}