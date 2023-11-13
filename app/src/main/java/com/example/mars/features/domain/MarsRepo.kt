package com.example.mars.features.domain

import com.example.mars.features.data.local.MarsEntity

interface MarsRepo {
    suspend fun loadData(): List<MarsEntity>?

    suspend fun loadLocalData(): List<MarsEntity>?
}