package com.cesarwillymc.movie.presentation.listMovies.adapter.holders

import android.view.LayoutInflater
import com.cesarwillymc.movie.base.BaseViewHolder
import com.cesarwillymc.movie.databinding.ListItemErrorBinding
import com.cesarwillymc.movie.presentation.listMovies.ListMovieViewModel

class ErrorViewHolder(
    inflater: LayoutInflater
) : BaseViewHolder<ListItemErrorBinding>(
    binding = ListItemErrorBinding.inflate(inflater)
) {
    fun bind(viewModel: ListMovieViewModel) {
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }
}
