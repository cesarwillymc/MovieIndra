package com.cesarwillymc.movie.presentation.detailMovie.di

import com.cesarwillymc.movie.module.CoreComponent
import com.cesarwillymc.movie.module.scope.FeatureScope
import com.cesarwillymc.movie.presentation.detailMovie.MovieDetailFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [MovieDetailModule::class],
    dependencies = [CoreComponent::class]
)
interface MovieDetailComponent {
    fun inject(fragment:MovieDetailFragment)
}