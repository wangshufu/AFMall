package com.shu.user.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.shu.base.ui.activity.BaseMvpActivity
import com.shu.user.R
import com.shu.user.presenter.RegisterPresenter
import com.shu.user.presenter.view.RegisterView

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
}
