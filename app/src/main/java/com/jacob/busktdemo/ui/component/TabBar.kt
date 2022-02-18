package com.jacob.busktdemo.ui.component

import android.util.Log
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.dp
import com.jacob.busktdemo.MenuTabVO
import kotlinx.coroutines.selects.select

/**
 * TabBar 不可滑动
 */
@Composable
fun TabBar(
    tabList: List<MenuTabVO>,
    onTabClick: (index: Int) -> Unit = {}
) {
    val state = remember { mutableStateOf(0) }
    TabRow(
        selectedTabIndex = state.value,
        modifier = Modifier.height(50.dp),
        backgroundColor = Color(0xFFEFEFEF),
        contentColor = Color.Blue,
        indicator = @Composable { tabPositions ->
            TabRowDefaults.Indicator(Modifier.customTabIndicatorOffset(tabPositions[state.value]),
                color = Color.White)
        }
    ) {
        tabList.forEachIndexed { index, menuTabVO ->
            Tab(
                selected = state.value == index,
                onClick = {
                    state.value = index
                    onTabClick(index)
                },
                unselectedContentColor = Color.Black
            ) {
                VerticalImageText(painter = menuTabVO.painter, text = menuTabVO.text, state.value == index)
            }
        }
    }
}

fun Modifier.customTabIndicatorOffset(
    currentTabPosition: TabPosition
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "tabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = currentTabPosition.width,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    val indicatorOffset by animateDpAsState(
        targetValue = currentTabPosition.left,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset + currentTabWidth / 4)  // 偏移量加上宽度的1/4
        .width(currentTabWidth / 2)  // 宽度Tab宽度的1/2
}


/**
 * TabBar 可滑动
 */
@Composable
fun ScrollTabBar(
    tabList: List<MenuTabVO>,
    onTabClick: (index: Int) -> Unit = {}
) {
    val sTabState = remember { mutableStateOf(0) }
    ScrollableTabRow(
        selectedTabIndex = sTabState.value,
        modifier = Modifier.height(50.dp),
        edgePadding = 0.dp
    ) {
        tabList.forEachIndexed { index, menuTabVO ->
            Tab(selected = sTabState.value == index,
                onClick = {
                    sTabState.value = index
                    onTabClick(index)
                }) {
                VerticalImageText(menuTabVO.painter, menuTabVO.text)
                onTabClick(index)
            }
        }
    }
}

/**
 * TabBar 不可滑动
 */
@Composable
fun BaseTabString(
    tabList: List<String>,
    onTabClick: (index: Int) -> Unit = {}
) {
    val state = remember { mutableStateOf(0) }
    TabRow(selectedTabIndex = state.value, modifier = Modifier.height(50.dp)) {
        tabList.forEachIndexed { index, text ->
            Tab(selected = state.value == index, onClick = {
                state.value = index
                onTabClick(index)
            }) {
                VerticalImageText(text = text)
                onTabClick(index)
            }
        }
    }
}
