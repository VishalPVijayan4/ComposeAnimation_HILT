package com.vishalpvijayan.composeanimation_hilt.presentation.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vishalpvijayan.composeanimation_hilt.domain.model.ManualBuyEducationData
import com.vishalpvijayan.composeanimation_hilt.domain.usecase.GetManualBuyEducationDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ManualBuyEducationViewModel @Inject constructor(
    private val getManualBuyEducationDataUseCase: GetManualBuyEducationDataUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<ManualBuyEducationData?>(null)
    val state: StateFlow<ManualBuyEducationData?> = _state

    fun load() {
        viewModelScope.launch {
            _state.value = getManualBuyEducationDataUseCase()
        }
    }
}