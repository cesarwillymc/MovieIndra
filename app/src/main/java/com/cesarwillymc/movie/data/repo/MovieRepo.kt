package com.cesarwillymc.movie.data.repo

import com.cesarwillymc.movie.core.model.BaseListMovies
import com.cesarwillymc.movie.core.model.Movie

interface MovieRepo {
    suspend fun getPopularMovies(page: Int): BaseListMovies
    suspend fun getMovieDB(): List<Movie>
    fun insertMovieDB(movie: Movie)
}