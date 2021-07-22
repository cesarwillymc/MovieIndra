package com.cesarwillymc.movie.presentation.listMovies

import com.cesarwillymc.movie.core.model.Movie


sealed class MovieListViewEvent {
    data class OpenMovieDetail(val movie: Movie) : MovieListViewEvent()
}
