package com.cesarwillymc.movie.presentation.detailMovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cesarwillymc.movie.core.model.Movie

class MovieDetailViewModel:ViewModel() {
    private val _stateMovie = MutableLiveData<Movie>()
    val stateMovie: LiveData<Movie> get() = _stateMovie

    fun setValue(movie:Movie){
        _stateMovie.value = movie
    }
}