package com.shu.goods.ui.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.shu.goods.ui.fragment.GoodsDetailTabOneFragment
import com.shu.goods.ui.fragment.GoodsDetailTabtwoFragment

/**
 * Created by wangshufu on 2018/3/27.
 */
class GoodsDetailVpAdapter(fm:FragmentManager, context: Context) : FragmentStatePagerAdapter(fm) {

    private val tabTitleArray = arrayOf("商品","详情")

    override fun getItem(position: Int): Fragment {
        return if (position == 0){
            GoodsDetailTabOneFragment()
        }else{
            GoodsDetailTabtwoFragment()
        }
    }

    override fun getCount(): Int {
        return tabTitleArray.size
    }


    override fun getPageTitle(position: Int): CharSequence {
        return tabTitleArray[position]
    }
}