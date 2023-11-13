package com.example.mars.domain.usecases

import com.example.mars.data.remote.ApiService
import com.example.mars.domain.mappers.toMarsUiModel
import com.example.mars.presentation.uiModels.MarsUiModel

class GetDataUsecase {

    suspend fun getData(): List<MarsUiModel>{
        return ApiService.apiService.getPhotos().body()!!.map {
            it.toMarsUiModel()
        }
    }
}