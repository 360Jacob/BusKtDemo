package com.jacob.busktdemo.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

/**
 *纵向图文控件
 */
@Composable
fun VerticalImageText(painter: Painter? = null, text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .defaultMinSize(minWidth = 50.dp)
    ) {
        if (painter != null) {
            Image(painter = painter, contentDescription = "logo")
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text)
    }
}
/**
 *纵向图文控件
 */
@Composable
fun VerticalImageText(painter: Painter? = null, text: String ,isSelected: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .defaultMinSize(minWidth = 50.dp)
    ) {
        if (painter != null) {
            var colorFilterTint = ColorFilter.tint(Color.Black)
            if(isSelected) {
                colorFilterTint = ColorFilter.tint(Color.Blue)
            }
            Image(painter = painter, contentDescription = "logo", colorFilter = colorFilterTint )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text)
    }
}