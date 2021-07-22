package com.cesarwillymc.movie.module

import android.content.Context
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

}