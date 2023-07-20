package com.mr_alhams.gonuts.ui.screen.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    DetailsContent(state)
}

@Composable
fun DetailsContent(state: DetailsUiState) {

    LazyColumn() {

        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Secondary)
            ) {

                IconButton(
                    onClick = { },
                    modifier = Modifier.padding(top = 40.dp, start = 32.dp)
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
                        .background(
                            Background,
                            RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
                        )
                        .padding(40.dp),
                ) {

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
    }


}