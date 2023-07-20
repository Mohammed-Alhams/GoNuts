package com.mr_alhams.gonuts.ui.screen.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mr_alhams.gonuts.data.GoNutsDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val goNutsDataSource: GoNutsDataSource,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _uiState = MutableStateFlow(DetailsUiState())
    val uiState = _uiState.asStateFlow()

    private val args: DetailsArgs = DetailsArgs(savedStateHandle)

    init {
        getDonutByIndex()
    }

    private fun getDonutByIndex() {
        val donutItem = goNutsDataSource.getDonutByIndex(args.index.toInt())

        _uiState.value = DetailsUiState(
            image = donutItem.image,
            title = donutItem.name,
            description = donutItem.description,
            price = donutItem.originalPrice
        )
    }

}