package com.example.mars.features.presentation.viewModel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mars.features.domain.usecases.GetDataUsecase
import com.example.mars.features.presentation.contract.MarsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarsViewModel @Inject constructor(
    private val getDataUsecase: GetDataUsecase
): ViewModel() {
    private val _uiState = MutableStateFlow(MarsUiState())
    val uiState: StateFlow<MarsUiState> = _uiState.asStateFlow()

    fun loadMarsData(){
        viewModelScope.launch {
            val data = getDataUsecase.getData()
            _uiState.update {
                it.copy(loading = false, list = data)
            }
        }
    }
}