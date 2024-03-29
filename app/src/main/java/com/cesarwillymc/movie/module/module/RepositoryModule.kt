package com.cesarwillymc.movie.module.module

import com.cesarwillymc.movie.core.db.dao.MovieDao
import com.cesarwillymc.movie.core.retrofit.MoviesApi
import com.cesarwillymc.movie.data.repo.AuthRepo
import com.cesarwillymc.movie.data.repo.AuthRepoImpl
import com.cesarwillymc.movie.data.repo.MovieRepo
import com.cesarwillymc.movie.data.repo.MovieRepoImpl
import com.cesarwillymc.movie.data.utils.RequestUser
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideAuthRepo(request: RequestUser):  AuthRepo  = AuthRepoImpl(request)


    @Singleton
    @Provides
    fun provideMoviesRepo(api: MoviesApi,movieDao: MovieDao):  MovieRepo  = MovieRepoImpl(api,movieDao)


}