package com.jacob.busktdemo.main

import androidx.activity.compose.setContent
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.accompanist.pager.ExperimentalPagerApi
import com.jacob.busktdemo.BaseActivity
import com.jacob.busktdemo.R
import com.jacob.busktdemo.ui.theme.BusKtDemoTheme
import com.jacob.commonmodule.arouter.ARouteConstants

@Route(path = ARouteConstants.Main.MAIN_ACTIVITY_URL)
class MainActivity : BaseActivity() {

    @ExperimentalPagerApi
    override fun setContentView() {
        setContent {
            BusKtDemoTheme {
                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//
//                }
                initUI(getString(R.string.txt_main_page),
                    onBackClick = { finish() },
                    onRightClick = { onTopBarRightClick() })
            }
        }

//
    }

    override fun initData() {

    }

    fun onTopBarRightClick() {
        //TODO 点击事件
        showToast("-->onTopBarRightClick")
    }

}



