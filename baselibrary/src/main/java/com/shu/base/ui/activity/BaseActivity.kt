package com.shu.base.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shu.base.common.AppManager
import com.trello.rxlifecycle.components.support.RxAppCompatActivity

/**
 * Created by wangshufu on 2018/3/20.
 *
 * 静态页面
 *
 */
open class BaseActivity : RxAppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppManager.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()

        AppManager.instance.finishActivity(this)
    }
}