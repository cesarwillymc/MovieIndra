package com.cesarwillymc.movie.module.module

import com.cesarwillymc.movie.core.retrofit.MoviesApi
import com.cesarwillymc.movie.data.repo.AuthRepo
import com.cesarwillymc.movie.data.repo.AuthRepoImpl
import com.cesarwillymc.movie.data.repo.MovieRepo
import com.cesarwillymc.movie.data.repo.MovieRepoImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideAuthRepo():  AuthRepo  = AuthRepoImpl()


    @Singleton
    @Provides
    fun provideMoviesRepo(api: MoviesApi):  MovieRepo  = MovieRepoImpl(api)


}