package com.jacob.busktdemo.main

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun messagePageView() {


    Scaffold(backgroundColor = Color(0xffefefef)) {
     Text(text = "消息")
    }
}