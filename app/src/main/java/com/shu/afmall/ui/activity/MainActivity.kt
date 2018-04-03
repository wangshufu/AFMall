package com.shu.afmall.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.kotlin.goods.event.UpdateCartSizeEvent
import com.shu.afmall.R
import com.shu.afmall.ui.fragment.HomeFragment
import com.shu.afmall.ui.fragment.MeFragment
import com.shu.base.common.AppManager
import com.shu.base.ui.activity.BaseActivity
import com.shu.base.ui.activity.BaseMvpActivity
import com.shu.base.utils.AppPrefsUtils
import com.shu.goods.common.GoodsConstant
import com.shu.goods.ui.fragment.CartFragment
import com.shu.goods.ui.fragment.CategoryFragment
import com.shu.messagecenter.ui.fragment.MessageFragment
import com.shu.provider.event.MessageBadgeEvent
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*

/**
 * Created by wangshufu on 2018/3/25.
 */
class MainActivity : BaseActivity() {

    private var pressTime:Long = 0

    //fragment栈
    private var mStack = Stack<Fragment>()
    //主界面Fragment
    private val mHomeFragment by lazy { HomeFragment() }
    //商品分类Fragment
    private val mCategoryFragment by lazy { CategoryFragment() }
    //购物车Fragment
    private val mCartFragment by lazy { CartFragment() }
    //消息Fragment
    private val mMessageFragment by lazy { MessageFragment() }
    //"我的"Fragment
    private val mMeFragment by lazy { MeFragment() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragments()
        initBottomNav()
        mBottomNavBar.checkMsgBadge(false)
        //设置默认显示主页fragment
        changeFragment(0)

        initObserve()
        loadCartSize()
    }

    /**
     * 初始化fragment
     */
    private fun initFragments() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.mContaier, mHomeFragment)
        transaction.add(R.id.mContaier, mCategoryFragment)
        transaction.add(R.id.mContaier, mCartFragment)
        transaction.add(R.id.mContaier, mMessageFragment)
        transaction.add(R.id.mContaier, mMeFragment)
        transaction.commit()

        mStack.add(mHomeFragment)
        mStack.add(mCategoryFragment)
        mStack.add(mCartFragment)
        mStack.add(mMessageFragment)
        mStack.add(mMeFragment)
    }


    private fun initBottomNav() {
        mBottomNavBar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener{
            override fun onTabReselected(position: Int) {

            }

            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)
            }

        })

        mBottomNavBar.checkMsgBadge(false)
    }

    /**
     * 切换fragment
     */
    private fun changeFragment(position: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        //将所有的fragment隐藏
        for (fragment in mStack){
            transaction.hide(fragment)
        }
        transaction.show(mStack[position])
        transaction.commit()

    }

    /*
        初始化监听，购物车数量变化及消息标签是否显示
     */
    private fun initObserve(){
        Bus.observe<UpdateCartSizeEvent>()
                .subscribe {
                    loadCartSize()
                }.registerInBus(this)

        Bus.observe<MessageBadgeEvent>()
                .subscribe {
                    t: MessageBadgeEvent ->
                    run {
                        mBottomNavBar.checkMsgBadge(t.isVisible)
                    }
                }.registerInBus(this)
    }

    /*
        加载购物车数量
     */
    private fun loadCartSize(){
        mBottomNavBar.checkCartBadge(AppPrefsUtils.getInt(GoodsConstant.SP_CART_SIZE))
    }

    /*
        取消Bus事件监听
     */
    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }

    /*
       重写Back事件，双击退出
    */
    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000){
            toast("再按一次退出程序")
            pressTime = time
        } else{
            AppManager.instance.exitApp(this)
        }
    }
}