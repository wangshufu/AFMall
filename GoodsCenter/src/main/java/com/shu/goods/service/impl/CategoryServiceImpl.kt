package com.shu.goods.service.impl

import com.shu.goods.data.protocol.Category
import com.shu.base.ext.convert
import com.shu.base.rx.BaseFunc
import com.shu.base.rx.BaseFuncBoolean
import com.shu.goods.data.repository.CategoryRepository
import com.shu.goods.service.CategoryService
import rx.Observable
import javax.inject.Inject

/**
 * Created by wangshufu on 2018/3/21.
 */
class CategoryServiceImpl @Inject constructor(): CategoryService {

    @Inject
    lateinit var repository : CategoryRepository

    override fun getCategory(parentId: Int): Observable<MutableList<Category>?> {

        return repository.getCategory(parentId).convert()
    }

}