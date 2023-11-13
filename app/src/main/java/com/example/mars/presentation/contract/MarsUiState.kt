package com.example.mars.presentation.contract

import com.example.mars.presentation.uiModels.MarsUiModel

data class MarsUiState (
    val loading: Boolean = true,
    val list: List<MarsUiModel> = emptyList()
)