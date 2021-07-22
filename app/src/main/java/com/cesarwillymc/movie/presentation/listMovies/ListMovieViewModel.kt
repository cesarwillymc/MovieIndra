package com.cesarwillymc.movie.presentation.listMovies


import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import com.cesarwillymc.movie.common.SingleLiveData
import com.cesarwillymc.movie.core.model.Movie
import com.cesarwillymc.movie.presentation.listMovies.paging.MoviesPageDataSourceFactory
import com.cesarwillymc.movie.presentation.listMovies.state.NetworkState

class ListMovieViewModel(
    private val dataSourceFactory: MoviesPageDataSourceFactory
):ViewModel() {
    private val networkState = Transformations.switchMap(dataSourceFactory.sourceLiveData) {
        it.networkState
    }

    val data = LivePagedListBuilder(dataSourceFactory, 1).build()
    val state = Transformations.map(networkState) {
        when (it) {
            is NetworkState.Success ->
                if (it.isAdditional && it.isEmptyResponse) {
                   ListMovieViewState.NoMoreElements
                } else if (it.isEmptyResponse) {
                   ListMovieViewState.Empty
                } else {
                   ListMovieViewState.Loaded
                }
            is NetworkState.Loading ->
                if (it.isAdditional) {
                   ListMovieViewState.AddLoading
                } else {
                   ListMovieViewState.Loading
                }
            is NetworkState.Error ->
                when {
                    it.isAdditional -> {
                        ListMovieViewState.AddError
                    }
                    it.isEmpty -> {
                        ListMovieViewState.EmptyError
                    }
                    else -> {
                        ListMovieViewState.Error
                    }
                }
        }
    }


    fun refreshLoadedMovieList() {
        dataSourceFactory.refresh()
    }


    fun retryAddMovieList() {
        dataSourceFactory.retry()
    }

    val event = SingleLiveData<MovieListViewEvent>()
    fun openMovieDetail(movieID: Movie) {
        event.postValue(MovieListViewEvent.OpenMovieDetail(movieID))
    }

}