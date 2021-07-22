package com.cesarwillymc.movie.presentation.listMovies.di

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import androidx.lifecycle.viewModelScope
import com.cesarwillymc.movie.module.scope.FeatureScope
import com.cesarwillymc.movie.presentation.listMovies.ListMovieViewModel
import com.cesarwillymc.movie.presentation.listMovies.ListMoviesFragment
import com.cesarwillymc.movie.presentation.listMovies.paging.MoviesPageDataSourceFactory
import com.cesarwillymc.movie.common.viewModel
import com.cesarwillymc.movie.data.repo.MovieRepo
import com.cesarwillymc.movie.presentation.listMovies.adapter.ListMovieAdapter
import com.cesarwillymc.movie.presentation.listMovies.paging.MoviesPageDataSource
import dagger.Module
import dagger.Provides


@Module
class MovieListModule(
    val fragment: ListMoviesFragment
) {


    @FeatureScope
    @Provides
    fun providesCharactersListViewModel(
        dataFactory: MoviesPageDataSourceFactory
    ) = fragment.viewModel {
        ListMovieViewModel(dataFactory)
    }

    @Provides
    fun providesMoviePageDataSource(
        viewModel: ListMovieViewModel,
        repository: MovieRepo
    ) = MoviesPageDataSource(
        repository = repository,
        scope = viewModel.viewModelScope,
    )


    @FeatureScope
    @Provides
    fun providesMovieListAdapter(
        viewModel: ListMovieViewModel
        ) = ListMovieAdapter(viewModel)
}
