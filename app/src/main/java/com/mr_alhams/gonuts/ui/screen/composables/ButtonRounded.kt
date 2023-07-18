package com.mr_alhams.gonuts.ui.screen.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonRounded(
    modifier: Modifier = Modifier,
    color: Color,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .size(45.dp)
            .clip(RoundedCornerShape(15.dp))
            .clickable { onClick() }
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}