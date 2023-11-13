package com.example.mars.presentation.viewModel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import com.example.mars.presentation.contract.MarsUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MarsViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(MarsUiState())
    val uiState: StateFlow<MarsUiState> = _uiState.asStateFlow()
}