package com.mr_alhams.gonuts.ui.screen.on_boarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor() : ViewModel(), OnBoardingInteractionListener {

    private val _effect = MutableSharedFlow<Unit>()
    val effect = _effect.asSharedFlow()

    override fun onClickStart() {
        viewModelScope.launch { _effect.emit(Unit) }
    }

}