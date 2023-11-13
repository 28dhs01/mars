package com.example.mars.features.data.dto

import com.google.gson.annotations.SerializedName

data class MarsDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("img_src")
    val imgUrl: String
)