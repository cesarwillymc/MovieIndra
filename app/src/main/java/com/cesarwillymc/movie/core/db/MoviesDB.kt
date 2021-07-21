package com.cesarwillymc.movie.core.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [],
    version = 1
)
abstract class MoviesDB : RoomDatabase() {

    companion object{
        @Volatile
        private var INSTANCE: MoviesDB?=null
        private val LOCK= Any()
        operator fun invoke(context: Context)= INSTANCE ?: synchronized(LOCK){
            INSTANCE ?: buildDatabase(context)
        }
        private fun buildDatabase(context: Context)= Room.databaseBuilder(context,
            MoviesDB::class.java, "App-Movies-db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}
