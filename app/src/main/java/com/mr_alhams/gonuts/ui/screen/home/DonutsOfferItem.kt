package com.mr_alhams.gonuts.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.mr_alhams.gonuts.R
import com.mr_alhams.gonuts.ui.theme.Primary
import com.mr_alhams.gonuts.ui.theme.White
import com.mr_alhams.gonuts.ui.theme.bodyMediumSemiboldSpanStyle
import com.mr_alhams.gonuts.ui.theme.bodySmallNormal
import com.mr_alhams.gonuts.ui.theme.titleSmallMedium
import com.mr_alhams.gonuts.ui.theme.titleXLargeSpanStyle


@Composable
fun DonutOffersItem(
    state: DonutOffer,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(193.dp)
            .clickable { onClick() }
            .padding(16.dp)

    ) {
        Icon(
            painter = painterResource(id = R.drawable.favourite),
            contentDescription = state.name,
            modifier = Modifier
                .background(White, CircleShape)
                .padding(horizontal = 8.dp, vertical = 9.dp)
                .size(24.dp),
            tint = Primary
        )

        Image(
            painter = painterResource(id = state.image),
            modifier = Modifier
                .offset(x = 94.dp)
                .size(138.dp),
            contentDescription = state.name,
        )

        Text(
            text = state.name,
            style = titleSmallMedium,
            modifier = Modifier.padding(top = 17.dp, bottom = 9.dp)
        )

        Text(
            text = state.description,
            style = bodySmallNormal,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = buildAnnotatedString {
                withStyle(bodyMediumSemiboldSpanStyle) {
                    append("\$${state.discountedPrice}")
                }
                withStyle(titleXLargeSpanStyle) {
                    append(" \$${state.originalPrice}")
                }
            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 4.dp),
        )
    }
}