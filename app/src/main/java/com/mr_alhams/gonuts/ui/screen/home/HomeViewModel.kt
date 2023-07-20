package com.mr_alhams.gonuts.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mr_alhams.gonuts.data.GoNutsDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val goNutsDataSource: GoNutsDataSource
) : ViewModel(), HomeScreenInteractionListener {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    private val _effect = MutableSharedFlow<Int>()
    val effect = _effect.asSharedFlow()

    init {
        getDonutsOffer()
        getDonuts()
    }

    private fun getDonutsOffer() {
        val donutOffers = goNutsDataSource.getDonutOffers()
        _uiState.update { it.copy(donutOffers = donutOffers) }
    }

    private fun getDonuts() {
        val donuts = goNutsDataSource.getDonuts()
        _uiState.update { it.copy(donutsList = donuts) }
    }

    override fun onSearchClicked() {

    }

    override fun onClickDonut(index: Int) {
        viewModelScope.launch { _effect.emit(index) }
    }

}