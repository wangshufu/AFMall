package com.shu.goods.data.protocol

/*
    按分类搜索商品

    pagerNo:第几页
 */
data class GetGoodsListReq(val categoryId: Int,val pageNo: Int)
