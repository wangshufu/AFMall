package com.shu.goods.ui.fragment

import android.os.Bundle
import android.os.LocaleList
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kennyc.view.MultiStateView.*
import com.shu.base.ui.adapter.BaseRecyclerViewAdapter
import com.shu.goods.data.protocol.Category
import com.shu.base.ext.setVisible
import com.shu.base.ext.startLoading
import com.shu.base.ui.fragment.BaseMvpFragment
import com.shu.goods.R
import com.shu.goods.common.GoodsConstant
import com.shu.goods.injection.component.DaggerCategoryComponent
import com.shu.goods.injection.module.CategoryModule
import com.shu.goods.presenter.CategoryPresenter
import com.shu.goods.presenter.view.CategoryView
import com.shu.goods.ui.activity.GoodsListActivity
import com.shu.goods.ui.activity.GoodsListActivity_MembersInjector
import com.shu.goods.ui.adapter.SecondCategoryAdapter
import com.shu.goods.ui.adapter.TopCategoryAdapter
import kotlinx.android.synthetic.main.fragment_category.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.intentFor
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

/**
 * Created by wangshufu on 2018/3/26.
 */
class CategoryFragment : BaseMvpFragment<CategoryPresenter>(), CategoryView {


    private lateinit var mTopAdapter: TopCategoryAdapter
    private lateinit var mSecondAdapter: SecondCategoryAdapter

    override fun injectComponent() {
        DaggerCategoryComponent.builder().activityComponent(activityComponent).categoryModule(CategoryModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_category, null)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onStart() {
        super.onStart()
        loadData()
    }

    private fun initView() {

        //一级分类
        val topLayoutManager = LinearLayoutManager(context)
        mTopAdapter = TopCategoryAdapter(context)
        mTopCategoryRv.layoutManager = topLayoutManager
        mTopCategoryRv.adapter = mTopAdapter
        mTopAdapter.setOnItemClickListener(object : BaseRecyclerViewAdapter.OnItemClickListener<Category> {
            override fun onItemClick(item: Category, position: Int) {
                for (category in mTopAdapter.dataList) {
                    category.isSelected = category.id == item.id
                }
                mTopAdapter.notifyDataSetChanged()

                //刷新二级目录的内容
                loadData(item.id)
            }
        })

        //二级分类
        val secondLayoutManager = GridLayoutManager(context, 3)
        mSecondAdapter = SecondCategoryAdapter(context)
        mSecondCategoryRv.layoutManager = secondLayoutManager
        mSecondCategoryRv.adapter = mSecondAdapter
        mSecondAdapter.setOnItemClickListener(object : BaseRecyclerViewAdapter.OnItemClickListener<Category> {
            override fun onItemClick(item: Category, position: Int) {
//                startActivity<GoodsListActivity>("categoryId",item.id)
                startActivity(intentFor<GoodsListActivity>().putExtra(GoodsConstant.KEY_CATEGORY_ID,item.id))

            }
        })

    }

    fun loadData(parent: Int = 0) {
        if (parent != 0){
            mMultiStateView.startLoading()
        }
        mPresenter.getCateGory(parent)
    }

    override fun getCategoryResult(list: MutableList<Category>?) {

        if (list != null && list.size > 0) {
            if (list[0] != null && list[0].parentId == 0) {
                //默认选中第一个
                list[0].isSelected = true
                mTopAdapter.setData(list)
                loadData(list[0].id)
            } else {
                mTopCategoryIv.setVisible(true)
                mCategoryTitleTv.setVisible(true)
                mSecondAdapter.setData(list)
                mMultiStateView.viewState = VIEW_STATE_CONTENT
            }
        } else {
            //没有数据
            mTopCategoryIv.setVisible(false)
            mCategoryTitleTv.setVisible(false)
            mMultiStateView.viewState = VIEW_STATE_EMPTY
        }

    }
}