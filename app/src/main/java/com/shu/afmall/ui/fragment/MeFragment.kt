package com.shu.afmall.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shu.afmall.R
import com.shu.afmall.ui.activity.MainActivity
import com.shu.afmall.ui.activity.SettingActivity
import com.shu.base.ext.loadUrl
import com.shu.base.ext.onClick
import com.shu.base.ui.fragment.BaseFragment
import com.shu.base.utils.AppPrefsUtils
import com.shu.order.common.OrderConstant
import com.shu.order.common.OrderStatus
import com.shu.order.ui.activity.OrderActivity
import com.shu.order.ui.activity.ShipAddressActivity
import com.shu.provider.common.ProviderConstant
import com.shu.provider.common.afterLogin
import com.shu.provider.common.isUserLogin
import com.shu.user.ui.activity.LoginActivity
import com.shu.user.ui.activity.UserCenterActivity
import kotlinx.android.synthetic.main.fragment_me.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by wangshufu on 2018/3/26.
 */
class MeFragment : BaseFragment(), View.OnClickListener {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_me, null)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    override fun onStart() {
        super.onStart()

        loadData()
    }

    private fun loadData() {
        if (isUserLogin()) {
            val userIcon = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_ICON)
            if (userIcon.isNotEmpty()) {
                mUserIconIv.loadUrl(userIcon)
            } else {
                mUserIconIv.setImageResource(R.drawable.icon_default_user)
            }
            val userName = AppPrefsUtils.getString(ProviderConstant.KEY_SP_USER_NAME)
            if (userName.isNotEmpty()) {
                mUserNameTv.text = userName
            } else {
                mUserNameTv.text = "None"
            }
        } else {
            mUserIconIv.setImageResource(R.drawable.icon_default_user)
            mUserNameTv.text = getString(R.string.un_login_text)
        }
    }

    private fun initView() {

        mUserIconIv.onClick(this)
        mUserNameTv.onClick(this)
        mSettingTv.onClick(this)
        mAddressTv.onClick(this)
        mWaitPayOrderTv.onClick(this)
        mWaitConfirmOrderTv.onClick(this)
        mCompleteOrderTv.onClick(this)
        mAllOrderTv.onClick(this)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.mUserIconIv, R.id.mUserNameTv -> {
                if (isUserLogin()) {
                    startActivity<UserCenterActivity>()
                } else {
                    startActivity<LoginActivity>()
                }
            }
            R.id.mWaitPayOrderTv -> {
                startActivity<OrderActivity>(OrderConstant.KEY_ORDER_STATUS to OrderStatus.ORDER_WAIT_PAY)
            }
            R.id.mWaitConfirmOrderTv -> {
                startActivity<OrderActivity>(OrderConstant.KEY_ORDER_STATUS to OrderStatus.ORDER_WAIT_CONFIRM)
            }
            R.id.mCompleteOrderTv -> {
                startActivity<OrderActivity>(OrderConstant.KEY_ORDER_STATUS to OrderStatus.ORDER_COMPLETED)
            }
            R.id.mAllOrderTv -> {
                afterLogin {
                    startActivity<OrderActivity>()
                }
            }
            R.id.mSettingTv -> {
                startActivity<SettingActivity>()
            }
            R.id.mAddressTv -> {
                startActivity<ShipAddressActivity>()
            }
        }
    }
}