package com.cesarwillymc.movie.presentation.listMovies.state


sealed class NetworkState {


    data class Success(
        val isAdditional: Boolean = false,
        val isEmptyResponse: Boolean = false
    ) : NetworkState()

    data class Loading(
        val isAdditional: Boolean = false
    ) : NetworkState()


    data class Error(
        val isAdditional: Boolean = false,
        val isEmpty: Boolean = true,
    ) : NetworkState()


    fun isSuccess() = this is Success


    fun isLoading() = this is Loading


    fun isError() = this is Error
}
