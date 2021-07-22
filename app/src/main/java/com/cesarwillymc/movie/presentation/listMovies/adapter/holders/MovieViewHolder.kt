package com.cesarwillymc.movie.presentation.listMovies.adapter.holders

import android.view.LayoutInflater
import com.cesarwillymc.movie.base.BaseViewHolder
import com.cesarwillymc.movie.core.model.Movie
import com.cesarwillymc.movie.databinding.LayoutCardMovieBinding
import com.cesarwillymc.movie.presentation.listMovies.ListMovieViewModel

class MovieViewHolder(
    inflater: LayoutInflater
) : BaseViewHolder<LayoutCardMovieBinding>(
    binding = LayoutCardMovieBinding.inflate(inflater)
) {


    fun bind(viewModel: ListMovieViewModel, item: Movie) {
        binding.viewModel = viewModel
        binding.model = item
        binding.executePendingBindings()
    }
}
