package com.example.mars.features.data.remote

import com.example.mars.features.data.dto.MarsDto
import com.example.mars.utils.BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MarsApi {
    @GET("photos")
    suspend fun getPhotos(): Response<List<MarsDto>>
}
