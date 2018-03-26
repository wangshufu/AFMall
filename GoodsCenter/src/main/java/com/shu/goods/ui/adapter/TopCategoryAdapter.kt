package com.shu.goods.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shu.base.ui.adapter.BaseRecyclerViewAdapter
import com.shu.goods.data.protocol.Category
import com.shu.goods.R
import kotlinx.android.synthetic.main.layout_top_category_item.view.*

/*
    首页折扣区域Adapter
 */
class TopCategoryAdapter(context: Context): BaseRecyclerViewAdapter<Category, TopCategoryAdapter.ViewHolder>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext)
                .inflate(R.layout.layout_top_category_item,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        val category = dataList[position]

        if (category.categoryName.isNullOrEmpty()){
            holder.itemView.mTopCategoryNameTv.text = "None"
        }else{
            holder.itemView.mTopCategoryNameTv.text = category.categoryName
        }

        holder.itemView.isSelected = category.isSelected

    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view)

}