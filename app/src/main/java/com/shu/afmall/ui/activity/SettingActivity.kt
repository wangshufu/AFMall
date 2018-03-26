package com.shu.afmall.ui.activity

import android.os.Bundle
import android.view.View
import com.shu.afmall.R
import com.shu.base.ext.onClick
import com.shu.base.ui.activity.BaseActivity
import com.shu.user.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_setting.*

/**
 * Created by wangshufu on 2018/3/26.
 */
class SettingActivity : BaseActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        initView()
    }

    private fun initView() {
        mLogoutBtn.onClick(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.mLogoutBtn -> {
                UserPrefsUtils.putUserInfo(null)
                finish()
            }
        }
    }

}