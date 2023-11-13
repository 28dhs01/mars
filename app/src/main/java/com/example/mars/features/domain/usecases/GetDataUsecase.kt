package com.example.mars.features.domain.usecases

import com.example.mars.features.domain.MarsRepo
import com.example.mars.features.domain.mappers.toMarsUiModel
import com.example.mars.features.presentation.uiModels.MarsUiModel
import javax.inject.Inject

class GetDataUsecase @Inject constructor(
    private val repo: MarsRepo
) {

    suspend fun getData(): List<MarsUiModel>{
        return repo.loadData()?.map {
            it.toMarsUiModel()
        } ?: emptyList()
    }
}