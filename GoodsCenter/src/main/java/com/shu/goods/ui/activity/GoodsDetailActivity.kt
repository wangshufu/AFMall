package com.shu.goods.ui.activity

import android.os.Bundle
import android.view.Gravity
import com.alibaba.android.arouter.launcher.ARouter
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.kotlin.goods.event.AddCartEvent
import com.kotlin.goods.event.UpdateCartSizeEvent
import com.shu.base.common.BaseApplication.Companion.context
import com.shu.base.ext.onClick
import com.shu.base.ui.activity.BaseActivity
import com.shu.base.utils.AppPrefsUtils
import com.shu.goods.R
import com.shu.goods.common.GoodsConstant
import com.shu.goods.ui.adapter.GoodsDetailVpAdapter
import com.shu.provider.common.afterLogin
import com.shu.provider.router.RouterPath
import kotlinx.android.synthetic.main.activity_goods_detail.*
import org.jetbrains.anko.startActivity
import q.rorbin.badgeview.QBadgeView

/**
 * Created by wangshufu on 2018/3/27.
 */
class GoodsDetailActivity : BaseActivity() {

    private lateinit var mCartBdage: QBadgeView


    private lateinit var mAdapter : GoodsDetailVpAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods_detail)


        initView()
        initObserve()
        loadCartSize()

    }

    private fun initView() {

        mCartBdage = QBadgeView(this)


        //Back键
        mLeftIv.onClick {
            finish()
        }
        mAdapter = GoodsDetailVpAdapter(supportFragmentManager,context)
        mGoodsDetailVp.adapter = mAdapter
        mGoodsDetailTab.setupWithViewPager(mGoodsDetailVp)

        //加入购物车
        mAddCartBtn.onClick {
            afterLogin {
                Bus.send(AddCartEvent())
            }
        }

        //购物车
        mEnterCartTv.onClick {
            startActivity<CartActivity>()
        }

    }

    /*
        加载购物车数量
     */
    private fun loadCartSize() {
        setCartBadge()
    }

    /*
        监听购物车数量变化
     */
    private fun initObserve(){
        Bus.observe<UpdateCartSizeEvent>()
                .subscribe {
                    setCartBadge()
                }.registerInBus(this)
    }

    /*
        设置购物车标签
     */
    private fun setCartBadge() {
        mCartBdage.badgeGravity = Gravity.END or Gravity.TOP
        mCartBdage.setGravityOffset(22f,-2f,true)
        mCartBdage.setBadgeTextSize(6f,true)
        mCartBdage.bindTarget(mEnterCartTv).badgeNumber = AppPrefsUtils.getInt(GoodsConstant.SP_CART_SIZE)

    }

    /*
        Bus取消监听
     */
    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }
}