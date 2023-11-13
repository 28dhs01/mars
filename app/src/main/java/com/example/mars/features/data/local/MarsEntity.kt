package com.example.mars.features.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mars_table")
data class MarsEntity(
    @PrimaryKey
    val id: Int,
    val imgUrl: String
)
