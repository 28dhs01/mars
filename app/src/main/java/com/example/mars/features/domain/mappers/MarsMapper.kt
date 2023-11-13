package com.example.mars.features.domain.mappers

import com.example.mars.features.data.dto.MarsDto
import com.example.mars.features.data.local.MarsEntity
import com.example.mars.features.presentation.uiModels.MarsUiModel

fun MarsDto.toMarsUiModel(): MarsUiModel {
    return MarsUiModel(
        id = this.id,
        imgUrl = this.imgUrl
    )
}

fun MarsDto.toMarsEntity(): MarsEntity {
    return MarsEntity(
        id = this.id,
        imgUrl = this.imgUrl
    )
}

fun MarsEntity.toMarsUiModel(): MarsUiModel {
    return MarsUiModel(
        id = this.id,
        imgUrl = this.imgUrl
    )
}