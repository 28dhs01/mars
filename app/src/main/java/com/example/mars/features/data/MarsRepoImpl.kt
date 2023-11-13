package com.example.mars.features.data

import com.example.mars.features.data.local.MarsDb
import com.example.mars.features.data.local.MarsEntity
import com.example.mars.features.data.remote.MarsApi
import com.example.mars.features.domain.MarsRepo
import com.example.mars.features.domain.mappers.toMarsEntity
import javax.inject.Inject

class MarsRepoImpl @Inject constructor(
    private val marsApi: MarsApi,
    private val marsDb: MarsDb
): MarsRepo {
    private val marsDao = marsDb.getMarsDao()

    override suspend fun loadData(): List<MarsEntity>? {
        try {
            val response = marsApi.getPhotos()

            if (response.isSuccessful) {
                val body = response.body()

                marsDao.saveList(body?.map {
                    it.toMarsEntity()
                }?: emptyList())
            }
        } catch (e: Exception) {
            // Handle exceptions that may occur during the network request
            e.printStackTrace()
        }
        return loadLocalData()
    }

    override suspend fun loadLocalData(): List<MarsEntity>? {
        return marsDao.getList()
    }
}