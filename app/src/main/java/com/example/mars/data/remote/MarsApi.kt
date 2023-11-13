package com.example.mars.data.remote

import com.example.mars.data.dto.MarsDto
import com.example.mars.utils.BASE_URL
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MarsApi {
    @GET("photos")
    suspend fun getPhotos(): Response<List<MarsDto>>
}

object ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
    val apiService = retrofit.create(MarsApi::class.java)
}