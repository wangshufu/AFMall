package com.shu.goods.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import cn.bingoogolapple.refreshlayout.BGAMeiTuanRefreshViewHolder
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder
import cn.bingoogolapple.refreshlayout.BGARefreshLayout
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder
import com.kennyc.view.MultiStateView.*
import com.shu.base.common.BaseApplication.Companion.context
import com.shu.base.ext.startLoading
import com.shu.base.ui.activity.BaseMvpActivity
import com.shu.base.ui.adapter.BaseRecyclerViewAdapter
import com.shu.goods.R
import com.shu.goods.common.GoodsConstant
import com.shu.goods.data.protocol.Goods
import com.shu.goods.injection.component.DaggerCategoryComponent
import com.shu.goods.injection.component.DaggerGoodsListComponent
import com.shu.goods.injection.module.CategoryModule
import com.shu.goods.injection.module.GoodsListModule
import com.shu.goods.presenter.GoodsListPresenter
import com.shu.goods.presenter.view.GoodsListView
import com.shu.goods.ui.adapter.GoodsListAdapter
import kotlinx.android.synthetic.main.activity_goods.*
import org.jetbrains.anko.intentFor

/**
 * Created by wangshufu on 2018/3/26.
 */
class GoodsListActivity : BaseMvpActivity<GoodsListPresenter>(), GoodsListView, BGARefreshLayout.BGARefreshLayoutDelegate {


    private lateinit var mLayoutManager: GridLayoutManager
    private lateinit var mAdapter: GoodsListAdapter

    private var mCurrentPage = 1
    private var mPageMax = 15
    private var mCategoryId = 1


    override fun injectComponent() {
        DaggerGoodsListComponent.builder().activityComponent(activityComponent).goodsListModule(GoodsListModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goods)
        initView()
        initRefreshLayout();
        mCategoryId = intent.getIntExtra(GoodsConstant.KEY_CATEGORY_ID, 1)
        loadData()
    }


    private fun initView() {
        mLayoutManager = GridLayoutManager(context, 2)
        mAdapter = GoodsListAdapter(context)
        mGoodsRv.layoutManager = mLayoutManager
        mGoodsRv.adapter = mAdapter
        mAdapter.setOnItemClickListener(object : BaseRecyclerViewAdapter.OnItemClickListener<Goods> {
            override fun onItemClick(item: Goods, position: Int) {
                startActivity(intentFor<GoodsDetailActivity>().putExtra(GoodsConstant.KEY_GOODS_ID, item.id))
            }

        })
    }


    override fun getGoodsListResult(list: MutableList<Goods>?) {
        //隐藏上拉或下拉刷新功能
        mRefreshLayout.endLoadingMore();
        mRefreshLayout.endRefreshing()
        if (list != null && list.size > 0) {
            if (mCurrentPage == 1) {
                mPageMax = list[0].maxPage
                mAdapter.setData(list)
            } else {
                mAdapter.addData(list)
            }
            mMultiStateView.viewState = VIEW_STATE_CONTENT
        } else if (mAdapter.dataList == null || mAdapter.dataList.size == 0) {//这里还要这样判断是怕加载更多时,如果返回null的话,多视图就会变成空视图了
            mMultiStateView.viewState = VIEW_STATE_EMPTY
        }
    }

    override fun onError(error: String) {
        mMultiStateView.viewState = VIEW_STATE_ERROR
    }

    private fun initRefreshLayout() {
        // 为BGARefreshLayout 设置代理
        mRefreshLayout.setDelegate(this);
        // 设置下拉刷新和上拉加载更多的风格     参数1：应用程序上下文，参数2：是否具有上拉加载更多功能
        val refreshViewHolder = BGANormalRefreshViewHolder(this, true)
//        val refreshViewHolder = BGAMeiTuanRefreshViewHolder(this, true)
        // 设置下拉刷新和上拉加载更多的风格
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);

    }

    /**
     * 加载数据
     */
    private fun loadData() {
        if (intent.getIntExtra(GoodsConstant.KEY_SEARCH_GOODS_TYPE, 0) != 0) {
            mMultiStateView.startLoading()
            mPresenter.getGoodsListByKeyword(intent.getStringExtra(GoodsConstant.KEY_GOODS_KEYWORD), mCurrentPage)
        } else {
            mMultiStateView.startLoading()
            mPresenter.getGoodsList(intent.getIntExtra(GoodsConstant.KEY_CATEGORY_ID, 1), mCurrentPage)
        }
    }

    /**
     * 在这里加载更多数据，或者更具产品需求实现上拉刷新也可以
     */
    override fun onBGARefreshLayoutBeginLoadingMore(refreshLayout: BGARefreshLayout?): Boolean {

        return if (mCurrentPage < mPageMax) {
            mCurrentPage++
            loadData()
            true
        } else {
            false
        }
    }

    /**
     * 在这里加载最新数据
     */
    override fun onBGARefreshLayoutBeginRefreshing(refreshLayout: BGARefreshLayout?) {
        mCurrentPage = 1
        loadData()

    }
}