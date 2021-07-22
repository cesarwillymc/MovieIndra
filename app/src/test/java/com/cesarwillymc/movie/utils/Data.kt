package com.cesarwillymc.movie.utils

import com.cesarwillymc.movie.core.model.BaseListMovies
import com.cesarwillymc.movie.core.model.Movie

object Data {
    val listMovie = listOf(
        Movie(
            adult = false,
            backdropPath = "url image",
            id = 12,
            originalLanguage = "es",
            originalTitle = "La cripta",
            overview = "Es una pelicula de accion que narra sucesos del año 200",
            popularity = 10.0,
            posterPath = "",
            releaseDate = "10-20-10",
            title = "The cript",
            video = true,
            voteAverage = 10.0,
            voteCount = 6
        ),
        Movie(
            adult = true,
            backdropPath = "url image",
            id = 2,
            originalLanguage = "es",
            originalTitle = "Sex education",
            overview = "Es una pelicula de accion que narra la historia de oriss",
            popularity = 10.0,
            posterPath = "",
            releaseDate = "10-19-10",
            title = "Educacion sexual",
            video = true,
            voteAverage = 10.0,
            voteCount = 2
        )
    )
    val baseList = listOf(
        BaseListMovies(page = 1, results = listMovie, totalPages = 10, totalResults = 1),
        BaseListMovies(page = 4, results = listMovie, totalPages = 1, totalResults = 2)
    )
}