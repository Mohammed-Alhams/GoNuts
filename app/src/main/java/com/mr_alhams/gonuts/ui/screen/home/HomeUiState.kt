package com.mr_alhams.gonuts.ui.screen.home

data class HomeUiState(
    val donutOffers: List<DonutOffer> = emptyList(),
    val todayOffersTitle: String = "",
    val donutsList: List<DonutItem> = emptyList(),
    val donutsTitle: String = "",
)

data class DonutOffer(
    val isFavorite: Boolean = false,
    val image: Int = 0,
    val name: String = "",
    val description: String = "",
    val originalPrice: Int = 0,
    val discountedPrice: Int = 0,
)

data class DonutItem(
    val image: Int = 0,
    val name: String = "",
    val price: Int = 0
)