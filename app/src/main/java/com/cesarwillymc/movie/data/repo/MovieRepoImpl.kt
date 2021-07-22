package com.cesarwillymc.movie.data.repo

import com.cesarwillymc.movie.core.model.BaseListMovies
import com.cesarwillymc.movie.core.retrofit.MoviesApi
import retrofit2.await

class MovieRepoImpl(private val  api:MoviesApi):MovieRepo {
    override suspend fun getPopularMovies(page: Int): BaseListMovies {
        return api.getPopularMovies(page).await()
    }

    override suspend fun getSearchMovies(word:String,page: Int): BaseListMovies {
        return api.getSearchMovies(word = word,page= page).await()
    }
}