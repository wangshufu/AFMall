package com.shu.goods.presenter

import com.shu.goods.data.protocol.Category
import com.shu.base.ext.excute
import com.shu.base.presenter.BasePresenter
import com.shu.base.rx.BaseSubscriber
import com.shu.goods.presenter.view.CategoryView
import com.shu.goods.service.CategoryService
import javax.inject.Inject

/**
 * Created by wangshufu on 2018/3/21.
 */
class CategoryPresenter @Inject constructor() : BasePresenter<CategoryView>() {

    @Inject
    lateinit var categoryService: CategoryService


    fun getCateGory(parentId: Int) {

        if (!checkNetWork()) {
            return
        }

        categoryService.getCategory(parentId).excute(object : BaseSubscriber<MutableList<Category>?>(mView){
            override fun onNext(t: MutableList<Category>?) {
                super.onNext(t)

                mView.getCategoryResult(t)

            }
        },lifecycleProvider)

    }

}