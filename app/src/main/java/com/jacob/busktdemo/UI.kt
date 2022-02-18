package com.jacob.busktdemo

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun MainContent(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        horizontalAlignment= Alignment.CenterHorizontally) {
        Button(modifier = Modifier.size(200.dp, Dp.Infinity),onClick = {
//            startActivity(Intent(this@MainActivity,IntroductionActivity::class.java))
        }) {
            Text(text = "Compose快速入门")
        }
        Spacer(modifier = Modifier.size(1.dp,10.dp))
        Button(modifier = Modifier.size(200.dp, Dp.Infinity),onClick = {
//            startActivity(Intent(this@MainActivity,CustomUIActivity::class.java))
        }) {
            Text(text = "布局")
        }
    }
}