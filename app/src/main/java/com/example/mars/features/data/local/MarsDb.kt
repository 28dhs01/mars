package com.example.mars.features.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [MarsEntity::class], version = 1)
abstract class MarsDb : RoomDatabase(){
    abstract fun getMarsDao() : MarsDao
}