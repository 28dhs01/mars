package com.example.mars.features.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MarsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveList(list: List<MarsEntity>)

    @Query("select * from mars_table")
    suspend fun getList(): List<MarsEntity>

    @Query("delete from mars_table")
    suspend fun clearList()

}