package com.shu.goods.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shu.base.ui.adapter.BaseRecyclerViewAdapter
import com.shu.goods.data.protocol.Category
import com.shu.base.ext.loadUrl
import com.shu.goods.R
import kotlinx.android.synthetic.main.layout_second_category_item.view.*

/*
    首页折扣区域Adapter
 */
class SecondCategoryAdapter(context: Context): BaseRecyclerViewAdapter<Category, SecondCategoryAdapter.ViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext)
                .inflate(R.layout.layout_second_category_item,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        val category = dataList[position]

        holder.itemView.mCategoryIconIv.loadUrl(category.categoryIcon)
        holder.itemView.mSecondCategoryNameTv.text = category.categoryName


    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)

}