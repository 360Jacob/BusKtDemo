package com.jacob.lib_ui_module.topBar

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jacob.busktdemo.R

/**
 * TopBar
 * title: String  标题
 * isRightButtonVisible ：Boolean  是否显示右边按钮
 * rightIconId: Int 右边iconId
 */
@Composable
fun TopBar(
    title: String,
    rightIconId: Int,
    isRightButtonVisible: Boolean,
    onBackClick: () -> Unit = {},
    onRightClick: () -> Unit = {}
) {
    TopAppBar {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(id = R.drawable.ic_arrow_left_white),
                contentDescription = "返回按钮",
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(40.dp)
                    .animateContentSize()
                    .clickable { onBackClick() }
            )
            Text(
                title,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            if (isRightButtonVisible) {
                var icon: Painter = rememberVectorPainter(Icons.Default.Menu)
                if (rightIconId != 0) {
                    icon = painterResource(id = rightIconId)
                }
                Image(icon,
                    contentDescription = "菜单",
                    colorFilter = ColorFilter.tint(Color.White),
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .size(40.dp)
                        .animateContentSize()
                        .clickable { onRightClick() }
                )
            }

        }
    }
}

/**
 * TopBar
 * title: String  标题
 * isRightButtonVisible ：Boolean  是否显示右边按钮
 * rightIconId: Int 右边iconId
 */
@Composable
fun TopBar(
    title: String,
    isRightButtonVisible: Boolean,
    onBackClick: () -> Unit = {},
    onRightClick: () -> Unit = {}
) {
    TopAppBar {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(id = R.drawable.ic_arrow_left_white),
                contentDescription = "返回按钮",
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(40.dp)
                    .animateContentSize()
                    .clickable { onBackClick() }
            )
            Text(
                title,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            if (isRightButtonVisible) {
                Image(
                    rememberVectorPainter(Icons.Default.Menu),
                    contentDescription = "菜单",
                    colorFilter = ColorFilter.tint(Color.White),
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .size(40.dp)
                        .animateContentSize()
                        .clickable { onRightClick() }
                )
            }

        }
    }
}