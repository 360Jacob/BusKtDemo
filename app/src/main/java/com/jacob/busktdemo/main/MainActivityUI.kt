package com.jacob.busktdemo.main

import android.util.Log
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.jacob.busktdemo.MenuTabVO
import com.jacob.busktdemo.ui.component.VerticalImageText
import com.jacob.lib_ui_module.topBar.TopBar
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun initUI(
    title: String,
    onBackClick: () -> Unit = {},
    onRightClick: () -> Unit = {}
) {

    val items = listOf<MenuTabVO>(
        MenuTabVO("首页", rememberVectorPainter(Icons.Rounded.Home)),
        MenuTabVO("消息", rememberVectorPainter(Icons.Rounded.Email)),
        MenuTabVO("我的", rememberVectorPainter(Icons.Rounded.AccountCircle)),
    )
    var pagerState = rememberPagerState(items.size)
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        backgroundColor = Color.White,
        scaffoldState = scaffoldState,
        //TODO 头部导航栏
        topBar = {
            TopBar(title,
                true,
                onBackClick = {
                    onBackClick()
                }, onRightClick = {
                    onRightClick()
                })
        },
        //TODO 底部Tab导航栏
        bottomBar = {
            val state = remember { mutableStateOf(0) }
            TabRow(
                selectedTabIndex = state.value,
                modifier = Modifier.height(50.dp),
                backgroundColor = Color(0xFFEFEFEF),
                contentColor = Color.Blue,
                indicator = @Composable { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                        color = Color.White
                    )
                }
            ) {
                items.forEachIndexed { index, menuTabVO ->
                    Tab(
                        selected = pagerState.currentPage == index,
                        onClick = {
                            state.value = index
                            scope.launch {
                                pagerState.scrollToPage(index)
                            }
                        },
                        unselectedContentColor = Color.Black
                    ) {
                        VerticalImageText(
                            painter = menuTabVO.painter,
                            text = menuTabVO.text,
                            pagerState.currentPage == index
                        )
                    }
                }
            }
        },

        ) {


        HorizontalPager(
            count = items.size,
            state = pagerState,
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        ) {
            Text(text = "page:" + pagerState.targetPage)
               when(pagerState.currentPage){
                   0->{
                      homePageView()
                   }
                   1->{
                       messagePageView()
                   }
                   2->{
                       userCenterView()
                   }
                   else ->{
                       Log.e(this.toString(),"lose my way")
                   }
               }
        }
    }

}
