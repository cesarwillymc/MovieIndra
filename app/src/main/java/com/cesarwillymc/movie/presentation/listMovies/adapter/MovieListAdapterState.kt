package com.cesarwillymc.movie.presentation.listMovies.adapter


sealed class MovieListAdapterState(
    val hasExtraRow: Boolean
) {


    object Added : MovieListAdapterState(hasExtraRow = true)

    object AddLoading : MovieListAdapterState(hasExtraRow = true)


    object AddError : MovieListAdapterState(hasExtraRow = true)


    object NoMore : MovieListAdapterState(hasExtraRow = false)


    fun isAdded() = this is Added


    fun isAddLoading() = this is AddLoading


    fun isAddError() = this is AddError


    fun isNoMore() = this is NoMore
}
