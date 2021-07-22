
package com.cesarwillymc.movie.module

import android.content.Context
import com.cesarwillymc.movie.app.MyApp
import com.cesarwillymc.movie.data.repo.AuthRepo
import com.cesarwillymc.movie.data.repo.AuthRepoImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {


    @Provides
    fun provideContext(application: MyApp): Context = application.applicationContext
}
