package com.cesarwillymc.movie.presentation.listMovies.paging


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.cesarwillymc.movie.core.model.Movie
import com.cesarwillymc.movie.data.repo.MovieRepo
import com.cesarwillymc.movie.presentation.listMovies.state.NetworkState
import javax.inject.Inject
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class MoviesPageDataSource @Inject constructor(
    val repository: MovieRepo,
    val scope: CoroutineScope,
) : PageKeyedDataSource<Int, Movie>() {

    val networkState = MutableLiveData<NetworkState>()


    var retry: (() -> Unit)? = null
    var isCalledDB = false
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>
    ) {
        networkState.postValue(NetworkState.Loading())
        scope.launch(
            CoroutineExceptionHandler { _, _ ->
                retry = {
                    loadInitial(params, callback)
                }

                scope.launch {

                    val response = repository.getMovieDB()
                    if (response.isEmpty()) {
                        networkState.postValue(NetworkState.Error(isEmpty = true))
                    } else {
                        isCalledDB = true
                        networkState.postValue(NetworkState.Error(isEmpty = false))
                        callback.onResult(response, null, 0)
                    }

                }

            }
        ) {
            val response = repository.getPopularMovies(
                page = 1,
            )
            isCalledDB = false
            callback.onResult(response.results, null, response.page + 1)
            networkState.postValue(NetworkState.Success(isEmptyResponse = response.results.isEmpty()))
        }
    }


    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Movie>
    ) {
        networkState.postValue(NetworkState.Loading(true))
        scope.launch(
            CoroutineExceptionHandler { _, _ ->
                retry = {
                    if (isCalledDB) {
                        this.invalidate()

                    } else {
                        loadAfter(params, callback)
                    }
                }
                networkState.postValue(NetworkState.Error(true))
            }
        ) {
            val response = repository.getPopularMovies(
                page = params.key,
            )
            callback.onResult(response.results, params.key + 1)
            networkState.postValue(NetworkState.Success(true, response.results.isEmpty()))
        }

    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Movie>
    ) {
        // Ignored, since we only ever append to our initial load
    }


    fun retry() {
        retry?.invoke()
    }
}
