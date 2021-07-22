package com.cesarwillymc.movie.presentation.listMovies.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.cesarwillymc.movie.core.model.Movie
import javax.inject.Inject
import javax.inject.Provider


class MoviesPageDataSourceFactory
@Inject constructor(
    private val providerDataSource: Provider<MoviesPageDataSource>
) : DataSource.Factory<Int, Movie>() {

    var sourceLiveData = MutableLiveData<MoviesPageDataSource>()

    override fun create(): DataSource<Int, Movie> {
        val dataSource = providerDataSource.get()
        sourceLiveData.postValue(dataSource)
        return dataSource
    }


    fun refresh() {
        sourceLiveData.value?.invalidate()
    }


    fun retry() {
        sourceLiveData.value?.retry()
    }
}
