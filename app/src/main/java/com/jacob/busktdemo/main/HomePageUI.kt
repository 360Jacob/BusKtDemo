package com.jacob.busktdemo.main

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun homePageView() {
    Scaffold(backgroundColor = Color(0xffefefef)) {
        Text(text = "首页")
//
//        Card(
//            shape = MaterialTheme.shapes.medium,
//            modifier = Modifier.height(50.dp).fillMaxWidth().padding(
//                10.dp, 0.dp, 10.dp, 10.dp
//            ),
//            border = BorderStroke(1.dp, color = Color(0xffefefef)),
//            backgroundColor = Color.White,
//
//            ) {
//            Column {
//                Text(fontSize = 15.sp,
//                    color = Color.Black,
//                    text = "hello")
//            }
//            Spacer(modifier = Modifier.height(1.dp).fillMaxWidth().padding(10.dp,0.dp,0.dp,0.dp).background(
//                Color.LightGray))
//
//        }
    }
}