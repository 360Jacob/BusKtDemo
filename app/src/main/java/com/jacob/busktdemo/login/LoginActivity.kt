package com.jacob.busktdemo.login

import com.alibaba.android.arouter.facade.annotation.Route
import com.jacob.busktdemo.BaseActivity
import com.jacob.busktdemo.R
import com.jacob.busktdemo.ui.theme.BusKtDemoTheme
import com.jacob.commonmodule.arouter.ARouteConstants

@Route(path = ARouteConstants.Login.LOGIN_ACTIVITY_URL)
class LoginActivity : BaseActivity() {
    override fun setContentView() {
        BusKtDemoTheme {
            initLoginActivityUI(getString(R.string.txt_login),
                onBackClick = { finish() },
                onRightClick = { onTopBarRightClick() })
        }
    }

    private fun onTopBarRightClick() {

    }

    override fun initData() {
    }
}