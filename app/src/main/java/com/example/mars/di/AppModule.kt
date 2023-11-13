package com.example.mars.di

import android.content.Context
import androidx.room.Room
import com.example.mars.features.data.MarsRepoImpl
import com.example.mars.features.data.local.MarsDb
import com.example.mars.features.data.remote.MarsApi
import com.example.mars.features.domain.MarsRepo
import com.example.mars.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMarsApi(): MarsApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit.create(MarsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMarsRepo(marsApi: MarsApi,marsDb: MarsDb): MarsRepo{
        return MarsRepoImpl(marsApi = marsApi, marsDb = marsDb)
    }

    @Provides
    @Singleton
    fun providesMarsDb(@ApplicationContext context: Context): MarsDb{
        return Room.databaseBuilder(
            context = context,
            MarsDb::class.java, "mars_database"
        ).build()
    }
}