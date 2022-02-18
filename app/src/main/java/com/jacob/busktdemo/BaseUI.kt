package com.jacob.busktdemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import com.jacob.busktdemo.ui.component.VerticalImageText
import com.jacob.lib_ui_module.topBar.TopBar
import kotlinx.coroutines.launch




@Composable
fun BaseTab(tabList: List<MenuTabVO>) {
    val state = remember { mutableStateOf(0) }
    TabRow(selectedTabIndex = state.value, modifier = Modifier.height(50.dp)) {
        tabList.forEachIndexed { index, menuTabVO ->
            Tab(selected = state.value == index, onClick = { state.value = index }) {
                VerticalImageText(painter = menuTabVO.painter, text = menuTabVO.text)
            }
        }
    }
}



@Composable
fun DrawerContent() {
    Text(text = "今天还没有打卡哦")
    Spacer(modifier = Modifier.height(20.dp))

}

/**
 * 使用ModalDrawer展示模态抽屉式导航栏
 */
@Composable
fun ModalDrawerCompose() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerContent() }
    ) {
        TextButton(
            modifier = Modifier.padding(top = 200.dp),
            onClick = {
                scope.launch {
                    //控制抽屉显示与关闭
                    drawerState.apply {
                        if (isOpen) close() else open()
                    }
                }
            }) {
            Text(text = "ModalDrawer抽屉")
        }
    }
}

/**
 * 采用Scaffold槽位
 */
@Composable
fun ScaffoldCompose() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        //顶部工具栏
        topBar = {
            TopBar("标题", true, onRightClick = {
                scope.launch {
                    //控制抽屉显示与关闭
                    scaffoldState.drawerState.apply {
                        if (isOpen) close() else open()
                    }
                }
            })
        },
        //底部工具栏
        bottomBar = {
            BottomAppBar(
                //当floatActionButton与bottomBar重叠时剪切样式
                cutoutShape = MaterialTheme.shapes.small.copy(CornerSize(50.dp)),

                ) {
               VerticalImageText(rememberVectorPainter(Icons.Rounded.Email), "消息")

                VerticalImageText(rememberVectorPainter(Icons.Rounded.Menu), "动态")
            }
        },
        //floatingActionButton位置
        floatingActionButtonPosition = FabPosition.Center,//居中
        //添加一个floatingActionButton
        floatingActionButton = {
            FloatingActionButton(onClick = {
                //点击按钮，显示一个SnackBar
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        "你点击了FloatingActionButton",
                        actionLabel = "Done"
                    )
                }
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        },
        //是否与bottomBar区域重叠,true叠加，false 不叠加
        isFloatingActionButtonDocked = true,
        drawerContent = { DrawerContent() }
    ) {
//        ShowMaterialComponents()
    }
}

