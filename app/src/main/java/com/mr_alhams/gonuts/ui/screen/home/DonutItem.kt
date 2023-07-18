package com.mr_alhams.gonuts.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mr_alhams.gonuts.ui.theme.LightGrey
import com.mr_alhams.gonuts.ui.theme.Primary
import com.mr_alhams.gonuts.ui.theme.White
import com.mr_alhams.gonuts.ui.theme.bodyMedium
import com.mr_alhams.gonuts.ui.theme.bodyMediumSemibold

@Composable
fun DonutItem(
    state: DonutItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(contentAlignment = Alignment.Center) {
        Column(
            modifier = modifier
                .clickable { onClick() }
                .background(
                    White,
                    RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    )
                )
                .width(138.dp)
                .padding(top = 27.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {

            Text(
                text = state.name,
                style = bodyMedium.copy(color = LightGrey),
                modifier = Modifier.padding(top = 24.dp, start = 4.dp, end = 4.dp),
                textAlign = TextAlign.Center,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${state.price}$",
                style = bodyMediumSemibold.copy(color = Primary),
                modifier = Modifier.padding(bottom = 20.dp, top = 10.dp)
            )

        }
        Image(
            painter = painterResource(id = state.image),
            modifier = Modifier
                .offset(y = (-60).dp)
                .width(83.dp)
                .height(85.dp),
            contentDescription = state.name,
        )
    }
}