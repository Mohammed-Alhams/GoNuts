package com.mr_alhams.gonuts.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mr_alhams.gonuts.R
import com.mr_alhams.gonuts.ui.screen.composables.TopBar
import com.mr_alhams.gonuts.ui.screen.details.navigateToDetails
import com.mr_alhams.gonuts.ui.theme.Background
import com.mr_alhams.gonuts.ui.theme.LightBlue
import com.mr_alhams.gonuts.ui.theme.Primary
import com.mr_alhams.gonuts.ui.theme.Secondary
import com.mr_alhams.gonuts.ui.theme.bodyMedium
import com.mr_alhams.gonuts.ui.theme.headlineSmallSemibold
import com.mr_alhams.gonuts.ui.theme.titleLargeSemibold
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {

    val state by viewModel.uiState.collectAsState()

    val coroutineScope = rememberCoroutineScope()


    LaunchedEffect(key1 = Unit) {
        coroutineScope.launch {
            viewModel.effect.collectLatest {
                navController.navigateToDetails(it)
            }
        }
    }

    HomeContent(state, viewModel)

}


@Composable
private fun HomeContent(
    state: HomeUiState,
    listener: HomeScreenInteractionListener
) {
    LazyColumn(modifier = Modifier.background(Background)) {

        item {

            Column() {

                TopBar(
                    title = {
                        Text(
                            text = stringResource(R.string.let_s_gonuts),
                            style = headlineSmallSemibold
                        )
                    },
                    subTitle = {
                        Text(text = stringResource(R.string.order_donuts), style = bodyMedium)

                    },
                    leading = {
                        IconButton(
                            onClick = { listener.onSearchClicked() },
                            modifier = Modifier.background(Secondary, RoundedCornerShape(15.dp))
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = stringResource(R.string.search_button),
                                tint = Primary
                            )
                        }
                    },
                    modifier = Modifier.padding(start = 32.dp, end = 32.dp, top = 40.dp)
                )

                Text(
                    text = stringResource(R.string.today_offers),
                    style = titleLargeSemibold,
                    modifier = Modifier.padding(start = 32.dp, top = 32.dp)
                )

                LazyRow(
                    contentPadding = PaddingValues(start = 32.dp, end = 64.dp, top = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(72.dp)
                ) {
                    itemsIndexed(state.donutOffers) { index, item ->
                        DonutOffersItem(
                            onClick = { listener.onClickDonut(index) },
                            state = item,
                            modifier = Modifier
                                .background(
                                    if (index % 2 == 0) LightBlue else Secondary,
                                    RoundedCornerShape(20.dp)
                                )
                        )
                    }
                }

                Text(
                    text = "Donuts",
                    style = titleLargeSemibold,
                    modifier = Modifier.padding(start = 32.dp, top = 24.dp)
                )

                LazyRow(
                    modifier = Modifier.padding(top = 24.dp),
                    contentPadding = PaddingValues(32.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    itemsIndexed(state.donutsList) { index, item ->
                        DonutItem(
                            onClick = {
                                listener.onClickDonut(index)
                            },
                            state = item,
                        )
                    }
                }
            }
        }
    }
}