package com.jacob.busktdemo.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.alibaba.android.arouter.launcher.ARouter
import com.jacob.commonmodule.arouter.ARouteConstants

@Composable
fun userCenterView() {


    Scaffold(backgroundColor = Color(0xffefefef)) {
        Column {
            Text(text = "用户中心")
            Button(onClick = {
                ARouter.getInstance().build(ARouteConstants.Login.LOGIN_ACTIVITY_URL).navigation()
            }){
                Text(text = "登录")
            }
        }
    }
}
