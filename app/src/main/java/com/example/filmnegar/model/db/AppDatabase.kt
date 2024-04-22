package com.example.filmnegar.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.filmnegar.model.data.Movie

@Database(entities = [Movie::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}