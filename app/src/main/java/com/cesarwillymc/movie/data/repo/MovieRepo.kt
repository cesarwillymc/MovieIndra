package com.cesarwillymc.movie.data.repo

import com.cesarwillymc.movie.core.model.BaseListMovies

interface MovieRepo {
    suspend fun getPopularMovies(page: Int): BaseListMovies
    suspend fun getSearchMovies(word:String,page: Int): BaseListMovies
}