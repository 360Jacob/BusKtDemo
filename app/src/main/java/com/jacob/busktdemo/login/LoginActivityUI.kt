package com.jacob.busktdemo.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jacob.busktdemo.ui.component.MyTextField
import com.jacob.lib_ui_module.topBar.TopBar


@Composable
fun initLoginActivityUI(
    title: String,
    onBackClick: () -> Unit = {},
    onRightClick: () -> Unit = {}
) {
    var scaffoldState = rememberScaffoldState()
    Scaffold(
        backgroundColor = Color.White,
        scaffoldState = scaffoldState,
        //TODO 头部导航栏
        topBar = {
            TopBar(title,
                false,
                onBackClick = {
                    onBackClick()
                }, onRightClick = {
                    onRightClick()
                })
        }

    ) {
        Box(contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier.fillMaxWidth().wrapContentHeight()
                    .padding(15.dp, 10.dp, 15.dp, 10.dp)
                    .background(Color.White),
            ) {

                MyTextField(
                    value = "1",
                    onValueChange = {},
                    placeholder = { Text(text = "请输入用户名") },//hint提示语
                    modifier = Modifier.fillMaxWidth().height(40.dp),
                    leadingIcon = {
                        Icon(
                            Icons.Filled.AccountCircle,
                            contentDescription = "",
                            modifier = Modifier.wrapContentHeight().wrapContentWidth(),
                            tint = Color.LightGray
                        )
                    },
                    trailingIcon = {
                        Icon(
                            Icons.Filled.Clear,
                            contentDescription = "",
                            modifier = Modifier.wrapContentHeight().wrapContentWidth(),
                            tint = Color.LightGray
                        )
                    }
                )
                Spacer(modifier = Modifier.height(20.dp))
                //TODO 输入密码
                MyTextField(
                    value = "1",
                    onValueChange = {},
                    placeholder = { Text(text = "请输入密码") },//hint提示语
                    modifier = Modifier.fillMaxWidth().height(40.dp),
                    leadingIcon = {
                        Icon(
                            Icons.Filled.Lock,
                            contentDescription = "",
                            modifier = Modifier.wrapContentHeight().wrapContentWidth(),
                            tint = Color.LightGray
                        )
                    },
                    trailingIcon = {
                        Icon(
                            Icons.Filled.Clear,
                            contentDescription = "",
                            modifier = Modifier.wrapContentHeight().wrapContentWidth(),
                            tint = Color.LightGray
                        )
                    }
                )

            }
        }

    }

}


fun onAccountChange() {
    //TODO 账号信息变更
}