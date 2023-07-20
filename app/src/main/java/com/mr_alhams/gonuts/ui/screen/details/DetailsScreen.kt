package com.mr_alhams.gonuts.ui.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mr_alhams.gonuts.R
import com.mr_alhams.gonuts.ui.screen.composables.ButtonPrimary
import com.mr_alhams.gonuts.ui.screen.composables.ButtonRounded
import com.mr_alhams.gonuts.ui.theme.Background
import com.mr_alhams.gonuts.ui.theme.Black
import com.mr_alhams.gonuts.ui.theme.DarkGray
import com.mr_alhams.gonuts.ui.theme.LightGrey
import com.mr_alhams.gonuts.ui.theme.Primary
import com.mr_alhams.gonuts.ui.theme.Secondary
import com.mr_alhams.gonuts.ui.theme.White
import com.mr_alhams.gonuts.ui.theme.bodyMediumNormal
import com.mr_alhams.gonuts.ui.theme.headlineSmallSemibold
import com.mr_alhams.gonuts.ui.theme.titleLargeSemibold
import com.mr_alhams.gonuts.ui.theme.titleMedium
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel(),
    navController: NavController
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(key1 = Unit) {
        viewModel.effect.collectLatest {
            navController.navigateUp()
        }
    }

    DetailsContent(state, viewModel)
}

@Composable
fun DetailsContent(
    state: DetailsUiState,
    listener: DetailsScreenInteractionListener
) {


    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Secondary)
    ) {

        IconButton(
            onClick = { listener.onClickBack() },
            modifier = Modifier.padding(top = 15.dp, start = 32.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back),
                contentDescription = stringResource(R.string.back_button),
                tint = Primary
            )
        }

        Image(
            modifier = Modifier
                .padding(bottom = 24.dp)
                .size(240.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(id = state.image),
            contentDescription = state.title,
            contentScale = ContentScale.FillWidth
        )

        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    Background,
                    RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                )
                .padding(bottom = 40.dp, start = 40.dp, end = 40.dp),
        ) {

            Icon(
                painter = painterResource(id = R.drawable.heart),
                contentDescription = state.title,
                modifier = Modifier
                    .offset(y = (-20).dp)
                    .background(White, RoundedCornerShape(16.dp))
                    .padding(horizontal = 8.dp, vertical = 9.dp)
                    .size(28.dp)
                    .align(Alignment.End),
                tint = Primary
            )

            Text(
                text = state.title,
                style = headlineSmallSemibold
            )

            Text(
                text = stringResource(R.string.about_gonut),
                style = titleMedium.copy(color = DarkGray),
                modifier = Modifier.padding(top = 32.dp)
            )

            Text(
                text = state.description,
                style = bodyMediumNormal.copy(color = LightGrey),
                modifier = Modifier.padding(top = 16.dp),
                maxLines = 4,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = stringResource(R.string.quantity),
                style = titleMedium.copy(color = DarkGray),
                modifier = Modifier.padding(top = 26.dp)
            )

            Row(
                modifier = Modifier
                    .padding(top = 18.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                ButtonRounded(modifier = Modifier, color = White, onClick = {}) {
                    Text(text = stringResource(R.string.minus), style = titleMedium)
                }
                ButtonRounded(modifier = Modifier, color = White, onClick = {}) {
                    Text(text = state.quantity.toString(), style = titleMedium)
                }
                ButtonRounded(modifier = Modifier, color = Black, onClick = {}) {
                    Text(
                        text = stringResource(R.string.bonus),
                        style = titleMedium.copy(White)
                    )
                }

            }

            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .height(999.dp)
            )

            Row(
                modifier = Modifier.padding(top = 47.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(26.dp)
            ) {
                Text(text = state.price.toString(), style = headlineSmallSemibold)
                ButtonPrimary(
                    onClick = {},
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = stringResource(R.string.add_to_cart),
                        style = titleLargeSemibold.copy(White),
                    )
                }
            }
        }
    }


}