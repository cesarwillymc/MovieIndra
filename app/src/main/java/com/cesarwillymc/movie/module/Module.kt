package com.cesarwillymc.movie.module


import com.cesarwillymc.movie.core.db.MoviesDB
import com.cesarwillymc.movie.core.retrofit.MoviesApi
import com.cesarwillymc.movie.core.retrofit.config.DefaultRequestInterceptor
import com.cesarwillymc.movie.core.retrofit.config.HttpConfiguration
import org.koin.dsl.module


val viewModelModule = module {

}

val networkModule = module {
    factory {  DefaultRequestInterceptor() }
    factory {  HttpConfiguration(get()) }
    factory<MoviesApi> {
        MoviesApi.invoke(get())
    }
}
val dbModule = module {
    single<MoviesDB> {  MoviesDB(get()) }
}

val useCaseModule = module {

}

val repoModule = module {

}


