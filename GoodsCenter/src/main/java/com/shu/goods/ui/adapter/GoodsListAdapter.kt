package com.shu.goods.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shu.base.ui.adapter.BaseRecyclerViewAdapter
import com.shu.base.ext.loadUrl
import com.shu.base.utils.YuanFenConverter
import com.shu.goods.R
import com.shu.goods.data.protocol.Goods
import kotlinx.android.synthetic.main.layout_goods_item.view.*

/*
    首页折扣区域Adapter
 */
class GoodsListAdapter(context: Context) : BaseRecyclerViewAdapter<Goods, GoodsListAdapter.ViewHolder>(context) {

    /**
     * 添加更多的数据
     */
    fun addData(sources: MutableList<Goods>?) {
        if (sources != null && sources.size > 0) {
            dataList.addAll(sources)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext)
                .inflate(R.layout.layout_goods_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        val goods = dataList[position]

        //商品图标
        holder.itemView.mGoodsIconIv.loadUrl(goods.goodsDefaultIcon)
        //商品描述
        holder.itemView.mGoodsDescTv.text = goods.goodsDesc
        //商品价格
        holder.itemView.mGoodsPriceTv.text = YuanFenConverter.changeF2YWithUnit(goods.goodsDefaultPrice)
        //商品销量及库存
        holder.itemView.mGoodsSalesStockTv.text = "销量${goods.goodsSalesCount}件     库存${goods.goodsStockCount}"

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

}