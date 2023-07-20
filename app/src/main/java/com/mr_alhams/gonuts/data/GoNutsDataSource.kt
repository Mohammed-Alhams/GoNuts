package com.mr_alhams.gonuts.data

import com.mr_alhams.gonuts.R
import com.mr_alhams.gonuts.ui.screen.home.DonutItem
import com.mr_alhams.gonuts.ui.screen.home.DonutOffer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GoNutsDataSource @Inject constructor() {
    fun getDonutOffers(): List<DonutOffer> {
        return listOf(
            DonutOffer(
                isFavorite = false,
                R.drawable.donut_offer1,
                "Strawberry Wheel",
                "These Baked Strawberry Donuts are filled with fresh strawberries with fresh strawberries",
                16,
                20
            ),
            DonutOffer(
                isFavorite = false,
                R.drawable.donut_offer2,
                "Chocolate Glaze",
                "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                16,
                20
            ),
            DonutOffer(
                isFavorite = false,
                R.drawable.donut_offer1,
                "Strawberry Wheel",
                "These Baked Strawberry Donuts are filled with fresh strawberries with fresh strawberries",
                16,
                20
            ),
            DonutOffer(
                isFavorite = false,
                R.drawable.donut_offer2,
                "Chocolate Glaze",
                "Moist and fluffy baked chocolate donuts full of chocolate flavor.",
                16,
                20
            ),
        )
    }

    fun getDonuts(): List<DonutItem> {
        return listOf(
            DonutItem(
                R.drawable.donut_item3,
                "Strawberry Shower",
                22
            ),
            DonutItem(
                R.drawable.donut_item1,
                "Chocolate Cherry",
                22
            ),
            DonutItem(
                R.drawable.donut_item2,
                "Strawberry Rain",
                22
            ),
            DonutItem(
                R.drawable.donut_item3,
                "Chocolate toottaa",
                22
            ),
        )
    }

    fun getDonutByIndex(index: Int): DonutOffer {
        return getDonutOffers()[index]
    }

}
