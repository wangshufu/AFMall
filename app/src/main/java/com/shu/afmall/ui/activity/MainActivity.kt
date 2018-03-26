package com.shu.afmall.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.shu.afmall.R
import com.shu.afmall.ui.fragment.HomeFragment
import com.shu.afmall.ui.fragment.MeFragment
import com.shu.base.common.AppManager
import com.shu.base.ui.activity.BaseActivity
import com.shu.base.ui.activity.BaseMvpActivity
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
    private val mCategoryFragment by lazy { HomeFragment() }
    //购物车Fragment
    private val mCartFragment by lazy { HomeFragment() }
    //消息Fragment
    private val mMessageFragment by lazy { HomeFragment() }
    //"我的"Fragment
    private val mMeFragment by lazy { MeFragment() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragments()
        initBottomNav()
        mBottomNavBar.checkCartBadge(20)
        mBottomNavBar.checkMsgBadge(false)
        //设置默认显示主页fragment
        changeFragment(0)
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