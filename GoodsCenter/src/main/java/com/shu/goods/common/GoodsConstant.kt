package com.shu.goods.common

/**
 * Created by wangshufu on 2018/3/21.
 */
class GoodsConstant {

    companion object {
        //商品类型
        const val KEY_CATEGORY_ID = "key_category_id"
        //搜索历史 本地存储
        const val SP_SEARCH_HISTORY = "search_history"
        //搜索商品类型
        const val KEY_SEARCH_GOODS_TYPE = "search_goods_type"
        //按分类搜索
        const  val SEARCH_GOODS_TYPE_CATEGORY = 0
        //按关键字搜索
        const  val SEARCH_GOODS_TYPE_KEYWORD = 1
        //商品关键字
        const val KEY_GOODS_KEYWORD = "goods_keyword"

    }
}