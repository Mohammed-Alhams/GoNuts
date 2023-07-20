package com.mr_alhams.gonuts.ui.screen.on_boarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mr_alhams.gonuts.R
import com.mr_alhams.gonuts.ui.screen.composables.ButtonSecondary
import com.mr_alhams.gonuts.ui.screen.home.navigateToHome
import com.mr_alhams.gonuts.ui.theme.Secondary
import com.mr_alhams.gonuts.ui.theme.Tertiary
import com.mr_alhams.gonuts.ui.theme.headlineLargeSemibold
import com.mr_alhams.gonuts.ui.theme.titleLargeSemibold
import com.mr_alhams.gonuts.ui.theme.titleMedium
import kotlinx.coroutines.flow.collectLatest


@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel = hiltViewModel(),
    navController: NavController
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.effect.collectLatest {
            navController.navigateToHome()
        }
    }

    OnBoardingContent(viewModel)
}

@Composable
private fun OnBoardingContent(
    listener: OnBoardingInteractionListener
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Secondary)
    ) {
        Image(
            painter = painterResource(id = R.drawable.onboarding_donuts),
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            contentDescription = null,
        )

        Column(
            Modifier
                .fillMaxSize()
                .padding(24.dp),
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

            ButtonSecondary(
                onClick = { listener.onClickStart() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 56.dp)
            ) {
                Text(text = "Get started", style = titleLargeSemibold)
            }
        }
    }

}