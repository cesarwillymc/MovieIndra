package com.cesarwillymc.movie.module.module



import com.cesarwillymc.movie.core.retrofit.MoviesApi
import com.cesarwillymc.movie.core.retrofit.config.DefaultRequestInterceptor
import com.cesarwillymc.movie.core.retrofit.config.HttpConfiguration
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideDefaultRequest() = DefaultRequestInterceptor()

    @Singleton
    @Provides
    fun provideHttpConfig(defaultRequest:DefaultRequestInterceptor) = HttpConfiguration(defaultRequest)

    @Singleton
    @Provides
    fun provideApi(httpConfiguration: HttpConfiguration): MoviesApi = MoviesApi.invoke(httpConfiguration)






}