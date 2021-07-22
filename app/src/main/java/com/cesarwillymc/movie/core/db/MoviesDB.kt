package com.cesarwillymc.movie.core.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [],
    exportSchema = false,
    version = 1,)

abstract class MoviesDB : RoomDatabase() {


}