package com.cesarwillymc.movie.module.module

import android.content.Context
import androidx.room.Room
import com.cesarwillymc.movie.core.db.MoviesDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMarvelDatabase(context: Context) =
        Room.databaseBuilder(context, MoviesDB::class.java, "AppDB")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    @Singleton
    @Provides
    fun provideMoviesDato(appdb: MoviesDB) =
        appdb.moviesListData()






}
