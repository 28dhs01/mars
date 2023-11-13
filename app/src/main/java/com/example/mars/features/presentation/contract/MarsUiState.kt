package com.example.mars.features.presentation.contract

import com.example.mars.features.presentation.uiModels.MarsUiModel

data class MarsUiState (
    val loading: Boolean = true,
    val list: List<MarsUiModel> = emptyList()
)