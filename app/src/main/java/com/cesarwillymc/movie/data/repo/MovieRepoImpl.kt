package com.cesarwillymc.movie.data.repo

import com.cesarwillymc.movie.core.db.dao.MovieDao
import com.cesarwillymc.movie.core.model.BaseListMovies
import com.cesarwillymc.movie.core.model.Movie
import com.cesarwillymc.movie.core.retrofit.MoviesApi
import retrofit2.await

class MovieRepoImpl(private val  api:MoviesApi,private val movieDao: MovieDao):MovieRepo {
    override suspend fun getPopularMovies(page: Int): BaseListMovies {
        return api.getPopularMovies(page).await()
    }

    override suspend fun getMovieDB(): List<Movie> {
        return movieDao.getAllMovies()
    }

    override fun insertMovieDB(movie: Movie) {
        movieDao.insertMovie(movie)
    }


}