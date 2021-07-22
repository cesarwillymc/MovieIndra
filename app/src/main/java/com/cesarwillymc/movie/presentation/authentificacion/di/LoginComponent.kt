package com.cesarwillymc.movie.presentation.authentificacion.di

import com.cesarwillymc.movie.module.CoreComponent
import com.cesarwillymc.movie.module.scope.FeatureScope
import com.cesarwillymc.movie.presentation.authentificacion.AuthFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [LoginModule::class],
    dependencies = [CoreComponent::class]
)
interface LoginComponent {
    fun inject(fragment:AuthFragment)
}