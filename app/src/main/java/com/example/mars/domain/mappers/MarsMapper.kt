package com.example.mars.domain.mappers

import com.example.mars.data.dto.MarsDto
import com.example.mars.presentation.uiModels.MarsUiModel

fun MarsDto.toMarsUiModel(): MarsUiModel{
    return MarsUiModel(
        id = this.id,
        imgUrl = this.imgUrl
    )
}