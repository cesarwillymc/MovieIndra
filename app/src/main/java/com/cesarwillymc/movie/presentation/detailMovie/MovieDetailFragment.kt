package com.cesarwillymc.movie.presentation.detailMovie


import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.cesarwillymc.movie.R
import com.cesarwillymc.movie.app.MyApp
import com.cesarwillymc.movie.base.BaseFragment
import com.cesarwillymc.movie.databinding.FragmentMovieDetailBinding
import com.cesarwillymc.movie.presentation.detailMovie.di.DaggerMovieDetailComponent
import com.cesarwillymc.movie.presentation.detailMovie.di.MovieDetailModule


class MovieDetailFragment : BaseFragment<FragmentMovieDetailBinding,MovieDetailViewModel>(layoutId = R.layout.fragment_movie_detail) {
    private val navArgs by navArgs<MovieDetailFragmentArgs>()
    override fun onInitDependencyInjection() {
        DaggerMovieDetailComponent.builder().coreComponent(MyApp.coreComponent(requireContext()))
            .movieDetailModule(MovieDetailModule(this)).build().inject(this)
    }

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setValuesViewModel()
        binding()
    }

    private fun setValuesViewModel() {
        viewModel.setValue(navArgs.model)

    }

    private fun binding() {
        viewBinding.buttonBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}