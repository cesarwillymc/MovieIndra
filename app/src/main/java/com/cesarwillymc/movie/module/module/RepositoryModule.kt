package com.cesarwillymc.movie.module.module

import com.cesarwillymc.movie.data.repo.AuthRepo
import com.cesarwillymc.movie.data.repo.AuthRepoImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideAuthRepo():  AuthRepo  = AuthRepoImpl()



}