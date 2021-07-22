package com.cesarwillymc.movie.presentation.listMovies.di

import com.cesarwillymc.movie.module.CoreComponent
import com.cesarwillymc.movie.module.scope.FeatureScope
import com.cesarwillymc.movie.presentation.listMovies.ListMoviesFragment
import dagger.Component


@FeatureScope
@Component(
    modules = [MovieListModule::class],
    dependencies = [CoreComponent::class]
)
interface MovieListComponent {

    fun inject(listFragment: ListMoviesFragment)
}
