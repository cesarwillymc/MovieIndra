package com.cesarwillymc.movie.core.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cesarwillymc.movie.core.model.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(item: Movie)

    @Query("SELECT * FROM moviedao")
    fun getAllMovies(): List<Movie>
}