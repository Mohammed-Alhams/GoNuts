package com.mr_alhams.gonuts.ui.screen.on_boarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.mr_alhams.gonuts.R
import com.mr_alhams.gonuts.ui.theme.Tertiary
import com.mr_alhams.gonuts.ui.theme.headlineLargeSemibold
import com.mr_alhams.gonuts.ui.theme.titleMedium


@Composable
fun OnBoardingScreen() {
    OnBoardingContent()
}

@Composable
fun OnBoardingContent() {

//    Box(modifier = Modifier.fillMaxSize()) {
//        Image(
//            contentDescription = null,
//        )

    Column(
        Modifier
//                .fillMaxWidth()
            .paint(
                painter = painterResource(id = R.drawable.onboarding_donuts),
            )
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom
    ) {

        Text(
            text = stringResource(R.string.gonuts_with_donuts),
            style = headlineLargeSemibold
        )

        Text(
            text = stringResource(R.string.gonuts_body),
            style = titleMedium.copy(color = Tertiary)
        )


    }
//    }

}