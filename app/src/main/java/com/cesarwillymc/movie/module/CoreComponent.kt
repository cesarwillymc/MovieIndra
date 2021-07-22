package com.cesarwillymc.movie.module

import android.content.Context
import com.cesarwillymc.movie.core.db.dao.MovieDao
import com.cesarwillymc.movie.core.retrofit.MoviesApi
import com.cesarwillymc.movie.data.repo.AuthRepo
import com.cesarwillymc.movie.data.repo.MovieRepo
import com.cesarwillymc.movie.data.utils.RequestUser
import com.cesarwillymc.movie.module.module.ContextModule
import com.cesarwillymc.movie.module.module.DatabaseModule
import com.cesarwillymc.movie.module.module.NetworkModule
import com.cesarwillymc.movie.module.module.RepositoryModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        RepositoryModule::class
    ]
)
interface CoreComponent {
    fun context(): Context
    fun authRepository(): AuthRepo
    fun moviesRepository(): MovieRepo
    fun apiService(): MoviesApi
    fun apiRequestUser(): RequestUser
    fun movieDao(): MovieDao
}