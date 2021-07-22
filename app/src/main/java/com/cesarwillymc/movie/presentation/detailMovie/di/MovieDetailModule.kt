package com.cesarwillymc.movie.presentation.detailMovie.di

import androidx.annotation.VisibleForTesting
import com.cesarwillymc.movie.module.scope.FeatureScope
import com.cesarwillymc.movie.common.viewModel
import com.cesarwillymc.movie.data.repo.MovieRepo
import com.cesarwillymc.movie.presentation.detailMovie.MovieDetailFragment
import com.cesarwillymc.movie.presentation.detailMovie.MovieDetailViewModel
import dagger.Module
import dagger.Provides

@Module
class MovieDetailModule(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val fragment: MovieDetailFragment
) {

    @FeatureScope
    @Provides
    fun setupFragmentWithViewModel(
        movieRepo: MovieRepo
    ) = fragment.viewModel {
        MovieDetailViewModel(movieRepo)
    }
}