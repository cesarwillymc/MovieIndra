package com.cesarwillymc.movie.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cesarwillymc.movie.core.db.dao.MovieDao

@Database(entities = [],
    exportSchema = false,
    version = 1,)

abstract class MoviesDB : RoomDatabase() {

    abstract fun moviesListData(): MovieDao

}