package com.cesarwillymc.movie.presentation.listMovies

import com.cesarwillymc.movie.base.BaseViewState

sealed class ListMovieViewState:BaseViewState {

    object Refreshing : ListMovieViewState()

    object Loaded : ListMovieViewState()

    object Loading : ListMovieViewState()

    object AddLoading : ListMovieViewState()

    object Empty : ListMovieViewState()

    object Error : ListMovieViewState()

    object EmptyError : ListMovieViewState()

    object AddError : ListMovieViewState()

    object NoMoreElements : ListMovieViewState()

    fun isRefreshing() = this is Refreshing

    fun isLoaded() = this is Loaded

    fun isLoading() = this is Loading

    fun isAddLoading() = this is AddLoading

    fun isEmpty() = this is Empty

    fun isError() = this is Error

    fun isAddError() = this is AddError

    fun isEmptyError() = this is EmptyError

    fun isNoMoreElements() = this is NoMoreElements
}