package com.cesarwillymc.movie.presentation.authentificacion.di

import androidx.annotation.VisibleForTesting
import com.cesarwillymc.movie.data.repo.AuthRepo
import com.cesarwillymc.movie.module.scope.FeatureScope
import com.cesarwillymc.movie.presentation.authentificacion.AuthFragment
import com.cesarwillymc.movie.presentation.authentificacion.AuthViewModel
import com.cesarwillymc.movie.common.viewModel
import dagger.Module
import dagger.Provides

@Module
class LoginModule(
    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    val fragment: AuthFragment
) {

    @FeatureScope
    @Provides
    fun setupFragmentWithViewModel(
        repo: AuthRepo
    ) = fragment.viewModel {
        AuthViewModel(repo = repo)
    }
}